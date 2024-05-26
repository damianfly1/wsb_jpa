package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {
    List<PatientEntity> findPatientsByLastName(String lastName);
    List<PatientEntity> findPatientsWithVisitsGreaterThan(long visitCount);
    List<PatientEntity> findPatientsOlderThan(int age);
}
