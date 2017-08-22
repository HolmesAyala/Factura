
package tienda;

import java.util.Scanner;

/**
 *
 * @author Cuchurrumi
 */
public class Cajero {
    
    int cantidad[] = {10, 10, 10, 10, 10, 10};
    int precio[] = {15, 12, 3, 4, 8, 20};
    String productos[] = {"Arroz", "Frijol", "Jabon Ropa", "Jabon Manos", "Celular", "Tablet"};
    Scanner leer = new Scanner(System.in);
    Cliente cliente;
    
    public Cajero(){
        cliente = new Cliente();
    }
    
    public void menu(){
        int opcion = 0;
        do{
            System.out.println("Seleccione un producto");
            System.out.println("1. Arroz");
            System.out.println("2. Frijol");
            System.out.println("3. Jabon ropa");
            System.out.println("4. Jabon manos");
            System.out.println("5. Celular");
            System.out.println("6. Tablet");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");
            opcion = leer.nextInt();
            if(opcion != 7){
                obtenerProducto(opcion-1);
            }
        }while(opcion != 7);
        factura();
    }
    
    public void obtenerProducto(int producto){
        System.out.println("Que quiere hacer");
        System.out.println("1. Agregar");
        System.out.println("2. Remover");
        System.out.println("3. Volver");
        System.out.print("Opcion: ");
        int opcion = leer.nextInt();
        switch(opcion){
            case 1:
                agregar(producto);
                break;
            case 2:
                remover(producto);
                break;
        }
    }
    
    public void agregar(int producto){
        if(cantidad[producto] > 0){
            System.out.println("Quedan "+cantidad[producto]+" de "+productos[producto]);
            System.out.print("Unidades a agregar: ");
            int cant = leer.nextInt();
            if(cant <= cantidad[producto]){
                this.cantidad[producto] -= cant;
                cliente.cantidad[producto] += cant;
                cliente.saldo += cant*precio[producto];
                System.out.println("El valor total ("+productos[producto]+"): "+cant*precio[producto]);
            }
            else{
                System.out.println("Cantidad no valida!");
            }
        }
        else{
            System.out.println("No hay "+productos[producto]);
        }
    }
    
    public void remover(int producto){
        if(cliente.cantidad[producto] > 0){
            System.out.println("Usted tiene "+cliente.cantidad[producto]+" de "+this.productos[producto]);
            System.out.println("Cantidad a remover: ");
            int cant = leer.nextInt();
            if(cant <= cliente.cantidad[producto]){
                this.cantidad[producto] += cant;
                cliente.cantidad[producto] -= cant;
                cliente.saldo -= cant*this.precio[producto];
            }
            else{
                System.out.println("Usted no tiene esa cantidad de "+this.productos[producto]);
            }
        }
        else{
            System.out.println("Usted no tiene ese articulo agregado.");
        }
    }
    
    public void factura(){
        System.out.println("Factura");
        System.out.println("Articulo      Cantidad      Precio");
        for(int i = 0; i < 6; i++){
            if(cliente.cantidad[i] > 0){
                System.out.println(this.productos[i]+"    "+cliente.cantidad[i]+"    "+cliente.cantidad[i]*this.precio[i]);
            }
        }
        System.out.println("Total a pagar: "+cliente.saldo);
    }
}