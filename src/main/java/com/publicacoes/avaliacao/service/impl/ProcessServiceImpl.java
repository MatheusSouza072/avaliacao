package com.publicacoes.avaliacao.service.impl;

import com.publicacoes.avaliacao.dto.ListProcessDTO;
import com.publicacoes.avaliacao.entity.Process;
import com.publicacoes.avaliacao.exception.CustomHandlerException;
import com.publicacoes.avaliacao.repository.ProcessRepository;
import com.publicacoes.avaliacao.service.ProcessService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProcessServiceImpl implements ProcessService {

    private final ProcessRepository processRepository;

    public ProcessServiceImpl(ProcessRepository processRepository) {
        this.processRepository = processRepository;
    }

    @Override
    public void createProcess(Process process) throws CustomHandlerException {
        validateProcess(process);

        processRepository.save(process);

    }

    @Override
    public void addDefendantToAProcess(Process process) throws CustomHandlerException {
        if (process.getId() == null) {
            throw new CustomHandlerException(HttpStatus.BAD_REQUEST, "Id must not be null");
        }

        Optional<Process> processFind = processRepository.findById(process.getId());
        if (processFind.isEmpty()) {
            throw new CustomHandlerException(HttpStatus.BAD_REQUEST, "Process not found");
        }

        Process finalProcess = processFind.get();
        finalProcess.setId(process.getId());
        finalProcess.setName(process.getName());
        finalProcess.setNumber(process.getNumber());
        finalProcess.setDefendant(process.getDefendant());

        processRepository.save(finalProcess);
    }


    @Override
    public List<ListProcessDTO> returnAllProcess() {
        return processRepository.returnAllProcess();
    }

    private void validateProcess(Process process) throws CustomHandlerException {
        Process processNumber = processRepository.findByNumberProcess(process.getNumber());
        if (Objects.nonNull(processNumber))
            throw new CustomHandlerException(HttpStatus.CONFLICT, "Process already exists");

    }
    @Override
    public void delete(Integer id) {
        processRepository.deleteById(id);
    }
}
