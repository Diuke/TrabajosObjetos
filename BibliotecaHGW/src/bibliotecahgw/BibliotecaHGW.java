/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecahgw;

import bibliotecahgw.material.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import org.jcp.xml.dsig.internal.dom.Utils;

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
        loadLibros();
        loadClientes();
        loadPrestamos(); 
//        for (int i = 0; i < 2000; i++) {
//            libros.put((i + 1), new Libro(true, i + 1, "" + rand.nextInt(), "Libro" + i + 1));
//        }
//        for (int i = 0; i < 200; i++) {
//            clientes.put((i + 1) + 3000, new Cliente(rand.nextInt(18), "Niño" + (i + 1), "Parents", "School", (i + 1) + 3000));
//        }
    }

    public void loadLibros() {
        HashMap<Integer, Libro> deserializeLibros = null;
        try {
            FileInputStream fis = new FileInputStream(Utils.class.getResource("/resources/libros.ser").getFile());
            ObjectInputStream ois = new ObjectInputStream(fis);
            deserializeLibros = (HashMap) ois.readObject();
            ois.close();
            fis.close();
            this.libros = deserializeLibros;

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void loadClientes() {
        HashMap<Integer, Cliente> deserializeClientes = null;
        try {
            FileInputStream fis = new FileInputStream(Utils.class.getResource("/resources/clientes.ser").getFile());
            ObjectInputStream ois = new ObjectInputStream(fis);
            deserializeClientes = (HashMap) ois.readObject();
            ois.close();
            fis.close();
            this.clientes = deserializeClientes;
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void loadPrestamos() {
        HashMap<Integer, Prestamo> deserializePrestamos = null;
        try {
            FileInputStream fis = new FileInputStream(Utils.class.getResource("/resources/prestamos.ser").getFile());
            ObjectInputStream ois = new ObjectInputStream(fis);
            deserializePrestamos = (HashMap) ois.readObject();
            ois.close();
            fis.close();
            this.prestamos = deserializePrestamos;

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void nuevoPrestamo(int codCliente, int codLibro, String fecha) { 
        Libro l = buscarLibro(codLibro);
        if(l.isDisponible()){
            Prestamo p = new Prestamo(Integer.parseInt("" + clientes.get(codCliente).getCod() + libros.get(codLibro).getCod()), libros.get(codLibro), clientes.get(codCliente), fecha);
            prestamos.put(p.getCodPrestamo(), p);
            //libros.get(codLibro).toggleDisponible(false); 
            libros.get(codLibro).toggleDisponible(); 
            libros.get(codLibro).setClientePrestado(clientes.get(codCliente));
            clientes.get(codCliente).addPrestamos(p);
            update();
        }
    }

    public void retornoPrestamo(int codPrestamo) {
        Prestamo tempP = prestamos.get(codPrestamo);
        if (tempP != null) {
            if (tempP.getMulta() > 0f) {
                System.out.println("Tiene una multa de " + tempP.getMulta());
                System.out.println("Desea pagar?");
                Scanner scan = new Scanner(System.in);
                if (scan.nextLine().equals("si")) {
                    //tempP.libro.toggleDisponible(true);
                    libros.get(tempP.libro.getCod()).toggleDisponible();
                    clientes.get(tempP.cliente.getCod()).actualizarIncumplimientos();
                    libros.get(tempP.libro.getCod()).setClientePrestado(null);
                    clientes.get(tempP.cliente.getCod()).prestamos.remove(codPrestamo);
                    prestamos.remove(codPrestamo);
                } else {
                    System.out.println("debe pagar primero");
                }

            } else {
                //tempP.libro.toggleDisponible(true);
                libros.get(tempP.libro.getCod()).toggleDisponible();
                clientes.get(tempP.cliente.getCod()).actualizarIncumplimientos();
                libros.get(tempP.libro.getCod()).setClientePrestado(null);
                clientes.get(tempP.cliente.getCod()).prestamos.remove(codPrestamo);
                prestamos.remove(codPrestamo);
            }

        } else {
            System.out.println("No se encontro el prestamo");
        }
        update();
    }

    public void renovarPrestamo(int codPrestamo) {
        Prestamo p = this.prestamos.get(codPrestamo);
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
        update();
    }

    public Libro buscarLibro(int cod) {
        Libro temp = libros.get(cod);
        if (temp != null) {
            return temp;
        }
        System.out.println("No se encontro el libro");
        return null;
    }

    public void update() {
        try {
            FileOutputStream f = new FileOutputStream(Utils.class.getResource("/resources/libros.ser").getFile());
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(this.libros);

            f = new FileOutputStream(Utils.class.getResource("/resources/clientes.ser").getFile());
            out = new ObjectOutputStream(f);
            out.writeObject(this.clientes);

            f = new FileOutputStream(Utils.class.getResource("/resources/prestamos.ser").getFile());
            out = new ObjectOutputStream(f);
            out.writeObject(this.prestamos);

            out.close();
            f.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Libro> librosDisponibles() {
        ArrayList<Libro> disponibles = new ArrayList<>();
        for (Libro libro : this.libros.values()) {
            if (libro.isDisponible()) {
                disponibles.add(libro);
            }
        }
        return disponibles;
    }

    public void reportarPerdido(int cod) {
        Libro p = buscarLibro(cod);
        if (p != null) {
            if (p.getClientePrestado() == null) {
                System.out.println("Este libro no ha sido prestado");
            } else {
                Prestamo pres = prestamos.get(p.getCod() + p.getClientePrestado().getCod());
                pres.setMulta(pres.getMulta() + 20000);
                libros.remove(cod);
            }
        } else {
            System.out.println("No se encontro el libro");
        }
        update();
    }

    public void reiniciarIncumplimento() {
        for (Prestamo p : prestamos.values()) {
            p.incumplido = false;
        }
        update();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BibliotecaHGW biblioteca = new BibliotecaHGW();
        //biblioteca.libros.get(201).toggleDisponible();
        
        //biblioteca.nuevoPrestamo(3001, 201, "Hoy");   
        //biblioteca.reportarPerdido(200);
        //biblioteca.retornoPrestamo(3001201); 
//        for (Prestamo p : biblioteca.prestamos.values()) {
//            System.out.println(p.codPrestamo + ", " + p.multa);
//        }
//        //biblioteca.clientes.get(3001).prestamos.clear();
//        for(Prestamo p : biblioteca.clientes.get(3001).prestamos.values()){
//            System.out.println(p.libro.getCod());
//        } 
//        ArrayList<Libro> lD = biblioteca.librosDisponibles();
//        for (Libro l : lD) {
//            System.out.println(l.getCod() + ", " + l.getTitulo());
//        }
        //System.out.println(biblioteca.libros.get(201).isDisponible() ? "si" : "no");
        //biblioteca.update();

    }

}
