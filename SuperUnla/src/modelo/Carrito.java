package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	private List<ItemCarrito> lstItemCarrito = new ArrayList<ItemCarrito>();
	private Entrega entrega;
	

	public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado,Cliente cliente,
			Entrega entrega) {
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cerrado = cerrado;
		this.cliente = cliente;
		this.entrega = entrega;
	}

	public int getId() {
		return id;
	}
    
public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public boolean isCerrado() {
		return cerrado;
	}

	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemCarrito> getLstItemCarrito() {
		return lstItemCarrito;
	}

	public void setLstItemCarrito(List<ItemCarrito> lstItemCarrito) {
		this.lstItemCarrito = lstItemCarrito;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	
	
	
	@Override
	public String toString() {
		return "\nCarrito \nId = " + id + ", Fecha = " + fecha + ", Hora=" + hora + ", Cerrado = " + cerrado + ",\nDescuento = "
				+ descuento + ", \n\nCliente = " + cliente + "\nLista Item Carrito = " + lstItemCarrito + ", Entrega = " + entrega;
	}

	
/*================AGREGAR AL CARRITO ===============*/
	
	
	public boolean agregarAlCarrito(Articulo articulo, int cantidad) {
		if(this.cerrado)
			return false;
					
		boolean validador = false;
		
		if(lstItemCarrito.isEmpty()) {
			this.lstItemCarrito.add(new ItemCarrito(articulo, cantidad));
			validador = true;
			return validador;
			
		}
		else {
			for(ItemCarrito i: lstItemCarrito) {
				if(i.getArticulo().equals(articulo)) {
					i.setCantidad(i.getCantidad() + cantidad);
					validador = true;
					return validador;
				}
			}
		}
		
				
		return validador ? true : this.lstItemCarrito.add(new ItemCarrito(articulo, cantidad)) ;		
	}
	

		
	
	/*================ELIMINAR Del CARRITO ===============*/
	
public boolean eliminarDelCarrito (Articulo articulo, int cantidad) {
		
			for(ItemCarrito c : lstItemCarrito) {
	        if(c.getArticulo() == articulo) {
	        	
	        	if(c.getCantidad() == cantidad) {
	        		
	        		lstItemCarrito.remove(c);
	        		return true;
	        		
	        	}
	        	else if(c.getCantidad()>cantidad) {
	        		c.setCantidad(c.getCantidad()-cantidad);
	        		return true;
	        	}
	        	else if(c.getCantidad()<cantidad) {
	        		System.out.println("La cantidad que desea eliminar excede a la cantidad en el carrito.");
	        		return false;
	        	}
	
	        	
	        }
				
			};
			return true;
			
	}

		public double calcularTotalCarrito() {
			double total=0;
			for(ItemCarrito c: lstItemCarrito) {
				total+=c.getCantidad()*c.getArticulo().getPrecio();
			}
			return total;
		}
		public double totalAPagarCarrito() {
			double total=calcularTotalCarrito();
			return total;
		}







}
