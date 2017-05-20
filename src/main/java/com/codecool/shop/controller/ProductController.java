package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.*;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>This class is responsible for the information exchange of the html and DAO implementations.</h1>
 * The class can work with both DAOMEM and DAOJDBC models, right now it uses DAOJDBC,
 * so it gets the data from a database. And it sends the filtered informations the spark routes.
 *
 *
 * @author Majoross Daniel
 * @author Racz Anna
 * @author Adam Kovacs
 * @version 1.0
 * @since 2017-05-20
 */

public class ProductController {
    //DAOMEM usage
    //    private static ProductDao productDataStore = ProductDaoMem.getInstance();
//    private static ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
//    private static SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
//    private static ShoppingCartDao shoppingCartDataStore = ShoppingCartDaoMem.getInstance();
    /** preparing a instance of ProductDaoJDBC class, to use its instance methods.*/
    private static ProductDao productDataStore = ProductDaoJDBC.getInstance();
    /** preparing a instance of ProductCategoryDaoJDBC class, to use its instance methods.*/
    private static ProductCategoryDao productCategoryDataStore = ProductCategoryDaoJDBC.getInstance();
    /** preparing a instance of SupplierDaoJDBC class, to use its instance methods.*/
    private static SupplierDao supplierDataStore = SupplierDaoJDBC.getInstance();
    /** preparing a instance of ShoppingCartDaoJDBC class, to use its instance methods.*/
    private static ShoppingCartDao shoppingCartDataStore = ShoppingCartDaoJDBC.getInstance();
    /** Declaring categoryToFilter object, so it is only declared once here in runtime.*/
    private static ProductCategory categoryToFilter;
    /** Declaring supplierToFilter object, so it is only declared once here in runtime.*/
    private static Supplier supplierToFilter;

    /**
     * This method is used for getting all unfiltered data of the products from the database and forward it to Spark
     * @param req unused
     * @param res unused
     * @return ModelAndView object, with a HashMap that contains all data
     */
    public static ModelAndView renderProducts(Request req, Response res) {

        Map params = new HashMap<>();
        params.put("categories", productCategoryDataStore.getAll());
        params.put("products", productDataStore.getAll());
        params.put("suppliers", supplierDataStore.getAll());
        return new ModelAndView(params, "product/index");
    }

    /**
     * This method is used for getting data of the products from the database, filtered by category, and forward it to Spark
     * @param req for getting the category to filter the data
     * @param res unused
     * @return ModelAndView object, with a HashMap that contains the filtered data
     */
    public static ModelAndView renderProductsFilteredByCategory(Request req, Response res) {

        for (ProductCategory cat : productCategoryDataStore.getAll()) {
            if (req.params(":name").equals(cat.getName())) {
                categoryToFilter = productCategoryDataStore.find(cat.getId());
            }
        }

        Map params = new HashMap<>();
        params.put("categories", productCategoryDataStore.getAll());
        params.put("products", productDataStore.getBy(categoryToFilter));
        params.put("suppliers", supplierDataStore.getAll());
        return new ModelAndView(params, "product/index");
    }

    /**
     * This method is used for getting data of the products from the database, filtered by supplier, and forward it to Spark
     * @param req for getting the supplier to filter the data
     * @param res unused
     * @return ModelAndView object, with a HashMap that contains the filtered data
     */
    public static ModelAndView renderProductsFilteredBySupplier(Request req, Response res) {

        for (Supplier sup : supplierDataStore.getAll()) {
            if (req.params(":name").equals(sup.getName())) {
                supplierToFilter = supplierDataStore.find(sup.getId());
            }
        }

        Map params = new HashMap<>();
        params.put("categories", productCategoryDataStore.getAll());
        params.put("products", productDataStore.getBy(supplierToFilter));
        params.put("suppliers", supplierDataStore.getAll());
        return new ModelAndView(params, "product/index");
    }
    /**
     * This method is used for getting data of the products from the database, that are in the shopping cart.
     * @param req unused
     * @param res unused
     * @return ModelAndView object, with a HashMap that contains the filtered data
     */
    public static ModelAndView renderCart(Request req, Response res) {

        Map params = new HashMap<>();
        params.put("cart", shoppingCartDataStore.getAll());
        params.put("TotalPrice", shoppingCartDataStore.getTotal());
        return new ModelAndView(params, "product/cart");
    }

}

