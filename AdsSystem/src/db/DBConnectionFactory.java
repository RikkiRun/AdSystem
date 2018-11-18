package db;

import db.mysql.MySQLConnection;

public class DBConnectionFactory {
	// This should change based on the pipeline.
	private static final String DEFAULT_DB = "mysql";
	
	public static DBConnection getConnection(String db) {
		switch (db) {
		case "mysql":
			return new MySQLConnection();
		case "mongodb":
			// return new MongoDBConnection();
			return null;
		default:
			throw new IllegalArgumentException("Invalid db: " + db);
		}
	}
	
	public static DBConnection getConnection() {
		return getConnection(DEFAULT_DB);
		
	}
}


// factory: 把所有的configuration集中在一个地方  以后要连其他数据库的时候只需要加一个case. 
// factory可以更好的extend数据库
