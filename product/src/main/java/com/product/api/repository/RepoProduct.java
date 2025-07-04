package com.product.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.api.dto.out.DtoProductOut;
import com.product.api.entity.Product;

/**
 * Repositorio para la entidad Product que permite acceder a los datos de productos en la base de datos.
 */
@Repository
public interface RepoProduct extends JpaRepository<Product, Integer> {

    /**
     * Obtiene un producto específico con información de su categoría.
     * 
     * @param product_id El ID del producto a buscar
     * @return DTO con la información completa del producto
     */
    @Query(value = "SELECT p.*, c.category " + 
                   "FROM product p " + 
                   "INNER JOIN  category c ON c.category_id = p.category_id " + 
                   "WHERE p.product_id = :product_id;", nativeQuery = true)
    DtoProductOut getProduct(Integer product_id);
}
