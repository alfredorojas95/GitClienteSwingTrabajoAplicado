package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import serviciomatricula.ServicioMatriculaProxy;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import servicioprofesor.ServicioProfesorProxy;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

public class RegistrarMatricula extends JFrame {

	private JPanel contentPane;
	private JTextField textRut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarMatricula frame = new RegistrarMatricula();
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
	public RegistrarMatricula() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSecretaria = new JLabel("Secretaria");
		lblSecretaria.setFont(new Font("Comic Sans MS", Font.ITALIC, 22));
		lblSecretaria.setBounds(144, 21, 171, 41);
		contentPane.add(lblSecretaria);
		
		JLabel lblRegistrarPagoDe = new JLabel("Registrar pago de matr\u00EDcula");
		lblRegistrarPagoDe.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		lblRegistrarPagoDe.setBounds(110, 62, 228, 20);
		contentPane.add(lblRegistrarPagoDe);
		
		JLabel lblRutEstudiante = new JLabel("Rut estudiante:");
		lblRutEstudiante.setBounds(34, 109, 102, 14);
		contentPane.add(lblRutEstudiante);
		
		textRut = new JTextField();
		textRut.setBounds(144, 106, 194, 20);
		contentPane.add(textRut);
		textRut.setColumns(10);
		
		JLabel labelMatricula = new JLabel("");
		labelMatricula.setBounds(77, 182, 261, 20);
		contentPane.add(labelMatricula);
		
		JButton btnPagarMatrcula = new JButton("Pagar matr\u00EDcula");
		btnPagarMatrcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rutEs = textRut.getText(); 				
				ServicioMatriculaProxy pagarMatricula = new ServicioMatriculaProxy();
				
				String resultado="";
				try {
					if (textRut.getText().trim().length()!=0){
					
						resultado =pagarMatricula.pagarMatricula(rutEs, "165643214");
						labelMatricula.setText(resultado);
					} else {
						labelMatricula.setText("Debe llenar el campo rut");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPagarMatrcula.setBounds(144, 137, 139, 23);
		contentPane.add(btnPagarMatrcula);
		
	
		
		JButton btnVolverAlMen = new JButton("Volver al Men\u00FA");
		btnVolverAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu b = new Menu();
				b.setLocationRelativeTo(null);
				b.setVisible(true);
				setVisible(false);
			}
		});
		btnVolverAlMen.setBounds(157, 213, 139, 23);
		contentPane.add(btnVolverAlMen);
	}

}
