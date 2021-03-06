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
			JOptionPane.showMessageDialog(null, "Erro ao exibir as informações do BD "+ e);
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stmt,rs);
		}
		return Onibus;
	}
	
	public void delete(Onibus o) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM onibus WHERE idOnibus=?");
			stmt.setInt(1, o.getIdOnibus());
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Onibus excluído com sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	public Onibus read (int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Onibus o = new Onibus();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM onibus WHERE idOnibus=? LIMIT 1;");
			stmt.setInt(1, id);
			rs =  stmt.executeQuery();
			if(rs != null && rs.next()) {
				o.setIdOnibus(rs.getInt("idOnibus"));
				o.setOrigem(rs.getString("origem"));
				o.setDestino(rs.getString("destino"));
				o.setHorario_c(rs.getString("horario_c"));
				o.setHorario_s(rs.getString("horario_s"));
				o.setPrefixo(rs.getInt("prefixo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return o;
	}
	
	public void update(Onibus o) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE onibus SET prefixo=?, horario_s=?, origem=?, horario_c=?, destino=? WHERE idOnibus=?;");
			stmt.setInt(1, o.getPrefixo());
			stmt.setString(2, o.getHorario_s());
			stmt.setString(3, o.getOrigem());
			stmt.setString(4, o.getHorario_c());
			stmt.setString(5, o.getDestino());
			stmt.setInt(6, o.getIdOnibus());
		
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");	
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar" + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
}
