/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aurorajpd;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author juan-
 */
public class Profesor extends MiembroUN{
    private String dept;
    private int sueldo;
    private HashMap<Integer, Curso> NRCs;
    public Profesor(int cod, String nombre, String dept, String correo, int sueldo) {
        super(cod, nombre, correo);
        NRCs = new HashMap<>();
        this.sueldo = sueldo;
        this.dept = dept;
    }
    
    public void newCurso(Curso c){
        this.NRCs.put(c.getNRC(), c);
    }
    
    public void verNRCs(){
        for(Curso c: NRCs.values()){
            System.out.println(""+c.getNRC());
        }
        if(NRCs.size() == 0){
            System.out.println("no hay cursos asignados");
        }
    }   

    public String getDept() {
        return dept;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    public void promediosEstudiantes(HashMap<Integer, Curso> cur, int nrc){
        for(Curso c: this.NRCs.values()){
            System.out.println("NRC: " + c.getNRC());
            cur.get(c.getNRC()).promediosXEstudiante();
        }
    }

}
