/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulo
 */
public class CollectionsDaoTest {

    private Product product1;
    private Product product2;
    private Product product3;
    private Collection<String> filterSearchType1 = new HashSet();
    private Collection<String> names = new HashSet();
    private Collection<String> filterSearchType2 = new HashSet();
    private DaoInterface dao = new CollectionsDao();

    public CollectionsDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParseException {
        product1 = new Product(0, "apples", 2.3, "fruit", "pinklady", new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2001"), "fresh choice", "bad");
        dao.addProduct(product1);
        product2 = new Product(1, "apples", 1.2, "fruit", "granny smith", new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2001"), "fresh choice", "good");
        dao.addProduct(product2);
        product3 = new Product(2, "carrots", 3.3, "vegs", "purple", new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2003"), "fresh choice", "ok");
        filterSearchType1.add(product1.getProductType());
        filterSearchType1.add(product2.getProductType());

        filterSearchType2.add(product1.getProductType2());
        filterSearchType2.add(product2.getProductType2());

        names.add(product1.getName());
        names.add(product2.getName());

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addProduct method, of class CollectionsDao.
     */
    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        dao.addProduct(product3);
        Product retrieved = dao.searchId(2);
        names.add(product3.getName());
        filterSearchType2.add(product3.getProductType());
        filterSearchType1.add(product3.getProductType());
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Retrieved product should be the same",
                product3, retrieved);
    }

    /**
     * Test of deleteProduct method, of class CollectionsDao.
     */
    @Test
    public void testDeleteProduct() {
        System.out.println("deleteProduct");
        dao.deleteProduct(product3);
        names.remove(product3.getName());
        filterSearchType1.remove(product3.getProductType());
        filterSearchType2.remove(product3.getProductType2());
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("product not deleted", false, dao.inDatabase(2));
    }

    /**
     * Test of editProduct method, of class CollectionsDao.
     */
    @Test
    public void testEditProduct() {
        System.out.println("editProduct");
        product2.setName("banana");
        dao.editProduct(product2);
        assertEquals("banana", dao.searchId(1).getName());
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of filterSearchType1 method, of class CollectionsDao.
     */
    @Test
    public void testFilterSearchType1() {
        System.out.println("filterSearchType1");
        String productType = "fruit";
        Collection<Product> result = dao.filterSearchType1(productType);
        Collection<Product> products = new HashSet();
        products.add(product1);
        products.add(product2);
        assertEquals(products, result);

    }

    /**
     * Test of filterSearchType2 method, of class CollectionsDao.
     */
    @Test
    public void testFilterSearchType2() {
        System.out.println("filterSearchType2");
        String productType = "pinklady";
        Collection<Product> result = dao.filterSearchType2(productType);
        Collection<Product> products = new HashSet();
        products.add(product1);
        assertEquals(products, result);
    }

    /**
     * Test of searchName method, of class CollectionsDao.
     */
    @Test
    public void testSearchName() {
        System.out.println("searchName");
        String name = "apples";
        Collection<Product> result = dao.searchName(name);
        Collection<Product> products = new HashSet();
        products.add(product1);
        products.add(product2);
        assertEquals(products, result);
    }

    /**
     * Test of getType1 method, of class CollectionsDao.
     */
    @Test
    public void testGetType1() {
        System.out.println("getType1");
        Collection<String> result = dao.getType1();
        assertEquals(filterSearchType1, result);
    }

    /**
     * Test of getType2 method, of class CollectionsDao.
     */
    @Test
    public void testGetType2() {
        System.out.println("getType2");
        Collection<String> result = dao.getType2();
        assertEquals(filterSearchType2, result);

    }

    /**
     * Test of getNames method, of class CollectionsDao.
     */
    @Test
    public void testGetNames() {
        System.out.println("getNames");

        Collection<String> result = dao.getNames();
        assertEquals(names, result);
    }

    /**
     * Test of getProducts method, of class CollectionsDao.
     */
    @Test
    public void testGetProducts() {
        System.out.println("getProducts");
        Collection<Product> products = dao.getProducts();
        assertTrue("prodOne should exist", products.contains(product1));
        assertTrue("prodTwo should exist", products.contains(product2));

    }

    /**
     * Test of searchId method, of class CollectionsDao.
     */
    @Test
    public void testSearchId() {
        System.out.println("searchId");
        int id = 0;
        Product result = dao.searchId(id);
        assertEquals(product1, result);

    }

    /**
     * Test of inDatabase method, of class CollectionsDao.
     */
    @Test
    public void testInDatabase() {
        System.out.println("inDatabase");
        int id = 0;
        boolean expResult = true;
        boolean result = dao.inDatabase(id);
        assertEquals(expResult, result);

    }

}
