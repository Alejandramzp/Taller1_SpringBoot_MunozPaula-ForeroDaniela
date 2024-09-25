let items=[];

function fetchApi(){
    let xhr = new XMLHttpRequest();
    let url = "http://172.16.103.20:8080/api/items"
    xhr.open("GET",url,true);
    xhr.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 200){
            let response = JSON.parse(this.responseText);
            console.log(response)
            console.log("Conexió exitosa")
        } else if(this.readyState == 4){
            console.log("Error :(",this.statusText)
        }
    }
    xhr.send();
}

function add_carousel() {
    let xhr = new XMLHttpRequest();
    let url = "http://172.16.103.20:8080/api/items";
    xhr.open("GET", url, true);
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            let response = JSON.parse(this.responseText);
            console.log(response);
            console.log("Conexió exitosa");

            let carouselInner = document.getElementById("carousel-items");
            let buttonCar = document.getElementById("indicators_items");

            // Clear previous items
            carouselInner.innerHTML = '';
            buttonCar.innerHTML = '';

            response.forEach((element, i) => {
                // Create carousel item
                let divContainer = document.createElement("div");
                divContainer.className = `carousel-item ${i === 0 ? 'active' : ''}`; // Only first item is active
                divContainer.setAttribute("data-bs-interval", "10000");
                if (element.descripcion==null || element.descripcion==""){
                    divContainer.innerHTML = `
                    <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: First slide" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#f5f5f5"></rect><text x="50%" y="50%" fill="#aaa" dy=".3em">First slide</text></svg>
                    <div class="carousel-caption d-none d-md-block">
                        <h5>${element.nombre}</h5>
                        <p></p>
                        <p>$${element.precio}</p>
                    </div>
                    `;
                }else{
                    divContainer.innerHTML = `
                    <img src="${element.imagen}" class="d-block w-100" alt="${element.nombre}">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>${element.nombre}</h5>
                        <p>${element.descripcion}</p>
                        <p>$${element.precio}</p>
                    </div>
                    `;
                }
                carouselInner.appendChild(divContainer);

                // Create carousel indicator button
                let newButton = document.createElement("button");
                newButton.type = "button";
                newButton.setAttribute("data-bs-target", "#carouselExampleDark"); // Ensure this matches the carousel ID
                newButton.setAttribute("data-bs-slide-to", `${i}`);
                newButton.setAttribute("aria-label", `Slide ${i + 1}`);
                newButton.className = `${i === 0 ? 'active' : ''}`; // Only first button is active

                buttonCar.appendChild(newButton);
            });
        } else if (this.readyState === 4) {
            console.log("Error :(", this.statusText);
        }
    }
    xhr.send();
}

add_carousel();

