package com.example.controller;

import com.example.model.Producto;
import java.util.*;
import com.example.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductoRestController {

    @Autowired
    private ProductoService service;

    @GetMapping(value = "/all")
    public List<Producto> getAll() {
        return service.list();

    }

    @GetMapping(value = "/find/{id}")
    public Producto find(@PathVariable int id) {
        return service.get(id);

    }

    @PostMapping(value = "/save")
    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
        Producto obj = service.save(producto);
        return new ResponseEntity<>(obj, HttpStatus.OK);

    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
