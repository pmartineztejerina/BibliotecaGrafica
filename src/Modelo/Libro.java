package Modelo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Excepciones.CamposVaciosException;
import Excepciones.IsbnException;

public class Libro {
	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private java.sql.Date fechaRegistro;
	private double precio;
	private boolean prestado;

	public Libro() {
		// TODO Auto-generated constructor stub
		this.isbn=null;
		this.titulo=null;
		this.autor=null;
		this.editorial=null;
		this.fechaRegistro=null;
		this.precio=0;
		this.prestado=false;
	}
	

	public Libro(String isbn, String titulo, String autor, String editorial, String fechaRegistro, String precio,
			String prestado) throws ParseException, CamposVaciosException, IsbnException {
		super();
		this.setIsbn(isbn);
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setEditorial(editorial);
		this.setFechaRegistro(fechaRegistro);
		this.setPrecio(precio);
		this.setPrestado(prestado);
	}


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws IsbnException, CamposVaciosException {
		if (isbn.equals("")) {
			throw new CamposVaciosException();
		}
		
		String isbnSinGuiones=isbn.replaceAll("-", "");
		String isbnNum=isbnSinGuiones.substring(0,12);
		String isbnCod=isbnSinGuiones.substring(12);
		
		int sumaImpar=0;
		int sumaPar=0;
		boolean impar=true;
		
		for (int x = 0; x < isbnNum.length(); x++) {
			if (impar) {
				sumaImpar+=Integer.parseInt(Character.toString(isbnNum.charAt(x)));
				impar=!impar;
			}
			else {
				sumaPar+=Integer.parseInt(Character.toString(isbnNum.charAt(x)))*3;
				impar=!impar;
			}
		}
		int suma=sumaImpar+sumaPar;
		int cod=10-suma%10;
		if (cod==10) {
			cod=0;
		}
		if (cod==Integer.parseInt(isbnCod)) {
			this.isbn = isbn;
		}
		else {
			throw new IsbnException();
		}
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws CamposVaciosException {
		if (titulo.equals("")) {
			throw new CamposVaciosException();
		}
		
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) throws CamposVaciosException {
		if (autor.equals("")) {
			throw new CamposVaciosException();
		}
		
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) throws CamposVaciosException {
		if (editorial.equals("")) {
			throw new CamposVaciosException();
		}
		
		this.editorial = editorial;
	}

	public java.sql.Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) throws ParseException, CamposVaciosException {
		if (fechaRegistro.equals("")) {
			throw new CamposVaciosException();
		}
		
		java.util.Date fecha=null;
		SimpleDateFormat formateador=new SimpleDateFormat("yyyy-MM-dd");
		formateador.setLenient(false);
		fecha=formateador.parse(fechaRegistro);
		this.fechaRegistro = new java.sql.Date(fecha.getTime());
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) throws CamposVaciosException {
		if (precio.equals("")) {
			throw new CamposVaciosException();
		}
		
		this.precio = Double.parseDouble(precio);
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(String prestado) throws CamposVaciosException {
		if (prestado.equals("")) {
			throw new CamposVaciosException();
		}
		
		this.prestado = Boolean.parseBoolean(prestado);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return isbn + "," + titulo + "," + autor + "," + editorial+ "," + fechaRegistro + "," + precio + "," + prestado;
	}

}
