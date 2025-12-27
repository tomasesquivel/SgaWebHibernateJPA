package mx.com.gm.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mx.com.gm.domain.Asignacion;

public class AsignacionDAO extends GenericDAO<Asignacion>{

  @Override
    public List<Asignacion> listar() {
        EntityManager em = getEntityManager();
        List<Asignacion> asignacions = new ArrayList<>();

        try {
            String hql = "SELECT a FROM Asignacion a";
            TypedQuery<Asignacion> query = em.createQuery(hql, Asignacion.class);
            asignacions = query.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return asignacions;
    }

    @Override
    public void crear(Asignacion objeto) {
     if(objeto == null){
            System.out.println("No se puede crear un objeto null");
            return;
        }
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
        
                em.merge(objeto);
            
            em.getTransaction().commit();
            System.out.println("Asignacion creado correctamente");
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
    public void actualizar(Asignacion objeto) {
        if(objeto == null){
            System.out.println("No se puede actualizar un objeto null");
            return;
        }
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
        
                em.merge(objeto);
            
            em.getTransaction().commit();
            System.out.println("Asignacion actualizado correctamente");
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
    public void eliminar(Asignacion objeto) {
          if(objeto == null){
            System.out.println("No se puede borrar un objeto null");
            return;
        }
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
        
               em.remove(em.merge(objeto));
            
            em.getTransaction().commit();
            System.out.println("Asignacion borrado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }
    
    public Asignacion buscarPorId(Integer idAsignacion) {
        if (idAsignacion == null) {
            System.out.println("No se puede buscar un asignacion null");
            return null;
        }
        Asignacion asignacionEncontrado = null;
        EntityManager em = getEntityManager();
        try {
            asignacionEncontrado = em.find(Asignacion.class, idAsignacion);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return asignacionEncontrado;
    }
    
}


