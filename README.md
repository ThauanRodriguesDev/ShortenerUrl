
# ShortnerUrl  

Este é um projeto de **Encurtador de URL** desenvolvido com **Java Spring Boot** e **PostgreSQL**, utilizando Docker para facilitar o ambiente de execução.  

## Funcionalidades  

- **Encurtar URLs**: Permite gerar URLs curtas baseadas em uma URL original.  
- **Definir prazo de expiração**: Configure um tempo limite para a validade da URL.  
- **Base customizável**: Escolha uma base para a URL encurtada (domínio ou caminho).  

## Pré-requisitos  

- **Docker** e **Docker Compose** instalados em sua máquina.  
- Um cliente HTTP, como o **Postman**, para interagir com a API.  

## Configuração  

1. Clone o repositório:  
   ```bash
   git clone https://github.com/ThauanRodriguesDev/ShortenerUrl.git
   cd seu-repositorio  
   ```  

2. Execute o Docker Compose para iniciar a aplicação:  
   ```bash
   docker-compose up  
   ```  

   Isso irá subir os contêineres do aplicativo Spring Boot e do banco de dados PostgreSQL.  

## Uso da API  

Para encurtar uma URL, envie uma requisição **POST** para o endpoint `/api/url` com o seguinte payload:  

```json
{
  "originalUrl": "https://www.example.com/minha-url-longa",
  "expirationTime": "2024-12-31T23:59:59", 
  "base": "https://meu-dominio.com"
}
```  

### Parâmetros  

- **originalUrl**: (Obrigatório) A URL que será encurtada.  
- **expirationTime**: (Obrigatório) Tempo no Formato de Timestamp.  
- **base**: (Obrigatório) Base personalizada para a URL encurtada (58 ou 62).  

### Exemplo de resposta  

```json
{
  "shortUrl": "https://meu-dominio.com/abc123",
  "originalUrl": "https://www.example.com/minha-url-longa",
  "expirationTime": "1389261489109"
}
```  

## Tecnologias Utilizadas  

- **Java Spring Boot**: Framework para desenvolvimento do back-end.  
- **PostgreSQL**: Banco de dados relacional para armazenar as URLs.  
- **Docker**: Contêineres para facilitar a execução do projeto.  

## Contribuição  

Sinta-se à vontade para abrir issues ou enviar pull requests com melhorias e correções.  
