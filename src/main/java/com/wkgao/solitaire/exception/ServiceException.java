package com.wkgao.solitaire.exception;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 3214654654654654613L;

    private String msg;

    private Integer code;

    public ServiceException() {}

    public ServiceException(String msg,Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
