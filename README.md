# test-jsf

Essa é uma aplicação desenvolvida com Java EE, utilizando os frameworks JSF, JPA e o banco de dados H2. Foi utilizado o servidor Wildfly
na versao "Jakarta EE Full & Web Distribution" obtido a partir do endereco: https://www.wildfly.org/downloads/
Também foi necessário instalar o plugin do Eclipse "Jboss Tools" que pode ser obtido acessando a IDE do Eclipse em help -> eclipse marketplace

Dentre as configurações realizadas para o seu funcionamento, deve-se acessar as propriedades do projeto no Eclipse, ativar o suporte ao CDI
e na aba do "Project Facets", selecionar as opcoes CDI, Dynamic Web Project 4.0, Java 11, Javascript 1.0, Java Server Faces (utilizei o 2.2), 
JAX-RS 2.1, JBoss Maven Integration 1.0 e JPA 2.2.

É preciso o uso da JDK 11.

Para executar a aplicação, deve-se instalar as dependências do projeto, adicionar o servidor Wildfly ao Eclipse e adicionar o projeto ao servidor.

após inicializar o servidor, a aplicação estará disponivel na porta 8080 através da url http://localhost:8080 ou http://localhost:8080/login.xhtml
