package Controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import Excepciones.CamposVaciosException;
import Excepciones.ContainsException;
import Excepciones.IsbnException;
import Modelo.Libro;

public class BibliotecaController {
	private List<Libro> biblioteca;

	public BibliotecaController() throws IOException, ParseException, CamposVaciosException, IsbnException {
		// TODO Auto-generated constructor stub
		
		biblioteca=new ArrayList<Libro>();
		
		//leer fichero
		File file=new File("biblioteca.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		String isbn,titulo, autor, editorial, fechaRegistro, precio, prestado;
		FileReader fr=new FileReader("biblioteca.txt");
		BufferedReader br=new BufferedReader(fr);
		String linea="";
		String [] datosBiblioteca=null;
		Libro libro;
		while ((linea=br.readLine())!= null) {
			datosBiblioteca=linea.split(",");
			isbn=datosBiblioteca[0];
			titulo=datosBiblioteca[1];
			autor=datosBiblioteca[2];
			editorial=datosBiblioteca[3];
			fechaRegistro=datosBiblioteca[4];
			precio=datosBiblioteca[5];
			prestado=datosBiblioteca[6];
			libro=new Libro(isbn, titulo, autor, editorial, fechaRegistro, precio, prestado);
			this.biblioteca.add(libro);
		}
		fr.close();
		br.close();
		fr=null;
		br=null;
		libro=null;
	}

	public List<Libro> getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(List<Libro> biblioteca) {
		this.biblioteca = biblioteca;
	}

	public List<Libro> mostrarBiblioteca() {
		// TODO Auto-generated method stub
		
		List<Libro> lista=null;
		for (Libro libro : this.biblioteca) {
			lista=getBiblioteca();
		}
		return lista;
	}

	public boolean agregarLibro(Libro libro) throws ContainsException {
		// TODO Auto-generated method stub
		boolean agregado=false;
		if (!biblioteca.contains(libro)) {
			biblioteca.add(libro);
			agregado=true;
		}
		else {
			throw new ContainsException();
		}
		return agregado;
	}

	public Libro buscarLibro(String isbn) {
		// TODO Auto-generated method stub
		Libro libro=null;
		for (Libro lib : this.biblioteca) {
			if (lib.getIsbn().equals(isbn)) {
				libro=lib;
			}
		}
		return libro;
	}

	public List<Libro> editarLibro(Libro libro, String isbn, String titulo, String autor, String editorial, String fechaRegistro, String precio, String prestado) throws CamposVaciosException, IsbnException, ParseException {
		// TODO Auto-generated method stub
	
		libro=buscarLibro(isbn);
		if (libro != null) {
			libro.setIsbn(isbn);
			libro.setTitulo(titulo);
			libro.setAutor(autor);
			libro.setEditorial(editorial);
			libro.setFechaRegistro(fechaRegistro);
			libro.setPrecio(precio);
			libro.setPrestado(prestado);
		
		}
		List<Libro> lista=null;
		for (Libro libro2 : this.biblioteca) {
			lista=getBiblioteca();
		}
		return lista;
	}

	public boolean borrarLibro(String isbn) {
		// TODO Auto-generated method stub
		boolean eliminado=false;
		Libro libro=buscarLibro(isbn);
		if (libro != null) {
			this.biblioteca.remove(libro);
			eliminado=true;
		}
		return eliminado;
	}

	public List<Libro> filtrarAutor(String autor) {
		// TODO Auto-generated method stub
		List<Libro> lista=new ArrayList<Libro>();
		for (Libro libro : this.biblioteca) {
			if (libro.getAutor().equals(autor)) {
				lista.add(libro);
			}
			if (lista.size()==0) {
				lista=null;
			}
		}
		return lista;
	}

	public boolean guardarBiblioteca(Libro libroGuardar) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw=new FileWriter("biblioteca2.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		String linea="";
		for (Libro libro : biblioteca) {
			linea=libro.toString();
			bw.write(linea);
			bw.newLine();
		}
		fw.flush();
		bw.flush();
		fw.close();
		bw.close();
		fw=null;
		bw=null;
		
		return true;
	}

}
