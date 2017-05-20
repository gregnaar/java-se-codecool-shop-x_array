package com.codecool.shop.model;


import com.codecool.shop.dao.implementation.ShoppingCartDaoMem;

import java.util.Currency;
/**
 * <h1>This class is used to construct LineItems stored in the shopping cart, and related methods </h1>
 * The constructed objects each stores a Product object, and have quantity attribute
 * to indicate the number of products it stores
 *
 * @author Majoross Daniel
 * @author Racz Anna
 * @author Adam Kovacs
 * @version 1.0
 * @since 2017-05-20
 */
public class LineItem {
    /**
     * id attribute of each LineItem instance.
     */
    private int id;
    /**
     * A product Object for each LineItem instance.
     */
    private Product product;
    /**
     * A quantity attribute for each LineItem instance, indicating how many times it contains the Product.
     */
    private int quantity;
    /**
     * The subtotal price attribute is the result of the quality multiplied by the Products default price.
     */
    private float subtotalPrice;
    static private int sumOfAll;

    /**
     * Constructor for the LineItem, it takes in a Product object and a quantity.
     * It sets the LineItem's id as the same as the product it contains, calculates subtotal price.
     * @param product The Product object to be contained by the LineItem.
     * @param quantity  The number of the same item contained by the LineItem.
     */
    public LineItem(Product product, int quantity) {
        this.product = product;
        this.id = product.getId();
        this.quantity = quantity;
        this.subtotalPrice = product.getDefaultPrice() * quantity;
        this.sumOfAll += (int) product.getDefaultPrice() * quantity;

    }

    /**
     * Constructor for the LineItem, it takes in an id a Product object and a quantity.
     * It sets the LineItem's id and calculates subtotal price.
     * @param id The id of the object. Needed mostly for constructing an Item from the database.
     * @param product The Product object to be contained by the LineItem.
     * @param quantity  The number of the same item contained by the LineItem.
     */
    public LineItem(int id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.id = product.getId();
        this.quantity = quantity;
        this.sumOfAll += (int) product.getDefaultPrice() * quantity;

    }

    public void changeAmount(int num) {
        quantity += num;
        sumOfAll += product.getDefaultPrice() * num;
        if (quantity < 1) {
            ShoppingCartDaoMem.getInstance().remove(this);
        }
    }

    /**
     * Getter method for getting the subtotal price attribute.
     * @return Subtotal price for each LineItem.
     */
    public float getSubtotalPrice() {
        return this.subtotalPrice;
    }

    /**
     * Getter method for getting the contained Product's default price attribute.
     * @return Returns the contained Product's default price attribute
     */
    public float getProductDefaultPrice() {
        return this.product.getDefaultPrice();
    }

    /**
     * Getter method for getting the id attribute of the LineItem instance.
     * @return Returns the id attribute.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter method for getting the id attribute of the contaied Product.
     * @return Returns the id of the contained Product.
     */
    public int getProductId() {
        return this.product.getId();
    }

    /**
     * Setter method for the id attribute.
     * @param id New id value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter method for getting the contained Product object.
     * @return Returns the product object that is stored in the LineItem.
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Getter method for getting quantity attribute of the LineItem object.
     * @return Returns the quantity attribute of the LineItem object.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter method for changing quantity attribute of the LineItem object.
     * @param quantity the new quantity attribute of the LineItem object.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSumOfAll() {
        return sumOfAll;

    }

    /**
     * Getter method for getting the defaultCurrency attribute of stored Product object.
     * @return Returns the defaultCurrency attribute of the stored Product object.
     */
    public Currency getDefaultCurrency() {
        return this.product.getDefaultCurrency();
    }
}

