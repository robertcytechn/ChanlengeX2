package Cytechnologies.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FuncionesAplication{
    private ObjectMapper mapper = new ObjectMapper();
    private BufferedReader leerConsola = new BufferedReader(new InputStreamReader(System.in));

    public <T> T convertirDatos(String datos, Class<T> tipo) {
        try {
            return mapper.readValue(datos, tipo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al convertir los datos a tipo clase", e);
        }
    }
    
    public Integer leerEntero() {
        //leemos un nuemero entero
        try {
            return Integer.parseInt(leerConsola.readLine());
        } catch (Exception e) {
            System.out.println("Parece ser que no introdujo un numero entero, por favor vuelva a intentarlo");
            return 0;
        }
    }

    //constructor
    public FuncionesAplication() {
    }
    
}
