package mx.com.gm.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.domain.Alumno;
import mx.com.gm.servicio.ServicioAlumno;

@WebServlet("/ServletModificar")
public class ServletModificar extends HttpServlet {
ServicioAlumno servicioAlumno = new ServicioAlumno();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idAlumno = req.getParameter("idAlumno");

        Alumno alumnoModificar = new Alumno();
        alumnoModificar.setIdAlumno(Integer.parseInt(idAlumno));

        alumnoModificar = servicioAlumno.encontrarAlumno(alumnoModificar);

        HttpSession sesion = req.getSession();
        sesion.setAttribute("alumnoModificar", alumnoModificar);

        req.getRequestDispatcher("/WEB-INF/modificarAlumno.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String modificar = req.getParameter("Modificar");

        if (modificar != null) {
            String nombre = req.getParameter("nombre");
            String apellido = req.getParameter("apellido");

            String calle = req.getParameter("calle");
            String noCalle = req.getParameter("noCalle");
            String pais = req.getParameter("pais");

            String email = req.getParameter("email");
            String telefono = req.getParameter("telefono");

            HttpSession sesion = req.getSession();
            Alumno alumno = (Alumno) sesion.getAttribute("alumnoModificar");

            alumno.setNombre(nombre);
            alumno.setApellido(apellido);

            alumno.getDomicilio().setCalle(calle);
            alumno.getDomicilio().setNoCalle(noCalle);
            alumno.getDomicilio().setPais(pais);

            alumno.getContacto().setEmail(email);
            alumno.getContacto().setTelefono(telefono);

            
            servicioAlumno.guardarAlumno(alumno);

            sesion.removeAttribute("alumnoModificar");
        }else{
            String idAlumnoS = req.getParameter("idAlumno");
            Integer idAlumno = Integer.parseInt(idAlumnoS);
            Alumno alumnoEliminar = new Alumno();
            alumnoEliminar.setIdAlumno(idAlumno);
            servicioAlumno.eliminarAlumno(alumnoEliminar);
        }
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }

}
