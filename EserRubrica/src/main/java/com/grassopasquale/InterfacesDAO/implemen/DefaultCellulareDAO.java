package com.grassopasquale.InterfacesDAO.implemen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.DbUtils;
import org.apache.log4j.Logger;

import com.grassopasquale.InterfacesDAO.CellulareDAO;
import com.grassopasquale.model.CellulareModel;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DefaultCellulareDAO implements CellulareDAO{
	
	final static Logger LOGGER = Logger.getLogger(DefaultCellulareDAO.class);
	final static String CELLULARE_INFO = "SELECT C.name,C.ram,C.cpu,C.displayPpi, C.displaySize,C.displayResolution,C.size,C.weight,B.name FROM Cellulare as C INNER JOIN Brand as B ON C.brand=B.id where C.id = ?;";
	final static String LISTA_CELLULARE="SELECT C.id,C.name,B.description FROM Cellulare as C INNER JOIN Brand as B ON C.brand=B.id";
	final static String SEARCH_INFO = "Select id From Cellulare where id=?;";
	final static String LIST_PHONE = "Select id,name From Cellulare;";
	
	
	private ArrayList<CellulareModel> listCell; 
	public void getListFromDB(){
		CellulareModel cellulareModel= new CellulareModel();
		 ArrayList<CellulareModel> listCell=new ArrayList<CellulareModel>();
		
		MysqlDataSource dataSource = new MysqlDataSource(); //TODO spring bean
		
			dataSource.setUser("root");
			dataSource.setPassword("root");
			dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
			
			Connection conn = null;
			
			try {
				
				conn = dataSource.getConnection();
			
				PreparedStatement stmtCellulareInfo = conn.prepareStatement(LIST_PHONE);
				
				
				ResultSet rsCellulareInfoSet = stmtCellulareInfo.executeQuery();
							
				if(rsCellulareInfoSet.first()){
					System.out.println("ok");
					do{
					cellulareModel.setCodice(rsCellulareInfoSet.getInt("id"));
					
					cellulareModel.setName(rsCellulareInfoSet.getString("name"));
					listCell.add(cellulareModel);
					}while(rsCellulareInfoSet.next());
					
				}
				//
				
			}
			
			catch(SQLException e) {
				LOGGER.error(e);
				
				
			}
			finally{
			    DbUtils.closeQuietly(conn); //oppure try with resource
			}
				
		
		
		
	}
	public void print(){
		for(CellulareModel a:listCell){
			a.StampaCodice();
		}
	}
	public CellulareModel getCellulareInfo(int codice) {

		
			CellulareModel cellulareModel= new CellulareModel();
			
			MysqlDataSource dataSource = new MysqlDataSource(); //TODO spring bean
			
				dataSource.setUser("root");
				dataSource.setPassword("root");
				dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
				
				Connection conn = null;
				
				try {
					
					conn = dataSource.getConnection();
				
					PreparedStatement stmtCellulareInfo = conn.prepareStatement(CELLULARE_INFO);
					stmtCellulareInfo.setInt(1, codice);
					
					ResultSet rsCellulareInfoSet = stmtCellulareInfo.executeQuery();
								
					if(rsCellulareInfoSet.first()){
						
						cellulareModel.setName(rsCellulareInfoSet.getString("C.name"));
						cellulareModel.setRam(rsCellulareInfoSet.getString("C.ram"));
						cellulareModel.setCpu(rsCellulareInfoSet.getString("C.CPU"));
						cellulareModel.setDisplayPpi(rsCellulareInfoSet.getString("C.displayPpi"));
						cellulareModel.setDisplaySize(rsCellulareInfoSet.getString("C.displaySize"));
						cellulareModel.setDisplayResolution(rsCellulareInfoSet.getString("C.displayResolution"));
						cellulareModel.setSize(rsCellulareInfoSet.getString("C.size"));
						cellulareModel.setWeight(rsCellulareInfoSet.getInt("C.weight"));
						cellulareModel.setBrandModello(rsCellulareInfoSet.getString("B.name"));
						
					}
					//while(rsCellulareInfoSet.next())
					
				}
				
				catch(SQLException e) {
					LOGGER.error(e);
					
					
				}
				finally{
				    DbUtils.closeQuietly(conn); //oppure try with resource
				}
					
			return cellulareModel;
	}
	

	public void updateCellulareInfo(int codice) {
		// TODO Auto-generated method stub
		
	}

	public void insertCellulare(CellulareModel cellulareModel) {
		// TODO Auto-generated method stub
		
	}
	

	public boolean searchCellulare(int phoneNumber) {
		boolean person_search = false;
		int num;
		MysqlDataSource dataSource = new MysqlDataSource();

		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			

			PreparedStatement stmtUserInfo = conn.prepareStatement(SEARCH_INFO);
			stmtUserInfo.setInt(1, phoneNumber);

			ResultSet rsCellulareInfoSet = stmtUserInfo.executeQuery();
			

			if (rsCellulareInfoSet.first()) {
				num = rsCellulareInfoSet.getInt("id");
				
				if (num==phoneNumber) {
					return person_search = true;
				}

			}

		} catch (SQLException e) {
			LOGGER.error(e);
			

		} finally {
			DbUtils.closeQuietly(conn); // oppure try with resource
		}
		return person_search;
	}

	public CellulareModel getCellulareInfo() {
		CellulareModel cellulareModel= new CellulareModel();
		
		MysqlDataSource dataSource = new MysqlDataSource(); //TODO spring bean
		
			dataSource.setUser("root");
			dataSource.setPassword("root");
			dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
			
			Connection conn = null;
			
			try {
				
				conn = dataSource.getConnection();
			
				PreparedStatement stmtCellulareInfo = conn.prepareStatement(LISTA_CELLULARE);
				
				
				ResultSet rsCellulareInfoSet = stmtCellulareInfo.executeQuery();
							
				if(rsCellulareInfoSet.first()){
					cellulareModel.setCodice(Integer.parseInt(rsCellulareInfoSet.getString("id")));
					cellulareModel.setName(rsCellulareInfoSet.getString("name"));
					cellulareModel.setSys(rsCellulareInfoSet.getString("B.description"));
					
					
					
				}
				
				
			}
			
			catch(SQLException e) {
				LOGGER.error(e);
				
			}
			finally{
			    DbUtils.closeQuietly(conn); //oppure try with resource
			}
				
		return cellulareModel;

		
		
	}

	

}
