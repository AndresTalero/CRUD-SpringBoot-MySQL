package com.andres.crud.servicio;

import com.andres.crud.interfaceService.IPersonaServicio;
import com.andres.crud.interfaces.IPersona;
import com.andres.crud.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServicio implements IPersonaServicio {

    @Autowired
    private IPersona data;

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
        int respuesta = 0;
        Persona persona=data.save(p);
        if(!persona.equals(null)){
            respuesta = 1;
        }
        return respuesta;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
    //En la página https://sweetalert.js.org/guides/ encontramos
    //métodos para programar, en este caso un método de confirmación
    //para eliminación, copiamos el CDN.
    //También copiamos el CDN de JQuery de la página https://releases.jquery.com/
    //en la sección uncompressed.
    //Ambos los copiamos en el archivo index.html

}
