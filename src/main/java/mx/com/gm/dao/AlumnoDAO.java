package mx.com.gm.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mx.com.gm.domain.Alumno;

public class AlumnoDAO extends GenericDAO<Alumno>{
   

  @Override
    public List<Alumno> listar() {
        EntityManager em = getEntityManager();
        List<Alumno> alumnos = new ArrayList<>();

        try {
            String hql = "SELECT a FROM Alumno a";
            TypedQuery<Alumno> query = em.createQuery(hql, Alumno.class);
            alumnos = query.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return alumnos;
    }

    @Override
    public void crear(Alumno objeto) {
     if(objeto == null){
            System.out.println("No se puede crear un objeto null");
            return;
        }
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
        
                em.merge(objeto);
            
            em.getTransaction().commit();
            System.out.println("Alumno creado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Alumno objeto) {
        if(objeto == null){
            System.out.println("No se puede actualizar un objeto null");
            return;
        }
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
        
                em.merge(objeto);
            
            em.getTransaction().commit();
            System.out.println("Alumno actualizado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }
    @Override
    public void eliminar(Alumno objeto) {
          if(objeto == null){
            System.out.println("No se puede borrar un objeto null");
            return;
        }
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
        
               em.remove(em.merge(objeto));
            
            em.getTransaction().commit();
            System.out.println("Alumno borrado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }
    
    public Alumno buscarPorId(Integer idAlumno) {
        if (idAlumno == null) {
            System.out.println("No se puede buscar un alumno null");
            return null;
        }
        Alumno alumnoEncontrado = null;
        EntityManager em = getEntityManager();
        try {
            alumnoEncontrado = em.find(Alumno.class, idAlumno);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return alumnoEncontrado;
    }
    
}

    

