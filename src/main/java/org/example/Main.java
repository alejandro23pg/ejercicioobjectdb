package org.example;

import org.example.models.Comentario;
import org.example.models.Usuario;
import org.example.services.Service;

public class Main {
    public static void main(String[] args) {
        Service s = new Service(ObjectDBUtil.getEntityManagerFactory());

        Usuario u = new Usuario();
        u.setCorreo("alejandro@cesurformacion.com");
        u.setNombre("Alejandro");
        s.saveUsuario(u);

        s.getUsuarios().forEach(System.out::println);

        Comentario c = new Comentario();
        c.setContenido("Buena película");
        c.setValoracion(7);

        s.getComentarios().forEach(System.out::println);
        s.getComentariosByUsuario().forEach(System.out::println);
    }
}