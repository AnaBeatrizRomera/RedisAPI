# Usando uma imagem oficial do Java para rodar o Spring Boot
FROM openjdk:17-jdk-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado pela sua aplicação para o diretório de trabalho
COPY target/sua-aplicacao-spring-boot.jar /app/sua-aplicacao-spring-boot.jar

# Expõe a porta 8080 (a porta padrão do Spring Boot)
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app/sua-aplicacao-spring-boot.jar"]
