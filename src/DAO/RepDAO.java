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


public class RepDAO {
	private final String url;
	private final String username;
	private final String password;
	
	public RepDAO(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	
	public Representative getRep(int id) throws SQLException {
		final String sql = "SELECT * FROM representatives WHERE rep_id = ?";
		
		Representative rep = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			String fName = rs.getString("fName");
			String lName = rs.getString("lName");
			String type = rs.getString("type");
			int district = rs.getInt("district");
			int stateID = rs.getInt("state_id");
			String party = rs.getString("party");
			
			rep = new Representative(id, fName, lName, type, stateID, district, party);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return rep;
		
	}
	
	
	public List<Representative> getReps() throws SQLException {
		final String sql = "SELECT * FROM representatives ORDER BY rep_id ASC";
		
		List<Representative> reps = new ArrayList<>();
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("rep_id");
			String fName = rs.getString("fName");
			String lName = rs.getString("lName");
			String type = rs.getString("type");
			int district = rs.getInt("district");
			int stateID = rs.getInt("state_id");
			String party = rs.getString("party");
			
			reps.add(new Representative(id, fName, lName, type, stateID, district, party));
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return reps;
	}
	
	public List<Representative> getReps(int stateID) throws SQLException {
		final String sql = "SELECT * FROM representatives WHERE state_id = ?" + " ORDER BY rep_id ASC";
		
		List<Representative> reps = new ArrayList<>();
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, stateID);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("rep_id");
			String fName = rs.getString("fName");
			String lName = rs.getString("lName");
			String type = rs.getString("type");
			int district = rs.getInt("district");
			String party = rs.getString("party");
			
			reps.add(new Representative(id, fName, lName, type, stateID, district, party));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return reps;
	}
	
	
	public boolean insertRep(String fName, String lName, String type, int stateID, int district, String party) throws SQLException {
		final String sql = "INSERT INTO reprsentatives (fName, lName, type, district, state_id, party) " +
							"VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		pstmt.setString(1, fName);
		pstmt.setString(2, lName);
		pstmt.setString(3, type);
		pstmt.setInt(4, stateID);
		pstmt.setInt(5, district);
		pstmt.setString(6, party);
		
		int affected = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return affected == 1;
	}
	
	public boolean updateRep(Representative rep) throws SQLException {
		final String sql = "UPDATE representatives SET fName = ?, lName = ?, type = ?, district = ?, state_id = ?, party = ?, " +
							"WHERE rep_id = ?";
		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		

		pstmt.setString(1, rep.getFName());
		pstmt.setString(2, rep.getLName());
		pstmt.setString(3, rep.getType());
		pstmt.setInt(4, rep.getDistrict());
		pstmt.setInt(5, rep.getState());
		pstmt.setString(6, rep.getParty());
		
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
