package consultas;

import java.time.LocalDate;

import clasesPojos.Sucursal;
import dataAccessObject.VentaDao;

public class Consulta5 {
     public static void main(String[] args) {
          LocalDate fechaDesde = LocalDate.of(2024, 1, 1);
          LocalDate fechaHasta = LocalDate.now();
          try {
               VentaDao.getInstance();
               // TODA LA CADENA
               String resp = VentaDao.rankingDeProductosPorMonto(fechaDesde, fechaHasta);
               
              
               System.out.println("\n5.Ranking de monto vendido, agrupado por producto y por sucursal.");

               
               System.out.println("\nRANKING DE PRODUCTOS POR MONTO EN TODA LA CADENA");
               System.out.println(resp);
               Sucursal sucursal1 = new Sucursal();  
               sucursal1.setCodigo(1);
               String resp2 = VentaDao.rankingDeProductosPorMonto(fechaDesde, fechaHasta, sucursal1);
               System.out.println("\nRANKING DE PRODUCTOS POR MONTO EN SUCURSAL 1");
               System.out.println(resp2);
               
               Sucursal sucursal2 = new Sucursal();  
               sucursal2.setCodigo(2);
               String resp3 = VentaDao.rankingDeProductosPorMonto(fechaDesde, fechaHasta, sucursal2);
               System.out.println("\nRANKING DE PRODUCTOS POR MONTO EN SUCURSAL 2");
               System.out.println(resp3);
               
               Sucursal sucursal3 = new Sucursal();  
               sucursal3.setCodigo(3);
               String resp4 = VentaDao.rankingDeProductosPorMonto(fechaDesde, fechaHasta, sucursal3);
               System.out.println("\nRANKING DE PRODUCTOS POR MONTO EN SUCURSAL 3");
               System.out.println(resp4);
               
          } catch (Exception e) {
               e.printStackTrace();
          }
     }
}