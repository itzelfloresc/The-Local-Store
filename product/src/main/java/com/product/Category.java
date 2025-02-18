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

}
