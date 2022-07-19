package com.example.facturacion.api.v1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.facturacion.entity.Producto;
import com.example.facturacion.repository.ProductoRespository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/productos")
public class ProductoRestController {

    @Autowired
    private ProductoRespository productoRespository;

    @GetMapping("/")
    public List<Producto> findAll() {
        return productoRespository.findAll();
    }

    @GetMapping("/{id}/")
    public Producto findOne(@PathVariable Long id) {
        return productoRespository.findById(id).get();
    }

    @PostMapping
    public Producto create(@Valid @RequestBody Producto producto) {
        return productoRespository.save(producto);
    }

    @PutMapping("/{id}/")
    public Producto update(@Valid @RequestBody Producto producto, @PathVariable Long id) {
        Producto productoBD = productoRespository.findById(id).get();
        productoBD.setDescription(producto.getDescription());
        productoBD.setName(producto.getName());
        // Comentado para utilizar SP en su lugar
        // productoBD.setPrecio(producto.getPrecio());
        productoRespository.save(productoBD);
        return productoBD;
    }

    @PutMapping("/{id}/price")
    public Producto updatePrice(@Valid @RequestBody Producto producto, @PathVariable Long id) {
        productoRespository.updatePrice(producto.getPrecio(), id);
        return productoRespository.findById(id).get();
    }

    @DeleteMapping("/{id}/")
    public void delete(@PathVariable Long id) {
        productoRespository.deleteById(id);
    }
}
