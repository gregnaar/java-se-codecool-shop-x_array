package com.codecool.shop.model;

import java.lang.reflect.Field;
/**
 * <h1>This class is used as blueprint for the other model classes</h1>
 * No Object is instantiated from this class, it serves as blueprint for the common properties and methods
 * for the other model classes.
 *
 * @author Majoross Daniel
 * @author Racz Anna
 * @author Adam Kovacs
 * @version 1.0
 * @since 2017-05-20
 */
public class BaseModel {
    /**
     * Id is for identification of each instance of the classes.
     */
    protected int id;
    /**
     * Name of each Object.
     */
    protected String name;
    /**
     * Description of each Object.
     */
    protected String description;

    /**
     * Basic constructor of the class, only takes in name paramter.
     * @param name Name for the object.
     */
    public BaseModel(String name) {
        this.name = name;
    }

    /**
     *Second Constructor of the class, takes in name and description as parameters.
     * @param name Name for the object.
     * @param description Description for the object.
     */
    public BaseModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * A simple getter for getting the id of the object.
     * @return returns the id attribute of the object.
     */
    public int getId() {
        return id;
    }
    /**
     * A simple setter for setting the id of the object.
     * @param id The new id to be set.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * A simple getter for getting the name of the object.
     * @return returns the name attribute of the object.
     */
    public String getName() {
        return name;
    }
    /**
     * A simple setter for setting the name of the object.
     * @param name The new name to be set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * A simple getter for getting the Description of the object.
     * @return returns the Description attribute of the object.
     */
    public String getDescription() {
        return description;
    }

    /**
     * A simple setter for setting the Description of the object
     * @param description The new Description to be set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This overwritten method changes the toString method, to providing the objects attributes in a formatted String.
     * @return Returns a String with the attributes of the Object.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(this);
                if (value != null) {
                    sb.append(field.getName() + ":" + value + ",");
                }
            } catch (IllegalAccessException e) {

            }
        }
        return sb.toString();
    }

}
