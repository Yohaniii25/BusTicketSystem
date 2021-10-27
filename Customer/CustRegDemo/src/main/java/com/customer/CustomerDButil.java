package com.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDButil {
	
	private static boolean isTrue;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	/*---------------------------------------------------------retrieve1--------------------------------------------------------*/
	
	//validate
	
	public static boolean validateVisit(String Email,String Password) {
		
			try {
				con = DBconnect.getConnection();
				stmt = con.createStatement();
				String sql = "select * from customer where Email='"+Email+"' and Password='"+Password+"'";
				rs = stmt.executeQuery(sql);
				
				if (rs.next()) {
					isTrue = true;
				} else {
					isTrue = false;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return isTrue;
		}
	
	public static boolean validateInsert(String Email) {
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customer where Email='"+Email+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isTrue = true;
			} else {
				isTrue = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isTrue;
	}
		
	
	
	/*---------------------------------------------------------Insert--------------------------------------------------------*/
	
	public static boolean insertCustomer(String Name,String Address,String Phone,String DateOfBirth,String Email,String Password) {
		boolean isTrue = false;
		
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into customer values (0,'"+Name+"','"+Address+"','"+Phone+"','"+DateOfBirth+"','"+Email+"','"+Password+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				
				isTrue = true;
			} else {
				isTrue = false;
			}
				
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return isTrue;
	}
	
	/*---------------------------------------------------------Update--------------------------------------------------------*/
	
	public static boolean UpdateCustomer (String id,String Name,String Address,String Phone,String DateOfBirth,String Email,String Password ) {
		
		try {
			
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			String sql = "update customer set Name='"+Name+"',Address='"+Address+"',Phone='"+Phone+"',DateOfBirth='"+DateOfBirth+"',Email='"+Email+"',Password='"+Password+"'"+"where id='"+id+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isTrue = true;
			} else {
				isTrue = false;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return isTrue;
	}
	
	/*---------------------------------------------------------retrieve2--------------------------------------------------------*/
	
	public static List <customer> getCustomerDetails(String Id) {
		
		int convertedID = Integer.parseInt(Id);
		
		ArrayList<customer> cus = new ArrayList<>();
		
		try {
			
			con=DBconnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customer where id = '"+convertedID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt(1);
				String Name = rs.getString(2);
				String Address = rs.getString(3);
				String Phone = rs.getString(4);
				String DateOfBirth = rs.getString(5);
				String Email = rs.getString(6);
				String Password = rs.getString(7);
				
				customer c = new customer(id,Name,Address,Phone,DateOfBirth,Email,Password);
				cus.add(c);
			}
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		return cus;
	}
	
	public static List <customer> getCustomer(String Email) {
		
		ArrayList<customer> cus = new ArrayList<>();
		
		try {
			
			con=DBconnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customer where Email= '"+Email+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt(1);
				String Name = rs.getString(2);
				String Address = rs.getString(3);
				String Phone = rs.getString(4);
				String DateOfBirth = rs.getString(5);
				String email = rs.getString(6);
				String Password = rs.getString(7);
				
				customer c = new customer(id,Name,Address,Phone,DateOfBirth,email,Password);
				cus.add(c);
			}
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		return cus;
	}
	
	
	
	/*---------------------------------------------------------Delete--------------------------------------------------------*/
	public static boolean deletecustomer(String id) {
		
		int convID = Integer.parseInt(id);
		
		try {
			
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			String sql = "delete from customer where id = '"+convID+"'";
			int rs = stmt.executeUpdate(sql); //result set
			
			if(rs>0) {
				isTrue = true;
			}
			else {
				isTrue = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isTrue;
	}
}
