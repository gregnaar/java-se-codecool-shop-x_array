package com.codecool.shop.dao;

import com.codecool.shop.model.LineItem;

import java.util.List;

/**
 * <h1>This interface is used for establishing the methods, that the implementation classes have to implement</h1>
 * This interface is extended by both ShoppingCartDaoMem and ShoppingCartDaoJDBC, they are doing the same thing,
 * providing data to the application, Mem uses the memory, JDBC uses a database for storing data.
 *
 * @author Majoross Daniel
 * @author Racz Anna
 * @author Adam Kovacs
 * @version 1.0
 * @since 2017-05-20
 */
public interface ShoppingCartDao {

    /**
     * This method is used to add a product through a LineItem object to the database/Memory
     * @param item An object to be added to the shoppingCart built from a product object and quantity attributes.
     */
    void add(LineItem item);

    /**
     * This method is used to remove a LineItem from the database.
     * @param item The LineItem object to be removed.
     */
    void remove(LineItem item);

    /**
     * This method is used to find a LineItem and return it by its ID, in the database
     * @param id ID of the LineItem to be found.
     * @return Returning the found LineItem object.
     */
    LineItem find(int id);

    /**
     * This method can be used the get all LineItems from the database, that are in the shopping cart.
     * @return Returns the list of all the LineItem objects that are in the shopping cart.
     */
    List<LineItem> getAll();

    /**
     * Used for getting the total price of all products in the shopping cart.
     * @return returns the total price of the LineItems as String.
     */
    String getTotal();

    /**
     * This method is used to increase a decrease a LineItems quantity in the shopping cart.
     * When we add an item multiple times, only its quantity will increase, no duplicate objects will be added.
     * @param item Target LineItem to be manipulated.
     * @param num The ammount quantity have the be changed by.
     */
    void changeAmount(LineItem item, int num);
}

