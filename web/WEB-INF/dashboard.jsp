<%@page import="test.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="images/ama_VZW_icon.png">
    <title>Dashboard | Home</title>
    <!-- ======= Styles ====== -->
    <link rel="stylesheet" href="assets/css/style.css">
</head>

<body>
    <%@ include file="menu.jsp" %>
    <%@ include file="main.jsp" %>
    
            <!-- ================ Order Details List ================= -->
            <div class="details">
                <div class="recentOrders">
                    <div class="cardHeader">
                        <h2>Latest Registrations</h2>
                        <a href="pstudents" class="btn">View All</a>
                    </div>

                    <table>
                        <thead>
                            <tr>
                                <td>Name</td>
                                <td>Price</td>
                                <td>Payment</td>
                                <td>Status</td>
                            </tr>
                        </thead>
                        <tbody>
                 <%
                   ArrayList<Student> std = (ArrayList<Student>) request.getAttribute("students");
                for(Student s: std){%>
                    
                        <tr>
                            <td><%= s.getName() %></td>
                            <td><%= s.getPrice() %> DH</td>
                            <td>Paid</td>
                            <td><span class="status delivered">Registration Completed</span></td>
                        </tr>
                        
                    <%};%>
                <%
                   ArrayList<Student> pendstd = (ArrayList<Student>) request.getAttribute("pendStudents");
                for(Student s: pendstd){%>
                    
                        <tr>
                            <td><%= s.getName() %></td>
                            <td><%= s.getPrice() %> DH</td>
                            <td>Pending</td>
                            <td><span class="status pending">Pending Registration</span></td>
                        </tr>
                        
                    <%};%>
                                                   
                        </tbody>
                    </table>
                </div>

                <!-- ================= New Customers ================ -->
                <div class="recentCustomers">
                    <div class="cardHeader">
                        <h2>Recent Students</h2>
                    </div>

                    <table>
                        <%
                   ArrayList<Student> LatestStudents = (ArrayList<Student>) request.getAttribute("LatestStudents");
                for(Student s: LatestStudents){%>
                    
                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="assets/imgs/customer02.jpg" alt=""></div>
                            </td>
                            <td>
                                <h4><%=s.getName() %><br> <span><%= s.getPack()%></span></h4>
                            </td>
                            
                        </tr>
                        
                    <%};%>
                        
                    </table>
                </div>
            </div>
        </div>
    </div>

    <!-- =========== Scripts =========  -->
    <script src="assets/js/main.js"></script>

    <!-- ====== ionicons ======= -->
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>
