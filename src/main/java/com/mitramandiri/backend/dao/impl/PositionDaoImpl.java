package com.mitramandiri.backend.dao.impl;

import com.mitramandiri.backend.dao.PositionDao;
import com.mitramandiri.backend.entities.Position;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class PositionDaoImpl implements PositionDao {
    //define field for entityManager
    @Autowired
    private EntityManager entityManager;

    //set up constructor injection
    // constructor injection (automatically created by spring boot)
//    @Autowired
//    public PositionDaoImpl(EntityManager theEntityManager) {
//        entityManager = theEntityManager;
//    }

    @Override
    @Transactional
    public List<Position> findAll() {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create a query
        //using native Hibernate API
        List<Position> positions = currentSession.createQuery("FROM positions", Position.class).getResultList();
//
//        //execute query and get result list
//        List<Position> positions = query.getResultList();
//        List<Position> positions =

        //return the results
        return positions;
    }

    @Override
    public Position findById(int id) {

        int theId = id;
        Session currentSession = entityManager.unwrap(Session.class);
        Position position = currentSession.get(Position.class, theId);
        return position;
    }

    @Override
    public void save(Position position) {

        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(position);
    }

    @Override
    public void deleteById(int id) {

        int theId = id;
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Position> query = currentSession.createQuery("DELETE FROM positions WHERE id=:idToDelete");
        query.setParameter("idToDelete", id);
        query.executeUpdate();
    }
}
