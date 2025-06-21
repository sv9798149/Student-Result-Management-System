package com.result.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddStudentServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String usn = request.getParameter("usn");
    String sname = request.getParameter("sname");
    int m1 = Integer.parseInt(request.getParameter("m1"));
    int m2 = Integer.parseInt(request.getParameter("m2"));
    int m3 = Integer.parseInt(request.getParameter("m3"));
    float percentage = (m1 + m2 + m3) / 3.0f;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "yourpassword");

      PreparedStatement ps = con.prepareStatement("INSERT INTO marks VALUES (?, ?, ?, ?, ?, ?)");
      ps.setString(1, usn);
      ps.setString(2, sname);
      ps.setInt(3, m1);
      ps.setInt(4, m2);
      ps.setInt(5, m3);
      ps.setFloat(6, percentage);

      ps.executeUpdate();
      response.sendRedirect("dashboard.jsp");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
