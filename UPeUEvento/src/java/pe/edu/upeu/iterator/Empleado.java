/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.iterator;

/**
 *
 * @author Alumnos
 */
public class Empleado {
    private String nombre;
    private String division;

    public Empleado(String nombre, String division) {
        this.nombre = nombre;
        this.division = division;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
    
    public void print(){
        System.out.println("Nombre: "+nombre+" Division: "+division);
    }
    
}
