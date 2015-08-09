package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import serviciomensualidad.ServicioMensualidadProxy;
public class MorososMensualidad extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MorososMensualidad frame = new MorososMensualidad();
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
	public MorososMensualidad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblSecretaria = new JLabel("Director");
		lblSecretaria.setFont(new Font("Comic Sans MS", Font.ITALIC, 22));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mes", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		
		JLabel lblMorososMensualidad = new JLabel("Morosos Mensualidad");
		lblMorososMensualidad.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		
		JLabel labelResultado = new JLabel("");
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visible();
				int dato = comboBox.getSelectedIndex();
				if(dato>0){
					ServicioMensualidadProxy morososMens = new ServicioMensualidadProxy();
					
					String[][] matriz;
					Gson gson = new Gson();
					String jsonMorosos;
					try {
						jsonMorosos = morososMens.obtenerListMorososMensualidad(dato);
						if(jsonMorosos!=null){
							matriz = gson.fromJson(jsonMorosos, String[][].class);
							Object [] fila = new Object[4]; fila[0] = "unal";
							
							for (int i = 0; i < matriz.length; i++) {
							fila[0] = matriz[i][0];
							fila[1] = matriz[i][1];
							fila[2] = matriz[i][2];
							fila[3] = matriz[i][3];

						
							((DefaultTableModel) table.getModel()).addRow(fila);
						}
							
						}else {
							labelResultado.setText("La tabla se encuentra vacía de momento");
					
					}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		JButton btnVolverAlMen = new JButton("Volver al Men\u00FA");
		btnVolverAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu b = new Menu();
				b.setLocationRelativeTo(null);
				b.setVisible(true);
				setVisible(false);
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(172, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(btnVer, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(190))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(200)
					.addComponent(lblMorososMensualidad)
					.addContainerGap(216, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(68, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(233, Short.MAX_VALUE)
					.addComponent(lblSecretaria, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(180))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(222, Short.MAX_VALUE)
					.addComponent(btnVolverAlMen, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(217))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(171)
					.addComponent(labelResultado, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(141, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addComponent(lblSecretaria, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMorososMensualidad)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVer)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelResultado, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnVolverAlMen)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		table = new JTable();
		visible();
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
	
	}
	
	public  void visible(){
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Rut estudiante", "Cant. Cursos", "Mes", "Monto"
				}
			));
	}
}
