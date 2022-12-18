package com.user.user.openfeign;

import com.user.user.model.Quadro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("quadro")
public interface QuadroFeign {

    @PostMapping("/quadro")
    public Quadro create(@RequestBody Quadro quadro);

    @PutMapping("/quadro/update")
    public Quadro update(@RequestBody Quadro quadro);

    @DeleteMapping("/quadro/delete/{id}")
    public void delete(@PathVariable String id);

}
