package com.mitramandiri.backend.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionRequest {
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String code;

}
