### Relevant Articles:
https://www.baeldung.com/spring-cloud-netflix-hystrix
#####Testing Hystrix Fallback ######

Now that we have configured the circuit, we can test it by bringing down the H2 database our repository interacts with. But first, let’s run H2 instance as external processes instead of running it as an embedded database.

Let us copy the H2 library (h2-1.4.193.jar) to a known directory and start the H2 server:
```
>java -cp h2-1.4.193.jar org.h2.tools.Server -tcp
TCP server running at tcp://192.168.99.1:9092 (only local connections)
```

Let us update our module’s data source URL in rating-service.properties to point to this H2 server:
```	
spring.datasource.url = jdbc:h2:tcp://localhost/~/ratings
```

We can start our services as given in our previous article from the Spring-Cloud series, and test ratings of each book by bringing down the external H2 instance we are running.

We could see that when the H2 database is not reachable, Hystrix automatically falls back to Redis to read the ratings for each book. The source code demonstrating this use case can be found here.


