# Spring Boot Testcontainers

### Formål

Prøver å lage unit -og integrasjonstester for å lære nye [Testcontainers](https://docs.spring.io/spring-boot/reference/testing/testcontainers.html) i Spring.

### Hva gjør denne lille applikasjonen

1. Henter organisasjonsnummer fra Oracle database i [org.testcontainers.oracle-free](https://testcontainers.com/modules/oracle-free/).
2. Bruke det organisasjonsnummeret og gjøre kall mot [Enhetsregisterets hos Brreg](https://data.brreg.no/enhetsregisteret/api/dokumentasjon/no/index.html#tag/Enheter/operation/lastnedEnheterRegneark).
3. Integrasjonstester verifiserer at organisasjonen bli hentet fra Brregs API.
4. Unit test verifiserer at service-laget parser organisasjonen deretter. 

### Kjøre miljøet

Du må ha Docker kjørende i maskinen.

### Guide

The following guides illustrate how to use some features concretely:

* Spring Boot 3.4
* Java 21
* Docker
* Maven

### Kjøre

```
mvn test
```
