/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upeu.dao.PersonaDAO;
import pe.edu.upeu.modelo.PersonaTO;

/**
 *
 * @author Alumnos
 */
@WebServlet(name = "PersonaControl", urlPatterns = {"/PersonaControlx"})
public class PersonaControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String opc=request.getParameter("opc")==null?"":
                   request.getParameter("opc");
        PersonaDAO dao=null;
        PersonaTO to=null;
        try {
            switch(opc){
                case "A" : //Reporte 
                       dao=new PersonaDAO();
              
                       request.getSession().setAttribute("reportePersonaX", 
                               dao.reportarPersona());
                       response.sendRedirect("mainPersona.jsp"); 
                       break;
                case "B" : // Crear/Formulario
                    response.sendRedirect("crearPersona.jsp");
                    break;
                case "B1" : // Guardar 
                    dao=new PersonaDAO();
                    to=new PersonaTO();
                    String nombre=request.getParameter("nombre");
                    String apellidos=request.getParameter("apellidos");
                    to.setNombres(nombre);
                    to.setApellidos(apellidos);
                    dao.insertarPersona(to);
                    response.sendRedirect("ejemplo.jsp");
                    break;
                case "C" : //Actualizar
                    int idx=0;
                    idx=Integer.parseInt(
                            request.getParameter("id")==null?"0":
                            request.getParameter("id"));
                    dao=new PersonaDAO();
                    request.getSession().setAttribute("personaX",
                            dao.buscarPersonaId(idx));
                    response.sendRedirect("crearPersona.jsp");
                    break;
                case "C1" : break;//Actualizar
                case "D" : 
                    int id=0;
                    id=Integer.parseInt(
                            request.getParameter("id")==null?"0":
                            request.getParameter("id"));
                    dao=new PersonaDAO();
                    dao.eliminarPersona(id);
                    dao=new PersonaDAO();              
                    request.getSession().setAttribute("reportePersonaX", 
                            dao.reportarPersona());
                    response.sendRedirect("mainPersona.jsp"); 
                    break;//Eliminar
                default: 
                    dao=new PersonaDAO();
                    
                    break;
            }
            
            
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
