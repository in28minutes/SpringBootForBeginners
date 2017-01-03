##What You Will Learn during this Step:
- Spring Boot vs Spring
- What Spring Boot is Not!
- Auto component scan

##Spring Boot vs Spring
###Spring
Spring is just a dependency management framework. Spring focuses on the "plumbing" of enterprise applications so that teams can focus on application-level business logic, without unnecessary ties to specific deployment environments.
 - Goals
  - Make applications testable. i.e. easier to write unit tests
  - Reduce plumbing code of JDBC and JMS
  - Simple architecture. Minus EJB.
  - Integrates well with other popular frameworks.

###My experience with Spring based Applications
- Developing Spring Based application need configuration of a lot of beans!
- Integration with other frameworks need configuration as well!
- Added to these, applications need other features (logging, transaction management, monitoring, configuration management etc) before they can go live!
- Spring Boot solves these problems

###Spring Boot
- Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can “just run”. Most Spring Boot applications need very little Spring configuration.
 - Goals
  - Provide quick start for projects with Spring.
  - Be opinionated but provide options.
  - Provide a range of non-functional features that are common to large classes of projects (e.g. embedded servers, security, metrics, health checks, externalized configuration).
- Absolutely no code generation and no requirement for XML configuration.

####What Spring Boot is NOT?
- It’s not an app or a web server
- Does not implement any specific framework - for example, JPA or JMS
- Does not generate code

