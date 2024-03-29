# java-transport-reservation

A java and Postgresql based program for transport reservation management

The project is using Spring layer Architecture which means the uses of _**model**_ - _**service**_ - _**controller**_ - _**repository**_ packages.

## To start the program
You need to have **Postgresql 14 or higher** version installed on your OS

#### - Connect to your Postgresql

#### - Create the database called "_**transport_booking**_"

Use the .sql file, located in the folder _**./psql-script**_ of this repository to create it with all necessary tables
- DB-transport-reservation.sql 

#### - Add mock data
After the creation of the database, use the SQL scripts located in _**./psql-script/mock**_ to insert mock data

##### !FOLLOW THIS ORDER!

- customer.sql
- employee.sql
- bus.sql
- bus_seat.sql
- driver.sql
- payment.sql
- booking.sql
- drive_assignment.sql

#### - Add those environment variables to your session or in intelliJ configurations according to your credentials

```
PSQL_USER = your postgres username
PSQL_PASSWORD = your postgres password
```

Those credentials can be seen in here:
```
src/main/java/org/transportreservation/connection/Credentials.java
```

#### - START THE PROGRAM
You can start the program **directly into intelliJ** or thru the jar file located here:
```
out/artifacts/java_transport_reservation_jar
```

## Indication about the endpoints
### Here is a list of all endpoints

#### Customer
```
post: 
  /customers
  description: add new Customer to the database

get: 
  /customers
  description: find all Customer in the database

get: 
  /customers/search/?name=name
  description: find a customer by name (firstname)

get: 
  /customers/search/{id}
  description: find a customer by Id

patch: 
  /customers/edit/{id}
  description: update a customer username using its Id as reference

delete: 
  /customers/{id}
  description: delete a customer using its id as reference
```

#### Employee
```
post: 
  /employees
  description: add new Employee to the database

get: 
  /employees
  description: find all Employee in the database

get: 
  /employees/search/?name=name
  description: find an employee by name (firstname)

get: 
  /employees/search/{id}
  description: find an employee by Id

patch: 
  /employees/edit/{id}
  description: update an employee address using its Id as reference

delete: 
  /employees/{id}
  description: delete an employee using its Id as reference
```

#### Bus
```
post: 
  /bus
  description: add new Bus to the database

get: 
  /bus
  description: find all Bus in the database

get: 
  /bus/search/{id}
  description: find a bus by Id

patch: 
  /bus/edit/places/{id}
  description: update the number of places of a bus using its Id as reference

delete: 
  /bus/{id}
  description: delete a bus using its Id as reference
```

#### Bus Seat
```
post: 
  /seat
  description: add new BusSeat to the database

get: 
  /seat
  description: find all BusSeat in the database

get: 
  /seat/search/{id}
  description: find a BusSeat by Id

patch: 
  /seat/edit/{id}
  description: update the price of a seat using its Id as reference

delete: 
  /seat/{id}
  description: delete a seat using its Id as reference
```

#### Driver
```
post: 
  /drivers
  description: add new Driver to the database

get: 
  /drivers
  description: find all Driver in the database

get: 
  /drivers/search/?name=name
  description: find a driver by name (firstname)

get: 
  /drivers/search/{id}
  description: find a driver by Id

patch: 
  /drivers/edit/{id}
  description: update a driver phone number using its Id as reference

delete: 
  /drivers/{id}
  description: delete a driver using its Id as reference
```

#### Payment
```
post: 
  /payment
  description: add new Payment to the database

get: 
  /payment
  description: find all Payment in the database

get: 
  /payment/search/{id}
  description: find a Payment by Id

patch: 
  /payment/edit/{id}
  description: update the amount of a payment using its Id as reference

delete: 
  /payment/{id}
  description: delete a payment using its Id as reference
```

#### Booking
```
post: 
  /booking
  description: add new Booking to the database

get: 
  /booking
  description: find all Booking in the database

get: 
  /booking/search/{id}
  description: find a Booking by Id

patch: 
  /booking/edit/{id}
  description: update the destination location using its Id as reference

delete: 
  /booking/{id}
  description: delete a booking using its Id as reference
```

#### Drive assignment
```
post: 
  /assignment
  description: add new DriveAssignment to the database

get: 
  /assignment
  description: find all DriveAssignment in the database

get: 
  /assignment/search/{id}
  description: find a DriveAssignment by Id

patch: 
  /assignment/edit/{id}
  description: update the assigned driver using the assignment Id as reference

delete: 
  /assignment/{id}
  description: delete an assignment using its Id as reference
```