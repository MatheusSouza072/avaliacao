package com.publicacoes.avaliacao.controller;

import com.publicacoes.avaliacao.dto.ListProcessDTO;
import com.publicacoes.avaliacao.entity.Process;
import com.publicacoes.avaliacao.exception.CustomHandlerException;
import com.publicacoes.avaliacao.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/process")
public class ProcessController {

    private final ProcessService processService;

    @Autowired
    public ProcessController(ProcessService cardAccountService, ProcessService processService){
        this.processService = processService;
    }


    @PutMapping
    public ResponseEntity addDefendantToAProcess (@RequestBody Process process) throws CustomHandlerException {
        processService.addDefendantToAProcess(process);
        return ResponseEntity.ok("success");
    }

    @PostMapping
    public ResponseEntity createProcess(@RequestBody Process process) throws CustomHandlerException {
        processService.createProcess(process);
        return ResponseEntity.ok("success");
    }

    @GetMapping
    public List<ListProcessDTO> returnAllProcess() {
        return processService.returnAllProcess();
    }

    @DeleteMapping("/{id}")
    public void deleteProcessById(@PathVariable Integer id) {
        processService.delete(id);
    }

}

