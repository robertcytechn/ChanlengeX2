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
        System.out.println("\n\n Bienvenido a la aplicacion de consulta de libros");
        while(opcion != 11){
            System.out.println(
                "\n" +
                "Seleccione una opcion\n" +
                "1.- Buscar libro por título\n" +
                "2.- \n" +
                "11.- Salir\n");
            opcion = funcionesAplication.leerEntero();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el titulo del libro a buscar:");
                    String titulo = funcionesAplication.leerCadena();
                    System.out.println("\n");
                    consultarLibrosPorTitulo(titulo);
                break;
                case 2:
                    
                break;

                default:
                    System.out.println("Opcion no valida, por favor vuelva a intentarlo\n");
                break;
            }
        }
    }


    // consultar todos los libros
    public void consultarTodosLibros(){
        String jsonData = apiConsumo.obtenerDatos(URL_BASE);
        JsonData data = funcionesAplication.convertirDatos(jsonData, JsonData.class);
        System.out.println("Datos obtenidos, se han encontrado " + data.TotalLibros() + " libros");
    }

    // para la opcion 2 - Buscar libro por titulo
    public void consultarLibrosPorTitulo (String titulo){
        System.out.println("Buscando ......\n");
        String json = apiConsumo.obtenerDatos(URL_BASE + "?search=" + titulo.replace(" ", "%20"));
        JsonData dataTitulo = funcionesAplication.convertirDatos(json, JsonData.class);
        if(dataTitulo.Libros().size() == 0){
            System.out.println("No se encontraron libros con el titulo: " + titulo);
        }
        else{
            System.out.println("Se encontraron " + dataTitulo.Libros().size() + " libros con el titulo: " + titulo + "\n");
            dataTitulo.Libros().forEach(libro -> System.out.println(libro.id() + " - " + libro.titulo() +"  --autores: "+ libro.autores().toString() + "\n"));
            System.out.println("\n");
            Integer opcionLibro = 0;
            while(opcionLibro != 10){
                System.out.println(
                    "Que quieres hacer con los libros que encontraste?  [recuerda que debes tener el id del libro]\n" +
                    "1.- Guardar un libro en la base de datos [con su id]\n" +
                    "10.- Regresar\n");
                opcionLibro = funcionesAplication.leerEntero();
                switch (opcionLibro) {
                    case 1:
                        System.out.println("Ingrese el id del libro a consultar:");
                        Integer idLibro = funcionesAplication.leerEntero();
                        System.out.println("\n");
                        
                    break;
                    case 10:
                        System.out.println("Regresando al menu principal\n");
                    break;
                    default:
                        System.out.println("Opcion no valida, por favor vuelva a intentarlo\n");
                    break;
                }
            }
        }

        
    }
}
