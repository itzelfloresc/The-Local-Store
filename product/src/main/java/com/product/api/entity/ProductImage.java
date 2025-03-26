package com.product.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad que representa una imagen de producto en el sistema.
 * Esta clase está mapeada a la tabla "product_image" en la base de datos
 * y contiene información sobre las imágenes asociadas a los productos.
 */

@Entity
@Table(name = "product_image")
public class ProductImage {

    /**
     * Identificador único de la imagen de producto
     * 
     * @Id Indica que es la llave primaria
     * @GeneratedValue(strategy = GenerationType.IDENTITY) Generación automática del ID
     * @Column(name = "product_image_id") Mapea al campo en la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id")
    private Integer productImageId;

    /**
     * ID del producto al que pertenece esta imagen
     * 
     * @Column(name = "product_id") Mapea al campo en la tabla
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * Imagen codificada en Base64
     * 
     * @Column(name = "image") Mapea al campo en la tabla
     */
    @Column(name = "image")
    private String image;

    /**
     * Estado de la imagen.
     * 
     * @Column(name = "status") Mapea al campo en la tabla
     */
    @Column(name = "status")
    private Integer status;

    /**
     * Obtiene el ID de la imagen de producto
     * 
     * @return El identificador único de la imagen
     */
    public Integer getProductImageId() {
        return productImageId;
    }

    /**
     * Establece el ID de la imagen de producto
     * 
     * @param productImageId El identificador único a asignar
     */
    public void setProductImageId(Integer productImageId) {
        this.productImageId = productImageId;
    }

    /**
     * Obtiene el ID del producto asociado
     * 
     * @return El identificador del producto
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * Establece el ID del producto asociado
     * 
     * @param productId El identificador del producto a asignar
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * Obtiene la imagen
     * 
     * @return La ubicación de la imagen
     */
    public String getImage() {
        return image;
    }

    /**
     * Establece la imagen
     * 
     * @param image La ubicación de la imagen a asignar
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Obtiene el estado actual de la imagen
     * 
     * @return El valor del estado
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Establece el estado de la imagen
     * 
     * @param status El valor de estado a asignar
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
