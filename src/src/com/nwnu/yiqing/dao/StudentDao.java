package com.nwnu.yiqing.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nwnu.yiqing.entity.Student;

public class StudentDao extends BaseDao<Student> {
	/**
	 * 根据用户名查找用户信息
	 * @param name
	 * @return
	 */
	public Student getStudent(String name){
		Student student = null;
		String sql = "select * from admin where name = '" + name + "'";
		try {
			PreparedStatement prepareStatement = con.prepareStatement(sql);
			ResultSet executeQuery = prepareStatement.executeQuery();
			if(executeQuery.next()){
				student = new Student();
				student.setId(executeQuery.getInt("id"));
				student.setName(executeQuery.getString("name"));
				student.setPassword(executeQuery.getString("password"));
				//student.setStatus(executeQuery.getInt("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
}
