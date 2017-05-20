package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import java.util.List;

/**
 * <h1>This interface is used for establishing the methods, that the implementation classes have to implement</h1>
 * This interface is extended by both ProductDaoMem and ProductDaoJDBC, they are doing the same thing,
 * providing data to the application, Mem uses the memory, JDBC uses a database for storing data.
 *
 * @author Majoross Daniel
 * @author Racz Anna
 * @author Adam Kovacs
 * @version 1.0
 * @since 2017-05-20
 */
public interface ProductDao {

    /**
     * This method is used to add a Product object to the database/Memory
     * @param product The product object to be added.
     */
    void add(Product product);

    /**
     * This method is used to find a specific Product in the database.
     * @param id The id of the product to be found.
     * @return Returns the found Product object.
     * @throws IllegalArgumentException For handling input errors.
     */
    Product find(int id) throws  IllegalArgumentException;

    /**
     * This method is used to remove a specific Product from the database.
     * @param id Id of the Product to be removed.
     * @throws IllegalArgumentException For handling input errors.
     */
    void remove(int id)throws  IllegalArgumentException;

    /**
     * This method is for getting all Product that is stored in the database.
     * @return Returns a list of all Product objects stored in the database.
     */
    List<Product> getAll();

    /**
     * This method is for getting Products from the database, that have a specific supplier.
     * @param supplier A Supplier object to filter the Products.
     * @return Returns a filtered list of Products.
     */
    List<Product> getBy(Supplier supplier);

    /**
     * This method is for getting Products from the database, that have a specific productCategory.
     * @param productCategory A ProductCategory object to filter the Products.
     * @return Returns a filtered list of Products.
     */
    List<Product> getBy(ProductCategory productCategory);

}
