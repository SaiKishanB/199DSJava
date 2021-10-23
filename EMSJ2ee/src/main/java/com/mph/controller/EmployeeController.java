package com.mph.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mph.dao.EmployeeDao;
import com.mph.dao.EmployeeDaoImpl;
import com.mph.model.Employee;

/**
 * Servlet implementation class EmployeeController
 */

public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDao dao;
	RequestDispatcher rd;

	public EmployeeController() {
		dao = new EmployeeDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("From do get()");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("Hello All");
		out.println("<html>");
		out.println("<head><title>Hello Page</title>");
		out.println("</head>");
		out.println("<body>");

		String action = request.getParameter("action");

		switch (action) {
		case "LIST": {
			listEmployee(request, response);
		}
		
		case "DELETE": {
			deleteEmployee(request, response);
		}
		}

		out.println("</body>");
		out.println("</html>");
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eid = Integer.parseInt(request.getParameter("eid"));
		if(dao.delete(eid))
		{
			request.setAttribute("NOTIFICATION", "Employee Deleted Successfully :)" );
			listEmployee(request, response);
		}
		
		
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> emlist = dao.getAllEmployees();
		System.out.println("Emp list from contr " + emlist);
		request.setAttribute("allemp", emlist);
		rd = request.getRequestDispatcher("employee-list.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee employee = new Employee();
		employee.setEmpno(Integer.parseInt(request.getParameter("eid")));
		employee.setEname(request.getParameter("ename"));
		employee.setDept(request.getParameter("dept"));
		System.out.println(employee);
		
		if(dao.save(employee))
		{
			request.setAttribute("NOTIFICATION", "Employee Added Successfully :)" );
			listEmployee(request, response);
		}
		
	}

}