package com.quadro.quadro.controller;

import com.quadro.quadro.model.Quadro;
import com.quadro.quadro.service.QuadroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quadro")
public class QuadroController {
    @Autowired
    private QuadroService quadroService;

    @PostMapping
    public Quadro create(@RequestBody Quadro quadro) {
        return quadroService.create(quadro);
    }

    @GetMapping("/{id}")
    public Quadro find(@PathVariable String id) {
        return quadroService.find(id);
    }

    @GetMapping
    public List<Quadro> findAll() {
        return quadroService.findAll();
    }

    @PutMapping("/update")
    public Quadro update(@RequestBody Quadro quadro) {
        return quadroService.update(quadro);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        quadroService.delete(id);
    }
}
