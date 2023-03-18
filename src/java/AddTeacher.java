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



@WebServlet(urlPatterns = {"/addTeacher"})
public class AddTeacher extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("login") != null){
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ama_school";
            Connection conn = DriverManager.getConnection(url,"root","");
            
                
            PreparedStatement pst1 = conn.prepareStatement("INSERT INTO teachers (fullname,filiere,levell) values (?,?,?)");
            pst1.setString(1,request.getParameter("full_name"));
            pst1.setString(2,request.getParameter("filliere"));
            pst1.setString(3,request.getParameter("niveau"));
            pst1.executeUpdate();
            pst1.close();
            conn.close();
            
            
            } catch (ClassNotFoundException | SQLException e) {
            System.out.print(e);
        }
            this.getServletContext().getRequestDispatcher("/teachers").forward(request, response);
        }else
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

}
