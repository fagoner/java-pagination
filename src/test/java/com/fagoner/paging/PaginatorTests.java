package com.fagoner.paging;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class PaginatorTests {

    @Test
    public void initialSetup() {
        PaginatorBuilder pb = PaginatorBuilder.of();
        Paginator paginator = pb.build();
        assertThat(paginator.getTotal()).isEqualTo(0);
        assertThat(paginator.getIndex()).isEqualTo(0);
    }

    @Test
    public void onePage() {
        int total = 8;
        int limit = 8;
        int page = 1;

        Paginator paginator = calculatePaginator(page, limit, total);
        assertThat(paginator.getLast()).isNull();
        assertThat(paginator.getNext()).isNull();
        assertThat(paginator.getPrev()).isNull();
        assertThat(paginator.getFirst()).isNull();
        assertThat(paginator.getIndex()).isEqualTo(0);
    }


    @Test
    public void pageOneOfTwoFrom16() {
        int total = 16;
        int limit = 8;
        int page = 1;
        Paginator paginator = calculatePaginator(page, limit, total);
        assertThat(paginator.getLast()).isNull();
        assertThat(paginator.getNext()).isEqualTo(page + 1);
        assertThat(paginator.getPrev()).isNull();
        assertThat(paginator.getFirst()).isNull();
        assertThat(paginator.getIndex()).isEqualTo(0);
    }

    @Test
    public void pageTwoOfTwoFrom16() {
        int total = 16;
        int limit = 8;
        int page = 2;
        int index = limit;
        Paginator paginator = calculatePaginator(page, limit, total);
        assertThat(paginator.getLast()).isNull();
        assertThat(paginator.getNext()).isNull();
        assertThat(paginator.getPrev()).isEqualTo(page - 1);
        assertThat(paginator.getFirst()).isNull();
        assertThat(paginator.getIndex()).isEqualTo(index);
    }

    @Test
    public void page3Limit8Total40() {
        int total = 40;
        int limit = 8;
        int page = 3;
        int last = calculateLast(total, limit);
        int index = calculateIndex(page, limit);
        Paginator paginator = calculatePaginator(page, limit, total);
        assertThat(paginator.getLast()).isEqualTo(last);
        assertThat(paginator.getNext()).isEqualTo(page + 1);
        assertThat(paginator.getPrev()).isEqualTo(page - 1);
        assertThat(paginator.getFirst()).isEqualTo(1);
        assertThat(paginator.getIndex()).isEqualTo(index);
    }

    @Test
    public void page1Limit5Total8() {
        int total = 8;
        int limit = 5;
        int page = 1;
        int index = 0;
        Paginator paginator = calculatePaginator(page, limit, total);
        assertThat(paginator.getLast()).isNull();
        assertThat(paginator.getNext()).isEqualTo(page + 1);
        assertThat(paginator.getPrev()).isNull();
        assertThat(paginator.getFirst()).isNull();
        assertThat(paginator.getIndex()).isEqualTo(0);
    }

    @Test
    public void page2Limit5Total42() {
        int page = 3;
        int total = 42;
        int limit = 5;
        int last = calculateLast(total, limit);
        int index = calculateIndex(page, limit);
        Paginator paginator = calculatePaginator(page, limit, total);
        assertThat(paginator.getLast()).isEqualTo(last);
        assertThat(paginator.getNext()).isEqualTo(page + 1);
        assertThat(paginator.getPrev()).isEqualTo(page - 1);
        assertThat(paginator.getFirst()).isEqualTo(1);
        assertThat(paginator.getIndex()).isEqualTo(index);
    }

    private int calculateLast(int total, int limit) {
        return (int) Math.ceil((double) total / (double) limit);
    }

    private int calculateIndex(int page, int limit) {
        return (page - 1) * limit;
    }

    private Paginator calculatePaginator(int page, int limit, int total) {
        return PaginatorBuilder
                .of()
                .setPage(page)
                .setTotal(total)
                .setLimit(limit)
                .build();
    }

}
