/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(urlPatterns = {"/change_pass"})
public class ChangePassword extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String url = "jdbc:mysql://localhost:3306/ama_school";
         if(request.getSession().getAttribute("login") != null){
             
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,"root","");
            PreparedStatement pst = conn.prepareStatement("UPDATE users set pass=? where username=?");
            String password = request.getParameter("password");
            pst.setString(1,password);
            pst.setString(2,request.getSession().getAttribute("login").toString());
            pst.executeUpdate();
            
            session.setAttribute("login",null);
            response.sendRedirect("login");

            conn.close();
            pst.close();
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.print(e);
        }
         }
        }

}

