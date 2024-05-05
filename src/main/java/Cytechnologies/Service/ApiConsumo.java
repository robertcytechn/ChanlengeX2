package Cytechnologies.Service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsumo {
   private final HttpClient client = HttpClient.newHttpClient();

    public String obtenerDatos(String url) {
        // Crea una nueva solicitud HTTP a partir de la URL proporcionada
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
    
        // Declara una variable para almacenar la respuesta HTTP
        HttpResponse<String> response;
    
        try {
            // Envía la solicitud HTTP y obtiene la respuesta
            // HttpResponse.BodyHandlers.ofString() se utiliza para convertir el cuerpo de la respuesta en una cadena
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            // Lanza una excepción si hay un error de entrada/salida durante el envío de la solicitud
            throw new UncheckedIOException("Error al realizar la petición HTTP", e);
        } catch (InterruptedException e) {
            // Si la solicitud es interrumpida, interrumpe el hilo actual y lanza una excepción
            Thread.currentThread().interrupt();
            throw new RuntimeException("La petición HTTP fue interrumpida", e);
        }
    
        // Comprueba si el código de estado de la respuesta HTTP es 200 (OK)
        // Si no es así, lanza una excepción
        if (response.statusCode() != 200) {
            throw new RuntimeException("Error en la respuesta del servidor: " + response.statusCode());
        }
    
        // Devuelve el cuerpo de la respuesta HTTP como una cadena
        return response.body();
    }
}
