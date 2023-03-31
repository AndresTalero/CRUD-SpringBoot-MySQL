package com.andres.crud.interfaceService;

import java.util.List;
import java.util.Optional;

import com.andres.crud.modelo.Persona;

public interface IPersonaServicio {
    public List<Persona>listar();
    public Optional<Persona>listarId(int id);
    public int save(Persona P);
    public void delete(int id);
}