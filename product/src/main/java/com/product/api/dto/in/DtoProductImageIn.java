package com.product.api.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

/**
 * Clase para representar un DTO (Data Transfer Object) para la entrada de datos de una imagen.
 * Esta clase se utiliza para recibir y validar los datos de una imagen enviados por el cliente.
 */
public class DtoProductImageIn {

    /**
     * El id del producto. Este campo es obligatorio.
     * El valor debe ser proporcionado en el JSON bajo la clave "product_id".
     */
    @JsonProperty("product_id")
    @NotNull(message = "El id del producto es obligatorio")
    private Integer productId;

    /**
     * Imagen codificada en Base64. Este campo es obligatorio.
     * El valor debe ser proporcionado en el JSON bajo la clave "imagen".
     */
    @JsonProperty("image")
    @NotNull(message = "La image del producto es obligatoria")
    private String image;

    /**
     * Obtiene el id del producto.
     * 
     * @return El id del producto.
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * Establece el id del producto.
     * 
     * @param productId El id del producto a establecer.
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * Obtiene la imagen codificada en Base64.
     * 
     * @return La imagen codificada en Base64.
     */
    public String getImage() {
        return image;
    }

    /**
     * Establece la imagen codificada en Base64.
     * 
     * @param image La imagen codificada en Base64 a establecer.
     */
    public void setImage(String image) {
        this.image = image;
    }
}
