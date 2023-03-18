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
import test.Student;


@WebServlet(urlPatterns = {"/students"})
public class Students extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("login") != null){
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ama_school";
            Connection conn = DriverManager.getConnection(url,"root","");
            PreparedStatement pst6 = conn.prepareStatement("SELECT id,first_name,last_name,prix,gender,email,phone,package,birthday FROM students ");
            ResultSet results6 = pst6.executeQuery();
            
            ArrayList<Student> pendstd = new ArrayList<Student>();
            while(results6.next()){
                String id = results6.getString(1);
                String name = results6.getString(2)+" "+results6.getString(3);
                String price = results6.getString(4);
                String gender = results6.getString(5);
                String email = results6.getString(6);
                String phone = results6.getString(7);
                String pack = results6.getString(8);
                String birth = results6.getString(9);
                pendstd.add(new Student(id,name,price,gender,email,phone,pack,birth));
            }
            request.setAttribute("pendStudents", pendstd);
            pst6.close();
            results6.close();
            conn.close();
                      
            
            } catch (ClassNotFoundException | SQLException e) {
            System.out.print(e);
        }
            this.getServletContext().getRequestDispatcher("/WEB-INF/students.jsp").forward(request, response);
        }else
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

}
