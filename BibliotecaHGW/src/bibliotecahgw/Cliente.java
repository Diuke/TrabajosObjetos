/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecahgw;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author juan-
 */
public class Cliente implements java.io.Serializable{
    private int cod;
    private int age;
    private String name;
    private String parents;
    private String school;
    int inclumplimiento;
    ArrayList<Actividad> actividades;
    HashMap<Integer, Prestamo> prestamos;

    public Cliente(int age, String name, String parents, String school, int cod) {
        this.cod = cod;
        this.age = age;
        this.inclumplimiento = 0;
        this.name = name;
        this.parents = parents;
        this.school = school;
        this.prestamos = new HashMap<>();
        this.actividades = new ArrayList<>();
    }
    
    public void addActividad(Actividad a){
        this.actividades.add(a);
    }
    
    public void addPrestamos(Prestamo p){
        this.prestamos.put(p.getCodPrestamo(), p);
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public HashMap<Integer, Prestamo> getPrestamos() {
        return prestamos;
    }

    public int getCod() {
        return cod;
    }
    
    public int getIncmplimiento(){
        return this.inclumplimiento;
    }
    
    public void actualizarIncumplimientos(){
        this.inclumplimiento = 0;
        for(Prestamo p: prestamos.values()){
            if(p.incumplido){
                inclumplimiento++;
            }
        }
    }
    
}
