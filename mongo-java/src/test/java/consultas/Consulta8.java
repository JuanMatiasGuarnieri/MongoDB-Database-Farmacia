package consultas;

import java.net.UnknownHostException;
import java.time.LocalDate;

import dataAccessObject.VentaDao;

public class Consulta8 {
    public static void main(String[] args) throws UnknownHostException{
        LocalDate fechaDesde = LocalDate.of(2024, 1, 1);
        LocalDate fechaHasta = LocalDate.now();
        VentaDao.getInstance();
        String resp = VentaDao.rankingClientePorCantidad(fechaDesde, fechaHasta);
        System.out.println("\n8.Ranking compras agrupadas por cliente y por sucursal\n "
        		+ "(quiero ver como compraron los clientes intra-sucursal). ");
        System.out.println(resp);
    }
}