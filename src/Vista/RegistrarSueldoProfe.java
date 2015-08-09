package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import serviciosueldo.ServicioSueldoProxy;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

public class RegistrarSueldoProfe extends JFrame {

	private JPanel contentPane;
	private JTextField textProfesor;
	private JTextField textMes;
	private JTextField textJefe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarSueldoProfe frame = new RegistrarSueldoProfe();
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
	public RegistrarSueldoProfe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		
		textProfesor = new JTextField();
		textProfesor.setColumns(10);
		textProfesor.setBounds(164, 91, 266, 20);
		panel.add(textProfesor);
		
		JLabel label_1 = new JLabel("Registrar sueldo profesor");
		label_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		label_1.setBounds(172, 52, 258, 30);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Director");
		label_2.setFont(new Font("Comic Sans MS", Font.ITALIC, 22));
		label_2.setBounds(197, 11, 126, 30);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Rut Jefe Adm");
		label_3.setBounds(41, 125, 85, 14);
		panel.add(label_3);
		
		JLabel label_5 = new JLabel("Rut Profesor:");
		label_5.setBounds(41, 94, 113, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Mes: ");
		label_6.setBounds(51, 156, 103, 14);
		panel.add(label_6);
		
		textMes = new JTextField();
		textMes.setColumns(10);
		textMes.setBounds(164, 153, 266, 20);
		panel.add(textMes);
		
		textJefe = new JTextField();
		textJefe.setColumns(10);
		textJefe.setBounds(164, 122, 266, 20);
		panel.add(textJefe);
		
		JLabel labelResultado = new JLabel("");
		labelResultado.setBounds(111, 218, 307, 20);
		panel.add(labelResultado);
		
		JButton button_1 = new JButton("Regitrar sueldo");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rutProfe = textProfesor.getText();
				String rutJefeAdm = textJefe.getText();
				String mes = textMes.getText();
				
				ServicioSueldoProxy pagar = new ServicioSueldoProxy();
				try {
					if ((textProfesor.getText().trim().length()!=0)&&(textJefe.getText().trim().length()!=0)
							&&(textMes.getText().trim().length()!=0)){
						
						int MM = Integer.parseInt(mes);
						String resultado = pagar.registrarSueldoProf(rutProfe, rutJefeAdm, MM);
						labelResultado.setText(resultado);
					} else {
						labelResultado.setText("Debe completar todos los campos");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_1.setBounds(164, 184, 173, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Volver al Men\u00FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu b = new Menu();
				b.setLocationRelativeTo(null);
				b.setVisible(true);
				setVisible(false);
			}
		});
		button_2.setBounds(197, 249, 126, 23);
		panel.add(button_2);
	}

}
