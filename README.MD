# Desafio: Url Shortener

Projeto desenvolvido como uma forma de resolução do desafio proposto pelo repositório [Backend Brasil](https://github.com/backend-br).

## 🚀  Tecnologias

- Java 21
- Spring Boot
- Docker
- Redis

## ✍  Instalação

Para rodar o projeto em sua máquina, siga as etapas abaixo:

1. Clone o repositório:
```
https://github.com/lusgaoliveira/url-shortener.git
```
   
2. Execute o comando docker compose up
```
docker compose up
```

3. Execute o projeto com Maven ou de apenas um run em sua IDE
    - Maven:
    ```mvn spring-boot:run```


## 📑 Uso 

### 1. Encurtar um URL (POST)
**[POST]**```{host}/shorten-url```
Ao enviar uma requisição POST para o endpoint acima, incluindo no corpo da requisição um JSON com o campo abaixo:
    - url: A url que será encurtada

### 2. Receber a URL encurtada (GET)
Logo após encurtar a url, o servidor retornará um 200 ok com a url encurtada. Caso você copie e utilize essa url em seu navegador, você navegador será redirecionada para a URL original.

**Resposta**
```
{
    "shortUrl": "http://localhost:8080/Nei03H"
}
```

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENÇA](LICENCE.MD) para detalhes.