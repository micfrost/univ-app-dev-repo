# --- Etap 1: Budowanie aplikacji ---
# Używamy oficjalnego obrazu Maven z JDK 21 do zbudowania aplikacji
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Ustawiamy katalog roboczy wewnątrz kontenera
WORKDIR /app

# Kopiujemy plik `pom.xml`, aby pobrać zależności
COPY pom.xml .
RUN mvn dependency:go-offline

# Kopiujemy resztę kodu źródłowego
COPY src ./src

# Budujemy aplikację, tworząc plik .jar. Pomijamy testy, aby przyspieszyć budowanie.
RUN mvn clean package -DskipTests


# --- Etap 2: Tworzenie finalnego, lekkiego obrazu ---
# Używamy lekkiego obrazu z Javą 21 do uruchomienia aplikacji
FROM eclipse-temurin:21-jre-alpine

# Ustawiamy katalog roboczy
WORKDIR /app

# Kopiujemy zbudowany plik .jar z etapu "build"
COPY --from=build /app/target/*.jar app.jar

# Definiujemy port, na którym nasłuchuje aplikacja
EXPOSE 8080

# Polecenie, które zostanie wykonane podczas uruchamiania kontenera
ENTRYPOINT ["java", "-jar", "app.jar"]
