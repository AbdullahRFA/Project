// Retrieve the email from localStorage
const email = sessionStorage.getItem("userEmail");

// If the email exists, show it in the span
if (email) {
  document.getElementById("email-span").innerText = email;
} else {
  console.log("No email found");
}

// Generate a random 4-digit number
function generateRandomNumber() {
  return Math.floor(1000 + Math.random() * 9000); // Generates a number between 1000 and 9999
}

// Generate and display the random number
const randomNumber = generateRandomNumber();
console.log("Generated Code:", randomNumber);

// Display the random number in the element with the class 'code'
const data = document.querySelector(".code");
if (data) {
  data.innerText = `Authentication Code: ${randomNumber}`;
} else {
  console.log("Element with class 'code' not found.");
}

// Add event listener for form submission
document.getElementById("verification-form").addEventListener("submit", function (event) {
  event.preventDefault(); // Prevent form submission

  // Get the entered code from the inputs
  const inputs = document.querySelectorAll(".code-input");
  let enteredCode = "";
  inputs.forEach((input) => {
    enteredCode += input.value;
  });

  // Check if the entered code matches the random number
  const result = document.getElementById("result");
  const authentic = document.getElementById("authentic")
  const form_element = document.getElementById("verification-form");
  const greating = document.querySelector(".greating");
  if (parseInt(enteredCode) === randomNumber) {
    authentic.style.display = "none";
    form_element.style.display = "none";
    data.style.display = "none";

    greating.style.display = "block"
    greating.innerHTML = "Congratulation!"
    result.innerText = "Verification Successful!";
    result.style.color = "green";
  } else {
    authentic.style.display = "none";
    form_element.style.display = "none";
    data.style.display = "none";

    result.innerText = "Verification Failed!";
    result.style.color = "red";
  }
});


document.querySelectorAll('.code-input').forEach((input, index, inputs) => {
    input.addEventListener('input', (e) => {
      if (e.target.value.length === 1 && index < inputs.length - 1) {
        inputs[index + 1].focus(); // Move to the next input field
      } else if (e.target.value.length === 0 && index > 0) {
        inputs[index - 1].focus(); // Move to the previous input field on delete
      }
    });
  
    input.addEventListener('keydown', (e) => {
      if (e.key === 'Backspace' && !e.target.value && index > 0) {
        inputs[index - 1].focus(); // Go back on backspace if empty
      }
    });
  });

  // Focus on the first input field when the page loads
//   document.addEventListener('DOMContentLoaded', () => {
//     const firstInput = document.querySelector('.code-input');
//     if (firstInput) {
//       firstInput.focus();
//     }
//   });