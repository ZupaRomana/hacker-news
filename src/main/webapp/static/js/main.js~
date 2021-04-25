const BASE_URL = 'http://localhost:8080';

function fetchData(route) {
    window.history.pushState(null, null, route);
    if (route.startsWith("?")) {
        route = window.location.pathname + route;
    }
    fetch(BASE_URL + "/api" + route)
        .then(response => response.json())
        .then(renderNews);
}

function menuHandler(event) {
    let elem = event.target;
    let url = elem.getAttribute("href");
    if (!url.startsWith("http")) {
        fetchData(url);
        event.preventDefault();
    }
}

function paging(event) {
    const params = new URLSearchParams(window.location.search);
    let pageValue = event.target.id === "prev" ? -1 : 1;
    let newPage = +params.get("page") + pageValue;
    params.set("page", newPage);

    fetchData("?" + params.toString());
}

function bindEventListeners() {
    let menu = document.querySelectorAll(".nav-link");
    menu.forEach((menuItem) => {
        menuItem.addEventListener("click", menuHandler, true);
    });

    let prev = document.getElementById("prev");
    let next = document.getElementById("next");
    next.addEventListener("click", paging);
    prev.addEventListener("click", paging);
}

function renderNews(news) {
    let newsDiv = document.getElementById("news");
    newsDiv.innerHTML = "";

    news.forEach((newsItem) => {
        let card = `<div class="card-body">
                        <div class="card-title"><a href="${newsItem.url}" target="_blank">${newsItem.title}</a></div>
                        <p class="card-text">${newsItem.timeAgo}<br />${newsItem.author}</p>
                    </div>`;
        let cardElement = document.createElement('div');
        cardElement.classList.add("card");
        cardElement.classList.add("text-white");
        cardElement.classList.add("bg-dark");
        cardElement.classList.add("mb-3");
        cardElement.style.width = "18rem";
        cardElement.innerHTML = card;
        newsDiv.appendChild(cardElement);
    });
}

function getRoute() {
    let path = window.location.pathname === "/" ? "/top" : window.location.pathname;
    let search = window.location.search === "" ? "?page=1" : window.location.search;
    return path + search;
}

(function () {
    bindEventListeners();
    let route = "/top?page=1";
    fetchData(route);
})();

(() => {
    console.log(document.getElementById('submit'));
    document.getElementById('submit').addEventListener('click', () => {
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        fetch(`${BASE_URL}/login`, {
            method: 'POST',
            body: JSON.stringify({username, password})
        }).then(response => response.json())
            .then(response => console.log(response));
    });
})();