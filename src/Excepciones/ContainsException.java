package Excepciones;

public class ContainsException extends Exception{

	public ContainsException() {
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return "Este libro ya esta incluido en la biblioteca";
	}

}
