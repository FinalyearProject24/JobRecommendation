 let signup = document.querySelector(".signup");
 let login = document.querySelector(".login");
 let slider = document.querySelector(".slider");
 let formSection = document.querySelector(".form-section");

 signup.addEventListener("click", () => {
	slider.classList.add("slider");
 	formSection.classList.add("form-section-move");
 });

 login.addEventListener("click", () => {
 	slider.classList.remove("slider");
 	formSection.classList.remove("form-section-move");
 });
email.addEventListener('change', e => {
	const errorEmail = document.querySelector('.invalid-email-message');
	const emailMessage = document.querySelector('.email-message');
    console.log(email)
    if(email.value){
    const regexMatch = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email.value);
    if (regexMatch) {
          errorEmail.textContent = '';
        } else {
          e.preventDefault();
          errorEmail.textContent = 'email is invalid';
          emailMessage.textContent = "";
        }
    } else {
      e.preventDefault();
      emailMessage.textContent = 'You must type in an email';
      errorEmail.textContent = "";
	}	
});
function checkInput() {
	var fname = document.forms["myForm"]["fname"].value;
	var lname = document.forms["myForm"]["lname"].value;
	var email = document.forms["myForm"]["email"].value;
	var phone = document.forms["myForm"]["phone"].value;
	var eduname = document.forms["myForm"]["eduname"].value;
	var Degree = document.forms["myForm"]["Degree"].value;
	var Skills = document.forms["myForm"]["Skills"].value;
	var myfile = document.forms["myForm"]["myfile"].value;


console.log(fname,lname,email,phone,eduname,Degree,Skills,myfile)
	var submitButton = document.getElementById("submitBtn");
	submitButton.disabled = (fname === "" || lname === "" || email === "" || phone === "" || eduname === "" || Degree === "" || Skills === "" || myfile === "" );
  }
 