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
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(urlPatterns = {"/accept"})
public class AcceptPendingStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("login") != null){
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ama_school";
            Connection conn = DriverManager.getConnection(url,"root","");
             PreparedStatement pst1 = conn.prepareStatement("SELECT * from pending_students where id=?");
            PreparedStatement insertStatmnt = conn.prepareStatement("INSERT INTO students (first_name, last_name, gender, birthday, email, phone , package, prix) values (?, ?, ?, ?, ?, ?, ?, ?)");
            
            pst1.setString(1,request.getParameter("id"));
            ResultSet results1 = pst1.executeQuery();
            while(results1.next()){
            insertStatmnt.setString(1,results1.getString(2));
            insertStatmnt.setString(2,results1.getString(3));
            insertStatmnt.setString(3,results1.getString(4));
            insertStatmnt.setString(4,results1.getString(5));
            insertStatmnt.setString(5,results1.getString(6));
            insertStatmnt.setString(6,results1.getString(7));
            insertStatmnt.setString(7,results1.getString(8));
            insertStatmnt.setString(8,results1.getString(9));
            insertStatmnt.executeUpdate();
            
            String recipient = results1.getString(6);
            String subject = "Welcome to AMA School";
            String content = "Hello "+results1.getString(2)+" "+results1.getString(3)+",\n\n"+"Congratulations, we are glad to inform you that you have been Accepted as a student in AMA School."+"\nKindly , prepare you papers and head over to our office in Morocco, Taroudant , LASTAH N55 to complete you registartion."+"\nHave a Good Day"+"\n\nAMA SCHOOL.";
                try {
                    email.sendEmail(recipient, subject, content);
                } catch (Exception ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            } catch (ClassNotFoundException | SQLException e) {
            System.out.print(e);
        }
            this.getServletContext().getRequestDispatcher("/delete?id="+request.getParameter("id")).forward(request, response);
        }else
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

}
