<%-- 
    Document   : index
    Created on : 10/10/2016, 09:01:39 AM
    Author     : Alumnos
--%>


<%@page import="pe.edu.upeu.modelo.PersonaTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="PersonaControlx?opc=B">
            Crear Persona
        </a>  
        <%
        List<PersonaTO> listaPersona=null; 
        listaPersona=(List<PersonaTO>)request.getSession().getAttribute("reportePersonaX");
        %>
        <br/>        
        <table>
            <tr>
                <td> Reporte de Personas</td>
            </tr>
            <tr>
                <td>#</td>
                <td>Nombre</td>
                <td>Apellidos</td>                                
                <td>Opciones</td>                                
            </tr>
            
                <%  
                int i=0;
                out.print(listaPersona.size());
                for(PersonaTO to: listaPersona){
                %>
                <tr>
                <td><%=++i%></td>
                <td><% out.print(to.getNombres()); %></td>
                <td><%=to.getApellidos() %></td>
                <td><a href="PersonaControlx?id=<%=to.getId()%>&opc=D">D</a> <a href="PersonaControlx?id=<%=to.getId()%>&opc=C">U</a></td>
                </tr>
                <%
                }
               
                %>
            
            
        </table>
        
    </body>
</html>
