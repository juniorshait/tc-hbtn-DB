package models;

import entities.Pessoa;
import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PessoaModel {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
    EntityManager em = emf.createEntityManager();

    public void create(Pessoa p) {

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar a pessoa !!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas = em.createQuery("FROM " + Pessoa.class.getSimpleName()).getResultList();
        return pessoas;

    }

    public Pessoa findById(Pessoa p) {
        return em.find(Pessoa.class, p.getId());
    }

    public void update(Pessoa p) {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void delete(Pessoa p) {
        try {
            Pessoa pessoa = findById(p);
            remove(pessoa);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void remove(Pessoa pessoa) {
        try {
            em.getTransaction().begin();
            pessoa = em.find(Pessoa.class, pessoa.getId());
            em.remove(pessoa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
