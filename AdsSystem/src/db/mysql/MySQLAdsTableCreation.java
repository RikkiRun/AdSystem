package db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class MySQLAdsTableCreation {
	public static void main(String[] args) {
		//1. connection
		try {
			System.out.println("Connecting to " + MySQLDBUtil.URL);
			Class.forName("com.mysql.jdbc.Driver").getConstructor().newInstance(); // set up jdbc connection
			Connection conn = DriverManager.getConnection(MySQLDBUtil.URL);
			
			if(conn == null) {
				return;
			}
			
			Statement statement = conn.createStatement();
			// 2. drop table
			
			String sql = "DROP TABLE IF EXISTS ad";
			statement.executeUpdate(sql);
			
			sql = "DROP TABLE IF EXISTS advertiser";
			statement.executeUpdate(sql);
			
			// 3. create table
			// create advertiser table
			 sql = "CREATE TABLE advertiser ("
					 + "advertiser_id int NOT NULL AUTO_INCREMENT,"
					 + "name VARCHAR(255),"
					 + "budget FLOAT," 
					 + "PRIMARY KEY (advertiser_id)"
					 + ")";
			 
			 System.out.println(sql);
			 statement.executeUpdate(sql);
			 
			 // create ad table
			 sql = "CREATE TABLE ad ("
						+ "ad_id int NOT NULL AUTO_INCREMENT,"
						+ "bid FLOAT,"
						+ "image_url VARCHAR(2083),"
						+ "advertiser_id int NOT NULL,"
						+ "ad_score float,"
						+ "PRIMARY KEY (ad_id),"
						+ "FOREIGN KEY (advertiser_id) REFERENCES advertiser(advertiser_id)"
						+ ")";
				
				System.out.println(sql);
				statement.executeUpdate(sql);
				System.out.println("Import done successfully");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//1:14
	

}
