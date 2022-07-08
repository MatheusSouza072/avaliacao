
<h3>Pré-requisitos</h3>

<li>Git</li>
<li>Ter a versão 17 do Java</li>
<li>IDE</li>

<h3>Passos para execução</h3>
<li>Clonar o repositorório</li>
<li>Abrir o projeto em uma IDE</li>
<li>E rodar a classe "AvaliacaoApplication"</li>

<h4>Atenção</h4>
No projeto, criei uma instância de banco de dados postgres no RDS da AWS, porém caso deseje rodar localmente, basta ter instalado o Docker no seu sistema operacional, e na raiz do projeto rodar "docker-compose up".
Após isso, basta trocar a propriedade spring.datasource.url localizada no application.properties para a seguinte:
<br>spring.datasource.url=jdbc:postgresql://localhost:5432/postgres

<br><br>Para verificar a documentação basta acessar o seguinte link: "http://localhost:8091/swagger-ui/index.html#/"
<br><br>No application.properties a porta está definida como 8091, caso tenha que alterar, altere na propriedade "server.port".
<br><br>URL base da api: http://localhost:8091/
<br><br>As configurações de gerações de estrutura sql do liquibase, encontran-se em resources/db/changelog
