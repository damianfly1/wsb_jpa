package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitDao visitDao;

    @Override
    public List<VisitTO> findVisitsByPatientId(Long patientId) {
        List<VisitEntity> visitEntities = visitDao.findVisitsByPatientId(patientId);
        return visitEntities
                .stream()
                .map(VisitMapper::mapToTO)
                .collect(Collectors.toList());
    }
}
