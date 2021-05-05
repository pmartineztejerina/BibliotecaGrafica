package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Controlador.BibliotecaController;
import Excepciones.CamposVaciosException;
import Excepciones.ContainsException;
import Excepciones.IsbnException;
import Modelo.Libro;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmFormulario extends JFrame {

	private JPanel panel;
	private JPanel panel_1;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnSuprimir;
	private JButton btnGuardar;
	private JButton btnDeshacer;
	private ImageIcon icon;
	private JPanel panel_2;
	private JLabel lblIsbn;
	private JLabel lblTItulo;
	private JLabel lblAutor;
	private JLabel lblEditorial;
	private JLabel lblFecha;
	private JLabel lblPrecio;
	private JCheckBox chckbxPrestado;
	private JTextField textIsbn;
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textEditorial;
	private JTextField textFecha;
	private JTextField textPrecio;
	private JLabel lblaño;
	private JLabel lblConsulta;
	private JComboBox cmbConsulta;
	private JTextField textField;
	
	private JButton btnFiltrar;
	private JPanel panel_3;
	private JScrollPane scrollPane;
	private JTable tableLibros;
	private DefaultTableModel dtm;
	private List<Libro> listadoLibros;
	private JPanel panel_4;
	private JButton btnBeginning;
	private JButton btnBackward;
	private JButton btnForward;
	private JButton btnEnd;
	
	private int puntero;
	private BibliotecaController biblioteca;
	private Libro libro;
	private String isbn,titulo, autor, editorial, fechaRegistro, precio, prestado;
	private JFrame frame;
	
	public FrmFormulario() throws IOException, ParseException, CamposVaciosException, IsbnException {
		
		biblioteca=new BibliotecaController();
		
		listadoLibros=biblioteca.getBiblioteca();
			
		
		setTitle("F O R M U L A R I O  D E  M A N T E N I M I E N T O");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1332, 550);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		

		definirVentana(listadoLibros);
		definirEventosNavegador(listadoLibros);
		definirEventosMantenimiento();
		
		setVisible(true);
	}

	
	private void definirVentana(List<Libro> listadoLibros) {
		// TODO Auto-generated method stub
		
		this.frame=this;
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Mantenimiento Libros", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_1.setBounds(24, 25, 260, 82);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		icon=new ImageIcon("imagenes/add.png");
		btnAgregar = new JButton("",icon);
		btnAgregar.setBounds(10, 20, 40, 40);
		panel_1.add(btnAgregar);
		icon=null;
		
		icon=new ImageIcon("imagenes/edit.png");
		btnEditar = new JButton("",icon);
		btnEditar.setBounds(60, 20, 40, 40);
		panel_1.add(btnEditar);
		icon=null;
		
		icon=new ImageIcon("imagenes/delete.png");
		btnSuprimir = new JButton("",icon);
		btnSuprimir.setBounds(110, 20, 40, 40);
		panel_1.add(btnSuprimir);
		icon=null;
		
		icon=new ImageIcon("imagenes/save.png");
		btnGuardar = new JButton("",icon);
		btnGuardar.setBounds(160, 20, 40, 40);
		panel_1.add(btnGuardar);
		icon=null;
		
		icon=new ImageIcon("imagenes/undo.png");
		btnDeshacer = new JButton("",icon);
		btnDeshacer.setBounds(210, 20, 40, 40);
		panel_1.add(btnDeshacer);
		icon=null;
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Libros", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_2.setBounds(24, 131, 281, 253);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblIsbn = new JLabel("Isbn");
		lblIsbn.setBounds(10, 17, 53, 18);
		panel_2.add(lblIsbn);
		lblIsbn.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		lblTItulo = new JLabel("Titulo");
		lblTItulo.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblTItulo.setBounds(10, 52, 53, 18);
		panel_2.add(lblTItulo);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblAutor.setBounds(10, 87, 53, 18);
		panel_2.add(lblAutor);
		
		lblEditorial = new JLabel("Editorial");
		lblEditorial.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblEditorial.setBounds(10, 122, 53, 13);
		panel_2.add(lblEditorial);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblFecha.setBounds(10, 152, 45, 13);
		panel_2.add(lblFecha);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblPrecio.setBounds(10, 182, 45, 13);
		panel_2.add(lblPrecio);
		
		puntero=0;
		//aqui podria llamar a un metodo mostrar libro		
		String libro[]=listadoLibros.get(puntero).toString().split(",");
		
		textIsbn = new JTextField(libro[0]);
		textIsbn.setEditable(true);
		textIsbn.setBounds(73, 18, 174, 19);
		panel_2.add(textIsbn);
		textIsbn.setColumns(10);
		
		textTitulo = new JTextField(libro[1]);
		textTitulo.setEditable(true);
		textTitulo.setColumns(10);
		textTitulo.setBounds(73, 53, 174, 19);
		panel_2.add(textTitulo);
		
		textAutor = new JTextField(libro[2]);
		textAutor.setEditable(true);
		textAutor.setColumns(10);
		textAutor.setBounds(73, 88, 174, 19);
		panel_2.add(textAutor);
		
		textEditorial = new JTextField(libro[3]);
		textEditorial.setEditable(true);
		textEditorial.setColumns(10);
		textEditorial.setBounds(73, 120, 174, 19);
		panel_2.add(textEditorial);
		
		textFecha = new JTextField(libro[4]);
		textFecha.setEditable(true);
		textFecha.setColumns(10);
		textFecha.setBounds(73, 150, 82, 19);
		panel_2.add(textFecha);
		
		textPrecio = new JTextField(libro[5]);
		textPrecio.setEditable(true);
		textPrecio.setColumns(10);
		textPrecio.setBounds(73, 180, 174, 19);
		panel_2.add(textPrecio);
		
		lblaño = new JLabel("aaaa-MM-dd");
		lblaño.setBounds(165, 153, 82, 13);
		panel_2.add(lblaño);
				
		chckbxPrestado = new JCheckBox("Prestado");
		if (libro[6].contains("true")) {
			chckbxPrestado.setSelected(true);
		}
		chckbxPrestado.setBounds(10, 212, 93, 21);
		panel_2.add(chckbxPrestado);
		
		lblConsulta = new JLabel("Consulta");
		lblConsulta.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblConsulta.setBounds(332, 25, 66, 13);
		panel.add(lblConsulta);
		
		cmbConsulta = new JComboBox();
		cmbConsulta.setModel(new DefaultComboBoxModel(new String[] {"Autor", "Editorial", "Prestado"}));
		cmbConsulta.setFont(new Font("Verdana", Font.PLAIN, 12));
		cmbConsulta.setBounds(332, 58, 98, 21);
		panel.add(cmbConsulta);
		
		textField = new JTextField();
		textField.setBounds(454, 60, 246, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
	
		btnFiltrar.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnFiltrar.setBounds(728, 59, 85, 21);
		panel.add(btnFiltrar);
		
		panel_3 = new JPanel();
		panel_3.setBounds(332, 107, 948, 357);
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		//MUY IMPORTANTE INSTANCIAR EL MODELO DE DATOS y ASOCIARLE LA TABLA
		dtm=new DefaultTableModel();
		
		tableLibros = new JTable(dtm);
		scrollPane.setViewportView(tableLibros);
		
		//Metodo Cargar Libros
		cargarGrid(listadoLibros);
		
		//Panel navegacion
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Navegador", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_4.setBounds(57, 404, 208, 71);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		icon=new ImageIcon("imagenes/beginning.png");
		btnBeginning = new JButton("", icon);
		btnBeginning.setBounds(10, 21, 40, 40);
		panel_4.add(btnBeginning);
		btnBeginning.setEnabled(false);
		icon=null;
		
		icon=new ImageIcon("imagenes/backward.png");
		btnBackward = new JButton("", icon);
		btnBackward.setBounds(59, 21, 40, 40);
		panel_4.add(btnBackward);
		btnBackward.setEnabled(false);
		icon=null;
		
		icon=new ImageIcon("imagenes/forward.png");
		btnForward = new JButton("", icon);
		btnForward.setBounds(108, 21, 40, 40);
		panel_4.add(btnForward);
		btnForward.setEnabled(true);
		icon=null;
		
		icon=new ImageIcon("imagenes/end.png");
		btnEnd = new JButton("", icon);
		btnEnd.setBounds(157, 21, 40, 40);
		panel_4.add(btnEnd);
		btnEnd.setEnabled(true);
		icon=null;
		
		
	}


	private void cargarGrid(List<Libro> listadoLibros) {
		// TODO Auto-generated method stub
		
		//Vamos a declarar un array para definir las columnas y poner sus titulos
				String [] titulos= {"ISBN","TITULO","AUTOR","EDITORIAL","FECHA PRESTAMO","PRECIO","PRESTADO"};
				dtm.setRowCount(0);		//antes de llenar la tabla la vaciamos
				dtm.setColumnCount(0);
				//y ahora con el array de titulos le indicamos el numero de columnas
				dtm.setColumnIdentifiers(titulos);
				//y ahora le ponemos tamaño a las columnas
				TableColumnModel tcm=tableLibros.getColumnModel();
				tcm.getColumn(0).setPreferredWidth(50); 
				
				//mostramos la lista de libros en la tabla
				//hacer metodo cargarGrid
				for (int x = 0; x < listadoLibros.size(); x++) {
					String libros[]=listadoLibros.get(x).toString().split(",");
					dtm.addRow(libros);
				}
				
	}

	private void definirEventosNavegador(List<Libro> listadoLibros) {
		// TODO Auto-generated method stub
		   
		//String libro[]=listadoLibros.get(puntero).toString().split(",");
		
		btnBeginning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puntero=0;
				String libro[]=listadoLibros.get(puntero).toString().split(",");
				btnBeginning.setEnabled(true);
				btnBackward.setEnabled(true);
				btnForward.setEnabled(true);
				btnEnd.setEnabled(true);
				
				textIsbn.setText(libro[0]);
				textTitulo.setText(libro[1]);
				textAutor.setText(libro[2]);
				textEditorial.setText(libro[3]);
				textFecha.setText(libro[4]);
				textPrecio.setText(libro[5]);
				if (libro[6].contains("true")) {
					chckbxPrestado.setSelected(true);
				}
				else {
					chckbxPrestado.setSelected(false);
				}
				if (puntero==0) {
					btnBeginning.setEnabled(false);
					btnBackward.setEnabled(false);
					btnForward.setEnabled(true);
					btnEnd.setEnabled(true);
				}
				else {
					btnBeginning.setEnabled(true);
					btnBackward.setEnabled(true);
					btnForward.setEnabled(true);
					btnEnd.setEnabled(true);
				}
			}
		});
		
		btnBackward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puntero--;
				String libro[]=listadoLibros.get(puntero).toString().split(",");
				btnBeginning.setEnabled(true);
				btnBackward.setEnabled(true);
				btnForward.setEnabled(true);
				btnEnd.setEnabled(true);
				
				textIsbn.setText(libro[0]);
				textTitulo.setText(libro[1]);
				textAutor.setText(libro[2]);
				textEditorial.setText(libro[3]);
				textFecha.setText(libro[4]);
				textPrecio.setText(libro[5]);
				if (libro[6].contains("true")) {
					chckbxPrestado.setSelected(true);
				}
				else {
					chckbxPrestado.setSelected(false);
				}
				if (puntero==0) {
					btnBackward.setEnabled(false);
					btnBeginning.setEnabled(false);
				}
				
				
				
			}
		});
		
		btnForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puntero++;
				String libro[]=listadoLibros.get(puntero).toString().split(",");
				btnBeginning.setEnabled(true);
				btnBackward.setEnabled(true);
				btnForward.setEnabled(true);
				btnEnd.setEnabled(true);
				
				textIsbn.setText(libro[0]);
				textTitulo.setText(libro[1]);
				textAutor.setText(libro[2]);
				textEditorial.setText(libro[3]);
				textFecha.setText(libro[4]);
				textPrecio.setText(libro[5]);
				if (libro[6].contains("true")) {
					chckbxPrestado.setSelected(true);
				}
				else {
					chckbxPrestado.setSelected(false);
				}
				if (puntero==listadoLibros.size()-1) {
					btnForward.setEnabled(false);
					btnEnd.setEnabled(false);
				}
			}
		});
		
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puntero=listadoLibros.size()-1;
				String libro[]=listadoLibros.get(puntero).toString().split(",");
				btnBeginning.setEnabled(true);
				btnBackward.setEnabled(true);
				btnForward.setEnabled(true);
				btnEnd.setEnabled(true);
				
				textIsbn.setText(libro[0]);
				textTitulo.setText(libro[1]);
				textAutor.setText(libro[2]);
				textEditorial.setText(libro[3]);
				textFecha.setText(libro[4]);
				textPrecio.setText(libro[5]);
				if (libro[6].contains("true")) {
					chckbxPrestado.setSelected(true);
				}
				else {
					chckbxPrestado.setSelected(false);
				}
				if (puntero==listadoLibros.size()-1) {
					btnForward.setEnabled(false);
					btnEnd.setEnabled(false);
				}
								
			}
		});
		
	}
	
	private void definirEventosMantenimiento() {
		// TODO Auto-generated method stub
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textIsbn.setText("");
				textTitulo.setText("");
				textAutor.setText("");
				textEditorial.setText("");
				textFecha.setText("");
				textPrecio.setText("");
				chckbxPrestado.setSelected(false);
				btnBeginning.setEnabled(false);
				btnBackward.setEnabled(false);
				btnForward.setEnabled(false);
				btnEnd.setEnabled(false);
				btnEditar.setEnabled(false);
				btnSuprimir.setEnabled(false);
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isbn=textIsbn.getText();
				titulo=textTitulo.getText();
				autor=textAutor.getText();
				editorial=textEditorial.getText();
				fechaRegistro=textFecha.getText();
				precio=textPrecio.getText();
				if (chckbxPrestado.isSelected()) {
					prestado="true";
				}
				else {
					prestado="false";
				}
								
				Libro libro=null;
				try {
					libro = new Libro(isbn, titulo, autor, editorial, fechaRegistro, precio, prestado);
					biblioteca.editarLibro(libro,isbn, titulo, autor, editorial, fechaRegistro, precio, prestado);
					
				} catch (ParseException | CamposVaciosException | IsbnException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, e1.getMessage(),"¡ERROR!",JOptionPane.ERROR_MESSAGE);
				}
				cargarGrid(listadoLibros);
				
			}
		});
		
		btnSuprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirmar=JOptionPane.showConfirmDialog(null, "¿Esta usted seguro de eliminar este libro?","ATENCION",JOptionPane.WARNING_MESSAGE);
				if (confirmar==0) {
					
					if (biblioteca.borrarLibro(textIsbn.getText())) {
						puntero--;
						String libro[]=listadoLibros.get(puntero).toString().split(",");
						textIsbn.setText(libro[0]);
						textTitulo.setText(libro[1]);
						textAutor.setText(libro[2]);
						textEditorial.setText(libro[3]);
						textFecha.setText(libro[4]);
						textPrecio.setText(libro[5]);
						if (libro[6].contains("true")) {
							chckbxPrestado.setSelected(true);
						}
						else {
							chckbxPrestado.setSelected(false);
						}
						if (puntero==0) {
							btnBackward.setEnabled(false);
							btnBeginning.setEnabled(false);
						}
					}
				}
				try {
					biblioteca.guardarBiblioteca(libro);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, e1.getMessage(),"¡ERROR!",JOptionPane.ERROR_MESSAGE);
				}
				cargarGrid(listadoLibros);
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isbn=textIsbn.getText();
				titulo=textTitulo.getText();
				autor=textAutor.getText();
				editorial=textEditorial.getText();
				fechaRegistro=textFecha.getText();
				precio=textPrecio.getText();
				if (chckbxPrestado.isSelected()) {
					prestado="true";
				}
				else {
					prestado="false";
				}
								
				Libro libro=null;
				try {
					libro = new Libro(isbn, titulo, autor, editorial, fechaRegistro, precio, prestado);
					biblioteca.agregarLibro(libro);
					//guardo la biblioteca
					biblioteca.guardarBiblioteca(libro);
					
				} catch (ParseException | CamposVaciosException | IsbnException | ContainsException | IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, e1.getMessage(),"¡ERROR!",JOptionPane.ERROR_MESSAGE);
				}
				
				cargarGrid(listadoLibros);
				
			}
		});
		
		btnDeshacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textIsbn.setText("");
				textTitulo.setText("");
				textAutor.setText("");
				textEditorial.setText("");
				textFecha.setText("");
				textPrecio.setText("");
				chckbxPrestado.setSelected(false);
				btnBeginning.setEnabled(false);
				btnBackward.setEnabled(false);
				btnForward.setEnabled(false);
				btnEnd.setEnabled(false);
				btnEditar.setEnabled(false);
				btnSuprimir.setEnabled(false);
			}
		});
		
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filtrado=cmbConsulta.getSelectedItem().toString();
				if(filtrado.equals("Autor")) {
					
					List<Libro> lista;
					lista=biblioteca.filtrarAutor(filtrado);
					if (lista!= null) {
						cargarGrid(lista);
					}
					else {
						JOptionPane.showMessageDialog(null, "No hay libros con ese parametro");
					}	
				}
				
				if(filtrado.equals("Editorial")) {
					
					List<Libro> lista;
					lista=biblioteca.filtrarEditorial(filtrado);
					if (lista!= null) {
						cargarGrid(lista);
					}
					else {
						JOptionPane.showMessageDialog(null, "No hay libros con ese parametro");
					}	
				}
				
				if(filtrado.equals("Prestado")) {
					
					List<Libro> lista;
					lista=biblioteca.filtrarPrestado(filtrado);
					if (lista!= null) {
						cargarGrid(lista);
					}
					else {
						JOptionPane.showMessageDialog(null, "No hay libros con ese parametro");
					}	
				}
				
				
			}
		});
	}
}
