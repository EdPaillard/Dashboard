const unauth = document.querySelector('.unauthenticate');
const auth = document.querySelector('.authenticate')
const hamburger = document.querySelector('#btnHamburger');
const userName = document.querySelector('#userName');


const login = async () => { 
    const response = await fetch('http://localhost:8080/user');
    const data = await response.json();

    if(data.name == null) {
        return;
    } else {
        userName.textContent = data.name;
        auth.style.display = "block";
        unauth.style.display = "none";
    }
}

const logout = async () => {
    const response = await fetch("/logout", {method:"POST"});
    console.log(response);

    userName.textContent = "";
    auth.style.display = "none";
    unauth.style.display = "block";    
}

window.onload = () => {
    login();
}

hamburger.addEventListener('click', () => {
    if(hamburger.classList.contains('open')) {
        hamburger.classList.remove('open');
        hamburger.classList.add('close');
    } else {
        hamburger.classList.add('close');
        hamburger.classList.remove('open');
    }
})