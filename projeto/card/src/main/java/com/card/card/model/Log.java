package com.card.card.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    private Action action = Action.NONE;
    private Date dataLog = new Date();
    private String userName;
    private String userEmail;
    private String quadroName;
    private String cardTitulo;
    private String cardStatus;
    private String cardDescricao;
    private String cardCriador;
    private Date dataCriacaoCard;
}
