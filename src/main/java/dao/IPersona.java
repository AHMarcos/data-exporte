/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Persona;

/**
 *
 * @author marqu
 */
public interface IPersona {
    
    void registrar (Persona persona) throws Exception;
    void modificar (Persona persona) throws Exception;
    void eliminar  (Persona persona) throws Exception;
    
      List<Persona> ListarPersona() throws Exception;
    
}
