const url_items = "http://172.16.100.111:8080/api/items"
const url_categorias = "http://172.16.100.111:8080/api/categorias"

function createNewItem() {
    let name = document.getElementById("itemNombre").value.trim();
    let provider = document.getElementById("itemProveedor").value.trim();
    let category = parseInt(document.getElementById("categorias").value);
    let descripcion = document.getElementById("itemDescripcion").value.trim();
    descripcion = descripcion === "" ? null : descripcion; // Se mantiene igual
    let price = parseFloat(document.getElementById("itemPrecio").value); 
    let image = document.getElementById("itemImagen").value.trim();

    let xhr = new XMLHttpRequest();
    xhr.open("POST", url_items, true);
    xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200 || xhr.status === 201) {
                console.log("Respuesta exitosa:", xhr.responseText);
            } else {
                console.error("Error en la solicitud:", xhr.status, xhr.statusText);
            }
        }
    };

    let data = {
        "nombre": name,
        "descripcion": descripcion,
        "proveedor": provider,
        "id_categoria": category,
        "precio": price,
        "imagen": image
    };

    xhr.send(JSON.stringify(data));
}

var e = document.getElementById("categorias");
e.onchange = function() {
  var strUser = e.options[e.selectedIndex].value;
  console.log(document.getElementById("itemNombre").value);
  console.log(document.getElementById("itemProveedor").value);
  console.log(document.getElementById("itemDescripcion").value);

  console.log(parseInt(strUser));
  console.log(document.getElementById("itemImagen").value);
}

function fetchCategorias(){
    let xhr = new XMLHttpRequest();
    xhr.open("GET",url_categorias,true);
    xhr.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 200){
            let response = JSON.parse(this.responseText);
            console.log(response)
            console.log("Conexió exitosa")
            
            let select=document.getElementById("categorias")

            response.forEach((element, i) => {
                let option = document.createElement("option");
                option.value=element.id_categoria;
                option.innerText=element.nombre;
                
                select.appendChild(option);
            })

        } else if(this.readyState == 4){
            console.log("Error :(",this.statusText)
        }
    }
    xhr.send();
}

fetchCategorias();