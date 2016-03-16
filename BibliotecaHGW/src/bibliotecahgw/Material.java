/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecahgw;

/**
 *
 * @author juan-
 */
public class Material implements java.io.Serializable{ 
    boolean disponible;
    int codigo; 
    String ubicacion;

    public Material(boolean disponible, int codigo, String ubicacion) {
        this.disponible = disponible;
        this.codigo = codigo;
        this.ubicacion = ubicacion;
    }    

    public int getCod() {
        return codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    
    public void toggleDisponible(){
        this.disponible = !disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }
    
    
}
