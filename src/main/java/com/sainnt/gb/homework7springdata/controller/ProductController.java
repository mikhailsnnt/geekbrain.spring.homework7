package com.sainnt.gb.homework7springdata.controller;

import com.sainnt.gb.homework7springdata.entity.Product;
import com.sainnt.gb.homework7springdata.repository.ProductRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("product")
public class ProductController {
    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable long id) {
        return repository.getById(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public long createProduct(@RequestBody Product product) {
        return repository.save(product).getId();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok("Entity deleted");
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(String.format("Entity with id %d not found", id), HttpStatus.NOT_FOUND);
        }
    }
}
