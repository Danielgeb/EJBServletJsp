package com.example.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean /// optional
public class JdbcExample { // EJB lite also know as No-interface

	public List<Employee> doData(int deptId1) {
		String url = "jdbc:mysql://localhost:3306/hr";
		String username = "root";
		String password = "root";
		List<Employee> empList = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement st = con.prepareStatement("select * from employee where dept_id=?")) {
			
			st.setInt(1, deptId1);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("EMP_ID");
				String name = rs.getString("EMP_NAME");
				double salary = rs.getDouble("SALARY");
				int deptId = rs.getInt("DEPT_ID");
				empList.add(new Employee(id, name, salary, deptId));
			}
			// empList.stream().filter(e -> e.getDeptId() == 101).forEach(e ->
			// System.out.println(e));

		} catch (SQLException ss) {
			System.err.println(ss.toString());
		}
		return empList;

	}

}
