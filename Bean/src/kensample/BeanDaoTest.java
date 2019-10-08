package kensample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BeanDaoTest {

	private Connection connection;
	
	public BeanDaoTest() throws ClassNotFoundException, SQLException {
	String url = "jdbc:mysql://localhost:3306/mysql";
	String user = "root";
	String password = "123456";
	Class.forName("com.mysql.jdbc.Driver");
	connection = DriverManager.getConnection(url, user, password);
	
	
}
	
	public void close() {
		try {
			if(connection != null) {
				connection.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public EmpBean getEmpDataById(int empId)throws SQLException{
		EmpBean bean = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM employee WHERE employee_id= ?";
			pstatement = connection.prepareStatement(sql);
			
			pstatement.setInt(1, empId);
			
			rs = pstatement.executeQuery();
			
			if(rs.next()) {
				bean = new EmpBean();
				bean.setId(rs.getInt("employee_id"));
				bean.setName(rs.getString("employee_name"));
				bean.setAddress(rs.getString("employee_address"));
				bean.setAge(rs.getInt("employee_age"));
				bean.setMail(rs.getString("employee_mail"));
				
			}
			rs.close();
			
		}finally {
			pstatement.close();
		}
		return bean;
	}
	
	public ArrayList<EmpBean> getEmpDataByAge(int age1, int age2) throws SQLException{
		ArrayList<EmpBean> empData = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM employee WHERE employee_age BETWEEN ? AND ?";
			pstatement = connection.prepareStatement(sql);
			
			pstatement.setInt(1, age1);
			pstatement.setInt(2, age2);
			
			rs = pstatement.executeQuery();
			empData = new ArrayList<EmpBean>();
			
			
			while(rs.next()) {
				
				EmpBean bean = new EmpBean();
				bean = new EmpBean();
				bean.setId(rs.getInt("employee_id"));
				bean.setName(rs.getString("employee_name"));
				bean.setAddress(rs.getString("employee_address"));
				bean.setAge(rs.getInt("employee_age"));
				bean.setMail(rs.getString("employee_mail"));
				
				empData.add(bean);
				
			}
				rs.close();
					
		} finally {
			pstatement.close();
		}
		return empData;
	}
	
	
	
}
	
	
	
