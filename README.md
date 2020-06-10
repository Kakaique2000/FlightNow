# FlightNow

## Introdução

Bem rapeizes, é dada a hora de uma vez por todas fazer essa Trabs, lamento não ter ajudado muito nas partes de SOAP, mas enfim, é dada a hora de desenvolver o projeto final de um SI distribuído, a boa notícia é que, se quiserem utilizar as seguintes tecnologias:

+ Angular
+ Spring Boot
+ PostgreSQL
+ Docker

Já temos esse repositório ready to go! com uma aplicação que pode ser acessada neste [link](http://ec2-52-67-170-93.sa-east-1.compute.amazonaws.com): 

## Estrutura do projeto

O projeto consiste em uma aplicação Angular, que é renderizada localmente, que acessa uma API remota (embora para acessar a aplicação precisamos acessar o site, o mesmo não precisa ser necessariamente utilizado para acessar o sistema, sendo assim, podemos dizer que ele é distribuido, já que o cliente faz requisições ao servidor e essa comunicação é feita da máquina do usuário para a máquina do servidor através de uma API REST

### Como é montado a configuração do sistema distribuído?

Esta parte é completamente feita pelo Docker, o Docker é uma tecnologia que nos permite criar micro máquinas virtuais das quais nos possibilita ter cada aplicação sendo executada em um container sem sofrermos com etapas chatas de configuração e erros de compatibilidade que podem acabar acontecendo, ele é muito útil também para preparar um ambiente de desenvolvimento fácil para nós.

### O que precisamos fazer

No momento temos um pouco de tudo, temos uma pequena aplicação feita em Angular e uma pequena API feita em Spring Boot, e um banco de dados que é criado através da ORM do Spring Boot (Hibernate), o que o professor não quer que seja feito (Ele quer que o banco de dados seja modelado e que cada consulta seja criada por nós, mas isto não é problema, já que conseguimos utilizar o banco criado pela ORM como base e continuar utilizando o Spring Boot para fazer as nossas chamadas pela API)

## Rodando a aplicação

Para tal, é necessário só e somente ter o [Docker](https://docs.docker.com/get-docker/) instalado em sua máquina e rodar o comando `docker compose up -d` na raiz da pasta em que você clonou o repositório e assim, em alguns segundos estará tudo pronto e tranquilo para utilizar a aplicação localmente.

## Desenvolvendo

Para desenvolver, será necessário mais uma ferramenta além do docker instaladas na sua máquina, a primeira delas é o [Node.js](https://nodejs.org/en/download/current/) Recomenda-se a última versão, e além disso é interessante possuir alguma IDE de java como o Eclipse para conseguir desenvolver o back-end
