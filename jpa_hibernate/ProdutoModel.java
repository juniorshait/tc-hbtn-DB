package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
    EntityManager em = emf.createEntityManager();
    public void create(Produto p) {

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Produto p) {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void delete(Produto p) {
        try {
            Produto produto = findById(p);
            remove(produto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Produto findById(Produto p) {
        return em.find(Produto.class, p.getId());
    }

    public List<Produto> findAll() {
      List<Produto> produtos = new ArrayList<Produto>();
      produtos = em.createQuery("FROM " + Produto.class.getSimpleName()).getResultList();
      return produtos;

    }
    public void remove(Produto produto) {
        try {
            em.getTransaction().begin();
            produto = em.find(Produto.class, produto.getId());
            em.remove(produto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
