package mx.com.gm.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "contacto")
public class Contacto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto")
    private Integer idContacto;
    
    private String email;
    private String telefono;
    
    public Contacto(){}
    public Contacto(Integer idContacto){
        this.idContacto = idContacto;
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Contacto{" + "idContacto=" + idContacto + ", email=" + email + ", telefono=" + telefono + '}';
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idContacto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contacto other = (Contacto) obj;
        return Objects.equals(this.idContacto, other.idContacto);
    }
    
    
}
