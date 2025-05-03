package com.product.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.product.api.entity.ProductImage;

/**
 *  Interfaz que define un repositorio para la entidad {@link ProductImage}.
 */
@Repository
public interface RepoProductImage extends JpaRepository<ProductImage, Integer>{

    /**
     * Obtiene un producto en específico
     * @param product_id El id del producto
     * @return Un ProductImage con la información del producto
     */
    @Query(value = "SELECT * FROM product_image WHERE product_id = :product_id;", nativeQuery = true)
    ProductImage findByProductId(Integer product_id); 

    /**
     * Elimina una imagen de un producto
     * @param product_image_id El id de la imagen a eliminar
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM product_image WHERE product_image_id = :product_image_id;", nativeQuery = true)
    void deleteProductImage(Integer product_image_id);

    /**
     * Obtiene una imagen en especifico
     * @param product_image_id El id de la imagen
     * @return Un ProductImage con la información del producto relacionada a la imagen
     */
    @Query(value = "SELECT * FROM product_image WHERE product_image_id = :product_image_id;", nativeQuery = true)
    ProductImage findByProductImageId(Integer product_image_id);

    /**
     * Obtiene todas las imágenes relacionadas a un producto
     * @param product_id El id del producto
     * @return Lista con la información para cada imagen
     */
    @Query(value = "SELECT * FROM product_image WHERE product_id = :product_id;", nativeQuery = true)
    List<ProductImage> findAllImagesByProductId(Integer product_id);
}
