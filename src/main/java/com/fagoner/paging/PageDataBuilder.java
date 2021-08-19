package com.fagoner.paging;

public class PageDataBuilder {

    private int total = 0;
    private int pageSize = 0;
    private int page = 0;

    public static PageDataBuilder of() {
        return new PageDataBuilder();
    }

    public PageDataBuilder setTotal(int total) {
        this.total = total;
        return this;
    }

    public PageDataBuilder setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public PageDataBuilder setPage(int page) {
        this.page = page;
        return this;
    }

    public PageData build() {
        PageData pageData = new PageData(this.page, this.pageSize, this.total);
        pageData.calculate();
        return pageData;
    }

}
