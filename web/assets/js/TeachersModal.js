// Get the modal
var edit = document.getElementById("modalEdit");

// Get the button that opens the modal
var buttons = document.querySelectorAll('.openEdit');

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("link-2")[0];


// When the user clicks the button, open the modal 

for (var i = 0; i < buttons.length; i++) {
  buttons[i].onclick = function() {
    edit.style.display = "block";
  };
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  edit.style.display = "none";
};

/******************** Remove Modal *****************/

// Get the modal
var remove = document.getElementById("modalRemove");

// Get the button that opens the modal
var buttons1 = document.querySelectorAll('.openRemove');

// Get the <span> element that closes the modal
var span1 = document.getElementsByClassName("link-2")[1];


// When the user clicks the button, open the modal 

for (var i = 0; i < buttons.length; i++) {
  buttons1[i].onclick = function() {
    remove.style.display = "block";
  };
}

// When the user clicks on <span> (x), close the modal
span1.onclick = function() {
  remove.style.display = "none";
};

/******************** Add Modal *****************/

// Get the modal
var add = document.getElementById("modalAdd");

// Get the button that opens the modal
var buttons2 = document.querySelectorAll('.openAdd');

// Get the <span> element that closes the modal
var span2 = document.getElementsByClassName("link-2")[2];


// When the user clicks the button, open the modal 

for (var i = 0; i < buttons.length; i++) {
  buttons2[i].onclick = function() {
    add.style.display = "block";
  };
}

// When the user clicks on <span> (x), close the modal
span2.onclick = function() {
  add.style.display = "none";
};