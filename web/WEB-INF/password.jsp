<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="images/ama_VZW_icon.png">
    <title>Change Password</title>
    <link rel="stylesheet" href="assets/css/style.css">
   </head>
    <body>
        <%@ include file="menu.jsp" %>
        <%@ include file="main.jsp" %>
        
        <div style="display: flex; justify-content: center; align-items: center; height: 45rem;">
  <form id="reset-form" action="change_pass" method="POST" style="background-color: #f2f2f2; padding: 20px; width: 500px; border-radius: 5px; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);">
    <h2 style="text-align: center;">Change Password</h2>
    <div style="display: flex; flex-direction: column; margin-bottom: 10px;">
      <label for="password" style="margin-bottom: 5px;">New Password:</label>
      <input type="text" id="password" name="password" style="padding: 10px; border: none; border-radius: 3px; box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.1);">
    </div>
    <div style="display: flex; flex-direction: column; margin-bottom: 10px;">
      <label for="confirm_password" style="margin-bottom: 5px;">Confirm Password:</label>
      <input type="text" id="confirm_password" name="confirm_password" style="padding: 10px; border: none; border-radius: 3px; box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.1);">
    </div>
     <p id="password-error" style="color: red; margin: 5px 0 10px 0; display: none;">Passwords do not match</p>
    <button type="submit" id="reset-button" style="background-color: #4CAF50; color: white; padding: 10px 20px; border: none; border-radius: 3px; cursor: pointer;">Reset Password</button>
  </form>
</div>

        
        <!-- =========== Scripts =========  -->
    <script src="assets/js/main.js"></script>

    <!-- ====== ionicons ======= -->
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    
    <script>
  const form = document.querySelector('#reset-form');
  const passwordInput = document.querySelector('#password');
  const confirmPasswordInput = document.querySelector('#confirm_password');
  const passwordError = document.querySelector('#password-error');
  const resetButton = document.querySelector('#reset-button');

  function validatePassword() {
    if (passwordInput.value !== confirmPasswordInput.value) {
      passwordError.style.display = 'block';
      resetButton.disabled = true;
    } else {
      passwordError.style.display = 'none';
      resetButton.disabled = false;
    }
  }

  confirmPasswordInput.addEventListener('input', validatePassword);
</script>
    </body>
</html>
