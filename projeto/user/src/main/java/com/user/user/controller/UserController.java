package com.user.user.controller;

import com.user.user.model.Card;
import com.user.user.model.Quadro;
import com.user.user.model.User;
import com.user.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    private User create(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping("/{id}")
    private User find(@PathVariable String id){
        return userService.find(id);
    }

    @GetMapping
    private List<User> findAll(){
        return userService.findAll();
    }

    @PutMapping("/update")
    private User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable String id){
        userService.delete(id);
    }

    @PostMapping("/{id}/criar/quadro")
    private User criarQuadro(@RequestBody Quadro quadro, @PathVariable String id){
        return userService.criarQuadro(quadro, id);
    }

    @PutMapping("/{id}/update/quadro")
    private User atualizarQuadro(@RequestBody Quadro quadro, @PathVariable String id){
        return userService.atualizarQuadro(quadro, id);
    }

    @DeleteMapping("/{id}/delete/quadro")
    private User deletarQuadro(@RequestBody Quadro quadro, @PathVariable String id){
        return userService.deleteQuadro(quadro, id);
    }

    @PostMapping("/{id}/criar/card")
    private User criarCard(@RequestBody Card card, @PathVariable String id){
        return userService.criarCard(card, id);
    }

    @PutMapping("/{id}/update/card")
    private User updateCard(@RequestBody Card card, @PathVariable String id){
        return userService.updateCard(card, id);
    }

    @PutMapping("/{id}/update/card/status")
    private User updateCardStatus(@RequestBody Card card, @PathVariable String id){
        return userService.moverCardDeFila(card, id);
    }

    @DeleteMapping("/{id}/delete/card")
    private User deletarCard(@RequestBody Card card, @PathVariable String id){
        return userService.deleteCard(card, id);
    }
}
