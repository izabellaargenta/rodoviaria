package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Onibus;
import model.dao.OnibusDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				readJTable();
			}
		});
		setTitle("Lista \u00D4nibus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Listagem dos Ônibus");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 389, 32);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 54, 642, 234);
		contentPane.add(scrollPane);
		
		JTOnibus = new JTable();
		JTOnibus.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"idOnibus","Prefixo", "Horário Saída", "Origem", "Horário Chegada", "Destino"
			}
		));
		scrollPane.setViewportView(JTOnibus);
		
		JButton btnNewButton = new JButton("Cadastrar Ônibus");
		btnNewButton.setBounds(20, 316, 167, 32);
		contentPane.add(btnNewButton);
		
		JButton btnAlterarOnibus = new JButton("Alterar Ônibus");
		btnAlterarOnibus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//verificar linha selecionada
				if(JTOnibus.getSelectedRow()!= -1) {
					JFAtualizarOnibus ao = new JFAtualizarOnibus((int)JTOnibus.getValueAt(JTOnibus.getSelectedRow(),0));
					ao.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um onibus");
				}
				readJTable();
			}
		});
		btnAlterarOnibus.setBounds(256, 318, 152, 28);
		contentPane.add(btnAlterarOnibus);
		
		JButton btnExcluirOnibus = new JButton("Excluir Ônibus");
		btnExcluirOnibus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JTOnibus.getSelectedRow()!= -1) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o ônibus selecionado?","Exclusão" , JOptionPane.YES_NO_OPTION);
					if(opcao == 0) {
					OnibusDAO dao = new OnibusDAO();
					Onibus o = new Onibus();
					o.setIdOnibus((int)JTOnibus.getValueAt(JTOnibus.getSelectedRow(),0));
					dao.delete(o);
				  }
			}else {
				JOptionPane.showMessageDialog(null, "Selecione um onibus!");
				
			   }
				readJTable();
			}
		});
		btnExcluirOnibus.setBounds(481, 316, 167, 28);
		contentPane.add(btnExcluirOnibus);
		
		readJTable();
	}
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) JTOnibus.getModel();
		modelo.setNumRows(0);
		OnibusDAO odao =  new OnibusDAO();
		for(Onibus o : odao.read()) {
			modelo.addRow(new Object[]{
				o.getIdOnibus(),
				o.getPrefixo(),
				o.getHorario_s(),
				o.getOrigem(),
				o.getHorario_c(),
				o.getDestino()
				
			});
		}
	}
}