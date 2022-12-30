/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillahbisa.yokbisa;

import bismillahbisa.yokbisa.exceptions.NonexistentEntityException;
import bismillahbisa.yokbisa.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author raiha
 */
public class Nyobaujian2JpaController implements Serializable {

    public Nyobaujian2JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bismillahbisa_yokbisa_jar_0.0.1-SNAPSHOTPU");
    
    public Nyobaujian2JpaController(){
        
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nyobaujian2 nyobaujian2) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(nyobaujian2);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNyobaujian2(nyobaujian2.getId()) != null) {
                throw new PreexistingEntityException("Nyobaujian2 " + nyobaujian2 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nyobaujian2 nyobaujian2) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            nyobaujian2 = em.merge(nyobaujian2);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = nyobaujian2.getId();
                if (findNyobaujian2(id) == null) {
                    throw new NonexistentEntityException("The nyobaujian2 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nyobaujian2 nyobaujian2;
            try {
                nyobaujian2 = em.getReference(Nyobaujian2.class, id);
                nyobaujian2.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nyobaujian2 with id " + id + " no longer exists.", enfe);
            }
            em.remove(nyobaujian2);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nyobaujian2> findNyobaujian2Entities() {
        return findNyobaujian2Entities(true, -1, -1);
    }

    public List<Nyobaujian2> findNyobaujian2Entities(int maxResults, int firstResult) {
        return findNyobaujian2Entities(false, maxResults, firstResult);
    }

    private List<Nyobaujian2> findNyobaujian2Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nyobaujian2.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Nyobaujian2 findNyobaujian2(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nyobaujian2.class, id);
        } finally {
            em.close();
        }
    }

    public int getNyobaujian2Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nyobaujian2> rt = cq.from(Nyobaujian2.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
