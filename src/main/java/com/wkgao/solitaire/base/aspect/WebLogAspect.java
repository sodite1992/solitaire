package com.wkgao.solitaire.base.aspect;


import org.apache.logging.log4j.core.config.Order;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * Web层的日志切面
 */
@Aspect
@Order(1) //切面的优先级  值越小，优先级越高   A<B   执行顺序: A-before  B-before  B-after  A-after
@Component
public class WebLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();
    private static ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<Map<String,Object>>();

    @Pointcut("execution(public * com.wkgao.solitaire.mvc.controller..*.*(..)) || execution(public * com.wkgao.solitaire.mvc.api..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
        startTime.remove();
    }

//    @Around("webLog()")
//    public void doAround(ProceedingJoinPoint pjp) throws Throwable {
//        startTime.set(System.currentTimeMillis());
//        // 接收到请求，记录请求内容
//        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = sra.getRequest();
//
//        // 记录下请求内容
//        logger.info("URL : " + request.getRequestURL().toString());
//        logger.info("HTTP_METHOD : " + request.getMethod());
//        logger.info("IP : " + request.getRemoteAddr());
//        logger.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
//        logger.info("ARGS : " + Arrays.toString(pjp.getArgs()));
//
//        HttpServletResponse response = sra.getResponse();
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter writer = response.getWriter();
//        String requestURI = request.getRequestURI();
//
//        String result = null;
//        if (StringUtils.isNotBlank(requestURI) && requestURI.startsWith("/open/")) {
//            //判断是否要解密
//            Map<String,Object> params = new HashMap<>();
//            Enumeration<String> enums = request.getParameterNames();
//            while (enums.hasMoreElements()) {
//                String paramName = enums.nextElement();
//                params.put(paramName, request.getParameter(paramName));
//            }
//            threadLocal.set(params);
//            Map<String, Object> resultMap = new HashMap<>();
//            try {
//                resultMap.put("code", 200);
//                resultMap.put("msg", "success");
//                resultMap.put("data", pjp.proceed());
//            } catch (Exception e) {
//                resultMap.put("code", 500);
//                resultMap.put("msg", e.getMessage());
//                resultMap.put("data", "");
//            }
//            //返回判断是否需要加密
//            result = JSONObject.toJSONString(resultMap);
//            writer.write(result);
//            writer.flush();
//            writer.close();
//            threadLocal.remove();
//        }
//
//        // 处理完请求，返回内容
//        logger.info("RESPONSE : " + result);
//        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
//        startTime.remove();
//    }



}
