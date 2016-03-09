/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecahgw;

import bibliotecahgw.material.Libro;

/**
 *
 * @author juan-
 */
public class Prestamo {
    int codPrestamo;
    int numeroRenovaciones;
    Libro libro;
    Cliente cliente;
    String fechaPrestamo;
    float multa;
    boolean incumplido;

    public Prestamo(int codPrestamo, Libro libro, Cliente cliente, String fechaPrestamo) {
        this.codPrestamo = codPrestamo;
        this.libro = libro;
        this.cliente = cliente;
        this.fechaPrestamo = fechaPrestamo;
    }
    
    int getDiasIncumplidos(){
        int diasIncumplidos = 0;//calcular los dias incumplidos con la fecha
        return diasIncumplidos;
    }

    public int getCodPrestamo() {
        return codPrestamo;
    }

    public int getNumeroRenovaciones() {
        return numeroRenovaciones;
    }

    public Libro getLibro() {
        return libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public float getMulta() {
        return multa;
    }

    public boolean isIncumplido() {
        return incumplido;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }
    
    
    
}
