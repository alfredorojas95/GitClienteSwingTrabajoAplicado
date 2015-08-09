package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import serviciocurso.ServicioCursoProxy;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import servicioprofesor.ServicioProfesorProxy;

public class RegistrarNota extends JFrame {

	private JPanel contentPane;
	private JTextField textEst;
	private JTextField textNota;
	private JTextField textCodigo;
	private JTextField textProf;
	private JLabel labelResultado;
	private JButton btnVolverAlMen;
	private JLabel lblRutEstudiante;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarNota frame = new RegistrarNota();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrarNota() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProfesor = new JLabel("Profesor");
		lblProfesor.setFont(new Font("Comic Sans MS", Font.ITALIC, 22));
		lblProfesor.setBounds(231, 30, 142, 32);
		contentPane.add(lblProfesor);
		
		JLabel lblRegistrarPromedioDel = new JLabel("Registrar promedio del estudiante en curso");
		lblRegistrarPromedioDel.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		lblRegistrarPromedioDel.setBounds(136, 73, 340, 32);
		contentPane.add(lblRegistrarPromedioDel);
		
		textEst = new JTextField();
		textEst.setBounds(231, 116, 255, 20);
		contentPane.add(textEst);
		textEst.setColumns(10);
		
		textNota = new JTextField();
		textNota.setColumns(10);
		textNota.setBounds(231, 148, 255, 20);
		contentPane.add(textNota);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(231, 179, 255, 20);
		contentPane.add(textCodigo);
		
		textProf = new JTextField();
		textProf.setColumns(10);
		textProf.setBounds(231, 210, 255, 20);
		contentPane.add(textProf);
		
		JButton btnRegistrarNota = new JButton("Registrar Nota");
		btnRegistrarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String rutEs = textEst.getText(); 
				String nota = textNota.getText();
				String cod = textCodigo.getText();
				String rutProfe = textProf.getText();
				
				
				ServicioProfesorProxy asignarNota = new ServicioProfesorProxy();
				
				String resultado;
				try {
					if ((textEst.getText().trim().length()!=0)&&(textNota.getText().trim().length()!=0)
							&&(textCodigo.getText().trim().length()!=0)&&(textProf.getText().trim().length()!=0)){
						
						int id = Integer.parseInt(cod);
						resultado = asignarNota.registrarPromedio(rutEs, id, nota, rutProfe);
						labelResultado.setText(resultado);
					} else {
						labelResultado.setText("Debe llenar todos los campos");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			}
		});
		btnRegistrarNota.setBounds(231, 241, 119, 23);
		contentPane.add(btnRegistrarNota);
		
		labelResultado = new JLabel("");
		labelResultado.setBounds(101, 275, 385, 20);
		contentPane.add(labelResultado);
		
		btnVolverAlMen = new JButton("Volver al Men\u00FA");
		btnVolverAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu b = new Menu();
				b.setLocationRelativeTo(null);
				b.setVisible(true);
				setVisible(false);
			}
		});
		btnVolverAlMen.setBounds(195, 306, 135, 23);
		contentPane.add(btnVolverAlMen);
		
		lblRutEstudiante = new JLabel("Rut estudiante: ");
		lblRutEstudiante.setBounds(42, 119, 119, 14);
		contentPane.add(lblRutEstudiante);
		
		label = new JLabel("Nota:");
		label.setBounds(42, 151, 119, 14);
		contentPane.add(label);
		
		label_1 = new JLabel("C\u00F3digo curso: ");
		label_1.setBounds(42, 182, 119, 14);
		contentPane.add(label_1);
		
		label_2 = new JLabel("Rut profesor: ");
		label_2.setBounds(42, 213, 119, 14);
		contentPane.add(label_2);
	}

}
