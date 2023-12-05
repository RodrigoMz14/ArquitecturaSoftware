package com.ProyectoArqui.CrudSpringBoot.service;

import com.ProyectoArqui.CrudSpringBoot.interfaceService.InterfacePersonaService;
import com.ProyectoArqui.CrudSpringBoot.interfaces.InterfacePersona;
import com.ProyectoArqui.CrudSpringBoot.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements InterfacePersonaService {


    @Autowired
    private InterfacePersona data;


    @Override
    public List<Persona> listar() {
        return (List<Persona>)data.findAll();
    }

    @Override
    public Optional<Persona> listarId(int id) {


        return data.findById(id);
    }

    @Override
    public int save(Persona p) {
        int respuesta=0;
        Persona persona = data.save(p);
        if(!persona.equals(null)){
            respuesta=1;
        }
        return respuesta;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);

    }
}
