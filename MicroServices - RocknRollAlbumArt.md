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

Configuration management of service—How do you manage the configuration of your microservice so that it moves between different environments in the cloud? <mark>Implemented Spring Cloud CONFIG Server</mark>

Event processing between services—How do you decouple your microservice using events so that you minimize hardcoded dependencies between your services and increase the resiliency of your application?


#### Routing Patterns

Service discovery—With service discovery and its key feature, service registry, you can make your microservice discoverable so client applications can find them without having the location of the service hardcoded into their application. (Eureka vs. Consul/Zookeeper) <mark>Implemented EUREKA Discovery</mark>

Service routing—With an API Gateway, you can provide a single entry point for all of your services so that security policies and routing rules are applied uniformly to multiple services and service instances in your microservices applications. <mark>Implemented Spring Cloud API Gateway</mark>

#### Client Resiliency/Load Balancing Patterns

Because microservice architectures are highly distributed, you have to be extremely sensitive in how you prevent a problem in a single service (ors ervice instance) from cascading up and out to the consumers of the service.

* Client-side load balancing - Client-side load balancing—How you cache the location of your service instances on the service so that calls to multiple instances of a microservice are load balanced to all the health instances of that microservice.

* Circuit breaker pattern — How you prevent a client from continuing to call a service that’s failing or suffering performance problems. When a service is running slowly, it consumes resources on the client calling it. You want these microservice calls to fail fast so that the calling client can quickly respond and take appropriate action.

* Fallback pattern — When a service call fails, how you provide a “plug-in” mechanism that allows the service client to try to carry out its work through alternative means other than the microservice being called.

* Bulkhead pattern — Microservice applications use multiple distributed resources to carry out their work. This pattern refers to how you compartmentalize these calls so that the misbehavior of one service call doesn’t negatively impact the rest of the application.



#### Security Patterns

Authentication—How you determine the service client calling the service is who they say they are.

<mark>Implemented Spring Cloud Security</mark>

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


## Heroku - [https://www.baeldung.com/spring-boot-12-factor](https://www.baeldung.com/spring-boot-12-factor)
### 1. Codebase

The first best practice of twelve-factor apps is to track it in a version control system. Same codebase across all deploys - but can be different versions.
This app was initial developed locally using <mark>GIT</mark>. Ultimately it will be deployed using <mark>AWS CodeCommit</mark> and a pipeline to Containers on EC2.

![Single code base held in VCS (GIT)](codebase.jpg)

### 2. Dependencies

A twelve-factor app should always explicitly declare all its dependencies. We should do this using a dependency declaration manifest. Java has multiple dependency management tools like Maven and Gradle. Maven is used on this project to achieve this goal. <mark>Configured as a Multi-Module Maven project</mark> . Dependencies described in the POM.

### 3. Configurations

A twelve-factor app should externalize all such configurations that vary between deployments. The recommendation is to use environment variables for such configurations. This leads to a clean separation of config and code. In this App I am using Spring Boot Config Server, with Config held in a GIT repo.

### 4. Backing Services

Backing services are services that the application depends on for operation. For instance a database or a message broker. A twelve-factor app should treat all such backing services as attached resources. What this effectively means is that it shouldn't require any code change to swap a compatible backing service. The only change should be in configurations.

In my application, I've used <mark>MySQL as the backing service to provide persistence</mark>.

Spring JPA makes the code quite agnostic to the actual database provider. I only need to define a repository which provides all standard operations:

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

This is not dependent on MySQL directly. Spring detects the MySQL driver on the classpath and provides a MySQL-specific implementation of this interface dynamically. Moreover, it pulls other details from configurations directly.

So, if I change from MySQL to Oracle, all I have to do is replace the driver in  dependencies and replace the configurations.

### 5. Build, Release and Run


### 6. Processes

A twelve-factor app is expected to run in an execution environment as stateless processes. In other words, they can not store persistent state locally between requests. It may generate persistent data which is required to be stored in one or more stateful backing services.

**BUT**

a twelve-factor app imposes no such restriction like ***sticky sessions***. This makes such an app highly portable and scalable. In a cloud execution environment offering automated scaling, it's quite a desirable behavior from applications.

### 7. Port Binding

A twelve-factor app expects runtime dependency. It's completely self-contained and only requires an execution runtime like Java.

java -jar application.jar

Upon starting the application, it should be possible to access the exported services via HTTP.

### 8. Concurrency

### 9. Disposability

Application processes can be shut down on purpose or through an unexpected event. In either case, a twelve-factor app is supposed to handle it gracefully. In other words, an application process should be completely disposable without any unwanted side-effects. Moreover, processes should start quickly

For instance, in this application, one of the endpoints is to create a new playlist record for a user. Now, an application handling such a request may crash unexpectedly. This should, however, not impact the state of the application. When a client sends the same request again, it shouldn't result in duplicate records.

In summary, the application should expose idempotent services. This is another very desirable attribute of a service destined for cloud deployments. This gives the flexibility to stop, move, or spin new services at any time without any other considerations.

### 10. Dev/Prod parity

It's typical for applications to be developed on local machines, tested on some other environments and finally deployed to production. It's often the case where these environments are different. For instance, the development team works on Windows machines whereas production deployment happens on Linux machines.

The twelve-factor methodology suggests keeping the gap between development and production environment as minimal as possible. These gaps can result from long development cycles, different teams involved, or different technology stack in use.

Now, technology like Spring Boot and Docker automatically bridge this gap to a great extent. A containerized application is expected to behave the same, no matter where we run it. We must use the same backing services – like the database – as well.

Moreover, we should have the right processes like continuous integration and delivery to facilitate bridging this gap further.

### 11. Logs

Logs are essential data that an application generates during its lifetime. They provide invaluable insights into the working of the application. Typically an application can generate logs at multiple levels with varying details and output ii in multiple different formats.

A twelve-factor app, however, separates itself from log generation and its processing. For such an app, logs are nothing but a time-ordered stream of events. It merely writes these events to the standard output of the execution environment. The capture, storage, curation, and archival of such stream should be handled by the execution environment.

Logging for this app implemented with ElasticSearch/Logstash/Kibana

### 12. Admin Processes



# GLOSSARY

## C
Cloud Computing Models - Iaas, CaaS, PaaS, FaaS, SaaS

## M

MicroService - A microservice is a small, loosely coupled, distributed service.


## R

REST