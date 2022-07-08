package com.publicacoes.avaliacao.repository;

import com.publicacoes.avaliacao.dto.ListProcessDTO;
import com.publicacoes.avaliacao.entity.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Integer> {
    @Query(value = "select * from public.process p \n" +
            "where p.number = :number\n", nativeQuery = true)
    Process findByNumberProcess(String number);
    
    @Query(value = "select p.id as getId, p.number as NumberProcess, p.name as NameProcess from process p", nativeQuery = true)
    List<ListProcessDTO> returnAllProcess();

}
