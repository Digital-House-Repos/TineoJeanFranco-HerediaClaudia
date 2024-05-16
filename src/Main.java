import dao.OdontologoEnMemoriaDAO;
import dao.OdontologoH2DAO;
import models.Odontologo;
import service.OdontologoService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        OdontologoH2DAO odontologoH2DAO = new OdontologoH2DAO();
        OdontologoEnMemoriaDAO odontologoEnMemoriaDAO = new OdontologoEnMemoriaDAO();

        OdontologoService odontologoService = new OdontologoService(odontologoH2DAO);
        OdontologoService odontologoService2 = new OdontologoService(odontologoEnMemoriaDAO);

        Odontologo odontologo = new Odontologo(0, "0000", "Franco", "Gonzalez");
        Odontologo odontologo2 = new Odontologo(0, "0000", "Franco", "Gonzalez");
        odontologoService2.guardarOdontologo(odontologo);
        odontologoService2.guardarOdontologo(odontologo2);
        System.out.println(odontologoService2.listarTodosOdontologos());

    }
}