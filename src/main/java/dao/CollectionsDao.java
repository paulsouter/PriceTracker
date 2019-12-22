/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author paulo
 */
public class CollectionsDao implements DaoInterface {

    private Collection<Product> productList = new HashSet();

    public void addProduct(Product product) {
        productList.add(product);

    }

    public void deleteProduct(Product product) {
        for (Product p : productList) {
            if (p.getId() == product.getId()) {
                productList.remove(p);
                return;
            }
        }

    }

    public void editProduct(Product product) {
        int id = product.getId();
        for (Product p : productList) {
            if (p.getId() == id) {
                productList.remove(p);
                productList.add(product);
                return;
            }
        }
    }

    public Collection<Product> filterSearchType1(String productType) {
        Collection<Product> products = new HashSet();
        for (Product p : productList) {
            if (p.getProductType() == productType) {
                products.add(p);
            }
        }

        return products;
    }

    public Collection<Product> filterSearchType2(String productType2) {
        Collection<Product> products = new HashSet();
        for (Product p : productList) {
            if (p.getProductType2() == productType2) {
                products.add(p);
            }
        }

        return products;

    }

    public Collection<Product> searchName(String name) {
        Collection<Product> products = new HashSet();
        for (Product p : productList) {
            if (name == p.getName()) {
                products.add(p);
            }
        }
        return products;
    }

    public Collection<String> getType1() {
        Collection<String> type1 = new HashSet();
        for (Product p : productList) {
            type1.add(p.getProductType());
        }
        return type1;
    }

    public Collection<String> getType2() {
        Collection<String> type2 = new HashSet();
        for (Product p : productList) {
            type2.add(p.getProductType2());
        }
        return type2;

    }

    public Collection<String> getNames() {
        Collection<String> names = new HashSet();
        for (Product p : productList) {
            names.add(p.getName());
        }
        return names;
    }

    public Collection<Product> getProducts() {

        return productList;
    }

    public Product searchId(int id) {
        Product product = new Product();
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return product;

    }

    public boolean inDatabase(int id) {
        boolean result = false;
        for (Product p : productList) {
            if (id == p.getId()) {
                return true;
            }
        }
        return result;
    }
}
