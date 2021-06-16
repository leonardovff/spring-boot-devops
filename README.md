[![pipeline status](https://gitlab.com/leonardovff/sprint-boot-devops/badges/main/pipeline.svg)](https://gitlab.com/leonardovff/sprint-boot-devops/-/commits/main)

# Installation
## with docker-compose 

#### 1. Enable docker swarm
```bash
docker swarm init
```

#### 2. Copy the env-example to .env and setting it 
#### and the copy the dbpassword to .dbpassword
```bash
cp env-example .env
cp dbpassword .dbpassword
```

#### 3. Build and up the container with mysql
```bash
docker-compose up -d db
```
#### 4. Build and up the containers with the application
```bash
docker-compose up -d app1 app2 app3
```

#### 5. Build and up the container with proxy
```bash
docker-compose up -d proxy
```
#### 6. Open the get url http://localhost:8080/demo/all on browser
#### 7. Or send a post to url http://localhost:8080/demo/add on client http

## without docker-compose 


#### 1. Copy the env-example to .env and setting it
```bash
cp env-example .env
```

#### 2. Create a shared local ethernet network
```bash
docker network create -d bridge my-bridge-network 
```

#### 3. Build and up the container with mysql
```bash
# build the container
docker build -t devops/db ./docker-config/db
# build run the container in daemon mode
docker run --rm -d -h db -p 1000:3600 --env-file ./.env --network=devops-network devops/db
```

#### 4. Build and up the container with the application
```bash
# build the container
docker build -t devops/app -f ./docker-config/app/Dockerfile .
# build run the container in daemon mode
docker run --rm -d -h app -p 9000:8080 --env-file ./.env --network=devops-network devops/app 
```

#### 5. Open the get url http://localhost:8080/demo/all on browser
#### 6. Or send a post to url http://localhost:8080/demo/add on client http

## to local development

#### 1. Install dependecies
```bash
mvn install
```
#### 2. Run the application
```bash
mvn spring-boot:run
```

---------------
# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.example.spring-boot' is invalid and this project uses 'com.example.springboot' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

