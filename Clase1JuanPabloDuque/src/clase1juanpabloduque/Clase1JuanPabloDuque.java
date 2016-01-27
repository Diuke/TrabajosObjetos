package clase1juanpabloduque;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Clase1JuanPabloDuque {

    public static void main(String[] args) {
        int dia, mes, year, error = 0;
        boolean valid = true;
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Ingrese el dia: ");
            dia = scan.nextInt();
            System.out.println("Ingrese el mes: ");
            mes = scan.nextInt();
            if (mes < 1 || mes > 12) {
                valid = false;
                error = 2;
            } else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                if (dia < 1 || dia > 31) {
                    valid = false;
                    error = 1;
                }

            } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                if (dia < 1 || dia > 30) {
                    valid = false;
                    error = 1;
                }

            } else if (mes == 2) {
                if (dia < 1 || dia > 28) {
                    valid = false;
                    error = 1;
                }

            }
            System.out.println("Ingrese el año: ");
            year = scan.nextInt();
            if (year < 0) {
                valid = false;
                error = 3;
            }
            if (year % 4 == 0 && mes == 2 && (dia >= 1 && dia <= 29)) {
                valid = true;
            }
            if (valid) {
                System.out.println("Fecha valida");
            } else {
                System.out.println("Fecha invalida");
                switch (error) {
                    case 1:
                        System.out.println("Error en el dia ingresado.");
                        break;

                    case 2:
                        System.out.println("Error en el mes ingresado.");
                        break;

                    case 3:
                        System.out.println("Error en el año ingresado.");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
            e.printStackTrace();
        }

    }
}
