package com.bean.aop.proxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.aop.model.Person;

public class PersonJ {

	public void update(Person person) {
		try {
		Connection con=DBConnection.getConnection();
		PreparedStatement pre=con.prepareStatement("update person set email=?, contact=?, name=? where id=?");
		pre.setString(1,person.getEmail());
		pre.setString(2,person.getContact());
		pre.setString(3,person.getName());
		pre.setInt(4,person.getId());
		pre.execute();
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String get() {
		try {
		Connection con=DBConnection.getConnection();
		PreparedStatement pre=con.prepareStatement("select * from person");
		ResultSet rs=		pre.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("email"));
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	return null;
	}
}
