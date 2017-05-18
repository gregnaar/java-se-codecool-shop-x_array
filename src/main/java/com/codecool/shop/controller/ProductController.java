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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    //DAOMEM usage
    //    private static ProductDao productDataStore = ProductDaoMem.getInstance();
//    private static ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
//    private static SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
//    private static ShoppingCartDao shoppingCartDataStore = ShoppingCartDaoMem.getInstance();
    private static ProductDao productDataStore = ProductDaoJDBC.getInstance();
    private static ProductCategoryDao productCategoryDataStore = ProductCategoryDaoJDBC.getInstance();
    private static SupplierDao supplierDataStore = SupplierDaoJDBC.getInstance();
    private static ShoppingCartDao shoppingCartDataStore = ShoppingCartDaoJDBC.getInstance();
    private static ProductCategory categoryToFilter;
    private static Supplier supplierToFilter;


    public static ModelAndView renderProducts(Request req, Response res) {
        logger.debug("Rendering all products");
        Map params = new HashMap<>();
        params.put("categories", productCategoryDataStore.getAll());
        params.put("products", productDataStore.getAll());
        params.put("suppliers", supplierDataStore.getAll());
        return new ModelAndView(params, "product/index");
    }

    public static ModelAndView renderProductsFilteredByCategory(Request req, Response res) {

        for (ProductCategory cat : productCategoryDataStore.getAll()) {
            if (req.params(":name").equals(cat.getName())) {
                categoryToFilter = productCategoryDataStore.find(cat.getId());
            }
        }
        logger.debug("Rendering products, filtered by category {}",categoryToFilter.getName());


        Map params = new HashMap<>();
        params.put("categories", productCategoryDataStore.getAll());
        params.put("products", productDataStore.getBy(categoryToFilter));
        params.put("suppliers", supplierDataStore.getAll());
        return new ModelAndView(params, "product/index");
    }

    public static ModelAndView renderProductsFilteredBySupplier(Request req, Response res) {

        for (Supplier sup : supplierDataStore.getAll()) {
            if (req.params(":name").equals(sup.getName())) {
                supplierToFilter = supplierDataStore.find(sup.getId());
            }
        }
        logger.debug("Rendering products, filtered by supplier {}",supplierToFilter.getName());
        Map params = new HashMap<>();
        params.put("categories", productCategoryDataStore.getAll());
        params.put("products", productDataStore.getBy(supplierToFilter));
        params.put("suppliers", supplierDataStore.getAll());
        return new ModelAndView(params, "product/index");
    }


    public static ModelAndView renderCart(Request req, Response res) {
    logger.debug("Rendering items in shopping cart!");
        Map params = new HashMap<>();
        params.put("cart", shoppingCartDataStore.getAll());
        params.put("TotalPrice", shoppingCartDataStore.getTotal());
        return new ModelAndView(params, "product/cart");
    }

}

