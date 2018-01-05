package com.revature.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public class TuitionDAO {
	final static Logger logger = Logger.getLogger(TuitionDAO.class);
	public static int login(String username, String password) {
		if(logger.isDebugEnabled()){
			logger.debug("This is debug enabled");
		}
		PreparedStatement ps = null;
		ResultSet rs=null;
		int value=-1;
		try(Connection conn =Connecting.getConnection()){
			System.out.println(username + " "+password);
			System.out.println("connected");
			String sql = "SELECT * FROM employees e WHERE e.email = ? AND e.password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				value = rs.getInt("EMPLOYEEID");
				System.out.println(value);
				System.out.println("congragulations you are logged in");
				return value;
			}
			else {
				System.out.println("what");
				return value;
			}
		}
		catch(Exception e) {
			System.out.println("failed");
			e.printStackTrace();
			
		}
		finally {
			if (ps != null) {
				try {
					ps.close();
				}
				catch(Exception e) {
					
				}
			}
		
	 if (rs!=null) {
		 try {
			 rs.close();
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
		}
		return value;
	}
	public static void createReimburse(int id, String location, String description, int cost, int typeid  ) throws SQLException, IOException {
		PreparedStatement ps= null;
		ResultSet rs = null;
		try(Connection conn =Connecting.getConnection()){
			System.out.println("connected reimburse");
			String sql = "insert into reimburse values (null, ?, null,  ?, ?, ?, ?, 1)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, location);
			ps.setString(3, description);
			ps.setInt(4, cost);
			ps.setInt(5, typeid);
			rs = ps.executeQuery();
		}
		catch(Exception e) {
			System.out.println("failed");
			e.printStackTrace();
			
		}
		finally {
			if (ps != null) {
				try {
					ps.close();
				}
				catch(Exception e) {
					
				}
			}
		
	 if (rs!=null) {
		 try {
			 rs.close();
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
		}
	}
	public static ArrayList<Reimburse> retrieveReimburse(int employeeid) throws SQLException, IOException{
		PreparedStatement ps= null;
		ResultSet rs = null;
		ArrayList<Reimburse> list = new ArrayList<Reimburse>();
		try (Connection conn = Connecting.getConnection()){
			System.out.println("connected");
			String sql = "Select * from reimburse r where ?=r.employeeid";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, employeeid);
			rs = ps.executeQuery();
			while (rs.next()) {
				int remid = rs.getInt("REIMBURSEID");
				String loc = rs.getString("LOCATIONS");
				String des = rs.getString("DESCRIPTION");
				Timestamp date = rs.getTimestamp("DATES");
				int costs = rs.getInt("COSTS");
				int type = rs.getInt("TYPEOfCLASS");
				int stage = rs.getInt("APPROVALSTAGE");
				Reimburse r = new Reimburse(remid,employeeid, date, loc, des, costs, type, stage);
				list.add(r);
			}
			System.out.print(list);
			return list;
		}
		catch(Exception e) {
			System.out.println("failed");
			e.printStackTrace();
		}
		finally {
			if (ps != null) {
				try {
					ps.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (rs!=null) {
				try {
					rs.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
}
