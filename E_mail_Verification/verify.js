// Retrieve the email from sessionStorage
const email = sessionStorage.getItem("userEmail");
// Add event listener for the close button
const close = document.getElementById("close");

// Display email in the email span if available
if (email) {
  document.getElementById("email-span").innerText = email;
} else {
  console.log("No email found in sessionStorage.");
}

// Function to generate a random 4-digit OTP
function generateRandomNumber() {
  return Math.floor(1000 + Math.random() * 9000); // Generates a number between 1000 and 9999
}

// Generate and display the OTP
const randomNumber = generateRandomNumber();
console.log("Generated OTP:", randomNumber);

// Display the random number in the element with class 'code'
const data = document.querySelector(".code");
if (data) {
  data.innerText = `Authentication Code: ${randomNumber}`;
} else {
  console.log("Element with class 'code' not found.");
}

// Event listener for OTP verification form submission
document
  .getElementById("verification-form")
  .addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent default form submission

    // Get the entered OTP from input fields
    const inputs = document.querySelectorAll(".code-input");
    let enteredCode = "";
    let isComplete = true;

    inputs.forEach((input) => {
      if (!input.value.trim()) {
        isComplete = false;
        input.focus();
      }
      enteredCode += input.value.trim();
    });

    if (!isComplete) {
      alert("Please fill all input fields.");
      return;
    }

    // Clear any previous result message
    const result = document.getElementById("result");
    result.innerText = "";

    // Validate the entered OTP
    const authentic = document.getElementById("authentic");
    const formElement = document.getElementById("verification-form");
    const greeting = document.querySelector(".greating");

    if (parseInt(enteredCode) === randomNumber) {
      // Success: Hide form and show success message
      authentic.style.display = "none";
      formElement.style.display = "none";
      data.style.display = "none";

      greeting.style.display = "block";
      greeting.innerHTML = "Congratulations!";
      result.innerText = "Verification Successful!";
      result.style.color = "green";

      // Redirect on close button
      close.addEventListener("click", (event) => {
        event.preventDefault(); // Prevent default behavior of the anchor tag
        window.location.href = "index.html";
      });

      // close.addEventListener("keydown", (event) => {
      //   if (event.key == "Enter") {
      //     window.location.href = "index.html";
      //   }
      // });
    } else {
      // Failure: Show error message
      authentic.style.display = "none";
      formElement.style.display = "none";
      data.style.display = "none";

      result.innerText = "Invalid OTP!";
      result.style.color = "red";

      // Redirect on close button
      close.addEventListener("click", (event) => {
        event.preventDefault();
        window.location.href = "verification.html";
      });

      // close.addEventListener("keydown", (event) => {
      //   if (event.key == "Enter") {
      //     window.location.href = "verification.html";
      //   }
      // });
    }
  });

// Auto-focus and move between input fields
document.querySelectorAll(".code-input").forEach((input, index, inputs) => {
  // Allow only numbers
  input.addEventListener("input", (e) => {
    e.target.value = e.target.value.replace(/[^0-9]/g, ""); // Restrict input to numbers

    // Move to the next input on valid entry
    if (e.target.value.length === 1 && index < inputs.length - 1) {
      inputs[index + 1].focus();
    }
  });

  // Move to the previous input on Backspace
  input.addEventListener("keydown", (e) => {
    if (e.key === "Backspace" && !e.target.value && index > 0) {
      inputs[index - 1].focus();
    }
  });
});

// Focus on the first input field when the page loads
document.addEventListener("DOMContentLoaded", () => {
  const firstInput = document.querySelector(".code-input");
  if (firstInput) {
    firstInput.focus();
  }
});