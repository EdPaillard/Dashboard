const weatherSection = document.querySelector('.section__weather');
const deezerSection = document.querySelector('.section__deezer');
const newsSection = document.querySelector('.section__news');
const hotSection = document.querySelector('.section__hot');
const youtubeSection = document.querySelector('.section__youtube');

window.onload = () => {
// var req = new XMLHttpRequest();
// req.open('GET', document.location, false);
// req.send(null);
// var headers = req.getAllResponseHeaders().toLowerCase();
// console.log(typeof headers);
// console.log(headers);


    // async function getId() {
    //     const response = await fetch("/getID");
    //     const data = await response.json();
    //     console.log(data);
    // }
    // getId();

    // async function getWidgets() {
    //     const response = await fetch("/getWidgets");
    //     const data = await response.json();
    //     console.log(data);
    // }
    // getWidgets();



    weatherSection.style.display = "none";
    deezerSection.style.display = "none";
    newsSection.style.display = "none";
    hotSection.style.display = "none";
    youtubeSection.style.display = "none";

    async function getServices(){
        const response = await fetch("/getServices");
        if(!response.ok) {
            throw new Error(response.statusText);
        }
        const data = await response.json();
        // const key = Object.keys(data);
        // const value = Object.values(data);
        // console.log(key);
        // console.log(value);
        

        for(const [key, value] of Object.entries(data)) {
            switch(key) {
                case "weather":
                    if(value == "true") {
                    weatherSection.style.display = "flex";
                    }
                    break;
                case "deezer":
                    if(value == "true") {
                    deezerSection.style.display = "flex";
                    }
                    break;
                case "news":
                    if(value == "true") {
                        newsSection.style.display = "flex";
                        hotSection.style.display = "flex";
                        }
                        break;
                case "youtube":
                    if(value == "true") {
                        youtubeSection.style.display = "flex";
                        }
                        break;
                case "weather":
                    if(value == "false") {
                        weatherSection.style.display = "none";
                        }
                        break;
                case "deezerDel":
                    if(value == "false") {
                        deezerSection.style.display = "none";
                        }
                        break;
                case "NewsDel":
                    if(value == "false") {
                        newsSection.style.display = "none";
                        hotSection.style.display = "none";
                        }
                        break;
                case "YoutubeDel":
                    if(value == "false") {
                        youtubeSection.style.display = "none";
                        }
                        break;
                    default:
                        return;
            }
        }
    }
    getServices();
}


const formOptions = document.querySelector('.form__options');
const optionBtn = document.querySelector('#optionBtn');

optionBtn.addEventListener('click', () => {
    if(formOptions.style.display == "block") {
        formOptions.style.display = "none";
    } else {
        formOptions.style.display = "block";
    }
});

async function addServices(service) {
    const response = await fetch("/saveServices",
                        {method: 'POST',
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(service)
                    });
}

async function delServices(service) {
    const response = await fetch("/saveServices",
                        {method: 'POST',
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(service)
                    });
}


function servicesOption() {
    const value = document.querySelector('#displaySize').value;

    switch(value) {
        case "weather":
            weatherSection.style.display = "flex";
            addServices({'weather': 'true'});
            break;
        case "deezer":
            deezerSection.style.display = "flex";
            addServices({'deezer': 'true'});
            break;
        case "News":
            newsSection.style.display = "flex";
            hotSection.style.display = "flex";
            addServices({'news': 'true'});
            break;
        case "Youtube":
            youtubeSection.style.display = "flex";
            addServices({'youtube': 'true'});
            break;
        case "weatherDel":
            weatherSection.style.display = "none";
            delServices({'weather': 'false'});
            break;
        case "deezerDel":
            deezerSection.style.display = "none";
            delServices({'deezer': 'false'});
            break;
        case "NewsDel":
            newsSection.style.display = "none";
            hotSection.style.display = "none";
            delServices({'news': 'false'});
            break;
        case "YoutubeDel":
            youtubeSection.style.display = "none";
            delServices({'youtube': 'false'});
            break;
            default:
                return;
    }

}