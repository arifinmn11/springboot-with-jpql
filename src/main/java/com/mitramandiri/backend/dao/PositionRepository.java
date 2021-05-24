package com.mitramandiri.backend.dao;

import com.mitramandiri.backend.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
    List<Position> findByNameLikeOrCodeLike(String name, String code);
}
