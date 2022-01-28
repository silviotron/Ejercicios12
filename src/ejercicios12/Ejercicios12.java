/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios12;

import java.util.Collection;

/**
 *
 * @author alumno
 */
public class Ejercicios12 {

    /**
     * @param args the command line arguments
     */
    private static Collection<String> c;
    private static Collection<Integer> notas;
    private static java.util.Scanner sc;
    public static void main(String[] args) {
        String seleccion = "";
        sc = new java.util.Scanner(System.in);
        do {
            
            seleccion = "";
            System.out.println("****************");
            System.out.println("*1. PArte 1    *");
            System.out.println("*2. Parte 2    *");
            System.out.println("*0. Salir      *");
            System.out.println("****************");
            seleccion = sc.nextLine();
            switch(seleccion){
                case "1":
                    parte1();
                    break;
                case "2":
                    parte2();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("opcion incorrecta");
                    
            }
            
        } while(!seleccion.equals("0"));
        
        
    }
        
        
    
    
    private static void parte1(){
        c = new java.util.ArrayList<>();
        sc = new java.util.Scanner(System.in);
        
        rellenar();
        
        String seleccion = "";

        do {
            seleccion = "";
            System.out.println("***********************");
            System.out.println("*1. Comprobar nombre  *");
            System.out.println("*2. Borrar nombre     *");
            System.out.println("*3. Borrar contiene   *");
            System.out.println("*4. Mostrar colección *");
            System.out.println("*0. Salir             *");
            System.out.println("***********************");
            String n;
            seleccion = sc.nextLine();
            switch(seleccion){
                case "1":
                    System.out.println("Introduce un nombre para comprobar.");
                    n = sc.nextLine();
                    if(c.contains(n)){
                        System.out.println("si");
                    }else{
                        System.out.println("no");
                    }
                    break;
                case "2":
                    System.out.println("Introduce un nombre para comprobar.");
                    n = sc.nextLine();
                    if(c.remove(n)){
                        System.out.println(c);
                    }else{
                        System.out.println("El nombre no existe");
                    }
                    break;
                case "3":
                    System.out.println("inserte la cadena que deben conter los elementos a borrar.");
                    n = sc.nextLine();
                    eliminarStringContiene2(n);
                    System.out.println(c);
                    break;
                case "4":
                    System.out.println(c);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("opcion incorrecta");
                    
            }
            
        } while(!seleccion.equals("0"));
        
        
    }
    
    
    private static void rellenar(){
        String n;
        do {            
            System.out.println("Introduce un nombre o final para terminar.");
            n = sc.nextLine();
            if(!n.equals("final")){
                c.add(n);
            }
            
        } while (!n.equals("final"));
    }
    
    private static int eliminarStringContiene(String s){
        java.util.Iterator<String> it = c.iterator();
        int eliminados = 0;
        while (it.hasNext()) {
            String next = it.next();
            if(next.contains(s)){
                it.remove();
                eliminados++;
            }            
        }
        return eliminados;
    }
    
    private static boolean eliminarStringContiene2(String s){
        return c.removeIf(elemento -> elemento.contains(s));
    }
    
    private static void parte2(){
        sc = new java.util.Scanner(System.in);
        notas = new java.util.ArrayList<>();
        int nota = -2;
        do {   
            System.out.println("Inserte la siguiente nota");
            if(sc.hasNextInt()){
                nota = sc.nextInt();
                if(nota >= 0 && nota <= 10){
                    notas.add(nota);
                }
                else if(nota != -1){
                    System.out.println("La nota debe tener un valor comprendido entre o y 10");
                }
            }
            sc.nextLine();
            
        } while (nota != -1);
        if(!notas.isEmpty()){
            System.out.println("Estado actual: ");
            System.out.println(notas);
            System.out.println("\nMedia: " + calcMedia());
            System.out.println("Mínimo: " + minimo());
            System.out.println("Máximo: " + maximo());
            
            System.out.println("\nEliminadas " + eliminarSuspensos() + " notas");
            System.out.println(notas);
            System.out.println("\nMedia: " + calcMedia());
            System.out.println("Mínimo: " + minimo());
            System.out.println("Máximo: " + maximo());            
            
            
        }
    }
    private static float calcMedia(){
        int suma = 0;
        for (Integer i : notas) {
            suma += i;
        }
        return suma/(float)notas.size();
        
    }
    
    private static int minimo(){
        int minimo = 10;
        for(int i: notas){
            if(minimo > i){
                minimo = i;
            }
        }
        return minimo;
    }
    
    private static int maximo(){
        int maximo = 0;
        for(int i: notas){
            if(maximo < i){
                maximo = i;
            }
        }
        return maximo;
    }
    
    private static int eliminarSuspensos(){
        //notas.removeIf(nota -> nota < 5);  
        int eliminados = 0;
        java.util.Iterator<Integer> it = notas.iterator();
        while(it.hasNext()){
            Integer next = it.next();
            if(next < 5){
                it.remove();
                eliminados++;
                
            }
        }
        return eliminados;
    }
    
}
