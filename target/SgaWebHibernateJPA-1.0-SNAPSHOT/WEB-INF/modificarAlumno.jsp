<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Alumno</title>
    </head>
    <body>
        <h1>Modificar Alumno</h1>
        <form name="form1" action="${pageContext.request.contextPath}/ServletModificar" method="post">
            
            <input type="hidden" name="idAlumno" value="${alumnoModificar.idAlumno}"/>
            
            Nombre: <input type="text" name="nombre" value="${alumnoModificar.nombre}"/>
            <br/>
            Apellido: <input type="text" name="apellido" value="${alumnoModificar.apellido}"/>
            <br/>
            <br/>
            Datos Domicilio:
            <br/>
            Calle: <input type="text" name="calle" value="${alumnoModificar.domicilio.calle}"/>
            <br/>
            Nro. Calle: <input type="text" name="noCalle" value="${alumnoModificar.domicilio.noCalle}"/>
            <br/>
            País: <input type="text" name="pais" value="${alumnoModificar.domicilio.pais}"/>
            <br/>
            <br/>
            Datos Contacto:
            <br/>
            Emai: <input type="email" name="email" value="${alumnoModificar.contacto.email}"/>
            <br/>
            Teléfono: <input type="tel" name="telefono" value="${alumnoModificar.contacto.telefono}"/>
            <br/>
            <input type="submit" name="Modificar" value="Modificar"/>
            <input type="submit" name="Eliminar" value="Eliminar"/>
    </body>
</html>
