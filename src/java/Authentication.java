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
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(urlPatterns = {"/authentication"})
public class Authentication extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String url = "jdbc:mysql://localhost:3306/ama_school";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,"root","");
            PreparedStatement pst = conn.prepareStatement("SELECT id FROM users where username=? AND pass=? ");
            pst.setString(1,username);
            pst.setString(2,password);
            ResultSet results = pst.executeQuery();
            if(results.next()){
            session.setAttribute("login",username);
            response.sendRedirect("dashboard");
            }else{
                response.sendRedirect("login");
                conn.close();
                pst.close();
                results.close();
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.print(e);
        }
        
    }

}

