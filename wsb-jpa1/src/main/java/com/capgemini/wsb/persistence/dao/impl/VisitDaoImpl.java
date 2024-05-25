package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class VisitDaoImpl extends AbstractDao<VisitEntity, Long> implements VisitDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void deleteAllByPatientId(Long patientId) {
        entityManager.createQuery("DELETE FROM VisitEntity v WHERE v.patient.id = :patientId")
                .setParameter("patientId", patientId)
                .executeUpdate();
    }

    @Override
    public List<VisitEntity> findVisitsByPatientId(Long patientId) {
        return entityManager.createQuery("SELECT v FROM VisitEntity v WHERE v.patient.id = :patientId", VisitEntity.class)
                .setParameter("patientId", patientId)
                .getResultList();
    }
}
