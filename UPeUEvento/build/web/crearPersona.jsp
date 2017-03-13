<%-- 
    Document   : crearPersona
    Created on : 07/11/2016, 09:05:16 AM
    Author     : Alumnos
--%>

<%@page import="pe.edu.upeu.modelo.PersonaTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
        PersonaTO to=null;
        to=(PersonaTO)request.getSession()
                .getAttribute("personaX");
        %>        
        <form name="formCrear" action="PersonaControlx">
            <table border="0">
                <thead>
                    <tr>
                        <th colspan="2">FORMULARIO - CREAR PERSONA</th>                        
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="nombre" value="<%=to.getNombres()%>" /></td>
                    </tr>
                    <tr>
                        <td>Apellidos:</td>
                        <td><input type="text" name="apellidos" value="" /></td>
                    </tr>
                    <tr>
                    <td colspan="2" >
                    <center> 
                    <input type="submit" value="Enviar" name="btnEnviar" />
                    <input type="hidden" name="opc" value="B1" />
                    </center>
                    </td>
                        
                    </tr>
                </tbody>
            </table>

             
             
            
        </form> 
    </body>
</html>
