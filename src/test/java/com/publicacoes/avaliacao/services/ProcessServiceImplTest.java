package com.publicacoes.avaliacao.services;


import com.publicacoes.avaliacao.dto.ListProcessDTO;

import com.publicacoes.avaliacao.entity.Process;
import com.publicacoes.avaliacao.exception.CustomHandlerException;
import com.publicacoes.avaliacao.repository.ProcessRepository;
import com.publicacoes.avaliacao.service.impl.ProcessServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProcessServiceImplTest {

    @InjectMocks
    private ProcessServiceImpl processServiceImpl;

    @Mock
    private ProcessRepository processRepository;

    List<ListProcessDTO> process = new ArrayList<>();

    @Before
    public void setUp() {
        ListProcessDTO itemDescriptionDto = new ListProcessDTO() {

            @Override
            public Integer getId() {
                return 1;
            }

            @Override
            public String getNumberProcess() {
                return "100";
            }

            @Override
            public String getNameProcess() {
                return "Processo1";
            }
        };
        process.clear();
        process.add(itemDescriptionDto);
    }

    @Test
    public void mustBeReturnAllProcess(){
        when(processRepository.returnAllProcess()).thenReturn(process);
        List<ListProcessDTO> processList = processServiceImpl.returnAllProcess();
        assert(processList.size() == 1);
        assert(processList.get(0).getNumberProcess() == "100");
        assert(processList.get(0).getNameProcess().equals("Processo1"));
        verify(processRepository).returnAllProcess();
    }

    @Test
    public void mustBeReturnProcessDetail() {

        String number = "1";

        when(processRepository.findByNumberProcess(number))
                .thenReturn(Process.builder().number(number).build());

        Process process = processRepository
                .findByNumberProcess(number);

        assertThat(process).satisfies(co -> assertThat(co.getNumber()).isEqualTo("0"));
    }

    @Test
    public void mustBeReturnExceptionWhenNumberNotFound() throws CustomHandlerException {

        String number = "1";

        when(processRepository.findByNumberProcess(number))
                .thenReturn(Process.builder().number(number).build());

        Process process = processRepository
                .findByNumberProcess(number);


        assertThat(process).satisfies(co -> assertThat(co.getNumber()).isEqualTo("0"));
    }

    @Test
    public void mustBeReturnExceptionWhenProcessExist() {

        Process process = Process.builder()
                .id(1)
                .number("555")
                .build();


        Process idProcess = Process.builder().id(1).build();
        Process processNumber = Process.builder().id(1).build();


        when(processRepository.findById(1)).thenReturn(Optional.of(idProcess));
        when(processRepository.findByNumberProcess("555")).thenReturn(processNumber);

        String expectedMessage = "Process already exists";
        String exceptionMessage = "";
        try {
            processServiceImpl.createProcess(process);
        } catch (CustomHandlerException e) {
            exceptionMessage = e.getMessage();
        }
        assertThat(exceptionMessage).isEqualTo(expectedMessage);
    }



}
