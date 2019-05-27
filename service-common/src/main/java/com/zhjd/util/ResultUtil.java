/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ResultUtil
 * Author:   whyxs
 * Date:     2019/1/16 17:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zhjd.util;

import com.zhjd.entities.ResponseVo;

/**
 *
 * @author whyxs
 * @create 2019/1/16
 * @since 1.0.0
 */
public class ResultUtil {

    public static ResponseVo success(){
        return build(CoreConst.RESPONSE_SUCCESS_CODE,null,null);
    }

    public static ResponseVo success(String message){
        return build(CoreConst.RESPONSE_SUCCESS_CODE,message,null);
    }

    public static ResponseVo success(String message,Object data){
        return build(CoreConst.RESPONSE_SUCCESS_CODE,message,data);
    }

    public static ResponseVo error(){
        return build(CoreConst.RESPONSE_ERROR_CODE,null,null);
    }

    public static ResponseVo error(String message){
        return build(CoreConst.RESPONSE_ERROR_CODE,message,null);
    }

    public static ResponseVo error(String message,Object data){
        return build(CoreConst.RESPONSE_ERROR_CODE,message,data);
    }

    private static ResponseVo build(Integer code,String message,Object data){
        return new ResponseVo<Object>(code, message, data);
    }
}
