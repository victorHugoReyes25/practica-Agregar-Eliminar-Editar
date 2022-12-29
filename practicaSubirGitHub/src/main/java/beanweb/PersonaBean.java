package beanweb;

import domain.Empleados;
import domain.Persona;
import ejb.EmpleadosFacadeLocal;
import ejb.PersonaFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.*;
import org.primefaces.event.RowEditEvent;

@Named("personaBean")
@RequestScoped

public class PersonaBean {

    Logger log = LogManager.getRootLogger();
    @Inject
    private PersonaFacadeLocal personaFacadeLocal;
    private EmpleadosFacadeLocal empleadoFac;
    private Persona personaseleccionada;
    List<Empleados> empleado;
    List<Persona> personas;
    private Persona personaSeleccionada;
   
    
  

    public PersonaBean() {
        log.debug("Iniciando el objeto PersonaBean");
    }
    

    @PostConstruct
    public void inicializar() {
       this.personas=personaFacadeLocal.findAll();
        System.out.println("beanweb.PersonaBean.inicializar()");
         this.personaseleccionada = new Persona();
         this.personaseleccionada.setEmpleados(new Empleados());
    }

    public void editListener(RowEditEvent event) {
        System.out.println("ENTROOO -- editListener");
        System.out.println("event-->" + event);
        System.out.println("event.getObject()-->" + event.getObject());
        Persona persona = (Persona) event.getObject();  
        personaFacadeLocal.updatePersona(persona);

    }

    public Persona getPersonaseleccionada() {
        return personaseleccionada;
    }
    
    public void setPersonaseleccionada(Persona personaseleccionada) {
        this.personaseleccionada = personaseleccionada;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> persona) {
        this.personas = persona;
    }
    
    
    public void eliminarPersona (){
        System.out.println("entro a elim->");
         this.personaFacadeLocal.deletePersona(this.personaseleccionada);
         this.personas.remove(this.personaSeleccionada);
         this.personaSeleccionada=null;
    
    }

    
    public void agregarPerosna(){
    this.personaFacadeLocal.insertPersona(personaseleccionada);
    this.personas.add(personaseleccionada);
    this.personaSeleccionada=null;

    
    }
    
    public void reiniciarPersonaSeleccionada(){
     this.personaSeleccionada = new Persona();
     
    }
    
 
     

}
