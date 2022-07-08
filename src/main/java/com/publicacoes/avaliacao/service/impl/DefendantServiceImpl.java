package com.publicacoes.avaliacao.service.impl;

import com.publicacoes.avaliacao.entity.Defendant;

import com.publicacoes.avaliacao.exception.CustomHandlerException;
import com.publicacoes.avaliacao.repository.DefendantRepository;

import com.publicacoes.avaliacao.service.DefendantService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DefendantServiceImpl implements DefendantService {

    private final DefendantRepository defendantRepository;

    public DefendantServiceImpl(DefendantRepository defendantRepository) {
        this.defendantRepository = defendantRepository;
    }

    @Override
    public void createDefendant(Defendant defendant) throws CustomHandlerException {
        defendantRepository.save(defendant);

    }


    @Override
    public List<Defendant> listAllDefendant() {
        return defendantRepository.listAllDefendant();
    }

    private void validateProcess(Defendant defendant) throws CustomHandlerException {
        Optional<Defendant> defendantId = defendantRepository.findById(defendant.getId());
        if (Objects.nonNull(defendantId))
            throw new CustomHandlerException(HttpStatus.CONFLICT, "Defendant already exists");

    }

}
