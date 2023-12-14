<div align="center">

[![Java](https://img.shields.io/badge/Java-333333.svg?logo=openjdk&logoColor=white&labelColor=black&style=for-the-badge)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
[![Spring Boot](https://img.shields.io/badge/-Spring%20Boot-333333.svg?logo=spring&labelColor=black&style=for-the-badge)](https://spring.io/projects/spring-boot)
[![Eureka](https://img.shields.io/badge/Eureka-333333.svg?logo=spring&logoColor=4d6b53&labelColor=black&style=for-the-badge)](https://spring.io/projects/spring-cloud-netflix)
[![Spring Cloud Gateway](https://img.shields.io/badge/Spring%20Cloud%20Gateway-333333.svg?logo=SpringCloud&logoColor=4d6b53&labelColor=black&style=for-the-badge)](https://spring.io/projects/spring-cloud-gateway)
[![Hibernate](https://img.shields.io/badge/Hibernate-333333.svg?logo=Hibernate&logoColor=4d6b53&labelColor=black&style=for-the-badge)](https://hibernate.org/)

[![Keycloak](https://img.shields.io/badge/keycloak-333333.svg?logo=keycloak&logoColor=4d6b53&labelColor=black&style=for-the-badge)](https://www.keycloak.org/)
[![Kafka](https://img.shields.io/badge/Kafka-333333.svg?logo=apachekafka&logoColor=4d6b53&labelColor=black&style=for-the-badge)](https://kafka.apache.org/)
[![Prometheus](https://img.shields.io/badge/Prometheus-333333.svg?logo=Prometheus&logoColor=4d6b53&labelColor=black&style=for-the-badge)](https://prometheus.io/)
[![Grafana](https://img.shields.io/badge/Grafana-333333.svg?logo=grafana&logoColor=4d6b53&labelColor=black&style=for-the-badge)](https://grafana.com/)
[![Zipkin](https://img.shields.io/badge/Zipkin-333333.svg?logo=Zipkin&logoColor=4d6b53&labelColor=black&style=for-the-badge)](https://zipkin.io/)

[![MongoDB](https://img.shields.io/badge/-MongoDB-333333.svg?logo=mongodb&logoColor=0197f6&labelColor=black&style=for-the-badge)](https://www.mongodb.com/)
[![PostgreSQL](https://img.shields.io/badge/-PostgreSQL-333333.svg?logo=PostgreSQL&logoColor=0197f6&labelColor=black&style=for-the-badge)](https://www.postgresql.org/)
[![MySQL](https://img.shields.io/badge/-MySQL-333333.svg?logo=mysql&logoColor=red&labelColor=black&style=for-the-badge)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/-docker-333333.svg?logo=docker&logoColor=0197f6&labelColor=black&style=for-the-badge)](https://www.docker.com/)

</div>

---
# JavaCart
JavaCart is a project designed for building and managing microservices that power a webshop ecosystem.

Developed with Java and Spring Boot, this platform integrates Eureka for service discovery, Keycloak for secure authentication, Kafka for efficient event-driven communication, and PostgreSQL, MySQL and MongoDB for flexible data storage. It offers a unified solution for creating, scaling, and orchestrating microservices in a webshop environment. With a focus on reliability and scalability, this application is tailored for building and experimenting with webshop microservices architectures.

---

## Used technologies:

 #### Backend
  - Java 
  - Spring Boot, Spring Security
  - Spring Cloud Netflix, Spring Cloud Gateway
  - Actuator
  - Kafka
  - Webflux
  - JPA Hibernate
  - Lombok
        
 #### Frontend
  - Vue (to be developed in the future)
    
 #### Database
  - MySQL
  - PostgreSQL
  - MongoDB
    
  #### Others
  - Docker
  - Jib
  - Keycloak
  - Zookeeper
  - Zipkin
  - Prometheus
  - Grafana

---
# Installation:

  Follow these instructions to get a copy of the Microservices project up and running on your local machine:

#### 1. Clone the repository
```
git@github.com:RMNorbert/Microservices.git
```

#### 2. Add environment variables for each module according to the application.properties files 

  The files located in each module in 
    
    src/main/resources/

#### 3.1 How to run the application using Docker
    All service avaiable through image.
    Run mvn clean package -DskipTests to build the applications and create the docker image locally.
    Run docker-compose up -d to start the applications.

#### 3.2 How to run the application without Docker

    Run mvn clean verify -DskipTests by going inside each folder to build the applications.
    After that you have to run the docker-compose up -d in the notification-service folder
    After that run mvn spring-boot:run by going inside each folder to start the applications.
