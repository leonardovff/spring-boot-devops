# Installation
## with docker-compose 

#### 1. Copy the env-example to .env and setting it
```bash
cp env-example .env
```

#### 2. Build and up the container with mysql
```bash
docker-compose up -d db
```
#### 3. Build and up the container with application
```bash
docker-compose up -d app
```
#### 4. Open the url http://localhost:8080 on browser

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
docker run --rm -d -p 1000:3600 --env-file ./.env --network=devops-network devops/db
```

#### 4. Build and up the container with the application
```bash
# build the container
docker build -t devops/app -f ./docker-config/app/Dockerfile .
# build run the container in daemon mode
docker run --rm -d -p 8080:3600 --env-file ./.env --network=devops-network devops/app 
```


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

