package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Envio extends Entrega {
  private LocalTime horaDesde;
  private LocalTime horaHasta;
  private double costo;
  private Ubicacion ubicacion;
  
  
public Envio(int id, LocalDate fecha, boolean efectivo,LocalTime horaDesde, LocalTime horaHasta, double costo, Ubicacion ubicacion) {
	super(id,fecha,efectivo);
	
	this.horaDesde = horaDesde;
	this.horaHasta = horaHasta;
	this.costo = costo;
	this.ubicacion = ubicacion;
}



public LocalTime getHoraDesde() {
	return horaDesde;
}

public void setHoraDesde(LocalTime horaDesde) {
	this.horaDesde = horaDesde;
}




public LocalTime getHoraHasta() {
	return horaHasta;
}
public void setHoraHasta(LocalTime horaHasta) {
	this.horaHasta = horaHasta;
}




public double getCosto() {
	return costo;
}

public void setCosto(double costo) {
	this.costo = costo;
}




public Ubicacion getUbicacion() {
	return ubicacion;
}
public void setUbicacion(Ubicacion ubicacion) {
	this.ubicacion = ubicacion;
}


@Override
public String toString() {
	return "Envio [horaDesde=" + horaDesde + ", horaHasta=" + horaHasta + ", costo=" + costo + ", ubicacion="
			+ ubicacion;
}
  

  
}
