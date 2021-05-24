package com.mitramandiri.backend.models.search;

import com.mitramandiri.backend.models.PageSearch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionSearch extends PageSearch {
    private String name;
    private String code;
}
