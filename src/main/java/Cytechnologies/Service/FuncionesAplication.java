package Cytechnologies.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FuncionesAplication{
    private ObjectMapper mapper = new ObjectMapper();

    public <T> T convertirDatos(String datos, Class<T> tipo) {
        try {
            return mapper.readValue(datos, tipo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al convertir los datos a tipo clase", e);
        }
    }

    //constructor
    public FuncionesAplication() {
    }
    
}
