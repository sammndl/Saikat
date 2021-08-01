package com.login.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.register.bean.RegisterBean;
import com.register.util.DatabaseCon;

public class ProfileDao {

	String setNm;
	
	public String proBean(RegisterBean pbn) {
		
			String name = pbn.getEmail();
			
			Connection con = null;
			
			try {
				
				con = DatabaseCon.createConnection();
				String query ="SELECT reg_nm FROM tbl_reg WHERE reg_email='"+name+"'";
				
				Statement stmt = con.createStatement();
				ResultSet rst = stmt.executeQuery(query);
				while(rst.next()) {
					 setNm = rst.getString("reg_nm");
				}
				
			}
			catch(Exception e) {
				
				System.out.println(e);
				
			}
			
			return setNm;		
	}

}
