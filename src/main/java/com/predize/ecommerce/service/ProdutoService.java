package com.predize.ecommerce.service;

import com.predize.ecommerce.entity.Produto;
import com.predize.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public Produto save(Produto produto){
        return repository.save(produto);
    }

    public Produto get(Long id){
        Produto produto = repository.findById(id).orElse(null);
        if(produto != null){
            return produto;
        }
        throw new RuntimeException("Produto não Encontrado");
    }

    public List<Produto> getAll(){
        return repository.findAll();
    }

    public Produto update(Produto produto){
        if(!repository.findById(produto.getId()).isEmpty()) {
            return repository.save(produto);
        }
        throw new RuntimeException("Produto não Encontrado");
    }

    public Boolean delete(Long id){
        Optional<Produto> produto = repository.findById(id);
        if(produto.isPresent()) {
            repository.delete(produto.get());
            return true;
        }
        throw new RuntimeException("Produto não Encontrado");
    }
}
