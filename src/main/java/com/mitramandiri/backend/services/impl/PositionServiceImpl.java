package com.mitramandiri.backend.services.impl;

import com.mitramandiri.backend.dao.PositionDao;
import com.mitramandiri.backend.dao.PositionRepository;
import com.mitramandiri.backend.entities.Position;
import com.mitramandiri.backend.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PositionServiceImpl extends CommonServiceImpl<Position, Integer> implements PositionService {

//    @Autowired
//    PositionRepository repository;

    @Autowired
    PositionDao positionDao;

    @Autowired
    PositionRepository positionRepository;

    public PositionServiceImpl(JpaRepository<Position, Integer> repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Page<Position> findAllPagination(Pageable pageable) {
        return positionRepository.findAllPositionWithPagination(pageable);
    }

    @Override
    @Transactional
    public List<Position> findAllPosition() {
        return positionRepository.findAllPosition();
    }

//
//    @Override
//    @Transactional
//    public Position findById(int id) {
//        return positionDao.findById(id);
//    }

//    @Override
//    @Transactional
//    public void save(Position position) {
//        positionDao.save(position);
//    }

//    @Override
//    @Transactional
//    public void deleteById(int id) {
//        positionDao.deleteById(id);
//    }
//
//    @Override
//    public List<Position> findByName(String name) {
//        return positionRepository.findByNameEndsWith(name);
//    }

//    @Override
//    public Page<Position> findAllPosition() {
//        return positionRepository.findAllPositionWithPagination();
//    }

    //    public PositionServiceImpl(JpaRepository<Position, Integer> repository) {
//        super(repository);
//    }

//    @Override
//    public List<Position> findByNameContainingOrCodeContaining(String name, String code) {
//        return repository.findByNameLikeOrCodeLike(name, code);
//    }
}
