package com.log.log.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "log")
public class Log {
    @Id
    private String id;
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
