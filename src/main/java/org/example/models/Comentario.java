package org.example.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Comentario implements Serializable {
    private static final long SERIAL_VERSION_UID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String contenido;
    private Integer valoracion;
    @OneToOne
    private Usuario usuario;

    @Override
    public String toString() {
        return "Comentario{" +
                "id='" + id + '\'' +
                ", contenido='" + contenido + '\'' +
                ", valoracion='" + valoracion + '\'' +
                ", usuario=" + usuario.getCorreo() +
                '}';
    }
}
