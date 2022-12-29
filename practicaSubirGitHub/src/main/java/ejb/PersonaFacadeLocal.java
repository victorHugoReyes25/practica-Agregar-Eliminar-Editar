/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejb;

import domain.Persona;
import java.util.List;
import javax.ejb.Local;
import union.PersonaE;

/**
 *
 * @author aspit
 */
@Local


public interface PersonaFacadeLocal {

    public void create(Persona persona);

    public void edit(Persona persona);

    public void remove(Persona persona);

    public Persona find(Object id);

   public List<Persona> findAll();
     
    public List<PersonaE> findAllPE();

    public List<Persona> findRange(int[] range);

    public int count();
    public void insertPersona(Persona persona);
    
    public void updatePersona(Persona persona);
    
    public void deletePersona(Persona persona);

    public void updatePersona(PersonaE persona);
    
    
}
