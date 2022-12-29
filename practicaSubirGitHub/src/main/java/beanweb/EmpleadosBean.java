package beanweb;

import domain.Empleados;
import ejb.EmpleadosFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.*;
import org.primefaces.event.RowEditEvent;

@Named("EmpleadosBean")
@RequestScoped
public class EmpleadosBean {
   Logger log= LogManager.getRootLogger();
   @Inject
   private EmpleadosFacadeLocal empleadoFacadeLocal;
   private Empleados empleadoSeleccionado;
   
   List<Empleados> empleado;
   //private Empleados empleadosSeleccionado;
   
   
   public EmpleadosBean(){
       log.debug("Iniciando el objeto Empleado");
   }
   @PostConstruct
   public void inicializar(){
   this.empleado=empleadoFacadeLocal.findAll();
   this.empleadoSeleccionado =new Empleados();
   }
   
   public void editListener(RowEditEvent event){
   Empleados empleado=(Empleados) event.getObject();
   empleadoFacadeLocal.edit(empleado);
   }
   
   public Empleados getEmpleadoseleccionado(){
       return empleadoSeleccionado;
   }
   
   public void setEmpleadoseleccionado(Empleados empleadoSeleccionado){
       this.empleadoSeleccionado=empleadoSeleccionado;
   }
   public List<Empleados> getEmpleados(){
   return empleado;
   }
   
   public void setEmpleados(List<Empleados> empleado){
   this.empleado=empleado;
   }
   

   
   
}
