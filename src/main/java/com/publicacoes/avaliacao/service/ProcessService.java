package com.publicacoes.avaliacao.service;

import com.publicacoes.avaliacao.dto.ListProcessDTO;
import com.publicacoes.avaliacao.dto.SaveProcessDTO;
import com.publicacoes.avaliacao.entity.Process;
import com.publicacoes.avaliacao.exception.CustomHandlerException;

import java.util.List;

public interface ProcessService {
    void createProcess(Process process) throws CustomHandlerException;

    Process addDefendantToAProcess(SaveProcessDTO saveProcessDTO) throws CustomHandlerException;

    List<ListProcessDTO> returnAllProcess();

    void delete(Integer id);


}
