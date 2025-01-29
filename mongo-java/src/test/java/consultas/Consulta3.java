package consultas;

import java.time.LocalDate;

import clasesPojos.Sucursal;
import dataAccessObject.VentaDao;

public class Consulta3 {
     public static void main(String[] args) {
          LocalDate fechaDesde = LocalDate.of(2024, 1, 1);
          LocalDate fechaHasta = LocalDate.now();
          try {
               VentaDao.getInstance();
               // TODA LA CADENA DE FARMACIAS
               String resp = VentaDao.detallesYTotalesDeVentasPorMedioDePago(fechaDesde, fechaHasta);
               
               System.out.println("\n3. Un reporte con dos resultados, por un lado el total de la cobranza de toda la cadena\n"
               				+ "   completa (todas las sucursales) y por otro lado la cobranza agrupada por sucursales. Todo esto\n"
               				+ "   debe ocurrir entre dos fechas pasadas como parámetros (fecha desde y fecha hasta).");
               System.out.println("\nTotales y detalles de ventas,para toda la cadena por medios de pago.");
               System.out.println(resp);
               Sucursal sucursal1 = new Sucursal();  
               sucursal1.setCodigo(1);
               String resp2 = VentaDao.detallesYTotalesDeVentasPorMedioDePago(fechaDesde, fechaHasta, sucursal1);
               System.out.println("\nTotales y detalles de ventas, por medio de pago, para la sucursal numero 1");
               System.out.println(resp2);
               
               Sucursal sucursal2 = new Sucursal();  
               sucursal2.setCodigo(2);
               String resp3 = VentaDao.detallesYTotalesDeVentasPorMedioDePago(fechaDesde, fechaHasta, sucursal2);
               System.out.println("\nTotales y detalles de ventas, por medio de pago, para la sucursal numero 2");
               System.out.println(resp3);
               
               Sucursal sucursal3 = new Sucursal();  
               sucursal3.setCodigo(3);
               String resp4 = VentaDao.detallesYTotalesDeVentasPorMedioDePago(fechaDesde, fechaHasta, sucursal3);
               System.out.println("\nTotales y detalles de ventas, por medio de pago, para la sucursal numero 3");
               System.out.println(resp4);
          } catch (Exception e) {
               e.printStackTrace();
          }
     }
}