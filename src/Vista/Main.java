package Vista;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controlador.BibliotecaController;
import Excepciones.CamposVaciosException;
import Excepciones.IsbnException;
import Modelo.Libro;


public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Instanciar objeto
		String isbn,titulo, autor, editorial, fechaRegistro, precio, prestado;
		isbn="978-84-663-2914-9";
		titulo="El capitan Alatriste";
		autor="Arturo Perez Reverte";
		editorial="Alfaguara";
		fechaRegistro="2015-03-15";
		precio="20.5";
		prestado="true";
		
		Libro libro=null;
		try {
			libro=new Libro(isbn, titulo, autor, editorial, fechaRegistro, precio, prestado);
			//System.out.println(libro);
		} catch (ParseException | CamposVaciosException | IsbnException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		//Instanciar Controller
		BibliotecaController biblioteca=null;
		List<Libro> listadoLibros=null;
		try {
			biblioteca=new BibliotecaController();
			
			listadoLibros=biblioteca.getBiblioteca();
			
			for (Libro libro2 : listadoLibros) {
				//System.out.println(libro2);
			}
			
		} catch (IOException | ParseException | CamposVaciosException | IsbnException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		//mando al frame la lista
		FrmFormulario formulario;
		try {
			formulario=new FrmFormulario();
		} catch (IOException | ParseException | CamposVaciosException | IsbnException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		
		/*
		//Menu
		Scanner leer = new Scanner(System.in);
		int opcion = 0;

		System.out.println("1. Mostrar los libros de la biblioteca");
		System.out.println("2. Agregar un libro");
		System.out.println("3. Buscar un libro");
		System.out.println("4. Modificar un libro");
		System.out.println("5. Eliminar un libro");
		System.out.println("6. Filtrar biblioteca por autor");
		System.out.println("7. Guardar biblioteca");
		System.out.println("8. Salir");
		opcion = leer.nextInt();
		switch (opcion) {
		case 1:// mostrar biblioteca

			List<Libro> biblio;
			biblio = biblioteca.mostrarBiblioteca();
			if (biblio != null) {
				for (Libro libro2 : biblio) {
					System.out.println(libro2);
				}
			} else {
				System.err.println("No hay ningun libro en la biblioteca");
			}
			biblio=null;
			break;

		case 2:// agregar libro

			isbn = "978-84-663-2914-9";
			titulo = "El capitan Alatriste";
			autor = "Arturo Perez Reverte";
			editorial = "Alfaguara";
			fechaRegistro = "2015-03-15";
			precio = "20.5";
			prestado = "true";
			try {
				libro = new Libro(isbn, titulo, autor, editorial, fechaRegistro, precio, prestado);
				if (biblioteca.agregarLibro(libro)) {
					System.out.println("El libro se agrego correctamente");
				} else {
					System.err.println("Ha ocurrido un error al agregar el libro");
				}

			} catch (ParseException | CamposVaciosException | IsbnException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			break;

		case 3:// buscar libro
			
			isbn = "978-84-675-3704-8";
			libro = biblioteca.buscarLibro(isbn);
			if (libro != null) {
				System.out.println(libro);
			} else {
				System.err.println("El libro que busca no está en la biblioteca");
			}
			break;

		case 4:// editar libro
			
			isbn = "978-84-675-3704-8";
			precio = "19.95";

			try {
				if (biblioteca.editarLibro(isbn, precio)) {
					System.out.println("El libro ha sido modificado");
					// podemos mostrar el libro para ver la modificacion
					libro = biblioteca.buscarLibro(isbn);
					System.out.println(libro);
				} else {
					System.err.println("Ha ocurrido un error y la modificacion no ha sido realizada");
				}
			} catch (CamposVaciosException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			break;

		case 5:// borrar libro
			
			isbn="978-84-450-0065-6";
			if (biblioteca.borrarLibro(isbn)) {
				System.out.println("El libro ha sido eliminado");
			}
			else {
				System.err.println("Libro no encontrado en la biblioteca");
			}

			break;

		case 6:// filtrar biblioteca por autor
			autor="John Verdon";
			List<Libro> listaAutor;
			listaAutor=biblioteca.filtrarAutor(autor);
			if (listaAutor!= null) {
				for (Libro libro2 : listaAutor) {
					System.out.println(libro2);
				}
			}
			else {
				System.err.println("No hay libros de ese autor");
			}

			break;

		case 7:// guardar biblioteca
			
			try {
				biblioteca=new BibliotecaController();
				Libro libroGuardar=null;
				if (biblioteca.guardarBiblioteca(libroGuardar)) {
					System.out.println("La copia se ha realizado con exito");
				}
				else {
					System.err.println("Guardado fallido");
				}
				
			} catch (IOException | ParseException | CamposVaciosException | IsbnException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}

			break;

		case 8:// Salir
			
			break;

		}*/

	}

}