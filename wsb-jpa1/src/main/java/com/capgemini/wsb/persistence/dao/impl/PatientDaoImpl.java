package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public List<PatientEntity> findPatientsByLastName(String lastName) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithVisitsGreaterThan(long visitCount) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p JOIN p.visits v GROUP BY p HAVING COUNT(v) > :visitCount", PatientEntity.class)
                .setParameter("visitCount", visitCount)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsOlderThan(int age) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.Age > :age", PatientEntity.class)
                .setParameter("age", age)
                .getResultList();
    }
}
