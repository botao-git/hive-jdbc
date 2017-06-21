package com.hive.sample;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TestJdbc {
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";

	public static void main(String[] args) {

		try {
			Class.forName(driverName);

			Connection con = DriverManager.getConnection("jdbc:hive2://192.168.0.113:10000/default", "root", "");
			Statement stmt = con.createStatement();

//			ResultSet res = stmt.executeQuery("select * from test");
//			ResultSet res = stmt.executeQuery("show tables");
			ResultSet res = stmt.executeQuery("select count(*) from t_hive");
			while(res.next()){
				//System.out.println(res.getString("t_data")+","+res.getString("t_sales")+","+res.getString("t_profits"));
				//System.out.println(res.getString("tab_name"));
				//System.out.println(res);//[t_hive.id, t_hive.name, t_hive.sex, t_hive.class, t_hive.age, t_hive.time, t_hive.indatetime, t_hive.address]
				//System.out.println(res.getString("t_hive.id"));
				System.out.println(res.getString(1));
			}
			
			System.out.println("Operation done successfully.");

			con.close();
		} catch (ClassNotFoundException e) {
			System.err.println("class not found!!!!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("sql exception!!!");
			e.printStackTrace();
		}

	}
}