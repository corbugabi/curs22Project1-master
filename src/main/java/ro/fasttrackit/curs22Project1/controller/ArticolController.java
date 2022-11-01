package ro.fasttrackit.curs22Project1.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs22Project1.model.entity.Articol;
import ro.fasttrackit.curs22Project1.service.ArticolService;

@RestController
@RequestMapping("api/articole")
public class ArticolController {
    private final ArticolService service;

    public ArticolController(ArticolService service) {
        this.service = service;
    }

    @PostMapping
    Articol addArticol(@RequestBody Articol newArticol){
        return service.create(newArticol);
    }

    @PutMapping("{articolId}")
    Articol replaceArticol(@PathVariable int articolId, @RequestBody Articol articol){
        return service.replaceArticol(articolId,articol)
                .orElseThrow(() -> new RuntimeException("Could not find transaction with id " + articolId));
    }

    @DeleteMapping("{articolId}")
    Articol deleteArticol(@PathVariable int articolId){
        return service.deleteArticol(articolId);
    }
}
