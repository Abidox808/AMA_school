<%@page import="test.Teacher"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="images/ama_VZW_icon.png">
    <link rel="stylesheet" href="assets/css/modal.css">
    <link rel="stylesheet" href="css/teachers.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/all.min.css">
    <title>Teachers</title>
    <!-- ======= Styles ====== -->
    <link rel="stylesheet" href="assets/css/pending.css">
    </head>
<body>
    <%@ include file="menu.jsp" %>
    <%@ include file="main.jsp" %>
           
        <!-- Start Team -->
    <div class="team" id="team">
      <h2 class="main-title">Teachers</h2>
      <div class="buttons">
        <a id="bp">Primaire</a>
        <a id="cp">Collége</a>
        <a id="lp">Lycée</a>
      </div>
      <div class="containers" id="pc" >
      <%
                   ArrayList<Teacher> std = (ArrayList<Teacher>) request.getAttribute("teachers");
                for(Teacher t: std){
                if(t.GetPack().equals("Primaire")){
    %>
        <div class="box">
          <div class="data">
          <img src="images/teacher.jpeg" alt="" />
          </div>
          <div class="info">
          <h3><%= t.GetName() %></h3> 
          <p><b>ID</b><b> <%= t.GetID() %></b><b> <%= t.GetFillier()+"'s" %></b> Teacher</p>
          </div>
          </div>
    <%}};%>  
          </div>
      <div class="containers cc-cont" style="display:none" id="cc" >
    <%
                   ArrayList<Teacher> std1 = (ArrayList<Teacher>) request.getAttribute("teachers");
                for(Teacher t: std1){
                if(t.GetPack().equals("Collége")){
    %>  
        <div class="box">
          <div class="data">
          <img src="images/teacher.jpeg" alt="" />
          </div>
          <div class="info">
          <h3><%= t.GetName() %></h3>
          <p><b>ID</b><b> <%= t.GetID() %></b><b> <%= t.GetFillier()+"'s" %></b> Teacher</p>
          </div>
        </div>
    <%}};%>       
      </div>     
      <div class="containers lc-cont" style="display:none;" id="lc" >
    <%
                   ArrayList<Teacher> std2 = (ArrayList<Teacher>) request.getAttribute("teachers");
                for(Teacher t: std2){
                if(t.GetPack().equals("Lycée")){
    %>      
        <div class="box">
          <div class="data">
          <img src="images/teacher.jpeg" alt="" />
          </div>
          <div class="info">
          <h3><%= t.GetName() %></h3>
          <p><b>ID</b><b> <%= t.GetID() %></b><b> <%= t.GetFillier()+"'s" %></b> Teacher</p>
          </div>
        </div>
    <%}};%>       
      </div>     
      </div>
    
    <div class="button">
        <a href="#m3-o" <button id="edit" class="edit openEdit">EDIT</a>
        <a href="#m3-oo" <button id="remove" class="remove openRemove">Remove</a>
        <a href="#m3-ooo" <button id="add" class="remove openAdd">Add</a>
      </div>
    </div>
    <!-- End Team -->
    <!-- =========== Modal Edit =========  -->
     <div class="boxM" id="modalEdit" style="display:none" >
  <div class="modal-container" id="m3-o" style="--m-background: var(--global-background);">
    <div class="modal" style="--m-shadow: 0 0 10rem 0">
      <h1 class="modal__title">Edit Teacher Info</h1>
      <form action="editTeacher" method="GET">
      <div class="inputs modal__text">
        <label class="label"><span class="idlabel">*</span>ID</label>
        <input id="id_input" class="input_modal" type="text" name="id" />
        <label class="label" >Full name</label>
        <input class="input_modal" type="text" name="full_name" />
        <label class="label">Filliere</label>
        <input class="input_modal" type="text" name="filliere"/>
        <label class="label">Niveau</label>
        <input class="input_modal" type="text" name="niveau"/>
      </div>
      <button type="submit" class="modal__btn">Save</button>
      <button class="modal__btn">Cancel </button>
      </form>
      <a href="#m3-c" class="link-2"></a>
    </div>
  </div>
</div>
 
    <!-- =========== Modal Remove =========  -->
     <div class="boxM" id="modalRemove" style="display:none" >
  <div class="modal-container" id="m3-oo" style="--m-background: var(--global-background);">
    <div class="modal" style="--m-shadow: 0 0 10rem 0">
      <h1 class="modal__title">Remove Teacher</h1>
      <form action="remove" method="GET">
      <div class="inputs modal__text">
        <label class="label"><span class="idlabel">*</span>ID</label>
        <input id="id_input" class="input_modal" type="text" name="id" />
      </div>
      <button type="submit" class="modal__btn">Save</button>
      <button class="modal__btn">Cancel </button>
      </form>
      <a href="#m3-c" class="link-2"></a>
    </div>
  </div>
</div>
    
    <!-- =========== Modal Add =========  -->
     <div class="boxM" id="modalAdd" style="display:none" >
  <div class="modal-container" id="m3-ooo" style="--m-background: var(--global-background);">
    <div class="modal" style="--m-shadow: 0 0 10rem 0">
      <h1 class="modal__title">Add Teacher</h1>
      <form action="addTeacher" method="GET">
      <div class="inputs modal__text">
        <label class="label" >Full name</label>
        <input class="input_modal" type="text" name="full_name" />
        <label class="label">Filliere</label>
        <input class="input_modal" type="text" name="filliere"/>
        <label class="label">Niveau</label>
        <input class="input_modal" type="text" name="niveau"/>
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
    <script src="js/teachers.js"></script>
    <script src="assets/js/TeachersModal.js"></script>
    <!-- ====== ionicons ======= -->
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>
</body>
</html>