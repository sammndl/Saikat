package com.register.dao;

import com.register.bean.*;
import com.register.util.*;

import java.sql.*;

public class RegisterUser {
	
	public String register(RegisterBean rb) {
		
		String name = rb.getName();
		String email = rb.getEmail();
		String address = rb.getAddress();
		String sex = rb.getSex();
		String phone = rb.getPhone();
		String password = rb.getPassword();
		
		Connection con = null;
		
		try {
			
			con = DatabaseCon.createConnection();
			String query ="INSERT INTO tbl_reg(reg_nm,reg_email,reg_adrs,reg_sex,reg_ph,reg_pass)VALUES('"+name+"','"+email+"','"+address+"','"+sex+"','"+phone+"','"+password+"')";
			
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery(query);
			
			rst.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return "SUCCESS";
	}

}
