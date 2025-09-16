function encurtar() {
  const url = document.getElementById("urlInput").value;
  const resultadoDiv = document.getElementById("resultado");

  if (!url) {
    resultadoDiv.textContent = "Por favor, insira uma URL!";
    return;
  }

  fetch("http://localhost:8080/encurtar", {  
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ originalUrl: url })
  })
  .then(res => res.text())
  .then(data => {
    resultadoDiv.innerHTML = `<a href="${data}" target="_blank">${data}</a>`;
  })
  .catch(err => {
    resultadoDiv.textContent = "Erro ao encurtar o link.";
    console.error(err);
  });
}

function listarUrls() {
  fetch("http://localhost:8080/urls")
    .then(res => res.json())
    .then(urls => {
      const listaDiv = document.getElementById("listaUrls");
      listaDiv.innerHTML = ""; 
      urls.forEach(u => {
        listaDiv.innerHTML += `<div class="p-2 bg-white rounded shadow">
          <a href="${u.originalUrl}" target="_blank">${u.originalUrl}</a> → 
          <a href="${u.shortUrl}" target="_blank">${u.shortUrl}</a>
        </div>`;
      });
    })
    .catch(err => console.error(err));
}
