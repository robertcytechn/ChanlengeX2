package Cytechnologies.Model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record JsonData(
    @JsonAlias("count") int TotalLibros,
    @JsonAlias("results") List<LibrosData> Libros
) {
    
}
