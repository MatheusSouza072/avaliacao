package com.publicacoes.avaliacao.repository;

import com.publicacoes.avaliacao.entity.Defendant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DefendantRepository extends JpaRepository<Defendant, Integer> {

    @Query(value = "select * from defendant d", nativeQuery = true)
    List<Defendant> listAllDefendant();
}
