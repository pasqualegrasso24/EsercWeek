package com.grassopasquale.InterfacesDAO.implemen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.log4j.Logger;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.grassopasquale.InterfacesDAO.PersonDAO;
import com.grassopasquale.model.BrandModel;
import com.grassopasquale.model.CellulareModel;
import com.grassopasquale.model.PersonModel;

public class DefaultPersonDAO implements PersonDAO {

	final static Logger LOGGER = Logger.getLogger(DefaultPersonDAO.class);
	final static String USER_INFO = "SELECT P.num_cell,P.name,P.cognome,P.email,P.indirizzo,C.name FROM Persona as P INNER JOIN Cellulare as C ON P.telefono=C.id WHERE P.num_cell= ?;";
	final static String INSERT_INFO = "INSERT INTO Persona(num_cell,name,cognome,email,indirizzo,telefono) VALUE (?, ?, ?, ?, ?,?);";
	final static String SEARCH_INFO = "SELECT num_cell From Persona where num_cell=?;";
	final static String UPDATE_INFO = "UPDATE Persona SET num_cell = ? WHERE num_cell = ? ;";
	final static String DELETE_INFO = "DELETE FROM Persona WHERE num_Cell = ? ;";
	
	final static String PHONE_INFO ="SELECT P.num_cell,P.name,P.cognome,C.name,C.ram,C.cpu,C.displayPpi,C.displaySize,C.displayResolution,C.size,C.weight,B.name,B.description FROM Persona as P INNER JOIN Cellulare as C ON P.telefono=C.id INNER JOIN Brand as B ON C.brand=B.id  WHERE P.num_cell= ?;"; 
		//	"Select P.num_cell,P.name,P.cognome, C.name,C.ram,C.cpu,C.displayPpi,C.displaySize,C.displayResolution,C.size,C.weight"
			//							+"FROM Persona as P INNER JOIN Cellulare as C ON P.telefono=C.id WHERE P.num_cell= ?;";
	

	public boolean searchPerson(String phoneNumber) {
		boolean person_search = false;
		String num;
		MysqlDataSource dataSource = new MysqlDataSource();

		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			

			PreparedStatement stmtUserInfo = conn.prepareStatement(SEARCH_INFO);
			stmtUserInfo.setString(1, phoneNumber);

			ResultSet rsUserInfoSet = stmtUserInfo.executeQuery();
			

			if (rsUserInfoSet.first()) {
				num = rsUserInfoSet.getString("num_cell");
				System.out.println("personDAO" + num);
				if (num.equalsIgnoreCase(phoneNumber)) {
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

	public PersonModel getPersonInfo(String num_cell) {

		PersonModel personModel = new PersonModel();

		MysqlDataSource dataSource = new MysqlDataSource();

		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");

		Connection conn = null;

		try {

			conn = dataSource.getConnection();

			PreparedStatement stmtUserInfo = conn.prepareStatement(USER_INFO);
			stmtUserInfo.setString(1, num_cell);

			ResultSet rsUserInfoSet = stmtUserInfo.executeQuery();

			if (rsUserInfoSet.first()) {
				personModel.setNum_cell(rsUserInfoSet.getString("P.num_cell"));
				personModel.setName(rsUserInfoSet.getString("P.name"));
				personModel.setSurname(rsUserInfoSet.getString("P.cognome"));
				personModel.setEmail(rsUserInfoSet.getString("P.email"));
				personModel.setIndirizzo(rsUserInfoSet.getString("P.indirizzo"));
				personModel.setTelefonoModello(rsUserInfoSet.getString("C.name"));
			}

		}

		catch (SQLException e) {
			LOGGER.error(e);
			

		} finally {
			DbUtils.closeQuietly(conn); 
		}

		return personModel;
	}
	
	public PersonModel getPersonCellInfo(String phoneNumber){
		PersonModel personModel = new PersonModel();
		CellulareModel cellularModel=new CellulareModel();
		BrandModel brandModel= new BrandModel();
		
		MysqlDataSource dataSource = new MysqlDataSource();

		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");

		Connection conn = null;

		try {

			conn = dataSource.getConnection();

			PreparedStatement stmtUserInfo = conn.prepareStatement(PHONE_INFO);
			stmtUserInfo.setString(1, phoneNumber);

			ResultSet rsUserInfoSet = stmtUserInfo.executeQuery();

			if (rsUserInfoSet.first()) {
				personModel.setNum_cell(rsUserInfoSet.getString("P.num_cell"));
				personModel.setName(rsUserInfoSet.getString("P.name"));
				personModel.setSurname(rsUserInfoSet.getString("P.cognome"));				
				cellularModel.setName(rsUserInfoSet.getString("C.name"));
				cellularModel.setRam(rsUserInfoSet.getString("C.cpu"));
				cellularModel.setCpu(rsUserInfoSet.getString("C.cpu"));
				cellularModel.setDisplayPpi(rsUserInfoSet.getString("C.displayPpi"));
				cellularModel.setDisplaySize(rsUserInfoSet.getString("C.displaySize"));
				cellularModel.setDisplayResolution(rsUserInfoSet.getString("C.displayResolution"));
				cellularModel.setSize(rsUserInfoSet.getString("C.size"));
				cellularModel.setWeight(rsUserInfoSet.getInt("C.weight"));
				brandModel.setName(rsUserInfoSet.getString("B.name"));
				brandModel.setDescription(rsUserInfoSet.getString("B.description"));
				cellularModel.setBrand(brandModel);
				personModel.setTelefono(cellularModel);
			}

		}

		catch (SQLException e) {
			LOGGER.error(e);
			

		} finally {
			DbUtils.closeQuietly(conn); 
		}

		return personModel;
	}

	public boolean updatePersonInfo(String numberOld,String numberNew) {
		
	        MysqlDataSource dataSource = new MysqlDataSource();
	        dataSource.setUser("root");
	        dataSource.setPassword("root");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
	        Connection conn = null;
	        try {
	            conn = dataSource.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(UPDATE_INFO);
	            stmt.setString(1, numberNew);
	            stmt.setString(2, numberOld);
	            if (stmt.executeUpdate() > 0) {
	                return true;
	            }
	        } catch (SQLException e) {
	        	LOGGER.error(e);
	        } finally {
	            DbUtils.closeQuietly(conn);
	        }
	        return false;
	}

	public boolean insertUser(PersonModel personModel) {
		
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();      
           
                PreparedStatement stmt = conn.prepareStatement(INSERT_INFO);
                stmt.setString(1, personModel.getNum_cell());
                stmt.setString(2, personModel.getName());
                stmt.setString(3, personModel.getSurname());
                stmt.setString(4, personModel.getEmail());
                stmt.setString(5, personModel.getIndirizzo());
                stmt.setInt(6,personModel.getCodiceTel());
                if (stmt.executeUpdate() > 0) {
                    return true;
                }
            //}
        } catch (SQLException e) {
        	LOGGER.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return false;

	}
	
	public boolean deletePersonInfo(String number){
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();      
           
            conn = dataSource.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement(DELETE_INFO);
            stmt.setString(1, number);
            if (stmt.executeUpdate() > 0) {
                return true;
            }
            //}
        } catch (SQLException e) {
        	LOGGER.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return false;
		
	}

}
