<%@ page import="java.sql.*" %>
<html>
<head><title>View Results</title></head>
<body>
  <h2>Student Results</h2>
  <table border="1">
    <tr>
      <th>USN</th><th>Name</th><th>Marks1</th><th>Marks2</th><th>Marks3</th><th>Percentage</th>
    </tr>
<%
  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "yourpassword");
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM marks");
    while (rs.next()) {
%>
  <tr>
    <td><%= rs.getString("usn") %></td>
    <td><%= rs.getString("sname") %></td>
    <td><%= rs.getInt("marks1") %></td>
    <td><%= rs.getInt("marks2") %></td>
    <td><%= rs.getInt("marks3") %></td>
    <td><%= rs.getFloat("percentage") %></td>
  </tr>
<%
    }
  } catch (Exception e) {
    e.printStackTrace();
  }
%>
  </table>
</body>
</html>
