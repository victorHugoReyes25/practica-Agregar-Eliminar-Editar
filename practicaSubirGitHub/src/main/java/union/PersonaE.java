package union;

import domain.Empleados;
import domain.Persona;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
public class PersonaE {
    Persona idPersona;
    Persona Edad;
    Persona nombre;
    Persona apellidoPateno;
    Persona apellidoMaterno;
    Empleados numeroDeEmpleado;
    Empleados puesto;
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
     @JoinColumn(name = "id_persona", updatable = false, nullable = false)
    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPErsona(Persona idPErsona) {
        this.idPersona = idPErsona;
    }

    public Persona getEdad() {
        return Edad;
    }

    public void setEdad(Persona Edad) {
        this.Edad = Edad;
    }

    public Persona getNombre() {
        return nombre;
    }

    public void setNombre(Persona nombre) {
        this.nombre = nombre;
    }

    public Persona getApellidoPateno() {
        return apellidoPateno;
    }

    public void setApellidoPateno(Persona apellidoPateno) {
        this.apellidoPateno = apellidoPateno;
    }

    public Persona getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(Persona apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Empleados getNumeroDeEmpleado() {
        return numeroDeEmpleado;
    }

    public void setNumeroDeEmpleado(Empleados numeroDeEmpleado) {
        this.numeroDeEmpleado = numeroDeEmpleado;
    }

    public Empleados getPuesto() {
        return puesto;
    }

    public void setPuesto(Empleados puesto) {
        this.puesto = puesto;
    }

 
    

}
