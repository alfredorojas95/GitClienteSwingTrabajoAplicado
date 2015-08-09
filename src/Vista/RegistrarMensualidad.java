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

import serviciomatricula.ServicioMatriculaProxy;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import serviciomensualidad.ServicioMensualidadProxy;

public class RegistrarMensualidad extends JFrame {

	private JPanel contentPane;
	private JTextField textRut;
	private JTextField textMes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarMensualidad frame = new RegistrarMensualidad();
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
	public RegistrarMensualidad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Secretaria");
		label.setFont(new Font("Comic Sans MS", Font.ITALIC, 22));
		label.setBounds(144, 21, 171, 41);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Registrar pago de mensualidad");
		label_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		label_1.setBounds(110, 62, 228, 20);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Rut estudiante:");
		label_2.setBounds(34, 109, 102, 14);
		panel.add(label_2);
		
		textRut = new JTextField();
		textRut.setColumns(10);
		textRut.setBounds(144, 106, 194, 20);
		panel.add(textRut);
		
		JLabel labelMensualidad = new JLabel("");
		labelMensualidad.setBounds(77, 192, 277, 20);
		panel.add(labelMensualidad);
		
		JButton button = new JButton("Pagar mensualidad");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rutEs = textRut.getText();
				String mes = textMes.getText();
				
				ServicioMensualidadProxy pagarMensualidad = new ServicioMensualidadProxy();
				
				String resultado="";
				try {
					if ((textRut.getText().trim().length()!=0)&&(textMes.getText().trim().length()!=0)){
						int num = Integer.parseInt(mes);
						resultado =pagarMensualidad.regPagoMensualidad(rutEs, "165643214", num);
						labelMensualidad.setText(resultado);
					} else {
						labelMensualidad.setText("Debe llenar los campo");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(144, 158, 171, 23);
		panel.add(button);
		
	
		
		JButton button_1 = new JButton("Volver al Men\u00FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu b = new Menu();
				b.setLocationRelativeTo(null);
				b.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(155, 217, 139, 23);
		panel.add(button_1);
		
		textMes = new JTextField();
		textMes.setBounds(144, 127, 194, 20);
		panel.add(textMes);
		textMes.setColumns(10);
		
		JLabel label_4 = new JLabel("Mes:");
		label_4.setBounds(34, 130, 102, 14);
		panel.add(label_4);
	}

}
