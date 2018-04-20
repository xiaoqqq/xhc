package com.xhc.xcxapi.entity;

/**
 * @author xiaoqqq by 2018/4/17 15:39
 * @desc: TODO
 */
public class BaseBean<T> {
    int code;
    String message;
    T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getRsult() {
        return result;
    }

    public void setRsult(T t) {
        this.result = t;
    }
}
