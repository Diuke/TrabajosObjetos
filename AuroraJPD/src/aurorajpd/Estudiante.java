/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aurorajpd;

import java.util.ArrayList;

/**
 *
 * @author juan-
 */
public class Estudiante extends MiembroUN {

    private String estado;
    private float promedio;
    private ArrayList<Curso> NRCs;
    private ArrayList<Examen> notas;

    public Estudiante(int cod, String nombre, String correo, String estado) {
        super(cod, nombre, correo);
        this.notas = new ArrayList<>();
        this.estado = estado;
        this.NRCs = new ArrayList<>();
    }

    public float getPromedio() {
        return promedio;
    } 

    public String getEstado() {
        return estado;
    }

    public void newCurso(Curso c) {
        NRCs.add(c);
    }

    public void newExamen(Examen exam) {
        this.notas.add(exam);
    }

    public void retiro(int nrc) {
        for (int i = 0; i < NRCs.size(); i++) {
            if (NRCs.get(i).getNRC() == nrc) {
                NRCs.remove(i);
            }
        }
    }

    public void verNRCs() {
        for (int i = 0; i < NRCs.size(); i++) {
            System.out.println(NRCs.get(i).getNRC());
        }
        if (NRCs.isEmpty()) {
            System.out.println("no hay cursos asignados");
        }
    }

    public void nuevaNota(float nota, int nrc, String nExamen) {
        for (Examen e : notas) {
            if (e.getNombreExamen().equals(nExamen) && e.getNRC() == nrc) {
                e.setNota(nota);
            }
        }
        calcPromedio();
    }

    public boolean estaCursando(int nrc) {
        for (Curso c : NRCs) {
            if (c.getNRC() == nrc) {
                return true;
            }
        }
        return false;
    }

    public float notaFinalCurso(int nrc) {
        if (this.estaCursando(nrc)) {
            ArrayList<Examen> temp = new ArrayList<>();
            for (Examen e : notas) {
                if (e.getNRC() == nrc) {
                    temp.add(e);
                }
            }
            Curso c = new Curso();
            c.calcularNotaFinal(temp);
            float nfinal = c.getNotaFinal();
            return nfinal;
        }
        System.out.println("No esta cursando");
        calcPromedio();
        return 0;
    }

    public void notasXMateria() {
        for (Curso c : NRCs) {
            System.out.println("NRC: " + c.getNRC());
            for (Examen e : notas) {
                if (e.getNRC() == c.getNRC()) {
                    System.out.println("" + e.getNota());
                }
            }
        }
    }

    private void calcPromedio() {
        float av = 0.0f;
        float sumMateria;
        for (Curso c : NRCs) {
            sumMateria = 0.0f;
            for (Examen e : notas) {
                if (e.getNRC() == c.getNRC()) {
                    sumMateria += e.getNota();
                }
            }
            av += sumMateria;
        }
        this.promedio = av / this.NRCs.size();
    }
}
