package com.heqianqian.testretrofit.entity;

/**
 * Result
 * Created by heqianqian on 2017/3/26.
 */
public class Result<T> {
    public int code;
    public String msg;
    public T data;
    public long count;
    public long page;

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", count=" + count +
                ", page=" + page +
                '}';
    }
}

