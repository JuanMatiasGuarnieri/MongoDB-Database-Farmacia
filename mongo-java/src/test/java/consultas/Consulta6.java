package consultas;

import java.net.UnknownHostException;
import java.time.LocalDate;

import dataAccessObject.VentaDao;

public class Consulta6 {
    public static void main(String[] args) throws UnknownHostException{
        LocalDate fechaDesde = LocalDate.of(2024, 1, 1);
        LocalDate fechaHasta = LocalDate.now();
        VentaDao.getInstance();
        String resp = VentaDao.rankingProductoPorCantidad(fechaDesde, fechaHasta);
        System.out.println("\n6.Ranking de cantidad de productos vendidos, agrupado por producto y por sucursal.");
        System.out.println(resp);
    }
}