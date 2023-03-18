// Get the modal
var edit = document.getElementById("modalEdit");

// Get the button that opens the modal
var buttons = document.querySelectorAll('.openModalEdit')

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("link-2")[0];


// When the user clicks the button, open the modal 

for (var i = 0; i < buttons.length; i++) {
  buttons[i].onclick = function() {
    edit.style.display = "block";
	selectElement = document.querySelector('#id_input');
        selectElement.value = this.getAttribute('id');
  }
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  edit.style.display = "none";
}