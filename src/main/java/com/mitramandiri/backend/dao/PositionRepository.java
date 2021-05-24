package com.mitramandiri.backend.dao;

import com.mitramandiri.backend.entities.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
//    List<Position> findByNameLikeOrCodeLike(String name, String code);

//    @Query("select u from Position u where u.name like %?1% or u.code like %?1%")
//    List<Position> findByNameEndsWith(String name);
//
//    @Query(value = "SELECT u FROM Position u ORDER BY id")
//    Page<Position> findAllPositionWithPagination();

    @Query(value = "SELECT u from Position u where u.isDeleted = 'false'")
    Page<Position> findAllPositionWithPagination(Pageable pageable);

//    @Query(value = "SELECT u from Position u where u.isDeleted = 'false'")
//    Position findPositionById(Pageable pageable);

    @Query(value = "SELECT u from Position u where u.isDeleted = 'false'")
    List<Position> findAllPosition();

//    @Modifying
//    @Query(value = "Insert u from ")
//    Position save(Position position);
}
