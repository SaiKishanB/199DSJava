package com.mph.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mph.model.Employee;
import com.mph.util.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	List<Employee> emplist;
	Employee employee;

	@Override
	public List<Employee> getAllEmployees() {
		emplist = new ArrayList<Employee>();

		connection = DBConnection.getMyDbConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from mphemp");
			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmpno(resultSet.getInt("empno"));
				employee.setEname(resultSet.getString("ename"));
				employee.setDept(resultSet.getString("dept"));
				emplist.add(employee);
			}
			System.out.println("Emp List from DAO " + emplist);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return emplist;
	}

	@Override
	public Employee getEmployee(int eno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Employee emp) {
		boolean flag = false;
		connection = DBConnection.getMyDbConnection();
		try {
			preparedStatement = connection.prepareStatement("insert into mphemp(empno,ename,dept) values(?,?,?)");
			preparedStatement.setInt(1, emp.getEmpno());
			preparedStatement.setString(2, emp.getEname());
			preparedStatement.setString(3, emp.getDept());
			int noofrows = preparedStatement.executeUpdate();
			System.out.println(noofrows + " inserted in DB successfully ");
			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int eno) {
		boolean flag = false;
		connection = DBConnection.getMyDbConnection();
		try {
			preparedStatement = connection.prepareStatement("delete from mphemp where empno="+eno);
			int noofrows = preparedStatement.executeUpdate();
			System.out.println(eno + " deleted in DB successfully ");
			if(noofrows>=1)
			{
			flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}