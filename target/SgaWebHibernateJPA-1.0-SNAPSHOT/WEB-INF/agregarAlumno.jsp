<%-- 
    Document   : agregarAlumno
    Created on : 25 dic 2025, 20:27:48
    Author     : Krober
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Alumno</title>
    </head>
    <body>
        <h1>Agregar Alumno</h1>
        <form name="form1" action="${pageContext.request.contextPath}/ServletAgregar" method="post">
            Nombre: <input type="text" name="nombre"/>
            <br/>
            Apellido: <input type="text" name="apellido"/>
            <br/>
            <br/>
            Datos Domicilio:
            <br/>
            Calle: <input type="text" name="calle"/>
            <br/>
            Nro. Calle: <input type="text" name="noCalle"/>
            <br/>
            País: <input type="text" name="pais"/>
            <br/>
            <br/>
            Datos Contacto:
            <br/>
            Emai: <input type="email" name="email"/>
            <br/>
            Teléfono: <input type="tel" name="telefono"/>
            <br/>
            <input type="submit" name="Agregar" value="Agregar"/>
            
        </form>
    </body>
</html>
