package py.fpuna.com.agendapediatricaapp.dto;

import java.io.Serializable;

/**
 * Created by marceloe on 09/10/17.
 */

public class UsuarioDTO implements Serializable {

    private Integer id;

    private String nombre;

    private String correo;

    private Boolean valido;
    private String[] hijos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getValido() {
        return valido;
    }

    public void setValido(Boolean valido) {
        this.valido = valido;
    }

}