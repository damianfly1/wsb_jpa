package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private DoctorDao doctorDao;

    @Transactional
    @Test
    public void testShouldDeletePatientAndVisitsButNotDoctors() {
        // given
        long patientId = 2;
        long visitId = 2;
        int initialDoctorCount = 3;

        // when
        patientService.deleteById(patientId);

        // then
        assertThat(patientDao.findOne(patientId)).isNull();
        assertThat(visitDao.findOne(visitId)).isNull();
        assertThat(doctorDao.count()).isEqualTo(initialDoctorCount);
    }

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given
        long patientId = 1;

        // when
        PatientTO patientTO = patientService.findById(patientId);

        // then
        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getId()).isEqualTo(1);
        assertThat(patientTO.getFirstName()).isEqualTo("Alice");
        assertThat(patientTO.getLastName()).isEqualTo("Johnson");
        assertThat(patientTO.getTelephoneNumber()).isEqualTo("111222333");
        assertThat(patientTO.getEmail()).isEqualTo("alice.johnson@example.com");
        assertThat(patientTO.getPatientNumber()).isEqualTo("PAT001");
        assertThat(patientTO.getDateOfBirth()).isEqualTo("1980-01-15");
        assertThat(patientTO.getAge()).isEqualTo(44);
    }
}
