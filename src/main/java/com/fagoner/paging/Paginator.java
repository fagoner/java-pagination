package com.fagoner.paging;

public class Paginator {

    private int page;
    private int limit;
    private int total;
    private int index;
    private Integer prev;
    private Integer next;
    private Integer last;
    private Integer first;

    public Paginator(int page, int limit, int total, int index, Integer prev, Integer next, Integer last, Integer first) {
        this.page = page;
        this.limit = limit;
        this.total = total;
        this.index = index;
        this.prev = prev;
        this.next = next;
        this.last = last;
        this.first = first;
    }

    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotal() {
        return total;
    }

    public Integer getPrev() {
        return prev;
    }

    public Integer getNext() {
        return next;
    }

    public Integer getLast() {
        return last;
    }

    public Integer getFirst() {
        return first;
    }

    public int getIndex() {
        return index;
    }

}
