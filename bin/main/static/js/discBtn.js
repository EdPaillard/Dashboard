const discBtn = document.querySelector('#discBtn');

discBtn.addEventListener('click', async () => {
    const response = await fetch('/logout');
    if(!response.ok) {
        throw new Error(response.statusText);
    } else {
        location.replace("http://localhost:8080/login");
    }
})