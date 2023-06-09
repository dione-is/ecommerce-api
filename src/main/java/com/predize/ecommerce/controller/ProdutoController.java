package com.predize.ecommerce.controller;

import com.predize.ecommerce.entity.Produto;
import com.predize.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/produto/")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.get(id));
        } catch (Exception e) {
            System.err.println("ProdutoController ::: getProduto :::" + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<List<Produto>> getAllProduto() {
        try {
            return ResponseEntity.ok(service.getAll());
        } catch (Exception e) {
            System.err.println("ProdutoController ::: getAllProduto :::" + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<Produto> saveProduto(@RequestBody Produto produto) {
        try {
            return ResponseEntity.ok(service.save(produto));
        } catch (Exception e) {
            System.err.println("ProdutoController ::: saveProduto :::" + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto) {
        try {
            return ResponseEntity.ok(service.update(produto));
        } catch (Exception e) {
            System.err.println("ProdutoController ::: updateProduto :::" + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping()
    public ResponseEntity<Boolean> deleteProduto(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.delete(id));
        } catch (Exception e) {
            System.err.println("ProdutoController ::: deleteProduto :::" + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
