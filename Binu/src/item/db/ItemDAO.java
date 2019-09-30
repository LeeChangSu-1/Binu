package item.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ItemDAO {
	// 디비연결
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql="";
	
	private Connection getCon() throws Exception{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/model2");
		con = ds.getConnection();
		
		return con;
	}
	// 디비자원해제
	
	public void closeDB(){
		try {
			if(rs != null){ rs.close(); }
			if(pstmt != null){ pstmt.close(); }
			if(con != null){ con.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
