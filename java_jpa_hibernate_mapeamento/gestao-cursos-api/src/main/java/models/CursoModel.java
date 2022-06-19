package models;

import entities.Aluno;
import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class CursoModel {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
    EntityManager em = emf.createEntityManager();
    public void create(Curso curso) {

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("Curso criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um curso !!!" + e.getMessage());
            e.printStackTrace();
        } finally {

            System.out.println("Finalizando a transação");
        }
    }

    public Curso findById(Long id) {
        return em.find(Curso.class, id);
    }

    public List<Curso> findAll() {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos = em.createQuery("FROM " + Curso.class.getSimpleName()).getResultList();
        return cursos;
    }

    public void update(Curso curso) {
        try {
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void delete(Curso curso) {
        try {
            Curso curso1 = findById(curso.getId());
            remove(curso1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void remove(Curso curso) {
        try {
            em.getTransaction().begin();
            curso = em.find(Curso.class, curso.getId());
            em.remove(curso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
