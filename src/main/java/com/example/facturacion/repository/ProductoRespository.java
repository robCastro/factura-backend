package com.example.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.example.facturacion.entity.Producto;

public interface ProductoRespository extends JpaRepository<Producto, Long> {
    
    @Procedure("sp_update_product_price")
    public void updatePrice(Double newPrice, Long id);

}
