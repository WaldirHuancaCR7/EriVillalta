/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.iterator;

import java.util.Iterator;

/**
 *
 * @author Alumnos
 */
public class Division {
   Empleado[] empleado=new Empleado[20];
   int numero=0;
   private String nombreDivision;

    public Division(String nombreDivision) {
        this.nombreDivision = nombreDivision;
    }

    public String getNombreDivision() {
        return nombreDivision;
    }
   
   public void add(String nombre){
       Empleado emp=new Empleado(nombre, nombreDivision);
       empleado[numero++]=emp;
   }
   
   public EjemploIterator iteratorX(){
       return new EjemploIterator(empleado);
   }
    
   public static void main(String [] arg){
   Division d=new Division("Mi Sucursal");
   d.add("Empleado 1");
   d.add("Empleado 2");
   d.add("Empleado 3");
   d.add("Empleado 4");
   
   //System.out.println(d);
   Iterator<Empleado> iter=d.iteratorX();
       while (iter.hasNext()) {
           Empleado empleado = iter.next();
           empleado.print();           
           System.out.println("Nombre X: "+empleado.getNombre());
       }
   
   }
   
}
