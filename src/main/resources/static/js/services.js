function weather() {
    const value = document.querySelector('#widget-value-weather').value;
    const optionValue = document.querySelector('#weather-widget-options').value;
    console.log(optionValue);
    const deletevalue = document.querySelector('#weather-widget-delete').value;
    console.log(deletevalue);
    const tempDisplay = document.querySelector('#tempDisplay');
    const descriptionDisplay = document.querySelector('#descriptionDisplay');
    const humidityDisplay = document.querySelector('#humidityDisplay');
    const windDisplay = document.querySelector('#windDisplay');
    const descParent = document.querySelector('#descParent');
    const humwindParent = document.querySelector('#humwindParent');


        const getJSON = async () => {
            const response = await fetch("http://localhost:8080/services/weather/temp?value=" + value);
            if(!response.ok) {
                throw new Error(response.statusText);
            }
            const data = await response.json();
            var temperature = data["main"]["temp"];
            temperature = temperature - 273.15;
            temperature = Math.floor(temperature);
            const description = data["weather"][0]["description"];
            const humidity = data["main"]["humidity"];
            const wind = data["wind"]["speed"];
            
            if((optionValue == null || optionValue == "") && (deletevalue == null || deletevalue == "")) {
                if(temperature < (-5)) {
                    var widget_temp = "widget__gel";
                } else if(temperature >= (-5) && temperature <= 5) {
                    var widget_temp = "widget__neige";
                } else if(temperature >= 5 && temperature < 15) {
                    var widget_temp = "widget__froid";
                } else if(temperature >= 15 && temperature < 28) {
                    var widget_temp = "widget__bon";
                } else {
                    var widget_temp = "widget__canicule";
                }
                const html =
                '<div id="' + value + '" class="widget__weather ' + widget_temp + '">\n' +
                '<div id="descParent" class="widget__weather__title">\n' + value +
                ' <span id="descriptionDisplay" class="widget__description"></span>\n' +
                '</div>\n' +
                '<p class="widget__temp">' + temperature + '°<sup>c</sup></p>\n' +
                '<p id="humwindParent" class="widget__humwind"><span id="humidityDisplay" class="widget__humidity"></span><span id="windDisplay" class="widget__wind"></span></p>\n' +
                '</div>';
                if(document.getElementById(value) == null || document.getElementById(value).getAttribute('id') != value) {         
                    tempDisplay.insertAdjacentHTML("afterbegin", html);
                } else if(document.getElementById(value) == value) {
                    return;
                }
            }

            if(document.getElementById(value) == null || document.getElementById(value).getAttribute('id') != value) {
                alert("Veuillez choisir la ville adéquate");
            }
            else if(document.getElementById(value).getAttribute('id') == value) {
                if(optionValue == "description" && descriptionDisplay.textContent == "") {
                    descriptionDisplay.insertAdjacentHTML("afterbegin", description);
                } else if(optionValue == "humidity" && humidityDisplay.textContent == "") {
                    humidityDisplay.insertAdjacentHTML("afterbegin", "Humidité: " + humidity + "%");
                } else if(optionValue == "wind" && windDisplay.textContent == "") {
                    windDisplay.insertAdjacentHTML("afterbegin", "Force du vent: " + wind + "m/s");
                } else if(deletevalue == "descriptionDel") {
                    descParent.removeChild(descriptionDisplay);
                } else if(deletevalue == "humidityDel") {
                    humwindParent.removeChild(humidityDisplay);
                } else if(deletevalue == "windDel") {
                    humwindParent.removeChild(windDisplay);
                } else {
                    return;
                }
            }
        }
        getJSON();
}

function deezer() {
    const value = document.querySelector('#widget-value-deezer').value;

    const deezerDisplay = document.querySelector('#deezerDisplay');

    const getJSON = async () => {
        const response = await fetch("http://localhost:8080/services/music/artist?value=" + value);
        if(!response.ok) {
            throw new Error(response.statusText);
        }
        const data = await response.json();
        const coverAlbum = data["data"][0]["album"]["cover"];
        const albumName = data["data"][0]["album"]["title"];
        const songLink = data["data"][0]["preview"];
        const artistName = data["data"][0]["artist"]["name"];
        const songTitle = data["data"][0]["title"];

        const html =
                '<div id="' + value + '" class="widget">\n' +
                '<div id="descParent" class="widget__title">\n' + songTitle +
                '</div>\n' +
                '<div class="flex">\n' +
                '<img class="widget__cover" src="'+ coverAlbum + '"><div class="widget__artist flex flex-fd-c flex-jc-c flex-ai-c"><strong>Artiste:</strong> ' + artistName + '<br><strong>Album:</strong> ' + albumName + '</div>\n' +
                '</div>' +
                '<div><audio style="width:100%;" src="' + songLink + '" controls>Votre browser ne supporte pas ce lecteur audio</audio></div>\n' +
                '</div>';
                       
        deezerDisplay.insertAdjacentHTML("afterbegin", html);
    }
    getJSON();
}

function news() {
    const value = document.querySelector('#widget-value-news').value;
    const newsDisplay = document.querySelector('#newsDisplay');

    const getJSON = async () => {
        const response = await fetch("http://localhost:8080/services/news/keyword?value=" + value);
        if(!response.ok) {
            throw new Error(response.statusText);
        }
        const data = await response.json();
        const datArray = data["articles"];
            const html = datArray.map(article => {
                if(article.author != null) {
                    return `<article id="${article.source.id}" class="news">
                                <h2 class="news__title">${article.title}</h2>
                                <h4 class="news__source">${article.source.name}</h4>
                                <h4 class="news__author">${article.author}</h4>
                                <p class="news__description">${article.description}<br>
                                <span class="news__full"><strong>Article complet <a href="${article.url}">ici</strong></a></span></p>
                                <p class="news__date"><span><em>${article.publishedAt}</em></span></p>
                            <article>`;
                } else {
                    return `<article id="${article.source.id}" class="news">
                                <h2 class="news__title">${article.title}</h2>
                                <h4 class="news__source">${article.source.name}</h4>
                                <p class="news__description">${article.description}<br>
                                <span class="news__full"><strong>Article complet <a href="${article.url}">ici</strong></a></span></p>
                                <p class="news__date"><span><em>${article.publishedAt}</em></span></p>
                            <article>`;
                }
            })
            .join("");
            newsDisplay.insertAdjacentHTML("afterbegin", html); 
    }
    getJSON();
}

function topnews() {
    const value = document.querySelector('#widget-value-hot').value;
    const hotDisplay = document.querySelector('#hotDisplay');

    const getJSON = async () => {
        const response = await fetch("http://localhost:8080/services/news/topnews?value=" + value);
        if(!response.ok) {
            throw new Error(response.statusText);
        }
        const data = await response.json();
        console.log(data);
        const datArray = data["articles"];
            const html = datArray.map(article => {
                if(article.author != null) {
                    return `<article id="${article.source.id}" class="news">
                                <h2 class="news__title">${article.title}</h2>
                                <h4 class="news__source">${article.source.name}</h4>
                                <h4 class="news__author">${article.author}</h4>
                                <p class="news__description">${article.description}<br>
                                <span class="news__full"><strong>Article complet <a href="${article.url}">ici</strong></a></span></p>
                                <p class="news__date"><span><em>${article.publishedAt}</em></span></p>
                            <article>`;
                } else {
                    return `<article id="${article.source.id}" class="news">
                                <h2 class="news__title">${article.title}</h2>
                                <h4 class="news__source">${article.source.name}</h4>
                                <p class="news__description">${article.description}<br>
                                <span class="news__full"><strong>Article complet <a href="${article.url}">ici</strong></a></span></p>
                                <p class="news__date"><span><em>${article.publishedAt}</em></span></p>
                            <article>`;
                }
            })
            .join("");
            hotDisplay.insertAdjacentHTML("afterbegin", html);                
    }
    getJSON();
}

function youtubeTrend() {
    const valueT = document.querySelector('#widget-value-youTrend').value;
    const youtubeTrendDisplay = document.querySelector('#youtubeTrendDisplay');

    const getJSON = async () => {
        const response = await fetch("http://localhost:8080/services/yt/trendingtop?value=" + valueT);
        if(!response.ok) {
            throw new Error(response.statusText);
        }
        const data = await response.json();
        console.log(data);
        const url = data["items"]

        const html = url.map(element => {
            return `<div class="article__display">
                        <h2>${element.snippet.channelTitle}</h2>
                        <h3>${element.snippet.title}</h3>
                        <img src="${element.snippet.thumbnails.high.url}"/>
                        <p>${element.snippet.description}</p>
                    </div>`
        })
        .join("");
        youtubeTrendDisplay.insertAdjacentHTML("afterbegin", html); 
    }
    getJSON();
}

function youtubeSearch() {
    const valueS = document.querySelector('#widget-value-youSearch').value;
    const youtubeSearchDisplay = document.querySelector('#youtubeSearchDisplay');
    
    const getJSON = async () => {
        const response = await fetch("http://localhost:8080/services/yt/search?value=" + valueS);
        if(!response.ok) {
            throw new Error(response.statusText);
        }
        const data = await response.json();
        console.log(data);
        const url = data["items"]

        const html = url.map(element => {
            return `<div class="article__display">
                        <h2>${element.snippet.channelTitle}</h2>
                        <h3>${element.snippet.title}</h3>
                        <img src="${element.snippet.thumbnails.high.url}" alt="Logo du youtuber"/>
                        <p>${element.snippet.description}</p>
                    </div>`
        })
        .join("");
        youtubeSearchDisplay.insertAdjacentHTML("afterbegin", html); 
    }
    getJSON();
}

function youtubeSub() {
    const valueSub = document.querySelector('#widget-value-youSub').value;
    const youtubeSubDisplay = document.querySelector('#youtubeSubDisplay');

    const getJSON = async () => {
        const response = await fetch("http://localhost:8080/services/yt/subscribers?value=" + valueSub);
        if(!response.ok) {
            throw new Error(response.statusText);
        }
        const data = await response.json();
        console.log(data);
        const url = data["items"]

        const html = url.map(element => {
            return `<div class="article__display">
                        <h2>${valueSub}</h2>
                        <h3>${element.statistics.subscriberCount} abonnés</h3>
                    </div>`
        })
        .join("");
        youtubeSubDisplay.insertAdjacentHTML("afterbegin", html); 
    }
    getJSON();
}