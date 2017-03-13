/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.modelo.PersonaTO;
import pe.edu.upeu.util.DBConn;

/**
 *
 * @author Alumnos
 */
public class PersonaDAO extends DBConn{

    public PersonaDAO() {
        con=new DBConn().getInstance();
    }
   
    
    public ArrayList<PersonaTO> reportarPersona(){
        PersonaTO to=null;
        ArrayList<PersonaTO> lista=new ArrayList<PersonaTO>();
        con=new DBConn().getInstance();
        
        try {
            rs=con.prepareStatement("select * from persona ").executeQuery();
            System.out.println("Probar:" +rs.getRow());
            while(rs.next()){
                to=new PersonaTO();
                to.setId(rs.getInt("id"));
                to.setNombres(rs.getString("nombres"));                
                to.setApellidos(rs.getString("apellidos")); 
                lista.add(to);
                //System.out.println("OJO"+lista.size());
            }
        } catch (Exception e) {
        }        
        return lista;
    }
    public PersonaTO buscarPersonaId(int id){
        PersonaTO to=null;               
        try {
            rs=con.prepareStatement("select * from "
                    + " persona where id="+id+" ")
                    .executeQuery();            
            if(rs.next()){
            to=new PersonaTO();
            to.setId(rs.getInt("id"));
            to.setNombres(rs.getString("nombres"));                
            to.setApellidos(rs.getString("apellidos"));                                 
            }
        } catch (Exception e) {}        
        return to;
    }
    
    public void insertarPersona(PersonaTO to){
        int i=0;
        try {
            PreparedStatement ps=con.prepareStatement(" INSERT INTO "
                    + " persona(id, nombres, apellidos)"
                    + " VALUES(?, ?, ?); ");
                ps.setInt(++i, to.getId());            
                ps.setString(++i, to.getNombres());                
                ps.setString(++i, to.getApellidos());                          
                ps.execute();     
           
        } catch (Exception e) {
        }        
    }
    
    public void actualizarPersona(PersonaTO to){
        int i=0;
        try {
                PreparedStatement ps=con.prepareStatement(" UPDATE persona SET nombres=?, apellidos=? WHERE id=?; ");                          
                ps.setString(++i, to.getNombres());                
                ps.setString(++i, to.getApellidos());  
                ps.setInt(++i, to.getId());  
                ps.executeUpdate();     
           
        } catch (Exception e) {
        }         
    }
    
    
    public int eliminarPersona(int id){
        int i=0;
        try {
                PreparedStatement ps=con.prepareStatement(" DELETE FROM persona WHERE id=?  ");
                ps.setInt(++i, id);  
               i= ps.executeUpdate();     
           
        } catch (Exception e) {
        } 
        return i;
    }
    
//    public static void main(String [] arg){
//        PersonaDAO persona=new PersonaDAO();
//        persona.reportarPersona();
//    }
}
