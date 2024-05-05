package Cytechnologies.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutoresData(
    @JsonAlias("name") String nombre,
    @JsonAlias("birth_year") String anioNacimiento,
    @JsonAlias("death_year") String anioMuerte
) {
    
}
