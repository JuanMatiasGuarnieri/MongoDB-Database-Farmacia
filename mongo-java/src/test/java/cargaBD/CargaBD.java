package cargaBD;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import clasesPojos.Cliente;
import clasesPojos.Domicilio;
import clasesPojos.Empleado;
import clasesPojos.FormaDePago;
import clasesPojos.Item;
import clasesPojos.Laboratorio;
import clasesPojos.ObraSocial;
import clasesPojos.Producto;
import clasesPojos.Sucursal;
import clasesPojos.TipoDeProducto;
import clasesPojos.Venta;
import dataAccessObject.VentaDao;

public class CargaBD {


	public static int numeroAleatorio(int desde, int hasta) {
		return (int) Math.floor(Math.random() * hasta + desde);
	}


	public static LocalDate generarFechaAleatoria(LocalDate desde, LocalDate hasta) {
		long minDay = desde.toEpochDay();
		long maxDay = hasta.toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
		return LocalDate.ofEpochDay(randomDay);
	}


	public static List<Venta> generarVentas(Sucursal sucursal, Cliente[] clientes, FormaDePago[] formasDePago,
			Producto[] productos, LocalDate desde, LocalDate hasta, int cantidadDeVentas) {
		List<Venta> ventas = new ArrayList<Venta>();
		for (int i = 0; i < cantidadDeVentas; i++) {
			Empleado atencion = sucursal.getEmpleados().get(numeroAleatorio(0, sucursal.getEmpleados().size()));
			Empleado cobro = sucursal.getEmpleados().get(numeroAleatorio(0, sucursal.getEmpleados().size()));
			Cliente cliente = clientes[numeroAleatorio(0, clientes.length)];
			FormaDePago formaDePago = formasDePago[numeroAleatorio(0, formasDePago.length)];
			LocalDate fecha = generarFechaAleatoria(desde, hasta);
			List<Item> items = new ArrayList<Item>();
			
			// GENERA DESDE 1 A 3 ITEMS POR VENTAS
			
			for (int j = 0; j < numeroAleatorio(1, 4); j++) {
				Producto producto = productos[numeroAleatorio(0, productos.length)];
				int cantidadDeProducto = numeroAleatorio(1, 4); 
				
				//CARGAM PRODUCTO ALEATORIAMENTE
				items.add(new Item(producto, cantidadDeProducto));
			}
			String nroDeTicket = String.valueOf(sucursal.getCodigo()) + "-" + String.valueOf(i);
			ventas.add(new Venta(nroDeTicket, fecha, formaDePago, atencion, cobro, sucursal, cliente, items));
		}
		return ventas;
	}

		// SE CARGA LA BASE DE DATOS
	
	public static void main(String[] args) {
		
		//SE CARGA LA OBRA SOCIAL A LA BASE DE DATOS		
		ObraSocial galeno = new ObraSocial("30598615825", "Galeno");
		ObraSocial sancor = new ObraSocial("33648104389", "Sancor Salud");
		ObraSocial medicus = new ObraSocial("30707746463", "Medicus");
		ObraSocial privado = new ObraSocial("0", "PRIVADO");
		
		
		// SE CARGAN LOS CLIENTES EN LA BASE DE DATOS
		Cliente c1 = new Cliente(38839452, "Jorge", "Perez", 142,
				new Domicilio("Av Corrientes ", 521, "CABA", "Buenos Aires"), galeno);
		
		Cliente c2 = new Cliente(38168908, "Jose", "Lopez", 143,
				new Domicilio("Maipu ", 128, "CABA", "Buenos Aires"), galeno);
		
		Cliente c3 = new Cliente(40770351, "Martin", "Gomez", 144,
				new Domicilio("Larroque ", 1150, "CABA", "Buenos Aires"), privado);
		
		Cliente c4 = new Cliente(41785928, "Josefina", "Danet", 145, 
				new Domicilio("Mitre", 501, "CABA", "CABA"),medicus);
		
		Cliente c5 = new Cliente(39489024, "Samanta", "Gomez", 2,
				new Domicilio("Av de Mayo ", 528, "CABA", "CABA"), medicus);
		
		Cliente c6 = new Cliente(39418005, "Geremias", "Blanco", 3,
				new Domicilio("Pje. Garcia", 212, "CABA", "CABA"), privado);
		
		Cliente c7 = new Cliente(43199443, "Angelina", "Lemos", 4,
				new Domicilio("Pje. Aristobulo Del valle", 216, "T.Suarez", "Buenos Aires"), galeno);
		
		Cliente c8 = new Cliente(42907294, "Alex", "Segovia", 6,
				new Domicilio("Pje. Valle", 1001, "Lanus", "Buenos Aires"), medicus);
		
		Cliente c9 = new Cliente(43311744, "Mirtha", "Cano", 7,
				new Domicilio("Itaty", 5043, "Lomas de Zamora", "Buenos Aires"), galeno);
		
		Cliente c10 = new Cliente(95978310, "Fidel", "Suares", 8,
				new Domicilio("30 de Semtiembre", 110, "Lavallol", "Buenos Aires"), sancor);
		
		// EMPLEADOS  SE CREAN 3 EMPLEADOS PARA CADA SUCURSAL
		
		Empleado e1 = new Empleado(39349645, "Lucas", "Gimenez", 499,
				new Domicilio("Chacabuco", 112, "CABA", "Buenos Aires"), sancor, "10200000011", false);
		Empleado e2 = new Empleado(41954891, "Nicolas", "Lopez", 200,
				new Domicilio("Alem", 1122, "Monte Grande", "Buenos Aires"), sancor, "10200000021", false);
		Empleado e3 = new Empleado(40714547, "Constanza", "Torres", 123,
				new Domicilio("Calle 113", 11, "Quilmes", "Buenos Aires"), sancor, "10200000031", true);//ENCARGADO
		
		
		Empleado e4 = new Empleado(95978310, "Martin", "Vazques", 111,
				new Domicilio("Calle 43", 10, "Quilmes", "Buenos Aires"), sancor, "10200000041", false);
		Empleado e5 = new Empleado(42472336, "Emilia", "Atias", 99,
				new Domicilio("Calle 198", 33, "La Plata", "Buenos Aires"), sancor, "10200000051", false);
		Empleado e6 = new Empleado(41638632, "Eugenia", "Ramos", 88, 
				new Domicilio("Libertad", 12, "CABA", "CABA"),sancor, "10200000061", true);//ENCARGADO
		
		
		Empleado e7 = new Empleado(41638632, "Marcela", "Barrientos", 1232,
				new Domicilio("Calle 123", 12, "Lanus", "Buenos Aires"), sancor, "10200000071", false);
		Empleado e8 = new Empleado(41064794, "Nelida", "Ramirez", 221,
				new Domicilio("Calle 123", 12, "Lanus", "Buenos Aires"), sancor, "10200000081", false);
		Empleado e9 = new Empleado(36944718, "Eduardo", "Saavedra", 983, 
				new Domicilio("Sarmiento", 12, "CABA", "CABA"),medicus, "10200000091", true);//ENCARGADO
		
		
		
		// SE CREAN LABORATORIOS
		
		Laboratorio bayer = new Laboratorio("10300000011", "Laboratorio Bayer");
		Laboratorio bago = new Laboratorio("10300000021", "Laboratorio Bago");
		Laboratorio ch = new Laboratorio("10300000031", "CH Carolina Herrera");
		Laboratorio elite = new Laboratorio("10300000041", "Elite");
		
		
		// SE CREAN TIPOS DE PRODUCTOS
		
		TipoDeProducto farmacia = new TipoDeProducto(1, "Farmacia");
		TipoDeProducto perfumeria = new TipoDeProducto(2, "Perfumeria");
		

		// SE CREAN PRODUCTOS EN GONDOLA
		Producto p1 = new Producto(1, "BayaAspirina", 100.0f, bayer, farmacia);
		Producto p2 = new Producto(2, "Actron600", 200.0f, bayer, farmacia);
		Producto p3 = new Producto(3, "Doricina", 300.0f, bayer, farmacia);
		Producto p4 = new Producto(4, "Loratadina", 400.0f, bago, farmacia);
		Producto p5 = new Producto(5, "Calcium", 500.0f, bago, farmacia);
		Producto p6 = new Producto(6, "Misoprostol", 100.0f, bago, farmacia);
		Producto p7 = new Producto(7, "CafiaAspirina", 100.0f, bago, farmacia);
		Producto p8 = new Producto(8, "Jabon", 300.0f, ch, perfumeria);
		Producto p9 = new Producto(9, "Shampoo Plusbelle", 400.0f, ch, perfumeria);
		Producto p10 = new Producto(10, "Panuelos descartables Elite", 50.0f, elite, perfumeria);
		Producto[] productos = { p1, p2, p3, p4, p5, p6, p7, p8, p9, p10 };
		
		
		// METODO DE PAGO EFECTIVO-CREDITO-DEBITO
		
		FormaDePago efectivo = new FormaDePago(1, "EFECTIVO");
		FormaDePago credito = new FormaDePago(2, "CREDITO");
		FormaDePago debito = new FormaDePago(3, "DEBITO");
		FormaDePago[] formasDePago = { efectivo, credito, debito };
		
		// SUCURSALES CABA---LANUS---ONCE
		
		Sucursal s1 = new Sucursal(1, "Sucursl CABA",
				new Domicilio("Av de Mayo", 510, "CABA", "Buenos Aires"), Arrays.asList(e1, e2, e3));
		
		Sucursal s2 = new Sucursal(2, "Sucursal Lanus", 
				new Domicilio("Mitre", 200, "Lanus", "Buenos Aires"),Arrays.asList(e4, e5, e6));
		
		Sucursal s3 = new Sucursal(3, "Sucursal Once", 
				new Domicilio("Av. Puerreydon", 750, "CABA", "CABA"),Arrays.asList(e7, e8, e9));
		
		
		// SE DEFINES LAS VENTAS PARA QUE SEAN ENTRE ENERO DESDE EL 2024 HASTA LA FECHA ACTUAL
		
		List<Venta> ventas = new ArrayList<Venta>();
		
		// SE REALIZA 30 VENTAS ALEATORIAS PARA LA SUCURSAL DE LANUS
		ventas.addAll(generarVentas(s1, new Cliente[] { c1, c2, c3, c10 }, formasDePago, productos,LocalDate.of(2024, 01, 01), LocalDate.now(), 30));
		// SE REALIZA 25 VENTAS ALEATORIAS PARA LA SUCURSAL DE LANUS
		ventas.addAll(generarVentas(s2, new Cliente[] { c4, c5, c6, c10 }, formasDePago, productos,LocalDate.of(2024, 01, 01), LocalDate.now(), 25));
		// SE REALIZA 35 VENTAS ALEATORIAS  PARA LA SUCURSAL DE ONCE
		ventas.addAll(generarVentas(s3, new Cliente[] { c7, c8, c9, c10 }, formasDePago, productos,LocalDate.of(2024, 01, 01), LocalDate.now(), 35));
		
		
		// GUARDO LAS VENTAS COMO UNA COLECCION EN LA BASE DE DATOS
		try {
			String uri = "mongodb://localhost:27017";
			MongoClient mongoClient = new MongoClient(new MongoClientURI(uri));
			mongoClient.dropDatabase("farmacia"); // Elimina la base de datos si existe
			VentaDao.getInstance();			
			for(Venta venta: ventas) {
				VentaDao.agregar(venta);
			}
			System.out.println("\nATENCION : Se cargo de manera adecuada la Base de datos.");
		} 
		catch (Exception e) {
			System.out.println("\nERROR!, hubo problemas en la carga de los datos.");
			e.printStackTrace();
		}
	}
}
