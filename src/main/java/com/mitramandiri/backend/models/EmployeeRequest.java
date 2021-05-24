package com.mitramandiri.backend.models;

import com.mitramandiri.backend.entities.Position;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class EmployeeRequest extends PageSearch{
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private Date birthDate;
    @NotNull
    private Position position;
    @NotNull
    private Integer idNumber;
    @NotNull
    private Integer gender;
}
