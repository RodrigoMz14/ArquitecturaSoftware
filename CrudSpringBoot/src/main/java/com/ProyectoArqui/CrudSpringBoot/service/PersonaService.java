package com.ProyectoArqui.CrudSpringBoot.service;

import com.ProyectoArqui.CrudSpringBoot.interfaceService.InterfacePersonaService;
import com.ProyectoArqui.CrudSpringBoot.interfaces.InterfacePersona;
import com.ProyectoArqui.CrudSpringBoot.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase que implementa las operaciones CRUD para el objeto Persona
 */
@Service
public class PersonaService implements InterfacePersonaService {


    @Autowired
    private InterfacePersona data;

    /**
     *  Devuelve una lista de objetos Personas
     * @return lista de personas de la base de datos
     */
    @Override
    public List<Persona> listar() {
        return (List<Persona>)data.findAll();
    }

    /**
     * Devuelve un objeto Persona segun el atributo id
     * @param id id de persona
     * @return objeto persona
     */

    @Override
    public Optional<Persona> listarId(int id) {
        return data.findById(id);
    }

    /**
     * Guardar objeto Persona en base de datos
     * @param p objeto persona a guardar
     * @return retorna 1 si la operacion fue exitosa
     */
    @Override
    public int save(Persona p) {
        int respuesta=0;
        Persona persona = data.save(p);
        if(!persona.equals(null)){
            respuesta=1;
        }
        return respuesta;
    }

    /**
     *  Para eliminar una persona utilizando su Id
     * @param id atributo id de persona a guardar
     */

    @Override
    public void delete(int id) {
        data.deleteById(id);

    }
}
