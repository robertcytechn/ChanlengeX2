package Cytechnologies.Principal;

import Cytechnologies.Model.JsonData;
import Cytechnologies.Service.ApiConsumo;
import Cytechnologies.Service.FuncionesAplication;

public class Principal {

    private ApiConsumo apiConsumo = new ApiConsumo();
    private FuncionesAplication funcionesAplication = new FuncionesAplication();
    public Integer opcion = 0;

    private String URL_BASE = "";

    //Contructor
    public Principal(String URL) {
        this.URL_BASE = URL;
        muestraMenu();
    }
    

    public void muestraMenu(){
        while(opcion != 11){
            System.out.println(
                "Bienvenido a la aplicacion de consulta de libros\n" +
                "Seleccione una opcion\n" +
                "1.- Consultar todos los libros\n" +
                "2.- Consultar libros por autor\n" +
                "3.- Consultar libros por titulo\n" +
                "4.- Consultar libros por idioma\n" +
                "5.- Consultar libros por fecha de publicacion\n" +
                "6.- Consultar libros de autores vivos\n" +
                "7.- Consultar libros de autores muertos\n" +
                "11.- Salir\n");
            opcion = funcionesAplication.leerEntero();
        }
    }
}
