const trigger = document.querySelector('#connecHidBtn');
const hiddenMenu = document.querySelector('#hiddenMenu');

trigger.addEventListener('click', () => {

    if(hiddenMenu.style.display == "block") {
        hiddenMenu.style.display = "none";
    } else {
        hiddenMenu.style.display = "block";
    }

});