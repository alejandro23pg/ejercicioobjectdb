package org.example.services;

import org.example.models.Comentario;
import org.example.models.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private static EntityManagerFactory emf;

    public Service(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Historia 1: Registrar un nuevo usuario en la plataforma
     * @param u
     */
    public void saveUsuario(Usuario u) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Listar los usuarios de la plataforma
     */
    public List<Usuario> getUsuarios() {
        List<Usuario> salida = new ArrayList<Usuario>(0);

        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<Usuario> q = em.createQuery(
                    "SELECT u FROM Usuario u",
                    Usuario.class);
            salida = q.getResultList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        return salida;
    }

    /**
     * Historia 2: Listar los comentarios de un usuario específico
     */
    public List<Comentario> getComentariosByUsuario() {
        List<Comentario> salida = new ArrayList<Comentario>(0);

        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<Comentario> q = em.createQuery(
                    "SELECT c FROM Comentario c WHERE c.usuario.correo=:usu",
                    Comentario.class);
            salida = q.getResultList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        return salida;
    }

    /**
     * Historia 3: Añadir un comentario la plataforma
     * @param c
     */
    public void saveComentario(Comentario c) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Listar los comentarios de la plataforma
     */
    public List<Comentario> getComentarios() {
        List<Comentario> salida = new ArrayList<Comentario>(0);

        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<Comentario> q = em.createQuery(
                    "SELECT c FROM Comentario c",
                    Comentario.class);
            salida = q.getResultList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        return salida;
    }

    /**
     * Historia 4: Listar los usuarios que han realizado comentarios con la valoración máxima posible
     */
    public List<Usuario> getUsuariosMaximaPuntuacion() {
        List<Usuario> salida = new ArrayList<Usuario>(0);

        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<Usuario> q = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.comentario.puntuacion=:10",
                    Usuario.class);
            salida = q.getResultList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        return salida;
    }
}
