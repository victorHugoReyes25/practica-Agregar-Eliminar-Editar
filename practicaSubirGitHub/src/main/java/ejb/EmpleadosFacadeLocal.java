/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejb;

import domain.Empleados;
import java.util.List;
import javax.ejb.Local;
import union.PersonaE;

/**
 *
 * @author aspit
 */
@Local
public interface EmpleadosFacadeLocal {

    void create(Empleados empleados);

    void edit(Empleados empleados);

    void remove(Empleados empleados);

    Empleados find(Object id);

    List<Empleados> findAll();

    List<Empleados> findRange(int[] range);

    int count();
    
    Empleados iniciarSesion(Empleados e);
    public void updatePersona(PersonaE persona);
}
