package mx.com.gm.dao;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Domicilio;

public class ContactoDAO extends GenericDAO<Contacto>{

 @Override
    public List<Contacto> listar() {
        EntityManager em = getEntityManager();
        List<Contacto> contactos = new ArrayList<>();

        try {
            String hql = "SELECT c FROM Contacto c";
            TypedQuery<Contacto> query = em.createQuery(hql, Contacto.class);
            contactos = query.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return contactos;
    }

    @Override
    public void crear(Contacto objeto) {
     if(objeto == null){
            System.out.println("No se puede crear un objeto null");
            return;
        }
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
        
                em.merge(objeto);
            
            em.getTransaction().commit();
            System.out.println("Contacto creado correctamente");
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
    public void actualizar(Contacto objeto) {
        if(objeto == null){
            System.out.println("No se puede actualizar un objeto null");
            return;
        }
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
        
                em.merge(objeto);
            
            em.getTransaction().commit();
            System.out.println("Contacto actualizado correctamente");
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
    public void eliminar(Contacto objeto) {
          if(objeto == null){
            System.out.println("No se puede borrar un objeto null");
            return;
        }
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
        
               em.remove(em.merge(objeto));
            
            em.getTransaction().commit();
            System.out.println("Contacto borrado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }
    
    public Contacto buscarPorId(Integer idContacto) {
        if (idContacto == null) {
            System.out.println("No se puede buscar un domicilio null");
            return null;
        }
        Contacto contactoEncontrado = null;
        EntityManager em = getEntityManager();
        try {
            contactoEncontrado = em.find(Contacto.class, idContacto);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return contactoEncontrado;
    }
    
}
