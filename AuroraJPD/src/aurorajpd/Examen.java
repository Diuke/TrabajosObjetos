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
public class Examen {
    private float nota;
    private String nombreExamen;
    private int porcentaje;
    private int NRC;

    public Examen(String nombreExamen, int porcentaje, int nrc) {
        this.nombreExamen = nombreExamen;
        this.porcentaje = porcentaje;
        NRC = nrc;
        
    }

    public int getNRC() {
        return NRC;
    } 
    
    public String getNombreExamen() {
        return nombreExamen;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public int getPorcentaje() {
        return porcentaje;
    }
        
}
