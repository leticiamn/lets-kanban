package com.quadro.quadro.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "quadro")
public class Quadro {
    @Id
    private String id;
    private String name;
    @JsonManagedReference
    private List<Card> cardList = new ArrayList<>();
}
