package com.codecool.shop.model;

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
public class Product extends BaseModel {
    /**
     * The default price of the product.
     */
    private float defaultPrice;
    /**
     * The default currency of the product.
     */
    private Currency defaultCurrency;
    /**
     * The products category, its a ProductCategory object.
     */
    private ProductCategory productCategory;
    /**
     * The products supplier, its a Supplier object.
     */
    private Supplier supplier;

    /**
     * Constructor of the class, extends the constructor from the BaseModel Class.
     * @param name Name of each Product instance object.
     * @param defaultPrice Default price of each Product instance object.
     * @param currencyString default currency of each Product instance object.
     * @param description Description of each Product instance object.
     * @param productCategory Product category of each Product instance object.
     * @param supplier Supplier of each Product instance object.
     */
    public Product(String name, float defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier) {
        super(name, description);
        this.setPrice(defaultPrice, currencyString);
        this.setSupplier(supplier);
        this.setProductCategory(productCategory);

    }

    /**
     * Constructor of the class, extends the constructor from the BaseModel Class, and also sets id.
     * @param id Id of each Product instance object.
     * @param name Name of each Product instance object.
     * @param defaultPrice Default price of each Product instance object.
     * @param currencyString default currency of each Product instance object.
     * @param description Description of each Product instance object.
     * @param productCategory Product category of each Product instance object.
     * @param supplier Supplier of each Product instance object.
     */
    public Product(int id, String name, float defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier) {
        super(name);
        this.setId(id);
        this.setDescription(description);
        this.setPrice(defaultPrice, currencyString);
        this.setSupplier(supplier);
        this.setProductCategory(productCategory);
    }

    /**
     * Setter method for changing the id of the Product instance object.
     * @param id The new id to be set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter method for changing the description of the Product instance object.
     * @param description The new Description to be set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter method for getting the default price attribute of the Product instance object.
     * @return Returns the defaultPrice attribute of the Product instance object.
     */
    public float getDefaultPrice() {
        return defaultPrice;
    }

    /**
     * Setter method for changing the default price attribute of the Product instance object.
     * @param defaultPrice The new defaultPrice to be set.
     */
    public void setDefaultPrice(float defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    /**
     * Getter method for getting the default currency attribute of the Product instance object.
     * @return Returning the defaultCurrency attribute of the Product instance object.
     */
    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    /**
     * Setter method for changing the default currency attribute of the Product instance object.
     * @param defaultCurrency The new defaultCurrency attribute to be set.
     */
    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    /**
     * Getter method for getting the default price attribute of the Product instance object.
     * @return Returning the defaultPrice attribute of the Product instance object.
     */
    public String getPrice() {
        return String.valueOf(this.defaultPrice) + " " + this.defaultCurrency.toString();
    }

    /**
     * Setter method to change the price and currency attribute of the Product instance object.
     * @param price The new defaultPrice attribute to be set.
     * @param currency The new defaultCurrency attribute to be set.
     */
    public void setPrice(float price, String currency) {
        this.defaultPrice = price;
        this.defaultCurrency = Currency.getInstance(currency);
    }

    /**
     * Getter method for getting the category attribute of the Product instance object.
     * @return Returning a ProductCategory Object.
     */
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    /**
     * Setter method to change the category attribute of the Product instance object.
     * Also adding the projectcategory's product list.
     * @param productCategory The new productCategory attribute to be set.
     */
    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
        this.productCategory.addProduct(this);
    }

    /**
     * Getter method for getting the supplier attribute of the Product instance object.
     * @return Returning a Supplier Object.
     */
    public Supplier getSupplier() {
        return supplier;
    }
    /**
     * Setter method to change the supplier attribute of the Product instance object.
     * Also adding the supplier's product list.
     * @param supplier The new Suppleir attribute to be set.
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
        this.supplier.addProduct(this);
    }
    /**
     * This overwritten method changes the toString method, to providing the objects attributes in a formatted String.
     * @return Returns a String with the attributes of the Object.
     */
    @Override
    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "defaultPrice: %3$f, " +
                        "defaultCurrency: %4$s, " +
                        "productCategory: %5$s, " +
                        "supplier: %6$s",
                this.id,
                this.name,
                this.defaultPrice,
                this.defaultCurrency.toString(),
                this.productCategory.getName(),
                this.supplier.getName());
    }
}
