package consultas;

import java.net.UnknownHostException;
import java.time.LocalDate;

import dataAccessObject.VentaDao;

public class Consulta4 {
    public static void main(String[] args) throws UnknownHostException{
        LocalDate fechaDesde = LocalDate.of(2024, 1, 1);
        LocalDate fechaHasta = LocalDate.now();
        VentaDao.getInstance();
        String resp = VentaDao.porSucursalYTipo(fechaDesde, fechaHasta);
        System.out.println("\n4.Un reporte con las cantidades de ventas agrupadas por tipo de producto (farmacia perfumería).\n"
        			+ "  Todo esto debe ocurrir entre dos fechas pasadas como parámetros (fecha desde y fecha hasta)");
  
        System.out.println(resp);
    }
}