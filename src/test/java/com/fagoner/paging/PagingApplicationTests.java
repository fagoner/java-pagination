package com.fagoner.paging;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class PagingApplicationTests {

    @Test
    void firstPage() {
        int page = 1;
        int pageSize = 8;
        int total = 10;

        int rangeBegin = page;
        int rangeEnd = pageSize;

        PageData pageData = PageDataBuilder.of()
                .setTotal(total)
                .setPageSize(pageSize)
                .setPage(page).build();

        assertThat(pageData.getPages()).isEqualTo(2);
        assertThat(pageData.getIndex()).isEqualTo(0);
        assertThat(pageData.getPageSize()).isEqualTo(pageSize);
        assertThat(pageData.getTotal()).isEqualTo(total);
        assertThat(pageData.getPage()).isEqualTo(page);
        assertThat(pageData.getRangeBegin()).isEqualTo(rangeBegin);
        assertThat(pageData.getRangeEnd()).isEqualTo(rangeEnd);
    }

    @Test
    void secondPage() {
        int page = 2;
        int pageSize = 8;
        int total = 10;

        int rangeBegin = (page - 1) * pageSize + 1;
        int rangeEnd = 10;

        PageData pageData = PageDataBuilder.of()
                .setPage(page)
                .setPageSize(pageSize)
                .setTotal(total)
                .build();

        assertThat(pageData.getPages()).isEqualTo(2);
        assertThat(pageData.getIndex()).isEqualTo(8);
        assertThat(pageData.getPageSize()).isEqualTo(pageSize);
        assertThat(pageData.getTotal()).isEqualTo(total);
        assertThat(pageData.getPage()).isEqualTo(page);
        assertThat(pageData.getRangeBegin()).isEqualTo(rangeBegin);
        assertThat(pageData.getRangeEnd()).isEqualTo(rangeEnd);
    }

    @Test
    void pageHigher() {
        int page = 1;
        int pageSize = 8;
        int total = 210;

        int pages = 27; // 210 / 8 => 26.25 ~> 27
        int rangeBegin = 1;
        int rangeEnd = pageSize;

        int index = 0;

        PageData pageData = PageDataBuilder.of()
                .setPage(page)
                .setPageSize(pageSize)
                .setTotal(total)
                .build();

        assertThat(pageData.getPages()).isEqualTo(pages);
        assertThat(pageData.getIndex()).isEqualTo(index);
        assertThat(pageData.getPageSize()).isEqualTo(pageSize);
        assertThat(pageData.getTotal()).isEqualTo(total);
        assertThat(pageData.getPage()).isEqualTo(page);
        assertThat(pageData.getRangeBegin()).isEqualTo(rangeBegin);
        assertThat(pageData.getRangeEnd()).isEqualTo(rangeEnd);
    }


    @Test
    public void withDefaultValues() {
        PageData pageData = PageDataBuilder.of().build();
        assertThat(pageData.getPages()).isEqualTo(1);
        assertThat(pageData.getIndex()).isEqualTo(0);
        assertThat(pageData.getPageSize()).isEqualTo(8);
        assertThat(pageData.getTotal()).isEqualTo(0);
        assertThat(pageData.getPage()).isEqualTo(1);
        assertThat(pageData.getRangeBegin()).isEqualTo(0);
        assertThat(pageData.getRangeEnd()).isEqualTo(0);
    }

    @Test
    public void smallTable() {
        int total = 4;
        int pageSize = 8;
        int page = 1;
        PageData pageData = PageDataBuilder.of()
                .setTotal(total)
                .setPageSize(pageSize)
                .setPage(page)
                .build();

        assertThat(pageData.getPages()).isEqualTo(1);
        assertThat(pageData.getIndex()).isEqualTo(0);
        assertThat(pageData.getPageSize()).isEqualTo(8);
        assertThat(pageData.getTotal()).isEqualTo(4);
        assertThat(pageData.getPage()).isEqualTo(1);
        assertThat(pageData.getRangeBegin()).isEqualTo(1);
        assertThat(pageData.getRangeEnd()).isEqualTo(4);
    }

}
