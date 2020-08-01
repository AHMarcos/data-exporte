/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PersonaDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Persona;

/**
 *
 * @author marqu
 */
public class PersonaC implements Serializable {

    private Persona persona;
    private PersonaDao dao;
    private List<Persona> listadoper;
    private List<Persona> listadoper2;

    
    public PersonaC(){
        persona = new Persona();
        dao = new PersonaDao();
        listadoper = new ArrayList();
    }
    
     @PostConstruct
    public void Iniciar(){
        try {
            listar();
        } catch (Exception e) {
        }
    }
    
    public void registrar() throws Exception {    
        try {
            dao.registrar(this.persona);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro","Completo..."));
        } catch (Exception e) {
            throw e;
        }
    
    }
    
    public void modificar() throws Exception {    
        try {
            dao.modificar(persona);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizado","Completo..."));
            limpiar();
        } catch (Exception e) {
            throw  e;
        }
    
    }
    
    public void eliminar(Persona persona) throws Exception{
        try {
            dao.eliminar(persona);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado","Completo..."));
            limpiar();
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void listar() throws Exception{
        try {
            listadoper = dao.ListarPersona();
        } catch (Exception e) {
            throw e;
        }
    
    }
    
    public void limpiar() throws Exception{
        try {
            this.persona.setIDPER("");
            this.persona.setNOMPER("");
            this.persona.setAPEPER("");
            this.persona.setDNIPER("");
        } catch (Exception e) {
            throw e;
        }
    
    }     
    
    
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public PersonaDao getDao() {
        return dao;
    }

    public void setDao(PersonaDao dao) {
        this.dao = dao;
    }

    public List<Persona> getListadoper() {
        return listadoper;
    }

    public void setListadoper(List<Persona> listadoper) {
        this.listadoper = listadoper;
    }

    public List<Persona> getListadoper2() {
        return listadoper2;
    }

    public void setListadoper2(List<Persona> listadoper2) {
        this.listadoper2 = listadoper2;
    }

}
