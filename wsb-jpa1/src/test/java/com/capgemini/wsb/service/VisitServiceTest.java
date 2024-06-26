package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.service.impl.VisitServiceImpl;
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
public class VisitServiceTest {

    @Autowired
    private VisitServiceImpl visitService;

    @Transactional
    @Test
    public void testFindVisitsByPatientId() {
        // when
        List<VisitTO> visits = visitService.findVisitsByPatientId(2l);

        // then
        assertThat(visits).isNotNull();
        assertThat(visits).hasSize(2);
        assertThat(visits.get(0).getPatient().getId()).isEqualTo(2l);
        assertThat(visits.get(1).getPatient().getId()).isEqualTo(2l);
    }
}
