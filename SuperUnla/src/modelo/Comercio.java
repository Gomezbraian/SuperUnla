package modelo;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.ArrayList;

import java.util.List;

public class Comercio extends Actor {
 private String nombreComercio;
 private long cuit;
 private double costoFijo;
 private double costoPorKm;
 private int diaDescuento;
 private int porcentajeDescuentoDia;
 private int porcentajeDescuentoEfectivo;
 private List<DiaRetiro>lstDiaRetiro = new ArrayList<DiaRetiro>();
 private List<Articulo>lstArticulo = new ArrayList<Articulo>();
 private List<Carrito>lstCarrito = new ArrayList<Carrito>();
 
 
	public Comercio(int id, Contacto contacto,String nombreComercio, long cuit, double costoFijo, double costoPorKm, int diaDescuento,
			int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo) {
		super(id,contacto);
		this.nombreComercio = nombreComercio;
		this.cuit = cuit;
		this.costoFijo = costoFijo;
		this.costoPorKm = costoPorKm;
		this.diaDescuento = diaDescuento;
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
	
	}


	public String getNombreComercio() {
		return nombreComercio;
	}
	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}



	public long getCuit() {
		return cuit;
	}
	public void setCuit(long cuit) throws Exception {
		 if(validarIdentificadorUnico(cuit) == true)
			 this.cuit = cuit; 
		 else 
			 throw new Exception("ERROR AL VALIDAR CUIT");	
	}


	public double getCostoFijo() {
		return costoFijo;
	}
	public void setCostoFijo(double costoFijo) {
		this.costoFijo = costoFijo;
	}



	public double getCostoPorKm() {
		return costoPorKm;
	}
	public void setCostoPorKm(double costoPorKm) {
		this.costoPorKm = costoPorKm;
	}


	public int getDiaDescuento() {
		return diaDescuento;
	}
	public void setDiaDescuento(int diaDescuento) {
		this.diaDescuento = diaDescuento;
	}
	



	public int getPorcentajeDescuentoDia() {
		return porcentajeDescuentoDia;
	}
	public void setPorcentajeDescuentoDia(int porcentajeDescuentoDia) {
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
	}



	public int getPorcentajeDescuentoEfectivo() {
		return porcentajeDescuentoEfectivo;
	}
	public void setPorcentajeDescuentoEfectivo(int porcentajeDescuentoEfectivo) {
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
	}



	public List<DiaRetiro> getLstDiaRetiro() {
		return lstDiaRetiro;
	}
	public void setLstDiaRetiro(List<DiaRetiro> lstDiaRetiro) {
		this.lstDiaRetiro = lstDiaRetiro;
	}




	public List<Articulo> getLstArticulo() {
		return lstArticulo;
	}
	public void setLstArticulo(List<Articulo> lstArticulo) {
		this.lstArticulo = lstArticulo;
	}



	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}
	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}


	@Override
	public String toString() {
		return "\nComercio \nNombre del Comercio = " + nombreComercio + "\nCuit = " + cuit + "\nCostoFijo = " + costoFijo
				+ "\nCostoPorKm = " + costoPorKm + "\nDiaDescuento = " + diaDescuento + "\nPorcentajeDescuentoDia = "
				+ porcentajeDescuentoDia + "\nPorcentaje del descuento en Efectivo = " + porcentajeDescuentoEfectivo ;
	}





/* ============================== COSTO POR DISTANCIA=========================*/



public double distanciaCoord( double lat1 , double lng1 , double lat2 , double lng2 ) {
  double radioTierra = 6371; // en kilómetros
  double dLat = Math. toRadians ( lat2 - lat1 );
  double dLng = Math. toRadians ( lng2 - lng1 );
  double sindLat = Math. sin ( dLat / 2);
  double sindLng = Math. sin ( dLng / 2);
  double va1 =Math. pow ( sindLat , 2)+Math. pow ( sindLng , 2)*Math. cos (Math. toRadians ( lat1 ))*
  Math. cos (Math. toRadians ( lat2 ));
  double va2 = 2 * Math. atan2 (Math. sqrt ( va1 ), Math. sqrt (1 - va1 ));
   return radioTierra * va2 ;
}



/* ============================== Validar CUIT=========================*/

public boolean validarIdentificadorUnico(long cuit) {
	int[] numPValidarCuil = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
	String cuilString = Long.toString(cuit);
	char[]charCuil = cuilString.toCharArray();
	
	int ultimoNum = Character.getNumericValue(charCuil[charCuil.length - 1]);
	
	int suma = 0;
	char sexo = 0;
	char x = 0,y = 0;
/*============= Compruebo que el Cuit fue ingresado de manera correcta antes de verificarlo=============*/
	if((charCuil[0] != '2') && (charCuil[0] != '3') || (charCuil.length != 11))return false;
	
/*============= Determino el sexo dependiendo los dos primeros digitos=============*/
	if((charCuil[0] == '2') && (charCuil[1] == '0')) 
		sexo = 'm';
	else if((charCuil[0] == '2') &&(charCuil[1] == '7'))
		sexo = 'f';
	
/*============= Realizo la operacion con los 10 digitos=============*/
	for(int i=0;i< numPValidarCuil.length; i++) {
		int num = numPValidarCuil[i];
		int numCuil = Character.getNumericValue(charCuil[i]) ;
		suma += num * numCuil;
	}
/*============= Obtengo el resto, y determino X y Y=============*/
	int r = suma%11;
	int z = 0;/*(r==0) ? r : 11 - r;*/
			switch(r) {
			case 0: z = 0;
				  break;			
			case 1:
				if(sexo == 'm') {
				x ='2';
				y ='3';
				z = 9;
				}if(sexo== 'f') {
					x = '2';
					y = '3';
					z = 4;
				}break;				
			default: 
				if(sexo == 'm') {
					x ='2';
					y ='0';
					z = 11 - r;
					}
				if(sexo== 'f') {
						x = '2';
						y = '7';
						z = 11 - r;
					}break;
		}
			/*============= Si Z(num verificador) es diferente al ultimo num que se ingreso FALSO=============*/
			/*============= Si X y Y son diferentes a los primeros digitos FALSO=============*/
		return (z != ultimoNum) || ((charCuil[0] != x)&& (charCuil[1] != y)) ? false : true;
		
	}

/* ============================== AGREGAR DIA DE RETIRO=========================*/
	public boolean agregarDiaRetiro(int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int intervalo )throws Exception{
		if(horaDesde.isAfter(horaHasta)) throw new Exception("La franja horaria es erronea");
		if(diaSemana < 1 || diaSemana > 7 ) throw new Exception("El dia de la semana es erroneo");
		int id = this.lstDiaRetiro.isEmpty() ? 1: this.lstDiaRetiro.get(lstDiaRetiro.size() - 1).getId() + 1; 
		
		this.lstDiaRetiro.add(new DiaRetiro(id , diaSemana, horaDesde, horaHasta, intervalo));
		
		
		return false;
	}
	
	
	/* =========== AGENDA==============*/
	public List<Turno> crearAgenda(LocalDate fecha){
		List<Turno> Agenda;
		try {
			Agenda = generarTurnosLibres(fecha);
			List<Turno> TurnosOcupados = traerTurnosOcupados(fecha);
			for(Turno t: Agenda) {
				for(Turno o: TurnosOcupados) {
					if((t.isOcupado() != o.isOcupado()) && (t.getHora().equals(o.getHora()))) {
						t.setOcupado(true);
						//System.out.println(t.ocupado+ "   " + o.isOcupado());
					}
				} 
			}
			return Agenda;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
		
	}
	
	
	/* =========== LSITA DE TURNOS LIBRES==============*/
	
	public List<Turno> generarTurnosLibres(LocalDate fecha) throws Exception {
		
		List<Turno> lstTurnos = new ArrayList<Turno>();
		int dia = fecha.getDayOfWeek().getValue() - 1;
		if(dia < 0 || dia > 6 ) throw new Exception("El dia de la semana es erroneo");
		LocalTime hasta = lstDiaRetiro.get(dia).getHoraHasta();
		int intervalo = lstDiaRetiro.get(dia).getIntervalo();
		LocalTime suma  = lstDiaRetiro.get(dia).getHoraDesde();
		int i = 0;
		while(hasta.isAfter(suma)) {
			lstTurnos.add(new Turno(fecha,suma ,false));
			
			suma = suma.plusMinutes(intervalo);
			i++;
			
			
		}
										
		return lstTurnos;
		
	}
	
	
	
	/* =========== traerTurnosOcupados==============*/
	
	
	
	public List<Turno> traerTurnosOcupados(LocalDate fecha) throws Exception {
		int i = 0;
		List<Turno>	listTurnos = generarTurnosLibres(fecha);
		List<Turno> lstTurnosOcupados = new ArrayList<Turno>();
		int dia = this.lstCarrito.get(0).getEntrega().getFecha().getDayOfWeek().getValue() - 1;
		if(dia< 0 || dia > 6 ) throw new Exception("El dia de la semana es erroneo");
		for(Turno t: listTurnos) {
			if(t.getHora().equals(lstCarrito.get(i).getHora())) {
				t.setOcupado(true);
				lstTurnosOcupados.add(t);
				/*System.out.println("Fecha: " + t.getDia() + " Hora: " + t.getHora() + " Disponible: NO");*/
				i++;	
			}
			
		}
													
		return lstTurnosOcupados;
		
	}
	
	/* ============================== Agregar CArrito a lista=========================*/

	public boolean agregarCarrito(Carrito carrito) throws Exception{
		// =================== SETEO DE DESCUENTO EN CARRITO==================
		/*int dia = carrito.getFecha().getDayOfWeek().getValue() - 1;
		//System.out.println(dia);
		carrito.setDescuento(calcularDescuentoCarrito(dia, this.porcentajeDescuentoDia, this.porcentajeDescuentoEfectivo, carrito));
		*/
		
		
		
		if(lstCarrito.isEmpty()) {
			lstCarrito.add(carrito);	
			return true;
		}
		else {
			for(Carrito c: lstCarrito) {
				if(c.equals(carrito)) {
					throw new Exception("ERROR EL MISMO CARRITO YA SE ENCUENTRA EN LA LISTA");
				}
			}
									
		}		
		return lstCarrito.add(carrito);		
	}	

	
	public double calcularDescuentoEfectivo(int porcentajeDescuentoEfectivo,Carrito carrito) {
		double descuento = 0;		
		//System.out.println(carrito.calcularTotalCarrito());
		if(carrito.getEntrega().isEfectivo()) {
			descuento = ((double)porcentajeDescuentoEfectivo/100) * carrito.calcularTotalCarrito();
			return descuento;	
			
		}
		return 0;
			 
	}
	
	
	public double calcularDescuentoDia (int diaDescuento, int porcentajeDescuentoDia, Carrito carrito) {
		double descuento=0;
		for(ItemCarrito i : carrito.getLstItemCarrito()) {
			int cantidadArticulos= i.getCantidad() / 2;
			if (this.diaDescuento == diaDescuento && cantidadArticulos>1) {          //si es el dia del descuento y hay mas de un articulo aplicarlo
				
				if(cantidadArticulos%2==0) {                   //si la cantidad de productos son pares aplicar el descuento a la mitad de los articulos
					descuento += (cantidadArticulos/2) *(double)porcentajeDescuentoDia/100 * (i.getArticulo().getPrecio() * ((cantidadArticulos-1)/2)) ;
					
				}
				else {                                         //aplico un menos 1 para forzar el numero par 
					descuento+=((cantidadArticulos-1)/2) *(double)porcentajeDescuentoDia /100 * (i.getArticulo().getPrecio() * ((cantidadArticulos-1)/2));
					
				} 
		}
			
			}return descuento;
	}
	
	public double calcularDescuentoCarrito (int diaDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo,Carrito carrito) {
		
			if (calcularDescuentoDia(diaDescuento, porcentajeDescuentoDia, carrito) > calcularDescuentoEfectivo(porcentajeDescuentoEfectivo, carrito)) 
				return calcularDescuentoDia(diaDescuento, porcentajeDescuentoDia, carrito);
			
				
			else
				return calcularDescuentoEfectivo(porcentajeDescuentoEfectivo, carrito);
			
			
			
		}
	
	public void imprimirTurnos(List<Turno> turnos) {
		for(Turno t: turnos) {
			System.out.println("Dia: " + t.getDia() + " Hora: " + t.getHora() + " Disponible: " + t.isOcupado());
		}
	}
	
	public void cerrarCarritos() {
		for(Carrito c: this.lstCarrito) {
			int dia = c.getFecha().getDayOfWeek().getValue() - 1;
			if(!c.isCerrado()) {
				c.setDescuento(calcularDescuentoCarrito(dia, porcentajeDescuentoDia, porcentajeDescuentoEfectivo, c));
				c.setCerrado(true);
			}
		}
	}
	
	
	
	
	/*public LocalTime traerHoraRetiro(LocalDate fecha) {
		int dia = fecha.getDayOfWeek().getValue() - 1;
		
		List = generarTurnosLibres(fecha);
		
	}*/
	
	
	
}
