package com.mitramandiri.backend.models;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageList<T> {
    private List<T> list;
    private Integer page;
    private Integer size;
    private Long total;

    public PageList(List<T> list, Integer page, Integer size, Long total) {
        this.list = list;
        this.page = page;
        this.size = size;
        this.total = total;
    }
}
