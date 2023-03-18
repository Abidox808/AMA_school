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
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(urlPatterns = {"/registration"})
public class Registration extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fname = request.getParameter("first_name");
        String lname = request.getParameter("last_name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String email1 = request.getParameter("email");
        String phone = request.getParameter("phone");
        String pckg = request.getParameter("package");
        String prix = request.getParameter("prix");
        String url = "jdbc:mysql://localhost:3306/ama_school";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,"root","");
            PreparedStatement pst = conn.prepareStatement("INSERT INTO pending_students (first_name, last_name, gender, birthday, email, phone , package, prix) values (?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1,fname);
            pst.setString(2,lname);
            pst.setString(3,gender);
            pst.setString(4,birthday);
            pst.setString(5,email1);
            pst.setString(6,phone);
            pst.setString(7,pckg);
            pst.setString(8,prix);
            pst.executeUpdate();
            String recipient = email1;
            String subject = "Confirmation of Your Registration";
            String content = "Hello "+fname+" "+lname+",\n\n"+"We have Received your application to join us , we will contact you shortly through your phone number about our decision."+"\n\nCheers,"+"\nAMA SCHOOL.";
                try {
                    email.sendEmail(recipient, subject, content);
                } catch (Exception ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("succes_registration");
                conn.close();
                pst.close(); 
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.print(e);
        }
    }

}
