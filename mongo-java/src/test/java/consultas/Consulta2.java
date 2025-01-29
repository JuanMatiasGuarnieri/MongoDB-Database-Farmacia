package consultas;

import java.net.UnknownHostException;
import java.time.LocalDate;

import dataAccessObject.VentaDao;

public class Consulta2 {
    public static void main(String[] args) throws UnknownHostException{
        LocalDate fechaDesde = LocalDate.of(2024, 1, 1);
        LocalDate fechaHasta = LocalDate.now();
        VentaDao.getInstance();
        String resp = VentaDao.porSucursalYObraSocial(fechaDesde, fechaHasta);
        System.out.println("\n2. Un reporte con las cantidades de ventas agrupadas por obras sociales y además considerar\n"
        				+ "   los privados (sin obra social) como un grupo mas. Todo esto debe ocurrir entre dos fechas\n"
        				+ "   pasadas como parámetros (fecha desde y fecha hasta).");
 
        System.out.println(resp);
    }
}