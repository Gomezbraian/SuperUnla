package modelo;

public class Cliente extends Actor {
	
  protected String nombre;
  protected String apellido;
  protected String dni;
  
public Cliente(int id, Contacto contacto, String nombre, String apellido, String dni) {
	super(id, contacto);
	this.nombre = nombre;
	this.apellido = apellido;
	this.dni = dni;
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}


public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}



@Override
public String toString() {
	return "\nNombre = " + nombre + ", Apellido = " + apellido + ", Dni = " + dni;
}

private boolean soloNumeros() {

	int i, j = 0;
	String numero = ""; // Es el número que se comprueba uno a uno por si hay alguna letra entre los 8 primeros dígitos
	String miDNI = ""; // Guardamos en una cadena los números para después calcular la letra
	String[] unoNueve = {"0","1","2","3","4","5","6","7","8","9"};

	for(i = 0; i < this.dni.length() - 1; i++) {
		numero = this.dni.substring(i, i+1);//buscar substring

		for(j = 0; j < unoNueve.length; j++) {
			if(numero.equals(unoNueve[j])) {
				miDNI += unoNueve[j];
			}
		}
	}

	if(miDNI.length() != 8  || miDNI.length() !=7 ) {
		return false;
	}
	else {
		return true;
	}
}

public boolean validarDni() {
	 
	if(dni.length() !=9 || Character.isLetter(this.dni.charAt(8))== false) {//buscar isLetter,charAt
		return false;
	}
	
	 this.dni.substring(8).toUpperCase();//buscar toUpperCase
	if(soloNumeros() == true) {
		return true;
	}
	
	else {
		return false;
	}
	
}
 

}
