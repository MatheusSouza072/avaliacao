package com.publicacoes.avaliacao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SaveProcessDTO {

    private Integer id;

    private String number;

    private String name;

    private Integer defendantId;
}
