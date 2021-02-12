package model;

import org.springframework.data.domain.Page;

import java.util.List;


public class CustomPage<T> {
    private final long page;
    private final long size;
    private final long totalPages;
    private final List<T> content;

    public CustomPage(Page<?> page, List<T> content) {
        this.page = page.getNumber();
        this.size = page.getSize();
        this.totalPages = page.getTotalPages();
        this.content = content;
    }
}

