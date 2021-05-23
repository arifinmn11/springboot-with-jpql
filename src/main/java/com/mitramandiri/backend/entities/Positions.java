package com.mitramandiri.backend.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "positions")
@Getter
@Setter
@NoArgsConstructor
public class Positions extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    @NotNull
    private String code;

    @Column(length = 100, nullable = false)
    @NotNull
    private String name;

}