package com.card.card.controller;

import com.card.card.model.Card;
import com.card.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping
    public Card create(@RequestBody Card card) {
        return cardService.create(card);
    }

    @GetMapping("/{id}")
    public Card find(@PathVariable String id) {
        return cardService.find(id);
    }

    @GetMapping("/criador/{id}")
    public List<Card> findByCriador(@PathVariable String id) {
        return cardService.findByCriador(id);
    }

    @GetMapping
    public List<Card> findAll() {
        return cardService.findAll();
    }

    @PutMapping("/update")
    public Card update(@RequestBody Card card) {
        return cardService.update(card);
    }

    @PutMapping("/update/status")
    public Card updateStatus(@RequestBody Card card) {
        return cardService.updateStatus(card);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        cardService.delete(id);
    }

    @DeleteMapping("/deleteall/{id}")
    public void deleteAll(@PathVariable String id) {
        cardService.deleteAll(id);
    }
}
