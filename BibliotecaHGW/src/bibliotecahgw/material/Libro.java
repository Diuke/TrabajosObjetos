/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecahgw.material;

import bibliotecahgw.*;
import bibliotecahgw.Material;

/**
 *
 * @author juan-
 */
public class Libro extends Material{
    String titulo;
    String genero;
    String autor;
    String palabrasClave;
    Cliente clientePrestado;

    public Libro(boolean disponible, int codigo, String ubicacion, String titulo) {
        super(disponible, codigo, ubicacion);
        this.titulo = titulo;
    }
    
    public void setClientePrestado(Cliente c){
        this.clientePrestado = c;
    }
    public Cliente getClientePrestado(){
        return this.clientePrestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getAutor() {
        return autor;
    }

    public String getPalabrasClave() {
        return palabrasClave;
    }
    
    
}
