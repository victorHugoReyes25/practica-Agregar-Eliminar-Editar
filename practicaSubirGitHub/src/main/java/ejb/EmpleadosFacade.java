
package ejb;

import domain.Empleados;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import union.PersonaE;

/**
 *
 * @author aspit
 */
@Stateless
public class EmpleadosFacade extends AbstractFacade<Empleados> implements EmpleadosFacadeLocal {

    @PersistenceContext(unitName = "practicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadosFacade() {
        super(Empleados.class);
    }
    @Override
    public Empleados iniciarSesion(Empleados e){
        System.out.println("----ejb.EmpleadosFacade.iniciarSesion()---");
        System.out.println("ejb.EmpleadosFacade.iniciarSesion() USUARIO --> " + e.getUsuario());
        System.out.println("ejb.EmpleadosFacade.iniciarSesion() CONTRASEÑA --> " + e.getPassword());

        Empleados usuario=null;
        String consulta;
        
      try{
          System.out.println("----ejb.EmpleadosFacade.iniciarSesion()--- TRY");
          consulta="FROM Empleados e WHERE e.usuario=?1 AND e.password=?2";
          Query query=em.createQuery(consulta);
          query.setParameter(1, e.getUsuario());
          query.setParameter(2, e.getPassword());
          
          List<Empleados>lista=query.getResultList();
          
          System.out.println("lista.isEmpty()" + lista.isEmpty());

          if(!lista.isEmpty()){
              usuario=lista.get(0);
          }
      }catch (Exception ex){
 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Credenciales Incorrectas"));
      }
      return usuario;
    }

    @Override
    public void updatePersona(PersonaE persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
