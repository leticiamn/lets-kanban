package com.log.log.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quadro {
    private String id;
    private String name;
    private List<Card> cardList = new ArrayList<>();
}
