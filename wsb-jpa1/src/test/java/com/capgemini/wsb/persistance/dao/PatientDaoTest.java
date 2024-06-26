package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testFindPatientsByLastName() {
        // when
        List<PatientEntity> patients = patientDao.findPatientsByLastName("Johnson");

        // then
        assertThat(patients).isNotNull();
        assertThat(patients).hasSize(1);
        assertThat(patients.get(0).getLastName()).isEqualTo("Johnson");
    }

    @Transactional
    @Test
    public void testFindPatientsWithVisitsGreaterThan() {
        // when
        List<PatientEntity> patients = patientDao.findPatientsWithVisitsGreaterThan(1l);

        // then
        assertThat(patients).isNotNull();
        assertThat(patients).hasSize(1);
        assertThat(patients.get(0).getLastName()).isEqualTo("Williams");
    }

    @Transactional
    @Test
    public void testFindPatientsOlderThan() {
        // when
        List<PatientEntity> patients = patientDao.findPatientsOlderThan(35);

        // then
        assertThat(patients).isNotNull();
        assertThat(patients).hasSize(1);
        assertThat(patients.get(0).getId()).isEqualTo(1l);
    }
}
