package com.predize.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "itemcompra")
public class ItemCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemcompra_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    @Column(name = "quantidade")
    private Integer quantidade;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_compra")
    private Compra compra;
}
