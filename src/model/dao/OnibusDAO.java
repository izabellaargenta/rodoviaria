package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Onibus;

public class OnibusDAO {

	public void create(Onibus o) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO onibus(prefixo, horario_s, origem, horario_c, destino) VALUES(?,?,?,?,?)");
			stmt.setInt(1, o.getPrefixo());
			stmt.setString(2, o.getHorario_s());
			stmt.setString(3, o.getOrigem());
			stmt.setString(4, o.getHorario_c());
			stmt.setString(5, o.getDestino());
			
		
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");	
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar" + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Onibus> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Onibus> Onibus = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM onibus");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Onibus o = new Onibus();
				o.setIdOnibus(rs.getInt("idOnibus"));
				o.setHorario_s(rs.getString("horario_s"));
				o.setOrigem(rs.getString("origem"));
				o.setHorario_c(rs.getString("horario_c"));
				o.setDestino(rs.getString("destino"));
				o.setPrefixo(rs.getInt("prefixo"));
				
				Onibus.add(o);
				
				
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao exibir as informações do BD" + e);
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stmt,rs);
		}
		return Onibus;
	}
}
