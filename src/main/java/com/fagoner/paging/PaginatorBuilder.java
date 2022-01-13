package com.fagoner.paging;

public class PaginatorBuilder {

    private int page = 1;
    private int limit = 8;
    private int total = 0;
    private int index = 0;

    private Integer last = null;
    private Integer next = null;
    private Integer prev = null;
    private Integer first = null;

    public static PaginatorBuilder of() {
        return new PaginatorBuilder();
    }

    public PaginatorBuilder setPage(int page) {
        this.page = page;
        return this;
    }

    public PaginatorBuilder setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public PaginatorBuilder setTotal(int total) {
        this.total = total;
        return this;
    }

    private int calculateLast() {
        return (int) Math.ceil((double) total / (double) limit);
    }

    private void setDefaultValues() {
        if (page < 1)
            page = 1;

        if (limit < 1)
            limit = 8;

        if (total < 1)
            total = 0;
    }

    private void calculate() {
        setDefaultValues();
        int calculatedLast = calculateLast();

        if (calculatedLast <= 1)
            return;

        if (page + 1 != calculatedLast && page != calculatedLast)
            last = calculatedLast;

        if (page < calculatedLast)
            next = page + 1;

        if (page > 1) {
            index = (page - 1) * limit;
            prev = page - 1;

            if (page - 1 != 1)
                first = 1;
        }
    }

    public Paginator build() {
        calculate();
        return new Paginator(page, limit, total, index, prev, next, last, first);
    }

}
