package DAO;
import entities.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;


public class StateDAO {
	private final String url;
	private final String username;
	private final String password;
	
	public StateDAO(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	
	public State getState(int id) throws SQLException {
		final String sql = "SELECT * FROM states WHERE state_id = ?";
		
		State state = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			String name = rs.getString("name");
			int districts = rs.getInt("districts");
			
			state = new State(id, name, districts);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return state;
		
	}
	
	
	public List<State> getStates() throws SQLException {
		final String sql = "SELECT * FROM states ORDER BY state_id ASC";
		
		List<State> states = new ArrayList<>();
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("state_id");
			String name = rs.getString("name");
			int districts = rs.getInt("districts");
			
			states.add(new State(id, name, districts));
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return states;
	}
	
	
	public boolean insertState(String name, int districts) throws SQLException {
		final String sql = "INSERT INTO states (name, districts) " +
							"VALUES (?, ?)";
		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		pstmt.setString(1, name);
		pstmt.setInt(2, districts);
		
		int affected = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return affected == 1;
	}
	
	public boolean updateState(State state) throws SQLException {
		final String sql = "UPDATE states SET name = ?, districts = ? " +
							"WHERE state_id = ?";
		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, state.getName());
		pstmt.setInt(2, state.getDistricts());
		int affected = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return affected == 1;
	}
	
	private Connection getConnection() throws SQLException {
		final String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, username, password);
	}
}
