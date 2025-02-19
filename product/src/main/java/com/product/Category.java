package com.product;

public class Category {

    Integer category_id;
    String category;
    String tag;
    Integer status;

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
