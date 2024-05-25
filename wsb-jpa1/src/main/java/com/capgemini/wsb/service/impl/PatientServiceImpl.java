package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private VisitDao visitDao;

    @Override
    public PatientTO findById(Long id) {
        PatientEntity patientEntity = patientDao.findOne(id);
        return PatientMapper.mapToTO(patientEntity);
    }

    @Override
    public void deleteById(Long id) {
        PatientEntity patientEntity = patientDao.findOne(id);
        if (patientEntity != null) {
            visitDao.deleteAllByPatientId(id);
            patientDao.delete(id);
        }
    }
}
