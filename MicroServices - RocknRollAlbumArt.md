# MicroServices - RocknRollAlbumArt

Objectives
- To build a MicroServices application using Spring Boot/Spring Cloud technologies
- Follow best practice MicroServices Design Patterns - The Twelve-Factor App - Heroku's
- Deploy project to AWS using Code Pipelines/ Docker containers
- Demonstrate Unit Testing, Integration Testing
- Provide documentation - SWAGGER
- Business User Case - trivial (intention to demonstrate Spring component technology)

![](rocknroll%20-%20microservices.jpg)

Tools/Technologies
* Java 17
* Spring Boot 3.0 - Starters


* Spring Cloud - Release Train 2022.0.0 - Kilburn

Spring Cloud is a collection of tools that wraps the work of open source companies such as VMware, HashiCorp, and Netflix in delivery patterns.

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

Service discovery—With service discovery and its key feature, service registry, you can make your microservice discoverable so client applications can find them without having the location of the service hardcoded into their application. (Eureka vs. Consul/Zookeeper)

Service routing—With an API Gateway, you can provide a single entry point for all of your services so that security policies and routing rules are applied uniformly to multiple services and service instances in your microservices applications. 

#### Client Resiliency/Load Balancing Patterns

Because microservice architectures are highly distributed, you have to be extremely sensitive in how you prevent a problem in a single service (ors ervice instance) from cascading up and out to the consumers of the service.

* Client-side load balancing - Client-side load balancing—How you cache the location of your service instances on the service so that calls to multiple instances of a microservice are load balanced to all the health instances of that microservice.

* Circuit breaker pattern — How you prevent a client from continuing to call a service that’s failing or suffering performance problems. When a service is running slowly, it consumes resources on the client calling it. You want these microservice calls to fail fast so that the calling client can quickly respond and take appropriate action.

* Fallback pattern — When a service call fails, how you provide a “plug-in” mechanism that allows the service client to try to carry out its work through alternative means other than the microservice being called.

* Bulkhead pattern — Microservice applications use multiple distributed resources to carry out their work. This pattern refers to how you compartmentalize these calls so that the misbehavior of one service call doesn’t negatively impact the rest of the application.



#### Security Patterns

Authentication—How you determine the service client calling the service is who they say they are.


Authorization—How you determine whether the service client calling a
microservice is allowed to undertake the action they’re trying to take.

Credential management and propagation—How you prevent a service client from constantly having to present their credentials for service calls involved in a transaction.

OAuth 2.0


#### Logging & Tracing Patterns

Log correlation - Spring Cloud Sleuth

Log aggregation - Spring Cloud Sleuth (ELK Stack)

Tracing - Spring Cloud Sleuth/Zipkin

#### Application Metrics Patterns
Metrics — How you create critical information about the health of your application and how to expose those metrics

Metrics service—Where you can store and query the application metrics

Metrics visualization suite—Where you can visualize business-related time data for the application and infrastructure


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

#### Spring Cloud Stream - rabbitmq/kafka

###### Annotations

#### Spring Cloud Sleuth - ElasticSearch/Logstash/Kibana

###### Annotations

#### MicroServices 101
Flexible, Scalable, Resilient
The more distributed a system is, the more places it can fail.


![](Micorservices%20Guidelines.jpg)

# GLOSSARY

## C
Cloud Computing Models - Iaas, CaaS, PaaS, FaaS, SaaS

## M

MicroService - A microservice is a small, loosely coupled, distributed service.


## R

REST