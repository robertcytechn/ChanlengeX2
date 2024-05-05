package Cytechnologies.Principal;

import Cytechnologies.Service.ApiConsumo;
import Cytechnologies.Service.FuncionesAplication;

public class Principal {

    private String URL_BASE = "";

    //Contructor
    public Principal(String URL) {
        this.URL_BASE = URL;
    }
    private ApiConsumo apiConsumo = new ApiConsumo();
    private FuncionesAplication funcionesAplication = new FuncionesAplication();

    public void muestraMenu(){
        System.out.println("Reciviendo datos de la API ...... Espere......");
        String datos = apiConsumo.obtenerDatos(URL_BASE);
        System.out.println("Datos recibidos");
    }
}
