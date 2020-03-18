package com.nwnu.yiqing.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nwnu.yiqing.entity.SchoolOffice;

public class SchoolOfficeDao extends BaseDao<SchoolOffice>{
	public SchoolOffice getAdmin(String name){
		SchoolOffice admin = null;
		String sql = "select * from schooloffice  where name = '" + name + "'";
		try {
			PreparedStatement prepareStatement = con.prepareStatement(sql);
			ResultSet executeQuery = prepareStatement.executeQuery();
			if(executeQuery.next()){
				admin = new SchoolOffice();
				admin.setId(executeQuery.getInt("id"));
				admin.setName(executeQuery.getString("name"));
				admin.setPassword(executeQuery.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}
	
}
