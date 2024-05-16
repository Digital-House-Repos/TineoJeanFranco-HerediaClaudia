import dao.OdontologoEnMemoriaDAO;
import dao.OdontologoH2DAO;
import models.Odontologo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static final Logger logger = Logger.getLogger(OdontologoEnMemoriaDAO.class);

    @Test
    public void testOdontologosEnMemoria() {
        logger.info("Haciendo test de odontologos en memoria");

        String resultado = "[Odontologo{id=1, numeroMatricula='1234', nombre='Franco', apellido='Tineo'}]";

        OdontologoEnMemoriaDAO odontologoEnMemoriaDAO = new OdontologoEnMemoriaDAO();
        OdontologoService odontologoService = new OdontologoService(odontologoEnMemoriaDAO);

        Odontologo odontologo = new Odontologo(1, "1234", "Franco", "Tineo");
        odontologoService.guardarOdontologo(odontologo);

        assertEquals(resultado, odontologoService.listarTodosOdontologos().toString());
    }

    @Test
    public void testOdontologosEnH2() {
        logger.info("Haciendo test de odontologos en H2");

        OdontologoH2DAO odontologoH2DAO = new OdontologoH2DAO();
        OdontologoService odontologoService = new OdontologoService(odontologoH2DAO);

        Odontologo odontologo = new Odontologo(2, "4321", "Claudia", "Heredia");
        String mensaje = odontologoService.guardarOdontologo(odontologo);
        assertEquals("Odontologo guardado en H2", mensaje);
    }
}