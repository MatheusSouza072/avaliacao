package com.publicacoes.avaliacao.service;

import com.publicacoes.avaliacao.dto.ListProcessDTO;
import com.publicacoes.avaliacao.entity.Process;
import com.publicacoes.avaliacao.exception.CustomHandlerException;

import java.util.List;
import java.util.Optional;

public interface ProcessService {
    void createProcess(Process process) throws CustomHandlerException;

    void addDefendantToAProcess(Process process) throws CustomHandlerException;

    List<ListProcessDTO> returnAllProcess();

    void delete(Integer id);


}
