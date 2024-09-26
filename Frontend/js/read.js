let url = "http://localhost:8080/api/items"
let url_categorias = "http://localhost:8080/api/categorias"


function fetchApi() {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url, true);
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            let response = JSON.parse(this.responseText);
            console.log(response);
            console.log("Conexión exitosa");

            let divSpace = document.getElementById("cardContainer");
            divSpace.innerHTML = "";

            let promises = response.map(async element => {
                const category = await getCategory(element.id_categoria);
                let card = document.createElement("div");
                card.classList.add("col");
                card.innerHTML = `
                    <div class="card">
                        <img src="${element.imagen}" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${element.nombre} ${element.proveedor}</h5>
                            <p class="card-text">${element.descripcion}</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item"><b>Precio:</b> $${element.precio}</li>
                            <li class="list-group-item"><b>Proveedor:</b> ${element.proveedor}</li>
                            <li class="list-group-item"><b>Categoría:</b> ${category}</li>
                        </ul>
                    </div>
                `;
                return card;
            });

            Promise.all(promises).then(cards => {
                cards.forEach(card => divSpace.appendChild(card));
            });

        } else if (this.readyState === 4) {
            console.log("Error :(", this.statusText);
        }
    };
    xhr.send();
}


fetchApi()

function searchItem() {
    let nombre_item = document.getElementById("searchNombre").value;
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url, true);
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            let response = JSON.parse(this.responseText);
            console.log(response);
            console.log("Conexión exitosa");

            let filteredResponse = response.filter(element => 
                element.nombre.toLowerCase() === nombre_item.toLowerCase()
            );

            let divSpace = document.getElementById("cardContainer");
            divSpace.innerHTML = "";

            let promises = filteredResponse.map(async element => {
                const category = await getCategory(element.id_categoria);
                let card = document.createElement("div");
                card.classList.add("col");
                card.innerHTML = `
                    <div class="card">
                        <img src="${element.imagen}" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${element.nombre} ${element.proveedor}</h5>
                            <p class="card-text">${element.descripcion}</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item"><b>Precio:</b> $${element.precio}</li>
                            <li class="list-group-item"><b>Proveedor:</b> ${element.proveedor}</li>
                            <li class="list-group-item"><b>Categoría:</b> ${category}</li>
                        </ul>
                    </div>
                `;
                return card;
            });

            Promise.all(promises).then(cards => {
                cards.forEach(card => divSpace.appendChild(card));
            });
        } else if (this.readyState === 4) {
            console.log("Error :(", this.statusText);
        }
    };
    xhr.send();
}

function getCategory(id_categoria) {
    return new Promise((resolve, reject) => {
        let xhr = new XMLHttpRequest();
        xhr.open("GET", url_categorias, true);
        xhr.onreadystatechange = function() {
            if (this.readyState === 4) {
                if (this.status === 200) {
                    let cat = JSON.parse(this.responseText);
                    let category = cat.find(categoria => categoria.id_categoria === id_categoria);
                    resolve(category ? category.nombre : "Sin categoría");
                } else {
                    reject(this.statusText);
                }
            }
        };
        xhr.send();
    });
}