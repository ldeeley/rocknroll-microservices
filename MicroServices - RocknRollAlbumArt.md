# MicroServices - RocknRollAlbumArt

Objectives
- To build a MicroServices application using Spring Boot/Spring Cloud technologies
- Follow best practice MicroServices Design Patterns - The Twelve-Factor App
- Deploy project to AWS using Code Pipelines/ Docker containers
- Demonstrate Unit Testing, Integration Testing
- Provide documentation - SWAGGER
- Business User Case - trivial (intention to demonstrate Spring component technology)

![](rocknroll%20-%20microservices.jpg)

Tools/Technologies
* Java 17
* Spring Boot 3.0 - Starters


* Spring Cloud
* Intellij - Ultimate
* Maven - Multi-Module
* GitHub
* SonarLint
* Docker
* CI/CD - AWS - Code Commit/Code Pipeline/EC2/CaaS
* MySQL
* Lombok
* POSTMAN
* Bootstrap 5.0
* Thymeleaf
* Junit Jupiter/Mockito/Test Containers



## Microservices Design Patterns
#### Core Development Patterns
Service granularity—How do you approach decomposing a business domain down into microservices so that each microservice has the right level of responsibility?

Communication protocols—How will developers communicate with your service?

Interface design—What’s the best way to design the actual service interfaces that developers are going to use to call your service? How do you structure your services?

Configuration management of service—How do you manage the configuration of your microservice so that it moves between different environments in the cloud?

Event processing between services—How do you decouple your microservice using events so that you minimize hardcoded dependencies between your services and increase the resiliency of your application?


#### Routing Patterns

Service discovery—With service discovery and its key feature, service registry, you can make your microservice discoverable so client applications can find them without having the location of the service hardcoded into their application.

Service routing—With an API Gateway, you can provide a single entry point for all of your services so that security policies and routing rules are applied uniformly to multiple services and service instances in your microservices applications. 

#### Client Resiliency Patterns

Because microservice architectures are highly distributed, you have to be extremely sensitive in how you prevent a problem in a single service (ors ervice instance) from cascading up and out to the consumers of the service.

* Client-side load balancing
* Circuit breaker pattern
* Fallback Pattern
* Bulkhead pattern


#### Security Patterns
#### Logging & Tracing Patterns
#### Application Metrics Patterns
#### Build & Deployment Patterns



## Spring Boot Starters

#### WebMVC

###### Annotations

#### Discovery Server/Client

###### Annotations

#### Config Server

###### Annotations

#### Actuator

###### Annotations

#### API Gateway

###### Annotations

#### Security

###### Annotations

#### Data JPA

###### Annotations


#### MicroServices 101
Flexible, Scalable, Resilient

![](Micorservices%20Guidelines.jpg)

# GLOSSARY

## C
Cloud Computing Models - Iaas, CaaS, PaaS, FaaS, SaaS

## M

MicroService - A microservice is a small, loosely coupled, distributed service.


## R

REST