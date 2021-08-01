package com.login.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.register.bean.*;
import com.register.util.DatabaseCon;

public class LoginUser {
	
	String email;
	String password;
	
	public String loginBean(RegisterBean lg) throws IOException{
		
		String tyemail = lg.getEmail();
		String typassword = lg.getPassword();
		
		
		Connection con = null;
		
try {
			
			con = DatabaseCon.createConnection();
			String query ="SELECT reg_email,reg_pass FROM tbl_reg WHERE reg_email='"+tyemail+"'";
			
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery(query);
			while(rst.next()) {
				 email = rst.getString("reg_email");
				 password = rst.getString("reg_pass");
			
			}
		if(tyemail.equals(email) && typassword.equals(password)) {
	
					return "SUCCESS";
			}
		 }catch(Exception e) {
			 System.out.println(e);
		 }
					return "Failed";
	}

}
