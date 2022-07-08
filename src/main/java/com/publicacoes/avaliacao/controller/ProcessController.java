package com.publicacoes.avaliacao.controller;

import com.publicacoes.avaliacao.dto.ListProcessDTO;
import com.publicacoes.avaliacao.dto.SaveProcessDTO;
import com.publicacoes.avaliacao.entity.Process;
import com.publicacoes.avaliacao.exception.CustomHandlerException;
import com.publicacoes.avaliacao.service.ProcessService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/process")
public class ProcessController {

    private final ProcessService processService;

    @Autowired
    public ProcessController(ProcessService processService){
        this.processService = processService;
    }

    @PutMapping
    @ApiOperation("Adicionar réu a processo")
    public ResponseEntity addDefendantToAProcess (@RequestBody SaveProcessDTO saveProcessDTO) throws CustomHandlerException {
        processService.addDefendantToAProcess(saveProcessDTO);
        return ResponseEntity.ok("Sucess");

    }

    @PostMapping
    @ApiOperation("Criar um processo")
    public ResponseEntity createProcess(@RequestBody Process process) throws CustomHandlerException {
        processService.createProcess(process);
        return ResponseEntity.ok("Sucess");
    }

    @GetMapping
    @ApiOperation("Retorna todos os processos")
    public List<ListProcessDTO> returnAllProcess() {
        return processService.returnAllProcess();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deletar processo")
    public void deleteProcessById(@PathVariable Integer id) {
        processService.delete(id);
    }

}

