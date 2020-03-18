package com.nwnu.yiqing.dao;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.nwnu.yiqing.entity.Collegeadmin;
import com.nwnu.yiqing.entity.yiqing;

public class yiqingDao extends BaseDao<yiqing> {
	public boolean updateyiqing(String College){
		String sql = " update yiqing set state ='ÒÑÉóºË' where college='"+College+"' ";
		try {
			PreparedStatement prepareStatement = (PreparedStatement) con.prepareStatement(sql);
			return prepareStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
