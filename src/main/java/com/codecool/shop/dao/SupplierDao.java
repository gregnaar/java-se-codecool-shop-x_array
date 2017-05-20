package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;

import java.util.List;

/**
 * <h1>This interface is used for establishing the methods, that the implementation classes have to implement</h1>
 * This interface is extended by both SupplierDaoMem and SupplierDaoJDBC, they are doing the same thing,
 * providing data to the application, Mem uses the memory, JDBC uses a database for storing data.
 *
 * @author Majoross Daniel
 * @author Racz Anna
 * @author Adam Kovacs
 * @version 1.0
 * @since 2017-05-20
 */
public interface SupplierDao {
    /**
     * This method is used to add a supplier object to the database/Memory
     * @param supplier An object to be added.
     */
    void add(Supplier supplier);
    /**
     * This method is used to find a specific Supplier in the database.
     * @param id id of the Supplier to be found.
     * @return Found Supplier object.
     * @throws IllegalArgumentException For handling input errors.
     */
    Supplier find(int id) throws IllegalArgumentException;
    /**
     * This method is used to remove a specific Supplier from the database.
     * @param id id of the Supplier to be removed.
     * @throws IllegalArgumentException For handling input errors.
     */
    void remove(int id)throws IllegalArgumentException;
    /**
     * This method is for getting all Supplier objects that are stored in the database.
     * @return Returns a list of all Suppleir objects stored in the database.
     */
    List<Supplier> getAll();
}
