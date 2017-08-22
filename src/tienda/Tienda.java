
package tienda;

/**
 *
 * @author Cuchurrumi
 */
public class Tienda {
    
    Cajero c;
    
    public Tienda(){
        c = new Cajero();
        c.menu();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tienda Tienda = new Tienda();
    }
    
}
