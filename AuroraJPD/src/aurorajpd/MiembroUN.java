/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aurorajpd;

/**
 *
 * @author juan-
 */
public class MiembroUN {
    private int cod;
    private String nombre;
    private String correo;

    public MiembroUN(int cod, String nombre, String correo) {
        this.cod = cod;
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
