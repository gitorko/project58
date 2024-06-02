# Project 58

Spring Virtual Threads

[https://gitorko.github.io/spring-virtual-threads/](https://gitorko.github.io/spring-virtual-threads/)

### Version

Check version

```bash
$java --version
openjdk 21
```

### Postgres DB

```
docker run -p 5432:5432 --name pg-container -e POSTGRES_PASSWORD=password -d postgres:9.6.10
docker ps
docker exec -it pg-container psql -U postgres -W postgres
CREATE USER test WITH PASSWORD 'test@123';
CREATE DATABASE "test-db" WITH OWNER "test" ENCODING UTF8 TEMPLATE template0;
grant all PRIVILEGES ON DATABASE "test-db" to test;

docker stop pg-container
docker start pg-container
```

### Dev

To build the code.

```bash
./gradlew clean build
```
