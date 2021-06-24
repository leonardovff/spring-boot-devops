[![pipeline status](https://gitlab.com/leonardovff/sprint-boot-devops/badges/main/pipeline.svg)](https://gitlab.com/leonardovff/sprint-boot-devops/-/commits/main)
[![coverage](https://gitlab.com/leonardovff/sprint-boot-devops/badges/main/coverage.svg)]((https://gitlab.com/leonardovff/sprint-boot-devops/-/commits/main))

# Installation
## with docker-compose 

#### 1. Copy the env-example to .env and setting it 
#### and the copy the dbpassword to .dbpassword
```bash
cp env-example .env
cp dbpassword .dbpassword
```

#### 2. Build and up the container with mysql
```bash
docker-compose up -d db
```
#### 3. Build and up the containers with the application
```bash
docker-compose up -d app1 app2 app3
```

#### 4. Build and up the container with proxy
```bash
docker-compose up -d proxy
```
#### 5. Open the get url http://localhost:8080/users on browser
#### 6. Or send a post to url http://localhost:8080/users on client http

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

#### 5. Open the get url http://localhost:8080/users on browser
#### 6. Or send a post to url http://localhost:8080/users on client http

## to local development

#### 1. Install dependecies
```bash
mvn install
```
#### 2. Run the application
```bash
mvn spring-boot:run
```
