package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.data.Employee;


@WebServlet("/details")
public class EmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmployeeDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int deptId = (int) session.getAttribute("deptId");
		List<Employee> empList = (List<Employee>) session.getAttribute("empList");
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("<h1 align='center'> Department " + deptId + " </h1>");

		pw.println("<table border='1' align='center'><th>ID</th><th>NAME</th><th>SALARY</th>");
		for (Employee e : empList) {
			pw.print("<tr><td>" + e.getId() + "</td>");
			pw.print("<td>" + e.getName() + "</td>");
			pw.println("<td>" + e.getSalary() + "</td></tr>");
		}
		pw.println("</table>");
		pw.println("</body></html>");
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
