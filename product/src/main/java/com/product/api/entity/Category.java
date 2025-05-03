package com.product.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase que representa una entidad de categoría en la base de datos.
 * Esta clase está mapeada a la tabla "category" en la base de datos y se utiliza
 * para almacenar y recuperar información sobre las categorías de productos.
 * 
 * La clase incluye anotaciones de JPA para mapear los campos de la tabla a los atributos
 * de la clase
 */
@Entity
@Table(name="category")
public class Category {

    /**
     * Identificador único de la categoría. Este campo es generado automáticamente
     * por la base de datos utilizando una estrategia de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("category_id")
    @Column(name = "category_id")
    Integer category_id;

    /**
     * Nombre de la categoría. Este campo es único y no puede ser nulo.
     */
    @JsonProperty("category")
    @Column(name = "category")
    String category;

    /**
     * Tag asociada a la categoría. Este campo es único y no puede ser nulo.
     */
    @JsonProperty("tag")
    @Column(name = "tag")
    String tag;

    /**
     * Estado de la categoría. Este campo indica si la categoría está habilitada (1) o deshabilitada (0).
     */
    @JsonProperty("status")
    @Column(name = "status")
    Integer status;

    /**
     * Constructor por defecto. Requerido por JPA.
     */
    public Category(){}

    /**
     * Constructor de la clase Category
     * @param Integer el id único de la categoria.
     * @param String el nombre único de la categoria.
     * @param String el tag único de la categoria.
     */
    public Category(Integer category_id, String category, String tag) {
        this.category_id = category_id;
        this.category = category;
        this.tag = tag;
        this.status = 1;
    }

    /**
     * Getter para el ID de la categoria.
     * @return category_id
     */
    public Integer getCategoryID() {
        return this.category_id;
    }

    /**
     * Getter para el nombre de la categoria.
     * @return category
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Getter para el tag de la categoria.
     * @return tag
     */
    public String getTag() {
        return this.tag;
    }

    /**
     * Getter para el nombre de la categoria.
     * @return category
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * Setter para el ID de la categoria
     * @param id
     */
    public void setCategoryID(Integer id) {
        this.category_id = id;
    }

    /**
     * Setter para el nombre de la categoria
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Setter para el nombre de la categoria
     * @param tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Setter para el ID de la categoria
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
