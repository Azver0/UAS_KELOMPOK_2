package com.itenas.oop.uas.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itenas.oop.uas.bean.Transaksi;
import com.itenas.oop.uas.bean.User;
import com.itenas.oop.uas.dao.TransaksiDAO;
import com.itenas.oop.uas.utils.DatabaseUtil;

public class TransaksiDaoImpl implements TransaksiDAO{
	public void setTransaksi(String username, Transaksi transaksi) {
		DatabaseUtil db = new DatabaseUtil();
		//User user = new User();
		try {
			db.connect();

			String query = "INSERT INTO Transaksi VALUES ("
					+ "'" + username + "',"
					+ "'" + transaksi.getGame() + "',"
					+ "'" + transaksi.getItem() + "',"
					+ "'" + transaksi.getPrice() + "');";
			
			db.executeQuery(query);
			System.out.println("Data Transaksi berhasil disimpan!");
		} catch (Exception ex) {
			System.out.println("The following error has occured : " + ex.getMessage());
		}

	}
	
	 public List<Transaksi> getAllTransaksi(){
		 List<Transaksi> listTransaksi = new ArrayList<Transaksi>();
		 DatabaseUtil db = new DatabaseUtil();
		 try {
			 db.connect();
		   
			 String query = "SELECT * FROM Transaksi";
		   
			 ResultSet rs = db.readData(query);
		   
			 while (rs.next()) {
		    
				 Transaksi Transaksi = new Transaksi();
				 User us = new User();
				 
				 Transaksi.setUsername(rs.getObject(1).toString());
				 Transaksi.setGame((rs.getObject(2).toString()));
				 Transaksi.setItem(rs.getObject(3).toString());
		         Transaksi.setPrice(Double.parseDouble(rs.getObject(4).toString()));
		         listTransaksi.add(Transaksi);
			 }
			  
			 db.disconnect();
			  
		 } catch (SQLException ex) {
			  System.out.println("Terjadi error: " + ex.getMessage());
		 }
		  
		  return listTransaksi;
	}
}
