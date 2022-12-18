package com.card.card.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "card")
public class Card {
    @Id
    private String id;
    private String titulo;
    private String status;
    private String descricao;
    private String criador;
    private Date dataCriacao = new Date();
    private Quadro quadro;
}
