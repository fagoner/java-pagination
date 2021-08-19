package com.fagoner.paging;

public class PageData {

    private int pageSize;

    private int page;

    private int total;

    private int index = 0;

    private int pages = 1;

    private int rangeBegin = 0;

    private int rangeEnd = 0;

    public PageData(int page, int pageSize, int total) {
        this.pageSize = pageSize;
        this.page = page;
        this.total = total;
    }

    public PageData calculate() {
        if (this.total < 0)
            this.total = 0;
        if (this.page < 1)
            this.page = 1;
        if (this.pageSize < 1)
            this.pageSize = 8;

        calculateIndex();
        calculatePages();
        calculateRanges();

        return this;
    }

    private void calculateIndex() {
        if (this.page > 1)
            this.index = (this.page - 1) * this.pageSize;
    }

    private void calculatePages() {
        if (this.total > 0) {
            double value = (double) this.total / (double) this.pageSize;
            this.pages = (int) Math.ceil(value);
        }
    }

    private void calculateRanges() {
        if (this.total > 0) {
            this.rangeBegin = this.index + 1;
            if (this.page == this.pages) {
                this.rangeEnd = this.total;
            } else {
                this.rangeEnd = this.index + this.pageSize;
            }
        }
    }


    public int getIndex() {
        return index;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPage() {
        return page;
    }

    public int getTotal() {
        return total;
    }

    public int getPages() {
        return pages;
    }

    public int getRangeBegin() {
        return rangeBegin;
    }

    public int getRangeEnd() {
        return rangeEnd;
    }

}
