/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ResponseVo
 * Author:   whyxs
 * Date:     2019/1/17 9:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zhjd.entities;

/**
 *
 * @author whyxs
 * @create 2019/1/17
 * @since 1.0.0
 */
public class ResponseVo<T> {
    private Integer code;
    private String message;
    private T data;

    public ResponseVo(Integer code,String message,T data) {
        this.code = code;
        this.message = message;
        this.data = data;
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
