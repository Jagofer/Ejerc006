package es.santander.ascender.ejerc006.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejerc006.model.Pais;
import es.santander.ascender.ejerc006.service.PaisService;

@RestController
@RequestMapping ("/api/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @PostMapping
    public Pais create(@RequestBody Pais pais) {
        return paisService.create(pais);
    }

    @GetMapping("/{id}")
    public Pais read(@PathVariable("id") Long id) {
        return paisService.read(id);
    }

    @PutMapping
    public Pais update(@RequestBody Pais pais) {
        return paisService.update(pais);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        paisService.delete(id);
    }

}
