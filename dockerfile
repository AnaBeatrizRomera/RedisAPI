# Etapa de Build
FROM ubuntu:latest AS build

# Atualiza e instala dependências necessárias
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven

# Define o diretório de trabalho
WORKDIR /app

# Copia todos os arquivos do projeto para o diretório de trabalho
COPY . .

# Executa o Maven para construir o projeto
RUN mvn clean install

# Etapa de Execução
FROM openjdk:17-jdk-slim

# Expõe a porta 8080
EXPOSE 8080

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado da etapa de build
COPY --from=build /app/target/deploy_render-1.0.0.jar app.jar

# Define o comando de entrada
ENTRYPOINT ["java", "-jar", "app.jar"]
, "-jar", "app.jar"]