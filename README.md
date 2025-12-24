# Consumo de API´s externas - *Por: Gabriel Coutinho*
## 🚀 Sobre o Projeto
**O intuito deste projeto, é no aprofundamento sobre a implementação e consumo de API´s externas em um projeto pessoal. Para a execução do código, foi-se utilizado a API do ViaCep, para consulta completa da região baseado no CEP inserido,
e o OpenWeather, que realiza consultas meteorológicas baseado no Nome da cidade.**

## 📋 Métodos http
*GET - Cep*
**http://localhost:8080/request/cep/{cep} -> Consulta as informações de uma região a partir do Cep informado**

*GET - Weather*
**http://localhost:8080/request/weather/{city} -> Consulta as informações meteorológicas de uma cidade a partir do nome da mesma**

*GET - Info*
**http://localhost:8080/request/info/{cep} -> Consulta informações, tanto da localidade quanto meteorológicas, a partir do Cep**


## 🛠️ Tecnologias utilizadas
* **Linguagem de programação** -> JAVA - 21
* **Framework** -> SpringBoot - 4.0.1
* **IDE** -> Intellij
* **Ambiente para versionamento de código** -> Git e GitHub
* **API ViaCep** -> https://viacep.com.br/
* **API OpenWeather** -> https://openweathermap.org/
* **Ferramenta para consulta externa** -> RestTemplate
