package com.predize.ecommerce.controller;

import com.predize.ecommerce.entity.Compra;
import com.predize.ecommerce.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("/api/compra/")
public class CompraController {

    @Autowired
    private CompraService service;

    @GetMapping("{id}")
    public ResponseEntity<Compra> getCompra(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.get(id));
        } catch (Exception e) {
            System.err.println("CompraController ::: getCompra :::" + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

//    @GetMapping()
//    public ResponseEntity<List<Compra>> getAllCompra() {
//        try {
//            return ResponseEntity.ok(service.getAll());
//        } catch (Exception e) {
//            System.err.println("CompraController ::: getAllCompra :::" + e.getMessage());
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//        }
//    }

    @PostMapping()
    public ResponseEntity<Compra> saveCompra(@RequestBody Compra Compra) {
        try {
            return ResponseEntity.ok(service.save(Compra));
        } catch (Exception e) {
            System.err.println("CompraController ::: saveCompra :::" + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

//    @PutMapping()
//    public ResponseEntity<Compra> updateCompra(@RequestBody Compra Compra) {
//        try {
//            return ResponseEntity.ok(service.update(Compra));
//        } catch (Exception e) {
//            System.err.println("CompraController ::: updateCompra :::" + e.getMessage());
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//        }
//    }

//    @DeleteMapping()
//    public ResponseEntity<Boolean> deleteCompra(@PathVariable Long id) {
//        try {
//            return ResponseEntity.ok(service.delete(id));
//        } catch (Exception e) {
//            System.err.println("CompraController ::: deleteCompra :::" + e.getMessage());
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//        }
//    }
}
