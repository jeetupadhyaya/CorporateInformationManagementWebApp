package net.javaguides.usermanagement.web;
//package net.javaguides.usermanagement.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermanagement.dao.UserDAO;
import net.javaguides.usermanagement.model.User;


@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	public UserServlet() {
		this.userDAO = new UserDAO();
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String action = request.getServletPath();

		
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				try {
					insertUser(request, response);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "/delete":
				
				try {
					deleteUser(request, response);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				break;
			case "/edit":
				try {
				showEditForm(request, response);
				}catch(SQLException e){
					e.printStackTrace();
				}
				break;
			case "/update":
				try {
				updateUser(request, response);
				}catch(SQLException e) {
					e.printStackTrace();
				}
				break;
			default:
				try {
				listUser(request, response);
				}catch(SQLException e) {
					e.printStackTrace();
				}
				break;
			
		} 
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int sn = Integer.parseInt(request.getParameter("sn"));
		User existingUser = userDAO.selectUser(sn);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String corporate_name = request.getParameter("corporate_name");
		String corporateid = request.getParameter("corporateid");
		String accountnumber = request.getParameter("accountnumber");
		User newUser = new User(corporate_name, corporateid, accountnumber);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int sn = Integer.parseInt(request.getParameter("sn"));
		String corporate_name = request.getParameter("corporate_name");
		String corporateid = request.getParameter("corporateid");
		String accountnumber = request.getParameter("accountnumber");

		User user = new User(sn, corporate_name, corporateid, accountnumber);
		userDAO.updateUser(user);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int sn = Integer.parseInt(request.getParameter("sn"));
		userDAO.deleteUser(sn);
		response.sendRedirect("list");

	}

}