# VisorComic
Visor de comic

Se realizaron estos pasos el dia 26/02/2018

## Arrancar

Lo ejecutamos para que realize la instalación.

```
./gradlew.bat 
```

Ahora miramos la version si esta bien instalada.

```
./gradlew.bat --version
```

Nos saldra la siguiente version
```
------------------------------------------------------------
Gradle 4.5.1
------------------------------------------------------------

Build time:   2018-02-05 13:22:49 UTC
Revision:     37007e1c012001ff09973e0bd095139239ecd3b3

Groovy:       2.4.12
Ant:          Apache Ant(TM) version 1.9.9 compiled on February 2 2017
JVM:          1.8.0_112 (Oracle Corporation 25.112-b15)
OS:           Windows 10 10.0 amd64
```

## Ejercutar el proyecto

```
./gradlew.bat bootRun
```

## Instalar la B.D.

Vamos a instalar una B.D prosgresSql

* URL descargar: https://www.enterprisedb.com/downloads/postgres-postgresql-downloads 
* Version: 10.2
* Puerto: 5432

Establecemos la contraseña: La de siempre:

### Crear la B.D.

Creamos la BD: comic

``` sql
CREATE DATABASE comic
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE comic
    IS 'Base de datos comic';
```

Creamos el usuario: comic

``` sql
CREATE ROLE comic WITH
	NOLOGIN
	NOSUPERUSER
	NOCREATEDB
	NOCREATEROLE
	INHERIT
	NOREPLICATION
	CONNECTION LIMIT -1
	PASSWORD 'xxxxxx';
```

Poner los permisos.

``` sql
GRANT ALL PRIVILEGES ON DATABASE comic to comic;
```
 
Establecemos en el proyecto, la depedencia de SQL, en el proyecto

```
	compile("org.postgresql:postgresql:42.2.1")
```

**Configurar la BD**

En el fichero **\src\main\resources\application.properties**

``` properties
# Configuracion del ORM
spring.jpa.hibernate.ddl-auto=create-drop
# Correcion de un error al arrancar, mirar el siguiente enlace  (http://vkuzel.blogspot.com.es/2016/03/spring-boot-jpa-hibernate-atomikos.html)
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults = false
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL95Dialect

spring.datasource.url=jdbc:postgresql://localhost:5432/comic
spring.datasource.username=comic
spring.datasource.password=comic
```

> Los dialectos : https://docs.jboss.org/hibernate/orm/5.2/javadocs/org/hibernate/dialect/package-summary.html

## Seguridad

Por defecto es: (User y la contraseña que sale en la consola)