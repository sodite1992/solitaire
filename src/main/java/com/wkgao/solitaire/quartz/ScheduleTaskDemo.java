package com.wkgao.solitaire.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 定时任务执行类
 */
public class ScheduleTaskDemo extends QuartzJobBean {

    private static Logger logger = LoggerFactory.getLogger(ScheduleTaskDemo.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("=================== xxx定时任务开始执行 ===================");




        logger.info("=================== xxx定时任务执行结束 ===================");
    }
}
