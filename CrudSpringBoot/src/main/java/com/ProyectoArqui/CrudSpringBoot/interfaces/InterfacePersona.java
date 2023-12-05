package com.ProyectoArqui.CrudSpringBoot.interfaces;

import com.ProyectoArqui.CrudSpringBoot.modelo.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InterfacePersona extends CrudRepository <Persona, Integer>{

}
