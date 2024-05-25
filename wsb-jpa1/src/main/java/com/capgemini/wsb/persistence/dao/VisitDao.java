package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;

public interface VisitDao extends Dao<VisitEntity, Long> {
    void deleteAllByPatientId(Long patientId);
    List<VisitEntity> findVisitsByPatientId(Long patientId);
}