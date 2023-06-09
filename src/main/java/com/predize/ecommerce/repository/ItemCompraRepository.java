package com.predize.ecommerce.repository;

import com.predize.ecommerce.entity.ItemCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCompraRepository extends JpaRepository<ItemCompra, Long> {
}
