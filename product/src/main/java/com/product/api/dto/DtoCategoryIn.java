package com.product.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

/**
 * Clase para representar un DTO (Data Transfer Object) para la entrada de datos de una categoria.
 * Esta clase se utiliza para recibir y validar los datos de una categoría enviados por el cliente.
 */
public class DtoCategoryIn {

    /**
     * Nombre de la categoría. Este campo es obligatorio.
     * El valor debe ser proporcionado en el JSON bajo la clave "category".
     */
    @JsonProperty("category")
    @NotNull(message="El valor category es obligatorio")
    private String category;

    /**
     * Tag de la categoría. Este campo es obligatorio.
     * El valor debe ser proporcionado en el JSON bajo la clave "tag".
     */
    @JsonProperty("tag")
    @NotNull(message="El valor tag es obligatorio")
    private String tag;

    /**
     * Obtiene el nombre de la categoría.
     * 
     * @return El nombre de la categoría.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Establece el nombre de la categoría.
     * 
     * @param category El nombre de la categoría a establecer.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Obtiene el tag de la categoría.
     * 
     * @return El tag de la categoría.
     */
    public String getTag() {
        return tag;
    }

    /**
     * Establece el tag de la categoría.
     * 
     * @param tag El tag de la categoría a establecer.
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    
}
