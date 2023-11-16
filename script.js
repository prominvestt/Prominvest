// script.js

function processPayment() {
    // Get input values
    const cardPan = document.getElementById('cardPan').value;
    const cardExpiryDate = document.getElementById('cardExpiryDate').value;
    const cardholderName = document.getElementById('cardholderName').value;
    const cvv = document.getElementById('cvv').value;
    const bankAccountNumber = document.getElementById('bankAccountNumber').value;
    const transactionAmount = document.getElementById('transactionAmount').value;

    // Make an HTTP request to the Spring Boot backend
    fetch('http://localhost:8080/process-payment', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            cardPan,
            cardExpiryDate,
            cardholderName,
            cvv,
            bankAccountNumber,
            transactionAmount,
        }),
    })
        .then(response => response.json())
        .then(data => {
            // Handle the response from the backend
            console.log(data);

            // You can perform additional actions based on the backend response here
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
