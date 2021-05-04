package Excepciones;

public class CamposVaciosException extends Exception{

	public CamposVaciosException() {
		// TODO Auto-generated constructor stub
		
	}
	public String getMessage(String campo) {
		return "No puede dejar el campo vacio";
	}

}
