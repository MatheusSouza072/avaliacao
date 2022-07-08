package com.publicacoes.avaliacao.services;



import com.publicacoes.avaliacao.entity.Defendant;

import com.publicacoes.avaliacao.repository.DefendantRepository;

import com.publicacoes.avaliacao.service.impl.DefendantServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DefendantServiceImplTest {

    @InjectMocks
    private DefendantServiceImpl defendantService;

    @Mock
    private DefendantRepository defendantRepository;
    List<Defendant> defendants = new ArrayList<>();

    @Before
    public void setUp() {
        Defendant defendant = new Defendant() {

            @Override
            public Integer getId() {
                return 1;
            }

            @Override
            public String getName() {
                return "teste";
            }
        };
        defendants.clear();
        defendants.add(defendant);
    }

    @Test
    public void mustBeReturnAllDefendant(){
        when(defendantRepository.listAllDefendant()).thenReturn(defendants);
        List<Defendant> defendantList = defendantService.listAllDefendant();
        assert(defendantList.size() == 1);
        verify(defendantRepository).listAllDefendant();
    }

    @Test
    public void mustSaveDefendant(){
        Defendant newDefendant = new Defendant(1,"teste");
        when(defendantRepository.save(any(Defendant.class))).thenReturn(newDefendant);
        List<Defendant> defendantList = defendantService.listAllDefendant();
        assert(defendantList.size() == 0);
    }
}
