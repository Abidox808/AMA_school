<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <!-- ========================= Main ==================== -->
            <div class="main">
                <div class="topbar">
                    <div class="toggle">
                        <ion-icon name="menu-outline"></ion-icon>
                    </div>
    
                    <div class="search">
                        <label>
                            <input type="text" placeholder="Search here">
                            <ion-icon name="search-outline"></ion-icon>
                        </label>
                    </div>
    
                    <div class="user">
                        <img src="assets/imgs/customer01.jpg" alt="">
                    </div>
                </div>
    
                <!-- ======================= Cards ================== -->
                <div class="cardBox">
                <div class="card">
                    <div>
                        <div class="numbers"><% out.println(request.getSession().getAttribute("pstudents")); %></div>
                        <div class="cardName">Pending Students</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="alert-circle-outline"></ion-icon>
                    </div>
                </div>

                <div class="card">
                    <div>
                        <div class="numbers"><% out.println(request.getSession().getAttribute("totalstud")); %></div>
                        <div class="cardName">Registered Students</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="people-circle-outline"></ion-icon>
                    </div>
                </div>

                <div class="card">
                    <div>
                        <div class="numbers"><% out.println(request.getSession().getAttribute("totalteach")); %></div>
                        <div class="cardName">Teachers</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="person-circle-outline"></ion-icon>
                    </div>
                </div>

                <div class="card">
                    <div>
                        <div class="numbers"><% out.println(request.getSession().getAttribute("price")+" MAD"); %></div>
                        <div class="cardName">Earnings</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="cash-outline"></ion-icon>
                    </div>
                </div>
            </div>
