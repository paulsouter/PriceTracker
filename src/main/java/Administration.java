
import dao.CollectionsDao;
import gui.Terminal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulo
 */
public class Administration {

    public static void main(String args[])

    {
        Terminal main = new Terminal(new CollectionsDao());
    }
}
