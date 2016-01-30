/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase1juanpabloduque;

import java.util.Scanner;

/**
 *
 * @author juan-
 */
public class InOut {
    //Construtor is purposely skipped
    Scanner scan = new Scanner(System.in);
    //Output
    public void Write(String Line){
        System.out.println(Line);
    }
    
    //Inputs
    public int InputInt(String label){
        int newInt = 0;
        System.out.println(label);
        try {
            newInt = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Error, se esperaba un numero entero");
        }
        return newInt;
    }
    
    public float InputFloat(String label){
        float newFloat = 0.0f;
        System.out.println(label);
        try {
            newFloat = scan.nextFloat();
        } catch (Exception e) {
            System.out.println("Error, se esperaba un numero real");
        }
        return newFloat;
    }
    
    public String InputString(String label){
        String newString = "";
        System.out.println(label);
        try {
            newString = scan.nextLine();
        } catch (Exception e) {
            System.out.println("Error, se esperaba un String");
        }
        return newString;
    }
}
