### Fazendo o build do projeto
````console
./gradlew build
````

### Avaliando desempenho Bundle Jar
````console
java -jar build/libs/demo-testcontainer-0.0.1-SNAPSHOT.jar
````

### Realizando a extração do jar
````console 
java -Djarmode=tools -jar build/libs/demo-testcontainer-0.0.1-SNAPSHOT.jar extract --destination application
````

### Avaliando desempenho Extracted Jar
````console
java -jar application/demo-testcontainer-0.0.1-SNAPSHOT.jar
````
### Realizando treinamento e gerando arquivo Jsa do CDS.
````console
 java -XX:ArchiveClassesAtExit=application.jsa -Dspring.aot.enabled=true -Dspring.context.exit=onRefresh -jar application/demo-testcontainer-0.0.1-SNAPSHOT.jar
````
### Utilizando o arquivo Jsa para inicializar o projeto. 
```
java -XX:SharedArchiveFile=application.jsa -Dspring.aot.enabled=true  -jar application/demo-testcontainer-0.0.1-SNAPSHOT.jar
```
## Comandos uteis

### (A qualquer momento) Verificando memória utilizada
```
curl http://localhost:8080/actuator/metrics/jvm.memory.used
```
### (A qualquer momento) Verificando tempo de inicialização
```
http://localhost:8080/actuator/metrics/application.started.time
```

