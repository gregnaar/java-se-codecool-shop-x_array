package com.codecool.shop.model;

import java.util.ArrayList;

/**
 * <h1>This class is used to construct ProductCategory objects, and stores related methods </h1>
 * The constructed objects each stores a list of related Product objects.
 *
 * @author Majoross Daniel
 * @author Racz Anna
 * @author Adam Kovacs
 * @version 1.0
 * @since 2017-05-20
 */
public class ProductCategory extends BaseModel {
    /**
     * Department attribute of the ProductCategory.
     */
    private String department;
    /**
     * A list for each instance object, stores all Product objects.
     */
    private ArrayList<Product> products;

    /**
     * Constructor of the class, extends the constructor from the BaseModel Class.
     * @param name Name of each ProductCategory instance object.
     * @param department Department of each ProductCategory instance object.
     * @param description Description of each ProductCategory instance object.
     */
    public ProductCategory(String name, String department, String description) {
        super(name);
        this.department = department;
        this.products = new ArrayList<>();
    }

    /**
     * Constructor of the class, extends the constructor from the BaseModel Class, and also sets id.
     * @param id Id of each ProductCategory instance object.
     * @param name Name of each ProductCategory instance object.
     * @param department Department of each ProductCategory instance object.
     * @param description Description of each ProductCategory instance object.
     */
    public ProductCategory(int id, String name, String department, String description) {
        super(name);
        this.id = id;
        this.department = department;
        this.description = description;
        this.products = new ArrayList<>();
    }

    /**
     * Getter method for getting the Department attribute of the ProductType instance object.
     * @return Returning the Department attribute of the ProductType instance object.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Setter method for changing the Department attribute of the ProductType instance object.
     * @param department The new Department to be set.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Setter merthod for adding a list of Product objects to the ProductType attributes.
     * @param products The new products list to be set.
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    /**
     * Getter method for getting the list of Product objects related to the Product type.
     * @return Returns a list of the related Product objects.
     */
    public ArrayList getProducts() {
        return this.products;
    }

    /**
     * Adds a Product object to the products list.
     * @param product A product object.
     */
    public void addProduct(Product product) {
        this.products.add(product);
    }

    /**
     * This overwritten method changes the toString method, to providing the objects attributes in a formatted String.
     * @return Returns a String with the attributes of the Object.
     */
    @Override
    public String toString() {
        return String.format(
                "id: %1$d, " +
                        "name: %2$s, " +
                        "department: %3$s, " +
                        "description: %4$s",
                this.id,
                this.name,
                this.department,
                this.description);
    }
}