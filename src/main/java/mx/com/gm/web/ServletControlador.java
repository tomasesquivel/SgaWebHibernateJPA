package mx.com.gm.web;


import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.domain.Alumno;
import mx.com.gm.servicio.ServicioAlumno;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
       ServicioAlumno servicioAlumno = new ServicioAlumno();
       
       List<Alumno> alumnos = servicioAlumno.Listar();
       
      req.setAttribute("alumnos", alumnos);
      
        try {
            req.getRequestDispatcher("/WEB-INF/listarAlumnos.jsp").forward(req, resp);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
      
    }
}
