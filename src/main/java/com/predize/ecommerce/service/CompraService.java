package com.predize.ecommerce.service;

import com.predize.ecommerce.entity.Compra;
import com.predize.ecommerce.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {
    @Autowired
    private CompraRepository repository;

    public Compra save(Compra compra){
        if(validaCampos(compra)) {
            return repository.save(compra);
        }
        throw new RuntimeException("A compra não possui produtos adicionados");
    }

    public Compra get(Long id){
        Compra compra = repository.findById(id).orElse(null);
        if(compra != null){
            return compra;
        }
        throw new RuntimeException("Produto não Encontrado");
    }


    public boolean validaCampos(Compra compra){
        if(compra.getItemCompra().isEmpty()){
            return false;
        }
        return true;
    }
}
