
package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author aspit
 */
@Entity
@Table(name = "empleados")
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false) 
    @Column(name = "numero_de_empleado")
    private Integer numeroDeEmpleado;
    @Size(max = 45)
    @Column(name = "puesto")
    private String puesto;
    @Size(max = 45)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona", updatable = false, nullable = false)
    private Persona persona;

    public Empleados() {
    }

    public Empleados(Integer numeroDeEmpleado) {
        this.numeroDeEmpleado = numeroDeEmpleado;
    }

    public Integer getNumeroDeEmpleado() {
        return numeroDeEmpleado;
    }

    public void setNumeroDeEmpleado(Integer numeroDeEmpleado) {
        this.numeroDeEmpleado = numeroDeEmpleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroDeEmpleado != null ? numeroDeEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.numeroDeEmpleado == null && other.numeroDeEmpleado != null) || (this.numeroDeEmpleado != null && !this.numeroDeEmpleado.equals(other.numeroDeEmpleado))) {
            return false;
        }
        return true;
    }

   @Override
    public String toString() {
        return "mx.com.gm.sga.practicacaaaa.Empleados[ numeroDeEmpleado=" + numeroDeEmpleado + " ]";
    }
    
    
    
}
