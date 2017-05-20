package com.codecool.shop.dao;

import com.codecool.shop.model.ProductCategory;

import java.util.List;

/**
 * <h1>This interface is used for establishing the methods, that the implementation classes have to implement</h1>
 * This interface is extended by both ProductCategoryDaoMem and ProductCategoryDaoJDBC, they are doing the same thing,
 * providing data to the application, Mem uses the memory, JDBC uses a database for storing data.
 *
 * @author Majoross Daniel
 * @author Racz Anna
 * @author Adam Kovacs
 * @version 1.0
 * @since 2017-05-20
 */
public interface ProductCategoryDao {
    /**
     * This method is used to add a product category object to the database/Memory
     * @param category An object to be added.
     */
    void add(ProductCategory category);

    /**
     * This method is used to find a specific ProductCategory in the database.
     * @param id id of the ProductCategory to be found.
     * @return Found ProductCategory object.
     * @throws IllegalArgumentException For handling input errors.
     */
    ProductCategory find(int id)throws IllegalArgumentException;

    /**
     * This method is used to remove a specific ProductCategory from the database.
     * @param id id of the ProductCategory to be removed.
     * @throws IllegalArgumentException For handling input errors.
     */
    void remove(int id)throws IllegalArgumentException;

    /**
     * This method is for getting all ProductCategory objects that are stored in the database.
     * @return Returns a list of all ProductCategory objects stored in the database.
     */
    List<ProductCategory> getAll();

}
