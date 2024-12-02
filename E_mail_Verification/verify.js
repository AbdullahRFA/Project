// On verification.html, retrieve the email from localStorage
const email = localStorage.getItem("userEmail");

// If the email exists, show it in the span
if (email) {
  document.getElementById("email-span").innerText = email;
} else {
  console.log("No email found");
}