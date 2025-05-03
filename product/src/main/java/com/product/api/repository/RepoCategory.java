package com.product.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.api.entity.Category;

import jakarta.transaction.Transactional;

/**
 * Interfaz que define un repositorio para la entidad {@link Category}.
 * Esta interfaz extiende {@link JpaRepository} y proporciona métodos personalizados
 * para realizar operaciones CRUD y otras consultas específicas en la tabla "category".
 * 
 * Los métodos personalizados están anotados con {@link Query} para definir consultas SQL nativas. 
 * Además, los métodos que modifican la base de datos están anotados con {@link Modifying}
 * y {@link Transactional} para garantizar que las operaciones se ejecuten dentro de una transacción.
 */
@Repository
public interface RepoCategory extends JpaRepository<Category, Integer>{
    
    /**
     * Obtiene una lista de todas las categorías ordenadas por nombre.
     * 
     * @return Una lista de todas las categorías.
     */
    @Query(value = "SELECT * FROM category ORDER BY category", nativeQuery = true)
    List<Category> getCategories();

    /**
     * Obtiene una lista de todas las categorías activas (con estado = 1) ordenadas por nombre.
     * 
     * @return Una lista de categorías activas.
     */
    @Query(value = "SELECT * FROM category WHERE status=1 ORDER BY category", nativeQuery = true)
    List<Category> getActiveCategories();

    /**
     * Obtiene una categoría específica por su ID.
     * 
     * @param category_id El ID de la categoría que se desea obtener.
     * @return La categoría correspondiente al ID proporcionado.
     */
    @Query(value = "SELECT * FROM category WHERE category_id = :category_id ORDER BY category", nativeQuery = true)
    Category getCategory(@Param("category_id") Integer category_id);

    /**
     * Crea una nueva categoría en la base de datos.
     * 
     * @param category El nombre de la categoría.
     * @param tag La etiqueta asociada a la categoría.
     */
    @Modifying 
    @Transactional
    @Query(value = "INSERT INTO category(category, tag, status) VALUES (:category, :tag, 1)", nativeQuery = true)
    void createCategory(@Param("category") String category, @Param("tag") String tag);

    /**
     * Actualiza una categoría existente en la base de datos.
     * 
     * @param category_id El ID de la categoría que se desea actualizar.
     * @param category El nuevo nombre de la categoría.
     * @param tag La nueva etiqueta asociada a la categoría.
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE category SET category = :category, tag = :tag WHERE category_id = :category_id;", nativeQuery = true)
    void updateCategory(@Param("category_id") Integer category_id, @Param("category") String category, @Param("tag") String tag);

    /**
     * Habilita una categoría estableciendo su estado a 1.
     * 
     * @param category_id El ID de la categoría que se desea habilitar.
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE category SET status = 1 WHERE category_id = :category_id;", nativeQuery = true)
    void enableCategory(@Param("category_id") Integer category_id);

    /**
     * Deshabilita una categoría estableciendo su estado a 0.
     * 
     * @param category_id El ID de la categoría que se desea deshabilitar.
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE category SET status = 0 WHERE category_id = :category_id;", nativeQuery = true)
    void disableCategory(@Param("category_id") Integer category_id);
}
