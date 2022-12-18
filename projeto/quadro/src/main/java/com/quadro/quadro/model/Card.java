package com.quadro.quadro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private String id;
    private String titulo;
    private String status;
    private String descricao;
    private String criador;
    private Date dataCriacao = new Date();
    @JsonBackReference
    private Quadro quadro;
}
