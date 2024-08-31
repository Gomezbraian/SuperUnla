package test;

import modelo.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws Exception {
		
		//=======================Creo Cliente y todo lo necesario para crear el cliente=================
		Ubicacion ubicacion1= new Ubicacion(10.10,20.20);
		Contacto contacto1=new Contacto("RodrigoFer98@hotmail.com","1165491871",ubicacion1);
		Cliente cliente1 = new Cliente(01,contacto1,"Fernandez","Rodrigo","404040");
				
		//Fin cliente---------------------------------------------------------
		
		
		//-------------------------------declaro Comercio------------------------------------------------
		Ubicacion ubicacion2 = new Ubicacion(15.00,25.50);
		Contacto contacto2 =new Contacto("AlmacenGranate@hotmail.com","42731341",ubicacion2);
	
		Comercio comercio1 = new Comercio(00,contacto2,"Almacen Granate",204040402,1.0,1.0,3,25,25);
		//-------------------------------Fin Comercio-----------------------------------------------------------
		
		//-------------------------------INICIO DE COMPRA----------------------------------------------------------
		
		//---------------------------Declaro carrito--------------------------------------------------
		Entrega entrega1= new Entrega (01,LocalDate.of(2020, 10, 15),false);
		Entrega entrega2= new Entrega (01,LocalDate.of(2020, 10, 15),true);
		Carrito carrito1=new Carrito(02,LocalDate.of(2020, 10, 15),LocalTime.of(15, 50),false,cliente1,entrega1);
		Carrito carrito2=new Carrito(03,LocalDate.now(),LocalTime.of(17, 50),false,cliente1,entrega2);
		//------------------------------------Fin Declarar carrito-----------------------------------------------------------
		
		//-------------------Declaro los Articulos para simular la compra----------------------------------
		Articulo articulo1=new Articulo(1000,"Coca-Cola 2.5L","1000",140.50);
		Articulo articulo2=new Articulo(1001,"Helado Bombom","1001",50);
		Articulo articulo3=new Articulo(1002,"Mani King: pasa de mani 450g","1002",280);
		
		//Fin Articulos-------------------------------------------------------------------
		
		
		/* ================ AGREGO DIA DE RETIROS =========================*/
		try {
			comercio1.agregarDiaRetiro(1, LocalTime.of(8, 00), LocalTime.of(18, 00), 30);
			comercio1.agregarDiaRetiro(2, LocalTime.of(8, 00), LocalTime.of(18, 00), 15);
			comercio1.agregarDiaRetiro(3, LocalTime.of(10, 30), LocalTime.of(18, 00), 20);
			comercio1.agregarDiaRetiro(4, LocalTime.of(8, 00), LocalTime.of(18, 00), 45);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//-----------------------------Agrego articulos al carrito------------------------------------
		
		try {
            carrito1.agregarAlCarrito(articulo1, 6);
            carrito2.agregarAlCarrito(articulo1, 6);
        }
        catch(Exception e){
                System.out.println(e.getMessage());
            }
		//AGREGO EL MISMO PARA QUE MUESTRE EL ERROR Y QUE ARTICULO YA ESTA EN LA LISTA|
		try {
            carrito1.agregarAlCarrito(articulo1, 2);
            carrito2.agregarAlCarrito(articulo1, 2);
		}
        catch(Exception e){
                System.out.println(e.getMessage());
            }
		try {
            carrito1.agregarAlCarrito(articulo2, 4);
            carrito2.agregarAlCarrito(articulo2, 4);
        }
        catch(Exception e){
                System.out.println(e.getMessage());
            }
		
		try {
            carrito1.agregarAlCarrito(articulo3, 2);
            carrito2.agregarAlCarrito(articulo3, 2);
            comercio1.agregarCarrito(carrito1);
            comercio1.agregarCarrito(carrito2);
        }
        catch(Exception e){
                System.out.println(e.getMessage());
            }
		 comercio1.cerrarCarritos();
		 System.out.println(("Total Carrito 1: "+carrito1.getDescuento()));
		 System.out.println(("Total Carrito 2: "+carrito2.getDescuento()));
		 System.out.println(comercio1.toString());
		 System.out.println(carrito1.toString());
		
		//======================Declaro Listas para agendar Turnos======================
		 List<Turno> TurnoDisponibles ;
		 List<Turno> turnosOcupados ;
		 List<Turno> Agenda ;
		//======================Completo las listas======================
		 try {	 
			 	TurnoDisponibles = comercio1.generarTurnosLibres(LocalDate.now());
				turnosOcupados = comercio1.traerTurnosOcupados(LocalDate.now());
				Agenda = comercio1.crearAgenda(LocalDate.now());
				comercio1.imprimirTurnos(Agenda);
			} catch (Exception e) {  	
				System.out.println(e.getMessage());
			}

	}
}

	
