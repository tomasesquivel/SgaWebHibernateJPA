package mx.com.gm.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mx.com.gm.domain.Curso;

public class CursoDAO extends GenericDAO<Curso> {

  @Override
    public List<Curso> listar() {
        EntityManager em = getEntityManager();
        List<Curso> cursos = new ArrayList<>();

        try {
            String hql = "SELECT cu FROM Curso cu";
            TypedQuery<Curso> query = em.createQuery(hql, Curso.class);
            cursos = query.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return cursos;
    }

    @Override
    public void crear(Curso objeto) {
     if(objeto == null){
            System.out.println("No se puede crear un objeto null");
            return;
        }
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
        
                em.persist(objeto);
            
            em.getTransaction().commit();
            System.out.println("Curso creado correctamente");
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
    public void actualizar(Curso objeto) {
        if(objeto == null){
            System.out.println("No se puede actualizar un objeto null");
            return;
        }
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
        
                em.merge(objeto);
            
            em.getTransaction().commit();
            System.out.println("Curso actualizado correctamente");
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
    public void eliminar(Curso objeto) {
          if(objeto == null){
            System.out.println("No se puede borrar un objeto null");
            return;
        }
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
        
               em.remove(em.merge(objeto));
            
            em.getTransaction().commit();
            System.out.println("Curso borrado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }
    
    public Curso buscarPorId(Integer idCurso) {
        if (idCurso == null) {
            System.out.println("No se puede buscar un curso null");
            return null;
        }
        Curso cursoEncontrado = null;
        EntityManager em = getEntityManager();
        try {
            cursoEncontrado = em.find(Curso.class, idCurso);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return cursoEncontrado;
    }
    
}
