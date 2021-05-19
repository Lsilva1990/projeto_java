package DAO;

import JPAcontroller.TypeJpaController;
import Model.Type;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author thi_s
 */
public class TypesDAO {
    private final TypeJpaController objetoJPA;
    private final EntityManagerFactory emf;

    public TypesDAO() {
        emf = Persistence.createEntityManagerFactory("ProjetoPU");
        objetoJPA = new TypeJpaController(emf);
    }
    
    public void add(Type objeto) throws Exception{
        objetoJPA.create(objeto);
    }
    
    public void edit(Type objeto) throws Exception{
        objetoJPA.edit(objeto);
    }
    
    public void remove(int id) throws Exception{
        objetoJPA.destroy(id);
    }
   
    
    public List<Type> getAllUsers(){
        return objetoJPA.findTypeEntities();
    }
    
    public void persist (Type objeto){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(objeto);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }   
}