package com.user.user.openfeign;

import com.user.user.model.Card;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("card")
public interface CardFeign {

    @PostMapping("/card")
    public Card create(@RequestBody Card card);

    @GetMapping("/card/criador/{id}")
    public List<Card> findByCriador(@PathVariable String id);

    @PutMapping("/card/update")
    public Card update(@RequestBody Card card);

    @PutMapping("/card/update/status")
    public Card updateStatus(@RequestBody Card card);

    @DeleteMapping("/card/delete/{id}")
    public void delete(@PathVariable String id);

    @DeleteMapping("/card/deleteall/{id}")
    public void deleteAll(@PathVariable String id);

}
