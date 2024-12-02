// Email Form Submission (For index.html)
document.getElementById('email-form')?.addEventListener('submit', function (event) {
    event.preventDefault(); // Prevent the form from submitting

    // Get the email input value
    const email = document.getElementById('email')?.value;

    // Log the email to the console
    console.log('User Email:', email);
    
    // Store the email in localStorage
    
    sessionStorage.setItem('userEmail', email);

    // Redirect to verification.html
    window.location.href = 'verification.html';
});

// Generate a random 4-digit number
