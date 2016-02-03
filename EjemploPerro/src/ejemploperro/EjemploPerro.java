/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploperro;

import java.util.ArrayList;

/**
 *
 * @author juan-
 */
public class EjemploPerro {
    
    /**
     * @param args the command line arguments
     */
    public Perro[] perros;
    public ArrayList<Perro> perrosList;
    
    public EjemploPerro(){
        perros = new Perro[10];
        perrosList = new ArrayList<Perro>();
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Perro cheo = new Perro(1, "Cheo", "Chandoberman", "Cafe con blanco");
        System.out.println(cheo.getEdad());
        
        EjemploPerro perrera = new EjemploPerro();
        perrera.perros[0] = new Perro(10, "Pancho", "Pincher", "Cafe y negro");
        perrera.perros[1] = new Perro(5, "Lucas", "Labrador", "Dorado");
        perrera.perrosList.set(0, new Perro(4, "Mocho", "Chander Terrier", "Cafe"));
                
    }

}
