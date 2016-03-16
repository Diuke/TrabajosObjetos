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
public class Curso {
    private int NRC;
    private int creditos;
    private ArrayList<Examen> examenes;
    private ArrayList<Estudiante> alumnos;
    private Profesor[] profesores;
    private Profesor profesor;
    private int alumnoCount;
    private int capacidad;
    private float notafinal;

    public Curso(int NRC, int capacidad, int creditos, ArrayList<Estudiante> alumnos, Profesor profesor) {
        this.NRC = NRC;
        this.creditos = creditos;
        this.capacidad = capacidad;
        this.examenes = new ArrayList<>();
        nuevoExamen("Parcial 1", 100);
        this.alumnos = new ArrayList<>();
        for(int i = 0; i<capacidad; i++){
            newAlumno(alumnos.get(i));
        }
        setProfesor(profesor);
        
    }
    
    public Curso() {

    }

    public int getNRC() {
        return NRC;
    }
    
    public void calcularNotaFinal(ArrayList<Examen> examenes){
        float notaF = 0;
        for(Examen e: examenes){ 
            notaF = notaF + (e.getNota()*(e.getPorcentaje()/100));
        }
        this.notafinal = notaF;
    }
    
    public float getNotaFinal(){
        return notafinal;
    }
    
    public void nuevoExamen(String nombre, int porcentaje){
        examenes.add(new Examen(nombre, porcentaje, this.NRC));  
    }

    public ArrayList<Estudiante> getAlumnos() {
        return alumnos;
    }

    public Profesor[] getProfesores() {
        return profesores;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public int getAlumnoCount() {
        return alumnoCount;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
        this.profesor.newCurso(this);
    }
    
    private void newAlumno(Estudiante alumnoNuevo){
        if(alumnos.size() < this.capacidad){
            this.alumnos.add(alumnoNuevo);
            this.alumnos.get(alumnos.size()-1).newCurso(this);
            for(Examen e : examenes){
                this.alumnos.get(alumnos.size()-1).newExamen(e);
            }
            
        }
        else{
            System.out.println("Cupos completos");
        }
    }
    
    public void infoEstudiantes(){
        for(Estudiante e: alumnos){
            System.out.println(e.getNombre() + ", " + e.getCod());
        }
        System.out.println(this.profesor.getNombre());
    }
    
    public void setNotasEstudiantes(){ 
        for(Estudiante est: this.alumnos){
            est.nuevaNota(4.5f, this.NRC, this.examenes.get(0).getNombreExamen()); 
        }
    }
    
    public void promediosXEstudiante(){
        for(Estudiante e: this.alumnos){
            System.out.println(""+e.getPromedio()); 
        }
    }
    
    public ArrayList<Estudiante> alumnosPerdieron(){
        ArrayList<Estudiante> temp = new ArrayList<>();
        for(Estudiante e: this.alumnos){
            if(e.notaFinalCurso(this.NRC) < 2.95){
                temp.add(e);
            }
        }
        return temp;
    }
    
    
}
