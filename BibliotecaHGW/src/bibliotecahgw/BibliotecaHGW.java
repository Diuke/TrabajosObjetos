/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecahgw;

import bibliotecahgw.material.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author juan-
 */
public class BibliotecaHGW {

    HashMap<Integer, Libro> libros;
    HashMap<Integer, Cliente> clientes;
    HashMap<Integer, Prestamo> prestamos;
    HashMap<Integer, DVD> dvd;
    HashMap<Integer, PDigital> pDigital;
    HashMap<Integer, Video> video;

    public BibliotecaHGW() {
        Random rand = new Random();
        libros = new HashMap<>();
        clientes = new HashMap<>();
        prestamos = new HashMap<>();
        dvd = new HashMap<>();
        pDigital = new HashMap<>();
        video = new HashMap<>();

        for (int i = 0; i < 2000; i++) {
            libros.put((i + 1), new Libro(true, i + 1, "" + rand.nextInt() + "," + rand.nextInt(), "Libro" + i + 1));
        }

        for (int i = 0; i < 200; i++) {
            clientes.put((i + 1) + 3000, new Cliente(rand.nextInt(18), "Niño" + (i + 1), "Them", "Tundra School", (i + 1) + 3000));
        }
    }

    public void nuevoPrestamo(int codCliente, int codLibro, String fecha) {
        Prestamo p = new Prestamo(clientes.get(codCliente).getCod() + libros.get(codLibro).getCod(), libros.get(codLibro), clientes.get(codCliente), fecha);
        prestamos.put(libros.get(codLibro).getCod() + clientes.get(codCliente).getCod(), p);
        libros.get(codLibro).toggleDisponible();
        libros.get(codLibro).setClientePrestado(clientes.get(codCliente));
        clientes.get(codCliente).addPrestamos(p);
    }

    public void retornoLibro(int codPrestamo) {
        Prestamo tempP = prestamos.get(codPrestamo);
        if (tempP != null) {
            if (tempP.getMulta() > 0f) {
                System.out.println("Tiene una multa de " + tempP.getMulta());
                System.out.println("Desea pagar?");
                Scanner scan = new Scanner(System.in);
                if (scan.nextLine().equals("si")) {
                    tempP.libro.toggleDisponible();
                    tempP.cliente.actualizarIncumplimientos();
                    tempP.libro.setClientePrestado(null);
                    tempP.cliente.prestamos.remove(codPrestamo);
                    prestamos.remove(codPrestamo);
                } else {
                    System.out.println("debe pagar primero");
                }

            } else {
                tempP.libro.toggleDisponible();
                tempP.cliente.actualizarIncumplimientos();
                tempP.libro.setClientePrestado(null);
                tempP.cliente.prestamos.remove(codPrestamo);
                prestamos.remove(codPrestamo);
            }

        } else {
            System.out.println("No se encontro el prestamo");
        }

    }

    public void renovarPrestamo(int codPrestamo) {
        Prestamo p = prestamos.get(codPrestamo);
        if (p != null) {
            if (p.getNumeroRenovaciones() > 2) {
                System.out.println("no se puede hacer otra renovacion");
            } else {
                p.numeroRenovaciones++;
                p.fechaPrestamo = "hoy";
            }
        } else {
            System.out.println("No se encontro el prestamo con dicho codigo");
        }

    }

    public Libro buscarLibro(int cod) {
        Libro temp = libros.get(cod);
        if (temp != null) {
            return temp;
        }
        System.out.println("No se encontro el libro");
        return null;
    }

    public ArrayList<Libro> librosDisponibles() {
        ArrayList<Libro> disponibles = new ArrayList<>();
        for (Libro libro : libros.values()) {
            if (libro.isDisponible()) {
                disponibles.add(libro);
            }
        }
        return disponibles;
    }

    public void reportarPerdido(int cod) {
        Libro p = buscarLibro(cod);
        if (p != null) {
            Prestamo pres = prestamos.get(p.getCod() + p.getClientePrestado().getCod());
            pres.setMulta(pres.getMulta() + 20000);
            libros.remove(cod);
        } else {
            System.out.println("No se encontro el libro");
        }
    }

    public void reiniciarIncumplimento() {
        for (Prestamo p : prestamos.values()) {
            p.incumplido = false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BibliotecaHGW biblioteca = new BibliotecaHGW();
        biblioteca.nuevoPrestamo(3001, 2000, "Hoy");
        ArrayList<Libro> lD = biblioteca.librosDisponibles();
        for (Libro l : lD) {
            System.out.println(l.getCod() + ", " + l.getTitulo());
        }
        biblioteca.reportarPerdido(2000);
        for(Prestamo p: biblioteca.prestamos.values()){
            System.out.println(p.codPrestamo + ", " + p.multa);
        }
        biblioteca.retornoLibro(5001);
    }

}
