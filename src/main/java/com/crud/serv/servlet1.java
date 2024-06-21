package com.crud.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.DAO.EmployeeBOimp;
import com.crud.model.Employee;

@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");
		PrintWriter out = resp.getWriter();

		EmployeeBOimp emp = new EmployeeBOimp();

		// insert(save) new record.
		if (action.equals("insert")) {

			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String gender = req.getParameter("gender");
			String mail = req.getParameter("mail");
			String mobileNumber = req.getParameter("mobileNumber");
			String designation = req.getParameter("designation");
			int salary = Integer.parseInt(req.getParameter("salary"));

			Employee e = new Employee(id, name, gender, mail, mobileNumber, designation, salary);

			int i = emp.insert(e);
			if (i == 1) {
				out.print(
						"<h1 style=\"color: green; text-align:center;padding: top 50px;\">Inserted data successfully.</h1>");
				out.println(
						"<a href=\"options.html\" style=\"background-color: green;color:white;border-radius:10px; padding:10px;margin-left:45%;><button \style=\"background-color: green;color:white; text-align:center;\">Home Page</button></a>");
			} else {
				out.print("<h1 style=\"color: red; text-align:center;padding: top 50px;\">Some Problem Occured.</h1>");
				out.println(
						"<a href=\"options.html\" style=\"background-color: green;color:white;border-radius:10px; padding:10px;margin-left:45%;><button \style=\"background-color: green;color:white; text-align:center;\">Home Page</button></a>");
			}
		}

		// update email on the basis of id

		else if (action.equals("update")) {

			int id = Integer.parseInt(req.getParameter("id"));
			String mail = req.getParameter("mail");

			Employee e = new Employee();
			e.setId(id);
			e.setMail(mail);

			int i = emp.update(e.getId(), e.getMail());
			if (i == 1) {
				out.print(
						"<h1 style=\"color: green; text-align:center;padding: top 50px;\">Updated data successfully.</h1>");
				out.println(
						"<a href=\"options.html\" style=\"background-color: green;color:white;border-radius:10px; padding:10px;margin-left:45%;><button \style=\"background-color: green;color:white; text-align:center;\">Home Page</button></a>");
			} else {
				out.println(
						"<h1 style=\"color: red; text-align:center;padding: top 50px;\">Some Problem Occured.</h1>");
				out.println(
						"<a href=\"options.html\" style=\"background-color: green;color:white;border-radius:10px; padding:10px;margin-left:45%;><button \style=\"background-color: green;color:white; text-align:center;\">Home Page</button></a>");
			}
		}

		// delete record on the basis of id

		else if (action.equals("delete")) {

			int id = Integer.parseInt(req.getParameter("id"));

			Employee e = new Employee();
			e.setId(id);

			int i = emp.delete(e.getId());
			System.out.println(i);
			if (i == 1) {
				out.print(
						"<h1 style=\"color: green; text-align:center;padding: top 50px;\"> Deleted data successfully.</h1>");
				out.println(
						"<a href=\"options.html\" style=\"background-color: green;color:white;border-radius:10px; padding:10px;margin-left:45%;><button \style=\"background-color: green;color:white; text-align:center;\">Home Page</button></a>");
			} else {
				out.print("<h1 style=\"color: red; text-align:center;padding: top 50px;\">Some Problem Occured.</h1>");
				out.println(
						"<a href=\"options.html\" style=\"background-color: green;color:white;border-radius:10px; padding:10px;margin-left:45%;><button \style=\"background-color: green;color:white; text-align:center;\">Home Page</button></a>");
			}
		}

		// Retrive record on the basis of id

		else if (action.equals("retrive")) {

			int id = Integer.parseInt(req.getParameter("id"));

			Employee e = new Employee();
			e.setId(id);

			Employee e1 = emp.get(e.getId());
			System.out.print(e1);

			// casting to list

			List<Employee> all = new ArrayList<>();
			if (e1 != null) {
				all.add(e1);
			}

			// Set the retrieved employee (or list) in request attribute
			req.setAttribute("employeeList", all);

			// Forward the request to your JSP
			RequestDispatcher dispatcher = req.getRequestDispatcher("allretrive.jsp");
			dispatcher.forward(req, resp);

		}

		// Retrieve all records

		else if (action.equals("retriveAll")) {

			Employee e = new Employee();

			List<Employee> all = emp.getAll();

			req.setAttribute("employeeList", all);

			// Forward the request to JSP file
			RequestDispatcher dispatcher = req.getRequestDispatcher("allretrive.jsp");
			dispatcher.forward(req, resp);

		}

	}
}
