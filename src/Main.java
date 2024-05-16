import dao.OdontologoEnMemoriaDAO;
import dao.OdontologoH2DAO;
import models.Odontologo;
import service.OdontologoService;

public class Main {
    public static void main(String[] args) {
        // DAO en memoria & DAO en H2
        OdontologoH2DAO odontologoH2DAO = new OdontologoH2DAO();
        OdontologoEnMemoriaDAO odontologoEnMemoriaDAO = new OdontologoEnMemoriaDAO();

        // Cargamos el dao que querramos utilizar
//        OdontologoService odontologoService = new OdontologoService(odontologoEnMemoriaDAO);
        OdontologoService odontologoService = new OdontologoService(odontologoH2DAO);

        // Creamos odontologos
        Odontologo odontologo = new Odontologo(1, "1234", "Franco", "Gonzalez");
        Odontologo odontologo2 = new Odontologo(2, "4321", "Claudia", "Heredia");

        // Guardamos odontologos
        odontologoService.guardarOdontologo(odontologo);
        odontologoService.guardarOdontologo(odontologo2);

        // Listamos odontologos
        System.out.println(odontologoService.listarTodosOdontologos());

    }
}