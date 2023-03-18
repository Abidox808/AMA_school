/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



@WebServlet(urlPatterns = {"/edit"})
public class EditStudentModal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("login") != null){
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ama_school";
            Connection conn = DriverManager.getConnection(url,"root","");
            if(request.getParameter("fname")!= ""){
            PreparedStatement pst1 = conn.prepareStatement("UPDATE students SET first_name=? where id=?");
            pst1.setString(1,request.getParameter("fname"));
            pst1.setString(2,request.getParameter("id"));
            pst1.executeUpdate();
            }if(request.getParameter("lname")!= ""){
            PreparedStatement pst1 = conn.prepareStatement("UPDATE students SET last_name=? where id=?");
            pst1.setString(1,request.getParameter("lname"));
            pst1.setString(2,request.getParameter("id"));
            pst1.executeUpdate();
            }if(request.getParameter("email")!= ""){
                PreparedStatement pst1 = conn.prepareStatement("UPDATE students SET email=? where id=?");
            pst1.setString(1,request.getParameter("email"));
            pst1.setString(2,request.getParameter("id"));
            pst1.executeUpdate();
            }
            if(request.getParameter("phone")!= ""){
                PreparedStatement pst1 = conn.prepareStatement("UPDATE students SET phone=? where id=?");
            pst1.setString(1,request.getParameter("phone"));
            pst1.setString(2,request.getParameter("id"));
            pst1.executeUpdate();
            }
            
            
            } catch (ClassNotFoundException | SQLException e) {
            System.out.print(e);
        }
            this.getServletContext().getRequestDispatcher("/students").forward(request, response);
        }else
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

}
