/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.DaoInterface;
import domain.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulo
 */
public class Terminal {

    private DaoInterface dao;

    public Terminal(DaoInterface dao) {
        this.dao = dao;
        mainMenu();
    }

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("quit")) {
            String input = sc.nextLine();
            String args = "";
            int count = input.length() - input.replace(" ", "").length();
            if (count > 1) {
                args = input.substring(0, input.lastIndexOf(" "));
            }
            switch (input) {
                case "quit":
                    return;

                case "help":
                    System.out.println("enter add to bring up the add product \n"
                            + "enter view to view all products \n"
                            + "enter delete plus product id to delete a product \n"
                            + "enter view plus id and prodcut id to view that product \n"
                            + "enter edit plus product id to bring up edit product \n"
                            + "enter view plus name to bring up all products that have that name \n"
                            + "enter view plus t1 and type1 to bring up all products of type1 \n"
                            + "enter view plus t2 and type2 to bring up all products of type2 \n"
                            + "enter get plus t1 to get all the type1's \n"
                            + "enter get plue t2 to get all the type2's \n"
                            + "enter get plus name to get all the names");
                    break;

                case "view":
                    viewAll();
                    break;

                case "view id":
                    int id = Integer.parseInt(args);
                    viewId(id);
                    break;

                case "view name":
                    viewName(args);
                    break;

                case "view t1":
                    viewType1(args);
                    break;

                case "view t2":
                    viewType2(args);
                    break;

                case "delete":
                    delete(Integer.parseInt(args));
                    break;

                case "edit":
                    edit(Integer.parseInt(args));
                    break;

                case "get t1":
                    getType1();
                    break;

                case "get t2":
                    getType2();
                    break;

                case "get name":
                    getName();
                    break;

                case "add":
                    add();
                    break;

                default:
                    System.out.println("if you need help please type help");

            }
        }

    }

    public void viewAll() {
        Collection<Product> products = dao.getProducts();
        for (Product p : products) {
            System.out.println(p.toString());
        }

    }

    public void viewId(int id) {
        Product p = dao.searchId(id);
        System.out.println(p.toString());
    }

    public void viewType1(String type1) {
        Collection<Product> products = dao.filterSearchType1(type1);
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }

    public void viewType2(String type2) {
        Collection<Product> products = dao.filterSearchType2(type2);
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }

    public void viewName(String name) {
        Collection<Product> products = dao.searchName(name);
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }

    public void delete(int id) {

        dao.deleteProduct(dao.searchId(id));
    }

    public void getType1() {
        Collection<String> type1s = dao.getType1();
        for (String t1 : type1s) {
            System.out.println(t1);
        }
    }

    public void getType2() {
        Collection<String> type2s = dao.getType2();
        for (String t2 : type2s) {
            System.out.println(t2);
        }
    }

    public void getName() {
        Collection<String> names = dao.getNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    public void add() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter prodcut id");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println("enter product name");
            String name = sc.nextLine();
            System.out.println("enter product price");
            double price = Double.parseDouble(sc.nextLine());
            System.out.println("enter product type1");
            String type1 = sc.nextLine();
            System.out.println("enter product type2");
            String type2 = sc.nextLine();
            System.out.println("enter date of price");
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
            System.out.println("enter the name of the store");
            String store = sc.nextLine();
            System.out.println("enter any other info that you would like recorded");
            String otherInfo = sc.nextLine();
            Product product = new Product(id, name, price, type1, type2, date, store, otherInfo);
            dao.addProduct(product);
        } catch (ParseException ex) {
            System.out.println("wrong input try again");
            add();

        } catch (NumberFormatException e) {
            System.out.println("wrong input try again");
            add();
        }

    }

    public void edit(int id) {
        try {
            Product product = dao.searchId(id);
            Scanner sc = new Scanner(System.in);
            System.out.println("name ="+ product.getName() +"\n enter new name");
            product.setName(sc.nextLine());
            System.out.println("price ="+ product.getPrice()+"\n enter new price");
            product.setPrice(Integer.parseInt(sc.nextLine()));
            System.out.println("product type 1 =" +product.getProductType()+"\n enter new price");
            product.setProductType(sc.nextLine());
            System.out.println("product type2 =" +product.getProductType2()+"\n enter new price");
            product.setProductType2(sc.nextLine());
            System.out.println("date ="+ product.getdate()+"\n enter new date");
            product.setdate( new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()));
            System.out.println("store ="+product.getStore()+"\n enter new store");
            product.setStore(sc.nextLine());
            System.out.println("other info ="+product.getOtherInfo()+"\n enter new other info");
            product.setOtherInfo(sc.nextLine());
        } catch (ParseException ex) {
            Logger.getLogger(Terminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
