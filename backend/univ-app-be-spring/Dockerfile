# --- Etap 1: Budowanie aplikacji (z Mavenem i JDK 21) ---
# Używamy oficjalnego, multi-platformowego obrazu z Temurin JDK 21
FROM eclipse-temurin:21-jdk AS build

# Ustawiamy katalog roboczy
WORKDIR /app

# Kopiujemy pliki Maven Wrappera
COPY .mvn/ .mvn/
COPY mvnw .
# Kopiujemy plik pom.xml, aby wykorzystać cache'owanie warstw Dockera
COPY pom.xml .

# Kopiujemy resztę kodu źródłowego
COPY src ./src

# Nadajemy uprawnienia do wykonania dla wrappera i budujemy aplikację
RUN chmod +x mvnw && ./mvnw clean package -DskipTests


# --- Etap 2: Tworzenie finalnego, lekkiego obrazu ---
# Używamy lekkiego, multi-platformowego obrazu z Javą 21
FROM eclipse-temurin:21-jre

# Ustawiamy katalog roboczy
WORKDIR /app

# Kopiujemy zbudowany plik .jar z etapu "build"
COPY --from=build /app/target/*.jar app.jar

# Definiujemy port, na którym nasłuchuje aplikacja
EXPOSE 8080

# Polecenie uruchamiające aplikację
ENTRYPOINT ["java", "-jar", "app.jar"]