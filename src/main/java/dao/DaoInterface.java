/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;

/**
 *
 * @author paulo
 */
public interface DaoInterface {

    void addProduct(Product product);

    void deleteProduct(Product product);

    void editProduct(Product product);

    Collection<Product> filterSearchType1(String productType);

    Collection<Product> filterSearchType2(String prodcutType2);

    Collection<Product> searchName(String name);

    Collection<String> getType1();

    Collection<String> getType2();

    Collection<String> getNames();

    Collection<Product> getProducts();

    Product searchId(int id);

    boolean inDatabase(int id);

}
