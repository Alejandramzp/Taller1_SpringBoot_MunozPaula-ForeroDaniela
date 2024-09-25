function createNewItem(){
    let name = document.getElementById(itemNombre).value
    let price = document.getElementById(itemNombre).value
}

function fetchCategorias(){
    let xhr = new XMLHttpRequest();
    let url = "http://172.16.103.20:8080/api/categorias"
    xhr.open("GET",url,true);
    xhr.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 200){
            let response = JSON.parse(this.responseText);
            console.log(response)
            console.log("Conexió exitosa")
            
            let select=document.getElementById("categorias")

            response.forEach((element, i) => {
                // Create carousel item
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

