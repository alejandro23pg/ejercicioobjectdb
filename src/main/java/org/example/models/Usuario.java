package org.example.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Usuario implements Serializable {
    private static final long SERIAL_VERSION_UID = 1L;

    @Id
    private String correo;
    private String nombre;
    @OneToMany
    private List<Comentario> comentarios = new ArrayList<>();

    public void addComentarios(Comentario c){
        comentarios.add(c);
        c.getUsuario();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", comentarios=" + comentarios.size() +
                '}';
    }
}
