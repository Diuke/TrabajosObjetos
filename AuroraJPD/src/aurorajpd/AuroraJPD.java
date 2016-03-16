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
public class AuroraJPD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Semestre s2016_1 = new Semestre("Primer Semestre 2016");
        for(int i = 0; i< 340; i++){
            s2016_1.nuevoEstudiante(new Estudiante(2000+i, "Estudiante" + i, "estudiante"+i+"@uninorte.edu.co", "normal"));
        }
        
        for(int i = 0; i<50; i++){
            s2016_1.nuevoProfesor(new Profesor(1000+i, "Profesor" + i, "Cualquiera", "profesor"+i+"@uninorte.edu.co", 100000+(i*100000)));
        }
        ArrayList<Estudiante> temporal;
        temporal = new ArrayList<>();
        for(int i = 0; i<30; i++){
            temporal.add(s2016_1.estudiantes.get(i+2020));
        }
        s2016_1.nuevoCurso(new Curso(4249, 24, 3, temporal, s2016_1.profesores.get(1001)));
        temporal.clear();
        for(int i = 0; i<30; i++){
            temporal.add(s2016_1.estudiantes.get(i+2100));
        }
        //temporal.add(s2016_1.encontrarEstudiante(2020));
        s2016_1.nuevoCurso(new Curso(4244, 24, 3, temporal, s2016_1.profesores.get(1001)));
        
        for(Curso c: s2016_1.cursos.values()){
            System.out.println("" + c.getNRC());
        } 
        Estudiante prueba = s2016_1.encontrarEstudiante(2020);//estudiante de prueba
        Curso cPrueba = s2016_1.cursos.get(4244);//curso de prueba 1
        Curso cPrueba2 = s2016_1.cursos.get(4249);//curso de prueba 2
        Profesor pPrueba = s2016_1.profesores.get(1001);//profesor de prueba
        
        prueba.verNRCs();
        cPrueba.setNotasEstudiantes();
        cPrueba.infoEstudiantes();
        float n = s2016_1.estudiantes.get(2100).notaFinalCurso(4249);
        System.out.println("");
        cPrueba2.setNotasEstudiantes();
        cPrueba2.infoEstudiantes();
        //prueba.nuevaNota(3.5f, 4244, "Parcial 1");
        n = prueba.notaFinalCurso(4249);
        System.out.println(""+n);
        pPrueba.verNRCs();
        prueba.notasXMateria();
        pPrueba.promediosEstudiantes(s2016_1.cursos, 1001);
    }
    
}
