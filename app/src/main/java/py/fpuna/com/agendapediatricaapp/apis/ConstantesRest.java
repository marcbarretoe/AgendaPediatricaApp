package py.fpuna.com.agendapediatricaapp.apis;

public class ConstantesRest {

    public static final String urlBase = "http://192.168.1.117:8080/AgendaPediatrica/webresources/";


    //poner aqui las urls de los servicios
    public static String API_VALDILAR_USUARIO = urlBase + "agendapediatrica.usuarios/ValidarUsuario";
    public static String API_GET_MOSTRAR_HIJO= urlBase + "agendapediatrica.usuarios/Mostrarhijo";
    public static String API_GET_VACUNAS = urlBase + "agendapediatrica.hijos/VacunasHijo";


}
