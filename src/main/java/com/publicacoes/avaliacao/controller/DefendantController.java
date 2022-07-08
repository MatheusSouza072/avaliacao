package com.publicacoes.avaliacao.controller;

import com.publicacoes.avaliacao.dto.ListProcessDTO;
import com.publicacoes.avaliacao.dto.SaveProcessDTO;
import com.publicacoes.avaliacao.entity.Defendant;
import com.publicacoes.avaliacao.entity.Process;
import com.publicacoes.avaliacao.exception.CustomHandlerException;
import com.publicacoes.avaliacao.service.DefendantService;
import com.publicacoes.avaliacao.service.ProcessService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/defendant")
public class DefendantController {

    private final DefendantService defendantService;

    @Autowired
    public DefendantController(DefendantService defendantService){
        this.defendantService = defendantService;
    }

    @PostMapping
    @ApiOperation("Criar um réu")
    public ResponseEntity createDefendant(@RequestBody Defendant defendant) throws CustomHandlerException {
        defendantService.createDefendant(defendant);
        return ResponseEntity.ok("Sucess");
    }

    @GetMapping
    @ApiOperation("Listar todos os réus")
    public List<Defendant> listAllDefendant() {
        return defendantService.listAllDefendant();
    }


}

