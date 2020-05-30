package com.changgou.common.pojo;

/**
 * 返回结果实体类
 *
 * @Author zhuzhiqiang
 * @Date 2020/5/25 8:54 上午
 */
public class Result<T> {

    /**
     * 是否成功
     */
    private boolean flag;

    /**
     * 用户类型
     *
     * @see StatusCode
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回的数据
     */
    private T data;

    public Result(boolean flag, Integer code, String message, T data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = (T) data;
    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result() {
        this.flag = true;
        this.code = StatusCode.OK;
        this.message = "执行成功";
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
