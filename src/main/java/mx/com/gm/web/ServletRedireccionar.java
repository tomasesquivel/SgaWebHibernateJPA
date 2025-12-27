package mx.com.gm.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletRedireccionar")
public class ServletRedireccionar extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
       req.getRequestDispatcher("/WEB-INF/agregarAlumno.jsp").forward(req, resp);
    }
    
}
