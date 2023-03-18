/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import test.Student;
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



@WebServlet(urlPatterns = {"/dashboard"})
public class Dashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("login") != null){
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ama_school";
            Connection conn = DriverManager.getConnection(url,"root","");
            PreparedStatement pst1 = conn.prepareStatement("SELECT COUNT(*) as pstdt FROM pending_students");
            PreparedStatement pst2 = conn.prepareStatement("SELECT COUNT(*) as totalstud FROM students");
            PreparedStatement pst3 = conn.prepareStatement("SELECT COUNT(*) as totalteach FROM teachers");
            PreparedStatement pst4 = conn.prepareStatement("SELECT SUM(prix) as price from students");
            ResultSet results1 = pst1.executeQuery();
            ResultSet results2 = pst2.executeQuery();
            ResultSet results3 = pst3.executeQuery();
            ResultSet results4 = pst4.executeQuery();
            if(results1.next() && results2.next() && results3.next() && results4.next()){
                
                request.getSession().setAttribute("pstudents", results1.getString("pstdt"));
                request.getSession().setAttribute("totalstud", results2.getString("totalstud"));
                request.getSession().setAttribute("totalteach", results3.getString("totalteach"));
                request.getSession().setAttribute("price", results4.getString("price"));
            }else{
                response.sendRedirect("login");
            }
            pst1.close();pst2.close();pst3.close();pst4.close();
            results1.close();results2.close();results3.close();results4.close();
            
            PreparedStatement pst5 = conn.prepareStatement("SELECT id,first_name,last_name,prix,package FROM students order by id DESC LIMIT 4 ");
            ResultSet results5 = pst5.executeQuery();
            PreparedStatement pst6 = conn.prepareStatement("SELECT id,first_name,last_name,prix,package FROM pending_students order by id DESC LIMIT 4 ");
            ResultSet results6 = pst6.executeQuery();
            PreparedStatement pst7 = conn.prepareStatement("SELECT id,first_name,last_name,prix,package FROM students order by id DESC LIMIT 8 ");
            ResultSet results7 = pst7.executeQuery();
            ArrayList<Student> std = new ArrayList<Student>();
            ArrayList<Student> pendstd = new ArrayList<Student>();
            ArrayList<Student> latestStd = new ArrayList<Student>();
            
            while(results5.next()){
                String id = results5.getString(1);
                String name = results5.getString("first_name");
                String price = results5.getString(4);
                String pack = results5.getString(5);
                std.add(new Student(id,name,price,pack));
            }
            while(results6.next()){
                String id = results6.getString(1);
                String name = results6.getString(2)+" "+results6.getString(3);
                String price = results6.getString(4);  
                String pack = results6.getString(5);
                pendstd.add(new Student(id,name,price,pack));
            }
            while(results7.next()){
                String id = results7.getString(1);
                String name = results7.getString(2)+" "+results7.getString(3);
                String price = results7.getString(4);
                String pack = results7.getString(5); 
                latestStd.add(new Student(id,name,price,pack));
            }
            
            request.setAttribute("students", std);
            request.setAttribute("pendStudents", pendstd);
            request.setAttribute("LatestStudents", latestStd);
            
            pst5.close();pst6.close();
            results5.close();results6.close();
            conn.close();
            
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.print(e);
        }
            this.getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);
        }else
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

}
