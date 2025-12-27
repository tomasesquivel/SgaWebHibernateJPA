package mx.com.gm.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Domicilio;

public class DomicilioDAO extends GenericDAO<Domicilio> {
     
    

    @Override
    public List<Domicilio> listar() {
        EntityManager em = getEntityManager();
        List<Domicilio> domicilios = new ArrayList<>();

        try {
            String hql = "SELECT d FROM Domicilio d";
            TypedQuery<Domicilio> query = em.createQuery(hql, Domicilio.class);
            domicilios = query.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return domicilios;
    }

    @Override
    public void crear(Domicilio objeto) {
     if(objeto == null){
            System.out.println("No se puede crear un objeto null");
            return;
        }
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
        
                em.merge(objeto);
            
            em.getTransaction().commit();
            System.out.println("Domicilio creado correctamente");
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
    public void actualizar(Domicilio objeto) {
        if(objeto == null){
            System.out.println("No se puede actualizar un objeto null");
            return;
        }
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
        
                em.merge(objeto);
            
            em.getTransaction().commit();
            System.out.println("Domicilio actualizado correctamente");
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
    public void eliminar(Domicilio objeto) {
          if(objeto == null){
            System.out.println("No se puede borrar un objeto null");
            return;
        }
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
        
               em.remove(em.merge(objeto));
            
            em.getTransaction().commit();
            System.out.println("Domicilio borrado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }
    
    public Domicilio buscarPorId(Integer idDomicilio) {
        if (idDomicilio == null) {
            System.out.println("No se puede buscar un domicilio null");
            return null;
        }
        Domicilio domicilioEncontrado = null;
        EntityManager em = getEntityManager();
        try {
            domicilioEncontrado = em.find(Domicilio.class, idDomicilio);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return domicilioEncontrado;
    }
    
}
