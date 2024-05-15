# Utilise l'image officielle de Maven pour la compilation
FROM maven:3.8.4-openjdk-11 AS build

# Définit le répertoire de travail
WORKDIR /app

# Copie le fichier pom.xml et télécharge les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copie le reste du projet et compile
COPY src ./src
RUN mvn package -DskipTests

# Utilise l'image officielle de Java pour exécuter l'application
FROM openjdk:11-jre-slim

# Définit le répertoire de travail
WORKDIR /app

# Copie le fichier JAR généré depuis l'image de build
COPY --from=build /app/target/*.jar appweb.jar

# Expose le port sur lequel l'application va tourner
EXPOSE 8080

# Commande pour exécuter l'application Java
CMD ["java", "-jar", "appweb.jar"]