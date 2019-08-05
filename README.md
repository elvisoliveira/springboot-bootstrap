# Springboot Bootstrap

Restful service that implements a simplified scope of industrial asset's management. The API exposes the following features and methods:

### Equipment
1. List inventory with all equipment
2. Consult a specific equipment through its id

### Maintenance orders
Returns the date when a piece of equipment will undergo a particular maintenance service
1. Create a maintenance order
2. Change an existing maintenance order
3. Consult all existing maintenance orders
4. See a specific order by its id

The service uses JSON format to represent information, which is persisted and mapped in a `Hibernate` schema.

## Quickstart

Developed on debian-based linux distro.

```bash
docker-compose build
docker-compose up
```

## Endpoints

Endpoints uses either a HTTP `GET`, `POST` or `DELETE` to access, insert and update, or delete data, respectively.

An `Postman` Collection (and Environment) is available on the root folder of this project.

**URL**: `/equipment/all`

**Method**: `GET`

---

**URL**: `/equipment/{:id}`

**Method**: `GET`

---

**URL**: `/maintenance/browse`
                             
**Method**: `GET`
                             
---

**URL**: `/maintenance/{:id}`

**Method**: `GET`

---

**URL**: `/maintenance`

**Method**: `POST`

**Insert**: 
```json
{
    "date": "2003-05-16",
    "equipment": 2
}
```
**Update**:
```json
{
    "id": 2,
    "date": "2003-05-17",
    "equipment": 2
}
```
## Toolbox

* JDK 8
* Maven 3.x
* PostgreSQL 9.4
* SLF4J
* Spring Boot
* Hibernate
* JUnit
* Tomcat
* Mockito