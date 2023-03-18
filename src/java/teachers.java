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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import test.Teacher;



@WebServlet(urlPatterns = {"/teachers"})
public class teachers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("login") != null){
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ama_school";
            Connection conn = DriverManager.getConnection(url,"root","");
            PreparedStatement pst = conn.prepareStatement("SELECT * from teachers;");
            ResultSet results = pst.executeQuery();
            ArrayList<Teacher> std = new ArrayList<Teacher>();
            
            while(results.next()){
                String id = results.getString(1);
                String name = results.getString(2);
                String fillier = results.getString(3);
                String pack = results.getString(4);
                std.add(new Teacher(id,name,fillier,pack));
            }
            request.setAttribute("teachers", std);
            } catch (ClassNotFoundException | SQLException e) {
            System.out.print(e);
        }
            this.getServletContext().getRequestDispatcher("/WEB-INF/teachers.jsp").forward(request, response);
        }else
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

}
