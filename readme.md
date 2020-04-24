# UserService-Applikation
Die UserService-Applikation ist ein kleiner REST-Service, der CRUD-Operationen für eine Benutzerverwaltung anbietet.
Ein Benutzer (User-Objekt) besitzt die folgenden Attribute:
id, userName, firstName, lastName, email, password.

Ids sind eindeutig und werden von der DB erzeugt. Das Attribut **userName** darf nicht leer sein.

Die Applikation benutzt eine Datei-basierte H2-Datenbank und ist derzeit so konfiguriert, dass sie erzeugt 
wird wenn keine vorhanden ist. Bestehende Inhalte werden erhalten. 
Wenn bei jedem Start der Applikation die Datenbank neu initialisiet werden soll, 
kann dies in der Datei config.yaml über die Option **spring.jpa.hibernate.ddl-auto = create** erreicht werden.

Die Anwendung lauscht auf den Port 8989. Somit sind die Endpunkte sind unter der Adresse **http://localhost:8989/users** 
erreichbar. 
 
## Vorraussetzungen:
* Java 11
* Maven

## Bauen und Starten:
Bauen: `mvn package`

Starten: `java -jar target/user-service-1.0-SNAPSHOT.jar`

## Sonstiges
Die Endpunkte liefern und erwarten JSON-Daten (Content-Type: application/json)

Der HealthEndpoint ist unter http://locahost:8989/actuator/health erreichbar.

## Implementierte Endpunkte
* GET http://localhost:8989/users
* GET http://localhost:8989/users/{id}
* POST http://localhost:8989/users
* DELETE http://localhost:8989/users
* GET http://localhost:8989/searchByUserName?userName={searchString}



 