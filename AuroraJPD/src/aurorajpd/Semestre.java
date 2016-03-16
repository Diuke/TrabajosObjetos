/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aurorajpd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author juan-
 */
public class Semestre {
    private String periodo;
    public HashMap<Integer, Curso> cursos;
    //public ArrayList<Curso> cursos;
    public HashMap<Integer, Estudiante> estudiantes;
    //public ArrayList<Estudiante> estudiantes;
    public HashMap<Integer, Profesor> profesores;
    //public ArrayList<Profesor> profesores;

    public Semestre(String periodo) {
        this.periodo = periodo;
        //this.estudiantes = new ArrayList<Estudiante>();
        this.estudiantes = new HashMap();
        this.profesores = new HashMap();
        this.cursos = new HashMap();
    }
    
    public Estudiante encontrarEstudiante(int cod){
        return estudiantes.get(cod);
    }
    
    public Profesor encontrarProfesor(int cod){
        return profesores.get(cod);
    }
    
    public Curso encontrarCurso(int nrc){
       return cursos.get(nrc);
    }
    
    public void nuevoEstudiante(Estudiante est){//INGRESA UN NUEVO ESTUDIANTE A LA LISTA DEL SEMESTRE
        this.estudiantes.put(est.getCod(), est);
    }
    
    public void nuevoCurso(Curso curso){
        this.cursos.put(curso.getNRC(), curso);
    }
    
    public void nuevoProfesor(Profesor prof){
        this.profesores.put(prof.getCod(), prof);
    }
    
    public void eliminarProfesor(int cod){
        Profesor p = profesores.get(cod);
        if(p != null){
            profesores.remove(cod);
        }
        else{
            System.out.println("No se encontraron profesores con dicho codigo");
        }
    } 
    
    public void eliminarEstudiante(int cod){
        if(estudiantes.get(cod) != null){
            estudiantes.remove(cod);
        }
        else{
            System.out.println("No se encontraron estudiantes con dicho codigo");
        }
    }
    
}
