package com.predize.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compra_id")
    private Long id;

    @OneToMany(mappedBy = "compra")
    @JsonManagedReference
    private List<ItemCompra> itemCompra;

    @Column(name = "datacompra")
    private Date dataCompra;

    @Column(name = "valortotal")
    private BigDecimal valorTotal;

}
