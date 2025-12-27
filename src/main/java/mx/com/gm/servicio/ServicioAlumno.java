package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.AlumnoDAO;
import mx.com.gm.domain.Alumno;

public class ServicioAlumno {
    
    private AlumnoDAO alumnoDao = new AlumnoDAO();
    
   public List<Alumno> Listar(){
       return alumnoDao.listar();
   }
   
   public void guardarAlumno(Alumno alumno){
       if(alumno != null && alumno.getIdAlumno() == null){
           alumnoDao.crear(alumno);
       }else{
           alumnoDao.actualizar(alumno);
       }
   }
   
   public void eliminarAlumno(Alumno alumno){
       if(alumno.getIdAlumno() != null){
           alumnoDao.eliminar(alumno);
       }else{
           System.out.println("El alumno no existe, ingrese un alumno válido.");
       }
   }
   
   public Alumno encontrarAlumno(Alumno alumno){
       return alumnoDao.buscarPorId(alumno.getIdAlumno());
   }
    
    
}
