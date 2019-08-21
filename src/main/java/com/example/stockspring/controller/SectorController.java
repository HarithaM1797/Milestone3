package com.example.stockspring.controller;

import java.sql.SQLException;
import java.util.List;

import com.example.stockspring.model.Sector;


public interface SectorController {
	public Sector Insert (Sector sector)throws ClassNotFoundException, SQLException;
	public List<Sector> GetAllSector()throws ClassNotFoundException, SQLException;
}
