package controlador;

import domain.Empleados;
import ejb.EmpleadosFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class indexController implements Serializable {
    @EJB
    private EmpleadosFacadeLocal EJBEmpleadosFacadeLocal;
    private Empleados e;
    
    @PostConstruct
    public void init (){
        System.out.println("ENTRO A INIT() -->");
       // this.iniciarSesion();
        e=new Empleados();
    }

    public Empleados getUsuario() {
        return e;
    }

    public void setUsuario(Empleados usuario) {
        this.e = usuario;
    }
    
    public String iniciarSesion(){
         System.out.println("ENTRO A iniciarSesion -->");
         String redireccion = "";
         Empleados usuario = new Empleados();
        //try {
        
            //usuario.setPassword("victor");
            //usuario.setUsuario("victorR");
            System.out.println("ENTRO A iniciarSesion USUARIO -->" + e.getUsuario());
            System.out.println("ENTRO A iniciarSesion CONTRASEÑA -->" + e.getPassword());

            
            usuario= EJBEmpleadosFacadeLocal.iniciarSesion(e);
            if (usuario != null) {
                System.out.println("!= null");

             redireccion = "principal";
            } else {
                System.out.println("= null");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Credenciales Incorrectas"));
            }
        //} catch(Exception ex){
           //
        //}
        return redireccion;
    }
}
