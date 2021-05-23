package com.mitramandiri.backend.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
public class Employees extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    @NotNull
    private String name;

    @Column(nullable = false, name = "birth_date")
    @NotNull
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Positions positionId;

    @Column(nullable = false, name = "id_number")
    @NotNull
    private Integer idNumber;

    @Column(nullable = false)
    @NotNull
    private Integer gender;

}