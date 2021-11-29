package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Onibus;

public class OnibusDAO {

	public void create(Onibus o) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO filme(idOnibus, horario_s, origem, horario_c, destino) VALUES(?,?,?,?,?)");
			stmt.setInt(1, o.getIdOnibus());
			stmt.setInt(2, o.getHorario_s());
			stmt.setString(3, o.getOrigem());
			stmt.setInt(4, o.getHorario_c());
			stmt.setString(5, o.getDestino());
			
		
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");	
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar" + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
