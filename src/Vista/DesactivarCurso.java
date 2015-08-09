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

public class DesactivarCurso extends JFrame {

	private JPanel contentPane;
	private JTextField textBuscar;
	private JTextField textDesactivar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesactivarCurso frame = new DesactivarCurso();
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
	public DesactivarCurso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJefeDeAdministracin = new JLabel("Director");
		lblJefeDeAdministracin.setFont(new Font("Comic Sans MS", Font.ITALIC, 22));
		lblJefeDeAdministracin.setBounds(162, 11, 162, 41);
		contentPane.add(lblJefeDeAdministracin);
		
		JLabel lblDesactivarCurso = new JLabel("Desactivar curso");
		lblDesactivarCurso.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		lblDesactivarCurso.setBounds(140, 52, 203, 23);
		contentPane.add(lblDesactivarCurso);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(52, 120, 78, 14);
		contentPane.add(lblCdigo);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(52, 216, 78, 14);
		contentPane.add(label);
		
		JLabel labelBuscar = new JLabel("");
		labelBuscar.setBounds(28, 163, 384, 20);
		contentPane.add(labelBuscar);
		
		JLabel lblBuscarCurso = new JLabel("Buscar curso");
		lblBuscarCurso.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		lblBuscarCurso.setBounds(54, 86, 113, 23);
		contentPane.add(lblBuscarCurso);
		
		JLabel label_2 = new JLabel("Desactivar curso");
		label_2.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		label_2.setBounds(54, 174, 113, 23);
		contentPane.add(label_2);
		
		textBuscar = new JTextField();
		textBuscar.setBounds(160, 117, 183, 20);
		contentPane.add(textBuscar);
		textBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cod = textBuscar.getText();
				
				ServicioCursoProxy buscar = new ServicioCursoProxy();
				try {
					if (textBuscar.getText().trim().length()!=0){
						int id = Integer.parseInt(cod);
						String []resultado = buscar.buscarCurso(id);
						String datos="|Nombre: "+resultado[0]+"|   |Estado curso: "+resultado[1]+"|   |Cant.cupos "+resultado[2]+"|";
						labelBuscar.setText(datos);
					} else {
						labelBuscar.setText("Debe llenar el campo");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(160, 140, 89, 23);
		contentPane.add(btnBuscar);
		
		textDesactivar = new JTextField();
		textDesactivar.setColumns(10);
		textDesactivar.setBounds(160, 213, 183, 20);
		contentPane.add(textDesactivar);
		
		JLabel labelDesactivar = new JLabel("");
		labelDesactivar.setBounds(28, 276, 384, 20);
		contentPane.add(labelDesactivar);
		
		JButton button = new JButton("Desactivar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cod = textDesactivar.getText();
				
				ServicioCursoProxy desactivar = new ServicioCursoProxy();
				try {
					if (textDesactivar.getText().trim().length()!=0){
						int id = Integer.parseInt(cod);
						String resultado = desactivar.desactivarCurso(id, "92749802");
						labelDesactivar.setText(resultado);
					} else {
						labelDesactivar.setText("Debe llenar el campo");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(160, 244, 113, 23);
		contentPane.add(button);
		
		
		
		JButton btnVolverAlMen = new JButton("Volver al Men\u00FA");
		btnVolverAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu b = new Menu();
				b.setLocationRelativeTo(null);
				b.setVisible(true);
				setVisible(false);
			}
		});
		btnVolverAlMen.setBounds(140, 307, 151, 23);
		contentPane.add(btnVolverAlMen);
	}

}
