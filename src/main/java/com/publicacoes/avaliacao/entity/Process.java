package com.publicacoes.avaliacao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "process", schema = "public")
@SuperBuilder
@ToString
public class Process {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "number")
    private String number;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "defendant_id")
    private Defendant defendant;
}
