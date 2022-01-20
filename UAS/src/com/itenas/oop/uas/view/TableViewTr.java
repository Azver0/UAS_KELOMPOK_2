package com.itenas.oop.uas.view;

import java.util.List;
import java.util.Scanner;

import com.itenas.oop.uas.bean.Transaksi;
import com.itenas.oop.uas.bean.User;
import com.itenas.oop.uas.dao.TransaksiDAO;
import com.itenas.oop.uas.dao.UserDAO;
import com.itenas.oop.uas.daoimpl.TransaksiDaoImpl;
import com.itenas.oop.uas.daoimpl.UserDaoImpl;

public class TableViewTr {
	public static void execute() {
		TransaksiDAO operation = new TransaksiDaoImpl();
		tableTransaksi(operation.getAllTransaksi());
	}
	
	public static void tableTransaksi(List<Transaksi> list) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("===================================================================================================");
		System.out.println("|                                            Data User                                            |");
		System.out.println("===================================================================================================");
		System.out.println("|        Username         |          Game           |         Item          |        Price        |");
		System.out.println("===================================================================================================");
		for (Transaksi transaksi : list) {
			System.out.println("| " + transaksi.getUsername() + " \t\t  | " + transaksi.getGame() + "\t    | " + transaksi.getItem() + "\t\t    | " + transaksi.getPrice() + "\t\t |");
		}
		System.out.println("===================================================================================================");
	}
}
