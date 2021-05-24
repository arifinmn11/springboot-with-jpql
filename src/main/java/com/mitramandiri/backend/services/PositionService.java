package com.mitramandiri.backend.services;

import com.mitramandiri.backend.dao.PositionDao;
import com.mitramandiri.backend.entities.Position;

import java.util.List;

public interface PositionService{
//    List<Position> findByNameContainingOrCodeContaining(String name, String code);

    List<Position> findAll();

    Position findById(int id);

    void save(Position position);

    void deleteById(int id);
}
