<%@page import="test.Student"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="images/ama_VZW_icon.png">
    <title>Students</title>
    <!-- ======= Styles ====== -->
    <link rel="stylesheet" href="assets/css/pending.css">
    <link rel="stylesheet" href="assets/css/modal.css">
    </head>
    <body>
        <%@ include file="menu.jsp" %>
        <%@ include file="main.jsp" %>
            <!-- ================ Pending students List ================= -->
            <div class="details">
                <div class="recentOrders recentCustomers">
                    <div class="cardHeader">
                        <h2>Students :</h2>
                        
                    </div>

                    <table>
                        <thead>
                            <tr>
                                <td></td>
                                <td></td>
                                <td>Name</td>
                                <td>Gender</td>
                                <td>Email</td>
                                <td>Phone</td>
                                <td>Birthday</td>                               
                                <td>Action</td>
                                
                            </tr>
                        </thead>
                        <tbody>               
                <%
                   ArrayList<Student> pendstd = (ArrayList<Student>) request.getAttribute("pendStudents");
                for(Student s: pendstd){%>
                    
                        <tr>
                            
                            <td width="60px">
                                <td width="60px">
                                    <div class="imgBx"><img src="assets/imgs/customer02.jpg" alt=""></div> </td>
                            </td>
                            <td>
                                <h4><%=s.getName() %><br> <span><%= s.getPack()%></span></h4>
                            </td>
                            
                            <td><%= s.getGender() %></td>
                            <td><%= s.getEmail() %></td>
                            <td><%= s.getPhone() %></td>
                            <td><%= s.getBirth() %></td>
                            <td><a href="#m3-o"<button id="<%= s.getID()%>" type="submit" class="accept openModalEdit">Edit</button></a><a href="deleteStudent?id=<%= s.getID()%>"<button type="submit" class="accept deny">Delete</button></a></td>
                            
                        </tr>
                        
                    <%};%>
                                                   
                        </tbody>
                    </table>
                </div>
                    
     <!-- =========== Modal =========  -->
     <div class="boxM" id="modalEdit" style="display:none" >
  <div class="modal-container" id="m3-o" style="--m-background: var(--global-background);">
    <div class="modal" style="--m-shadow: 0 0 10rem 0">
      <h1 class="modal__title">Edit Info</h1>
      <form action="edit" method="GET">
      <div class="inputs modal__text">
        <label class="label"><span class="idlabel">*</span>ID</label>
        <input id="id_input" class="input_modal" type="text" name="id" />
        <label class="label" >First name</label>
        <input class="input_modal" type="text" name="fname" />
        <label class="label" >Last name</label>
        <input class="input_modal" type="text" name="lname" />
        <label class="label">Email</label>
        <input class="input_modal" type="text" name="email"/>
        <label class="label">Phone</label>
        <input class="input_modal" type="text" name="phone"/>
      </div>
      <button type="submit" class="modal__btn">Save</button>
      <button class="modal__btn">Cancel </button>
      </form>
      <a href="#m3-c" class="link-2"></a>
    </div>
  </div>
</div>
<!-- =========== Scripts =========  -->
    <script src="assets/js/main.js"></script>
    <script src="assets/js/modal.js"></script>
    <!-- ====== ionicons ======= -->
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>    
</body>
</html>