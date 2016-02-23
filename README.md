# Sample code to use Byteman and JBoss

This repo contains an example to show how to use Byteman in JBoss to inspect all object injected into the WebSession.
The Byteman Helper checks if object is Serialiable or not.

## First compile ByteMan Helper  

```
  cd ExtractGrape
  mvn clean package
```

## Second compile sample application

```
  cd helloworld
  mvn clean package
```

## Runtime

Copy the War file to the JBoss `deployement` directory
Modify `standalone.conf` like this 



## Result 

You should get an output like this whent you call <http://127.0.0.1:8080/jboss-helloworld/Session?name=toto3>
