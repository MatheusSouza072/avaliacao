package com.publicacoes.avaliacao.service;

import com.publicacoes.avaliacao.entity.Defendant;
import com.publicacoes.avaliacao.entity.Process;
import com.publicacoes.avaliacao.exception.CustomHandlerException;

import java.util.List;

public interface DefendantService {
    void createDefendant(Defendant defendant) throws CustomHandlerException;

    List<Defendant> listAllDefendant();
}
