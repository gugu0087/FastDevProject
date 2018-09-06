package com.xyc.fastdevproject.model;

/**
 * Create by Admin on 2018/9/6
 */
public class BaseModel<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
