package consultas;

import java.time.LocalDate;

import clasesPojos.Sucursal;
import dataAccessObject.VentaDao;

public class Consulta1 {
     public static void main(String[] args) {
          LocalDate fechaDesde = LocalDate.of(2024, 1, 1);
          LocalDate fechaHasta = LocalDate.now();
          try {
               VentaDao.getInstance();
               // TODAS LAS CADENAS
               String resp1 = VentaDao.detallesYTotalesDeVentas(fechaDesde, fechaHasta);
               System.out.println("\n1. Un reporte con dos resultados, por un lado el total de la cantidad de ventas de toda la\n"
                  		+ "  cadena completa (todas las sucursales) y por otro lado las cantidades de ventas agrupadas por\n"
                  		+ "  sucursales. Todo esto debe ocurrir entre dos fechas pasadas como parámetros (fecha desde y\n"
                  		+ "  fecha hasta).");
                    
               System.out.println("\nTotales y detalles de ventas para toda la cadena");
               System.out.println(resp1);
               
               Sucursal sucursal1 = new Sucursal();  
               sucursal1.setCodigo(1);
               String resp2 = VentaDao.detallesYTotalesDeVentas(fechaDesde, fechaHasta, sucursal1);
               System.out.println("\nTotales y detalles de ventas para la sucursal 1");
               System.out.println(resp2);
               
               Sucursal sucursal2 = new Sucursal();  
               sucursal2.setCodigo(2);
               String resp3 = VentaDao.detallesYTotalesDeVentas(fechaDesde, fechaHasta, sucursal2);
               System.out.println("\nTotales y detalles de ventas para la sucursal 2");
               System.out.println(resp3);
               
               Sucursal sucursal3 = new Sucursal();  
               sucursal3.setCodigo(3);
               String resp4 = VentaDao.detallesYTotalesDeVentas(fechaDesde, fechaHasta, sucursal3);
               System.out.println("\nTotales y detalles de ventas para la sucursal 3");
               System.out.println(resp4);
               
          } catch (Exception e) {
               e.printStackTrace();
          }
     }
}