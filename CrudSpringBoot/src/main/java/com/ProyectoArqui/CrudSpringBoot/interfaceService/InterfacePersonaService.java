package com.ProyectoArqui.CrudSpringBoot.interfaceService;

import com.ProyectoArqui.CrudSpringBoot.modelo.Persona;

import java.util.Optional;
import java.util.List;

/**
 * Interface que define las operaciones CRUD para objeto Persona
 */
public interface InterfacePersonaService {

    public List<Persona>listar();

    Optional<Persona> listarId(int id);

    public int save(Persona p);
    public void delete(int id);

}
