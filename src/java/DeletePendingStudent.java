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
import java.util.logging.Level;
import java.util.logging.Logger;
import test.Student;


@WebServlet(urlPatterns = {"/delete"})
public class DeletePendingStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("login") != null){
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ama_school";
            Connection conn = DriverManager.getConnection(url,"root","");
            PreparedStatement pst = conn.prepareStatement("DELETE from pending_students where id=?");
            PreparedStatement pst1 = conn.prepareStatement("SELECT * from pending_students where id=?");
            pst.setString(1,request.getParameter("id"));
            pst1.setString(1,request.getParameter("id"));
            ResultSet results1 = pst1.executeQuery();
            pst.executeUpdate();           
            String recipient;
            String subject;
            String content;
            while(results1.next()){
            recipient = results1.getString(6);
            subject = "Application Denied";
            content = "Hello "+results1.getString(2)+" "+results1.getString(3)+",\n\n"+"We regret to inform you that your application to join AMA School was Denied."+"\nWe wish you best of luck, Thanks ."+"\n\nAMA SCHOOL.";   
            try {
                    email.sendEmail(recipient, subject, content);
                } catch (Exception ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            } catch (ClassNotFoundException | SQLException e) {
            System.out.print(e);
        }
            this.getServletContext().getRequestDispatcher("/pstudents").forward(request, response);
        }else
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

}
