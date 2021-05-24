package com.mitramandiri.backend.dao;

import com.mitramandiri.backend.entities.Position;

import java.util.List;

public interface PositionDao {
    List<Position> findAll();

    Position findById(int id);

    void save(Position employee);

    void deleteById(int id);
}
