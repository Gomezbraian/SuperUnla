package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class RetiroLocal extends Entrega {

	private LocalTime retiroLocal;

	public RetiroLocal(int id, LocalDate fecha, boolean efectivo,LocalTime retiroLocal) {
		super(id,fecha,efectivo);
		this.retiroLocal = retiroLocal;
	}

	public LocalTime getRetiroLocal() {
		return retiroLocal;
	}

	public void setRetiroLocal(LocalTime retiroLocal) {
		this.retiroLocal = retiroLocal;
	}
	
		
	
}
