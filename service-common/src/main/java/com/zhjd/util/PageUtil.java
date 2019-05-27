/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PageUtil
 * Author:   whyxs
 * Date:     2019/1/18 15:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zhjd.util;

import com.github.pagehelper.PageInfo;
import com.zhjd.entities.PageInfoVo;

/**
 *
 * @author whyxs
 * @create 2019/1/18
 * @since 1.0.0
 */
public class PageUtil {

    public static Integer setPageNum(Object pageNum){
        try {
            return Integer.parseInt(pageNum.toString());
        } catch (Exception e) {
            return CoreConst.PAGE_NUMBER;
        }
    }

    public static Integer setPageSize(Object pageSize){
        try {
            return Integer.parseInt(pageSize.toString());
        } catch (Exception e) {
            return CoreConst.PAGE_SIZE;
        }
    }


    public static PageInfoVo simplePageInfo(PageInfo pageInfo){
        if (pageInfo != null){
            return new PageInfoVo(pageInfo.getPageNum(),pageInfo.getSize(),pageInfo.getTotal(),pageInfo.getList());
        }
        return new PageInfoVo();
    }

}
