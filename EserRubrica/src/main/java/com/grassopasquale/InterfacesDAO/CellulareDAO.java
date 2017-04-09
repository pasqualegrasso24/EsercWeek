package com.grassopasquale.InterfacesDAO;

import java.util.ArrayList;

import com.grassopasquale.model.CellulareModel;

public interface CellulareDAO {
	
	public CellulareModel getCellulareInfo(int codice);
	public void updateCellulareInfo(int name_cell);
	public void insertCellulare(CellulareModel cellulareModel);
	public CellulareModel getCellulareInfo();
	public boolean searchCellulare(int phoneNumber);
	public void getListFromDB();
	public void print();
	

}
