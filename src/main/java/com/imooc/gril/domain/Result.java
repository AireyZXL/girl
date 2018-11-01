package com.imooc.gril.domain;

/**
 * Http请求返回的最外层对象
 *
 * @author zxlei1
 * @date 2018/10/29 22:10
 */
public class Result<T> {

    /**
     *错误码
     */
    private Integer code;

    /**
     * 提示消息
     */
    private String msg;


    /**
     * 具体的内容
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
