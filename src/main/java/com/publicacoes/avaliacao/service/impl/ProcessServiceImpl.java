package com.publicacoes.avaliacao.service.impl;

import com.publicacoes.avaliacao.dto.ListProcessDTO;
import com.publicacoes.avaliacao.dto.SaveProcessDTO;
import com.publicacoes.avaliacao.entity.Defendant;
import com.publicacoes.avaliacao.entity.Process;
import com.publicacoes.avaliacao.exception.CustomHandlerException;
import com.publicacoes.avaliacao.repository.DefendantRepository;
import com.publicacoes.avaliacao.repository.ProcessRepository;
import com.publicacoes.avaliacao.service.ProcessService;
import liquibase.pro.packaged.P;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProcessServiceImpl implements ProcessService {

    private final ProcessRepository processRepository;
    private final DefendantRepository defendantRepository;

    public ProcessServiceImpl(ProcessRepository processRepository, DefendantRepository defendantRepository) {
        this.processRepository = processRepository;
        this.defendantRepository = defendantRepository;
    }

    @Override
    public void createProcess(Process process) throws CustomHandlerException {
        validateProcess(process);
        processRepository.save(process);

    }

    @Override
    public Process addDefendantToAProcess(SaveProcessDTO saveProcessDTO) throws CustomHandlerException {
        Optional<Defendant> defendantType = defendantRepository.findById(saveProcessDTO.getDefendantId());

        Process process = new Process();

        process.setId(saveProcessDTO.getId());
        process.setName(saveProcessDTO.getName());
        process.setNumber(saveProcessDTO.getNumber());
        process.setDefendant(defendantType.get());

        return processRepository.save(process);
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
