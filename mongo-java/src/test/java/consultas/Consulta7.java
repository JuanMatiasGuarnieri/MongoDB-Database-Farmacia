package consultas;

import java.time.LocalDate;

import clasesPojos.Sucursal;
import dataAccessObject.VentaDao;

public class Consulta7 {
     public static void main(String[] args) {
          LocalDate fechaDesde = LocalDate.of(2024, 1, 1);
          LocalDate fechaHasta = LocalDate.now();
          try {
               VentaDao.getInstance();
               // TODA LA CADENA
               String resp = VentaDao.rankingDeClientesPorMonto(fechaDesde, fechaHasta);
               
               System.out.println("\n7.Ranking compras agrupadas por cliente para el total de la cadena.\n"
               		+ "  (quiero ver los clientes que mas compraron en toda la cadena, pudieron comprar en mas de una sucursal).");
               System.out.println("\nRANKING DE CLIENTES POR MONTO EN TODA LA CADENA");
               System.out.println(resp);
               Sucursal sucursal1 = new Sucursal();  
               sucursal1.setCodigo(1);
               String resp2 = VentaDao.rankingDeClientesPorMonto(fechaDesde, fechaHasta, sucursal1);
               System.out.println("\nRANKING DE CLIENTES POR MONTO EN SUCURSAL NUMERO 1");
               System.out.println(resp2);
               
               Sucursal sucursal2 = new Sucursal();  
               sucursal2.setCodigo(2);
               String resp3 = VentaDao.rankingDeClientesPorMonto(fechaDesde, fechaHasta, sucursal2);
               System.out.println("\nRANKING DE CLIENTES POR MONTO EN SUCURSAL NUMERO 2");
               System.out.println(resp3);
               
               Sucursal sucursal3 = new Sucursal();  
               sucursal3.setCodigo(3);
               String resp4 = VentaDao.rankingDeClientesPorMonto(fechaDesde, fechaHasta, sucursal3);
               System.out.println("\nRANKING DE CLIENTES POR MONTO EN SUCURSAL NUMERO 3");
               System.out.println(resp4);
          } catch (Exception e) {
               e.printStackTrace();
          }
     }
}