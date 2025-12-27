package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;


public abstract class GenericDAO<T> {
    protected static EntityManagerFactory emf;
    protected EntityManager em;
    
    public GenericDAO(){
        if(emf == null){
            this.emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        }
    }
    
   protected EntityManager getEntityManager(){
       return emf.createEntityManager();
   }
   
   public static void closeFactory(){
       if(emf != null && emf.isOpen()){
           emf.close();
       }
   }
   
   public abstract List<T> listar();
   public abstract void crear(T objeto);
   public abstract void actualizar(T objeto);
   public abstract void eliminar(T objeto);
    
}
