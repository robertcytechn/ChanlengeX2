package Cytechnologies.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements InterfaceConvertir{
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String datos, Class<T> tipo) {
        try {
            return mapper.readValue(datos, tipo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al convertir los datos", e);
        }
    }
    
}
