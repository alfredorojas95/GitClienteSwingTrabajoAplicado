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

import servicioestudiante.ServicioEstudianteProxy;

public class VerSituacionEstudiante extends JFrame {

	private JPanel contentPane;
	private JTextField textRut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerSituacionEstudiante frame = new VerSituacionEstudiante();
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
	public VerSituacionEstudiante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblApoderadoestudiante = new JLabel("Apoderado/EStudiante");
		lblApoderadoestudiante.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblApoderadoestudiante.setBounds(97, 11, 254, 50);
		contentPane.add(lblApoderadoestudiante);
		
		JLabel lblRutEstudiante = new JLabel("Rut Estudiante:");
		lblRutEstudiante.setBounds(51, 108, 88, 14);
		contentPane.add(lblRutEstudiante);
		
		textRut = new JTextField();
		textRut.setBounds(149, 105, 220, 20);
		contentPane.add(textRut);
		textRut.setColumns(10);
		
		JLabel labelResultado = new JLabel("");
		labelResultado.setBounds(79, 177, 290, 20);
		contentPane.add(labelResultado);
		
		JButton btnConsultar = new JButton("Consultar situaci\u00F3n");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rutEst = textRut.getText();
				
				
				ServicioEstudianteProxy ver = new ServicioEstudianteProxy();
				try {		
					if (textRut.getText().trim().length()!=0){
						String resultado = ver.obtenerSituacionEstudiante(rutEst);
						labelResultado.setText(resultado);
					} else {
						labelResultado.setText("Debe ingresar un rut");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		btnConsultar.setBounds(149, 136, 173, 23);
		contentPane.add(btnConsultar);
		
		
		
		JButton btnVolverAlMen = new JButton("Volver al Men\u00FA");
		btnVolverAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu b = new Menu();
				b.setLocationRelativeTo(null);
				b.setVisible(true);
				setVisible(false);
			}
		});
		btnVolverAlMen.setBounds(159, 208, 130, 23);
		contentPane.add(btnVolverAlMen);
		
		JLabel lblConsultarSituacinEstudiante = new JLabel("Consultar situaci\u00F3n estudiante");
		lblConsultarSituacinEstudiante.setBounds(126, 64, 196, 14);
		contentPane.add(lblConsultarSituacinEstudiante);
	}

}
