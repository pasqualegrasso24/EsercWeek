package com.grassopasquale.InterfacesDAO.implemen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.log4j.Logger;

import com.grassopasquale.InterfacesDAO.BrandDAO;
import com.grassopasquale.model.BrandModel;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DefaultBrandDAO implements BrandDAO{
	
	final static Logger logger = Logger.getLogger(DefaultBrandDAO.class);
	final static String BRAND_INFO = "SELECT name,description,company FROM Brand where number = ?;"; 


	public BrandModel getBrandInfo(String name_brand) {
		BrandModel brandModel= new BrandModel();
		
		MysqlDataSource dataSource = new MysqlDataSource(); //TODO spring bean
		
			dataSource.setUser("root");
			dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
			
			Connection conn = null;
			
			try {
				
				conn = dataSource.getConnection();
			
				PreparedStatement stmtBrandInfo = conn.prepareStatement(BRAND_INFO);
				stmtBrandInfo.setString(1, name_brand);
				
				ResultSet rsBrandInfoSet = stmtBrandInfo.executeQuery();
							
				if(rsBrandInfoSet.first()){
					
					brandModel.setName(rsBrandInfoSet.getString("name"));
					brandModel.setDescription(rsBrandInfoSet.getString("description"));
					brandModel.setCompany(rsBrandInfoSet.getString("company"));
					
				}
				
			}
			
			catch(SQLException e) {
				logger.error(e);			
			}
			finally{
			    DbUtils.closeQuietly(conn); //oppure try with resource
			}
				
		return brandModel;
	}

	public void updateBrandInfo(String name_brand) {
		// TODO Auto-generated method stub
		
	}

	public void insertBrand(BrandModel brandModel) {
		// TODO Auto-generated method stub
		
	}

}
