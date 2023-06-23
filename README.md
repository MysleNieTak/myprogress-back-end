## myProgress Application

### Introduction
The application is used to register your sport activities, plan your goals and monitor your health progress. 

## Features
- JPA
- Spring Boot
- MySQL
- REST API

The application allows the user to:
- add new activity
- delete the activity
- edit the activity <i> (name, distance, time and userName of particular activity) - still in progress :) </i>
- list all activities
<hr>
In near future, the application will have few <b>additional functionalities! </b>

- <b>activities data manipulation</b><i> - filtering and sorting (search for...) </i>
- <b>challenge creator</b> <i>- user provides the goal to achieve (e.g. the kcal to burn) and the application
  prepares a dedicated training plan!</i>
- <b>notifications </b> <i>- application notifies after each goal achieved, 100 km run etc.</i>
- <b> followers </b> <i>- users may follow other users and see their activities, goals achieved and... the progress! </i>
- <b>results</b> <i> - a wide general results calculation of the users progress will be available soon! What are the planned results to be shown? Average kcal burnt
  / kilometers run / meters swam  - per day / goal / etc. </i>
- <b>account settings </b> <i>- users account will contain the important information regarding user age, weight, BMI. The data is very important and impacts the training plan </i>

### How to configure and run
- Install MySQL database (e.g. MySQL Workbench)
- Create new database
- Provide the parameters to connect with the database
Parameters are located in `/src/main/resources/application.yaml`.
The following must be filled: 

```yaml
spring:
  datasource:
    url: jdbc:mysql:// #fill connection string url 
    password: #fill password
    username: #fill username
  jpa:
    hibernate:
      ddl-auto: update
```
To run the application, please use the following command:
```shell
mvn spring-boot:run
```

### Authors
Paulina Pionk
