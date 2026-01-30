# Utiliser une image OpenJDK officielle pour Java 21
FROM eclipse-temurin:21-jdk-alpine

# Définir le dossier de travail à l'intérieur du conteneur
WORKDIR /app

# Copier le fichier JAR compilé depuis target/
COPY target/productapp-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port utilisé par Spring Boot (par défaut 8080)
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java","-jar","app.jar"]