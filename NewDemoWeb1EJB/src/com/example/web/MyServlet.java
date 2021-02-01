package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.data.Employee;
import com.example.data.JdbcExample;

@WebServlet("/search")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	JdbcExample j;

	public MyServlet() {
        super();

    }


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		String name = req.getParameter("q");
		// logic how to use and for what

		pw.println("<html><body bgcolor='cyan'>");
		pw.println("<h1 align='center'> Cogent Univesity </h1>");
		pw.println("<marquee>" + name + "</marquee>");
		pw.println("</body></html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// doGet(req, res);
		int deptId = Integer.parseInt(req.getParameter("q"));

		List<Employee> empList=j.doData(deptId);
		HttpSession session = req.getSession();
		session.setAttribute("deptId", deptId);
		session.setAttribute("empList", empList);
		
		// req.getRequestDispatcher("details").forward(req, res);
		req.getRequestDispatcher("details.jsp").forward(req, res);

	}



}
