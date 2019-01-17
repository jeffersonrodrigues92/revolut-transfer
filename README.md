## REVOLUT TEST

## ABOUT ENVIRONMENT

- Java 8
- Java EE
- JAX-RS
- Thorntail
- Hibernate
- H2 Database
- CDI
- Maven

## HOW TO PERFORM? 

- To run project using the .jar you shoud run command 'mvn package'.

- In directory /target use the .jar 'revolut-1.0.0-thorntail.jar '

- Command to run jar: java -jar revolut-1.0.0-thorntail.jar

You can use the Maven to perform application using the command below:

Command: mvn thorntail:run 

The server running you access the API using the URL bellow:

Example to transfer: http://localhost:8080/


##API SWAGGER

Create POST request to transfer.

POST /transfer

Request:

```json
{
  "bankAccountOrigin" : {
      "iban" : "GB09DBAX86098185440302"
  },
  "bankAccountDestination" : {
      "iban" : "GB34HEDN31241073627468"
  },
       "amount" : 100.00
}
```

Response: 200 (application/json)

```json
{
  "transactionId": "cbd0dda1-34d0-4ae5-b6c2-e528ad0762d0"
}
```

Create GET request to find informations about your transfer using transactionId.

Request:

GET /transfer/{transactionId}

Response: 200 (application/json)

```json
{
    "id": 1,
    "transactionId": "301ea91a-20d4-4541-a4b4-7e394acb4b78",
    "bankAccountOrigin": {
        "iban": "GB09DBAX86098185440302",
        "bic": "REVOGB21",
        "email": "test@revolut.com",
        "bankBalance": 400
    },
    "bankAccountDestination": {
        "iban": "GB34HEDN31241073627468",
        "bic": "REVOGB21",
        "email": "test@gmail.com",
        "bankBalance": 950
    },
    "amount": 100
}
```

Create GET request to find informations about account using iban account.

Request:

GET /transfer/{transactionId}

Response: 200 (application/json)

```json
{
    "id": 1,
    "transactionId": "301ea91a-20d4-4541-a4b4-7e394acb4b78",
    "bankAccountOrigin": {
        "iban": "GB09DBAX86098185440302",
        "bic": "REVOGB21",
        "email": "test@revolut.com",
        "bankBalance": 400
    },
    "bankAccountDestination": {
        "iban": "GB34HEDN31241073627468",
        "bic": "REVOGB21",
        "email": "test@gmail.com",
        "bankBalance": 950
    },
    "amount": 100
}
```

## Developer
Jefferson Rodrigues

## LinkedIn
https://www.linkedin.com/in/jefferson-nascimento-rodrigues/
