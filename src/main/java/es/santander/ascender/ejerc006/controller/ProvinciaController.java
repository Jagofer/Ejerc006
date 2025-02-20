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

import es.santander.ascender.ejerc006.model.Provincia;
import es.santander.ascender.ejerc006.service.ProvinciaService;

@RestController
@RequestMapping ("/api/provincia")
public class ProvinciaController {

    @Autowired
    private ProvinciaService provinciaService;

    @PostMapping
    public Provincia create(@RequestBody Provincia provincia) {
        return provinciaService.create(provincia);
    }

    @GetMapping("/{id}")
    public Provincia read(@PathVariable("id") Long id) {
        return provinciaService.read(id);
    }
    

    @PutMapping
    public Provincia update(@RequestBody Provincia provincia) {
        return provinciaService.update(provincia);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        provinciaService.delete(id);
    }
}
