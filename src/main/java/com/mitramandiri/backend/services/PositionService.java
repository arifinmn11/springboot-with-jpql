package com.mitramandiri.backend.services;

import com.mitramandiri.backend.dao.PositionDao;
import com.mitramandiri.backend.entities.Position;
import com.mitramandiri.backend.services.impl.CommonServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PositionService {

    Page<Position> findAllPagination(Pageable pageable);

    List<Position> findAllPosition();

    Position findById(Integer id);

}
