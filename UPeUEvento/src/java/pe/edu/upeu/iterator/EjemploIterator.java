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
public class EjemploIterator implements Iterator<Empleado>{
    
    Empleado[] empleado;
    int location=0;
    
    public EjemploIterator(Empleado[] emp) {
        empleado=emp;
    }
   
    @Override
    public Empleado next(){        
    return empleado[location++]; }
    
    @Override
    public boolean hasNext(){
        if(location<empleado.length && empleado[location]!=null){
        return  true;
        }else{
        return false;}
    }
    
    @Override
    public void remove(){    
    }
    
}
