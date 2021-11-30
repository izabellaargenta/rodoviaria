package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Onibus;
import model.dao.OnibusDAO;

import javax.swing.JButton;

public class JFListarOnibus extends JFrame {

	private JPanel contentPane;
	private JTable JTOnibus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarOnibus frame = new JFListarOnibus();
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
	public JFListarOnibus() {
		setTitle("Listar \u00D4nibus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar \u00D5nibus");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 389, 32);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 54, 642, 234);
		contentPane.add(scrollPane);
		
		JTOnibus = new JTable();
		JTOnibus.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"idOnibus", "Hor\u00E1rio Sa\u00EDda", "Origem", "Hor\u00E1rio Chegada", "Destino"
			}
		));
		scrollPane.setViewportView(JTOnibus);
		
		JButton btnNewButton = new JButton("Cadastrar Filme");
		btnNewButton.setBounds(20, 316, 167, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Alterar \u00D4nibus");
		btnNewButton_1.setBounds(256, 318, 152, 28);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Excluir \u00D4nibus");
		btnNewButton_2.setBounds(481, 316, 167, 28);
		contentPane.add(btnNewButton_2);
		
		readJTable();
	}
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) JTOnibus.getModel();
		modelo.setNumRows(0);
		OnibusDAO odao =  new OnibusDAO();
		for(Onibus o : odao.read()) {
			modelo.addRow(new Object[]{
				o.getIdOnibus(),
				o.getHorario_s(),
				o.getOrigem(),
				o.getHorario_c(),
				o.getDestino()
				
			});
		}
	}
}