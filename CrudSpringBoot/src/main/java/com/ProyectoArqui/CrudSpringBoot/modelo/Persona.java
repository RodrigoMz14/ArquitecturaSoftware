package com.ProyectoArqui.CrudSpringBoot.modelo;

import jakarta.persistence.*;

/**
 *  Modelo para el objeto Persona.
 */
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se hace referencia que id es el identificador de la tabla "persona"
    private int id;
    private String nombre;
    private String telefono;


    public Persona() {

    }
    public Persona(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
