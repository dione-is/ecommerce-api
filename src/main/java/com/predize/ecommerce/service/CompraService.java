package com.predize.ecommerce.service;

import com.predize.ecommerce.entity.Compra;
import com.predize.ecommerce.entity.ItemCompra;
import com.predize.ecommerce.repository.CompraRepository;
import com.predize.ecommerce.repository.ItemCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CompraService {
    @Autowired
    private CompraRepository repository;
    @Autowired
    private ItemCompraRepository itemCompraRepository;

    public Compra save(Compra compra) {
        if (validaCampos(compra)) {
            compra.setDataCompra(new Date());
            repository.save(compra);
            compra.getItemCompra().forEach( e -> {
                e.setCompra(compra);
                itemCompraRepository.save(e);
            });
            return compra ;
        }
        throw new RuntimeException("A compra não possui produtos adicionados");
    }

    public Compra get(Long id) {
        Compra compra = repository.findById(id).orElse(null);
        if (compra != null) {
            return compra;
        }
        throw new RuntimeException("Produto não Encontrado");
    }


    public boolean validaCampos(Compra compra) {
        if (compra.getItemCompra().isEmpty()) {
            return false;
        }

        for (ItemCompra c :
                compra.getItemCompra()) {
            if(c.getQuantidade() > c.getProduto().getQuantidade() || c.getQuantidade() < 0){
                throw new RuntimeException("Quantidade de " + c.getProduto().getNome() + " solicitado é maior que a quantidade em estoque.");
            }
        }
        return true;
    }
}
