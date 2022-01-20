package com.itenas.oop.uas.dao;

import java.util.List;

import com.itenas.oop.uas.bean.Transaksi;

public interface TransaksiDAO {
	public void setTransaksi(String username, Transaksi transaksi);
	public List<Transaksi> getAllTransaksi();
}
