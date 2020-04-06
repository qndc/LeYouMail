package com.leyou.common.pojo;

import java.util.List;

/**
 * @Auther: dc
 * @Date: 2020/4/6 13:43
 * @Description:
 */
public class PageResult<T> {

    private List<T> items;  //当前页数据
    private Integer totalPage;  //总页数
    private Long total; //总条数
    private Integer pageSize;   //每页显示数量
    private Integer page;   //当前页码

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public PageResult() {
    }

    public PageResult(List<T> items, Integer totalPage, Long total, Integer pageSize, Integer page) {
        this.items = items;
        this.totalPage = totalPage;
        this.total = total;
        this.pageSize = pageSize;
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
