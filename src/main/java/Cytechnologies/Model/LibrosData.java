package Cytechnologies.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibrosData(
    @JsonAlias("title") String titulo,
    @JsonAlias("id") Integer id,
    @JsonAlias("authors") List<AutoresData> autores,
    @JsonAlias("subjects") List<String> temas,
    @JsonAlias("bookshelves") List<String> estanterias,
    @JsonAlias("languages") List<String> idiomas,
    @JsonAlias("download_count") Integer descargas
) {
}
