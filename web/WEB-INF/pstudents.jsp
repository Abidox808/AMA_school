<%@page import="test.Student"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="images/ama_VZW_icon.png">
    <title>Pending Students</title>
    <!-- ======= Styles ====== -->
    <link rel="stylesheet" href="assets/css/pending.css">
    </head>
    <body>
        <%@ include file="menu.jsp" %>
        <%@ include file="main.jsp" %>
            <!-- ================ Pending students List ================= -->
            <div class="details">
                <div class="recentOrders">
                    <div class="cardHeader">
                        <h2>Pending Students :</h2>
                        
                    </div>

                    <table>
                        <thead>
                            <tr>
                                <td>Name</td>                            
                                <td>Price</td>
                                <td>Payment</td>
                                <td>Action</td>
                                
                            </tr>
                        </thead>
                        <tbody>               
                <%
                   ArrayList<Student> pendstd = (ArrayList<Student>) request.getAttribute("pendStudents");
                for(Student s: pendstd){%>
                    
                        <tr>
                            <td><%= s.getName() %></td>
                            <td><%= s.getPrice() %> DH</td>
                            <td>Pending</td>
                            <td><a href="accept?id=<%= s.getID()%>"<button type="submit" class="accept">Accept</button></a><a href="delete?id=<%= s.getID()%>"<button type="submit" class="accept deny">Deny</button></a></td>
                            
                        </tr>
                        
                    <%};%>
                                                   
                        </tbody>
                    </table>
                </div>
<!-- =========== Scripts =========  -->
    <script src="assets/js/main.js"></script>

    <!-- ====== ionicons ======= -->
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>    
</body>
</html>