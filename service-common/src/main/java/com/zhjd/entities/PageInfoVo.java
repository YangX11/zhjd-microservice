/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PageInfoVo
 * Author:   whyxs
 * Date:     2019/1/18 15:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zhjd.entities;

import java.util.List;

/**
 *
 * @author whyxs
 * @create 2019/1/18
 * @since 1.0.0
 */
public class PageInfoVo<T> {

    private Integer pageNum;
    private Integer pageSize;
    private Long total;
    private List<T> list;

    public PageInfoVo() {
    }

    public PageInfoVo(Integer pageNum, Integer pageSize, Long total, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
