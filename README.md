# Intelligent Transaction Monitoring Platform

As a Java Angular Fullstack developer, I undertook the challenge to develop an Intelligent Transaction Monitoring Platform as part of an interview process. The platform is designed to provide real-time monitoring of transaction data and includes sophisticated fraud detection capabilities. With a seamless data pipeline and real-time streaming, the platform ensures efficient handling of data for timely insights and action.

## Setup and Installation Guide

### Prerequisites

#### 1. Java Development Kit (JDK): 
Ensure you have JDK installed on your system. You can download and install JDK from the official Oracle website or adopt OpenJDK.

#### 2. Node.js and npm: 
Install Node.js and npm to manage dependencies and run the Angular frontend application.

#### 3. PostgreSQL Database: 
Install PostgreSQL on your local machine. You can download and install PostgreSQL from the official website or use package managers like Homebrew (for macOS) or apt (for Linux).

#### 4. Apache Kafka: 
Install Apache Kafka for real-time streaming. You can download and install Kafka from the official website or use package managers.


### Database Setup

#### Create Database: 
Open your PostgreSQL command line or GUI tool (like pgAdmin) and create a new database named transaction_monitoring.

#### Execute SQL Scripts: 
Run the provided SQL scripts to create the necessary tables. 

You can use the following commands:

sql

```
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
```
```
CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    due_date DATE,
    completed BOOLEAN DEFAULT FALSE,
    user_id BIGINT,
    CONSTRAINT fk_user
        FOREIGN KEY(user_id) 
        REFERENCES users(id)
);
```


### Kafka Setup

#### Download and Extract Kafka: 
Download Apache Kafka from the official website and extract it to your desired location.

#### Start Zookeeper: 
Kafka uses Zookeeper for coordination. Navigate to the Kafka directory and start Zookeeper using the following command:

bash
```
bin/zookeeper-server-start.sh config/zookeeper.properties
```


#### Start Kafka Server:
Start the Kafka server by running the following command:

bash
```
bin/kafka-server-start.sh config/server.properties
```


#### Create Topic: 
Create a Kafka topic named transactions using the following command:

bash
```
bin/kafka-topics.sh --create --topic transactions --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1
```


### Running the Application

#### Backend Application:

Navigate to the backend directory of your project.
Run the Spring Boot application using your IDE or command line:

arduino
```
./mvnw spring-boot:run
```

#### Frontend Application:

Navigate to the frontend directory of your project.
Install dependencies using npm:

bash
```
npm install
```

#### Start the Angular application:

bash
```
npm start
```

### Accessing the Application

Once both the backend and frontend applications are running, you can access the Intelligent Transaction Monitoring Platform by navigating to 'http://localhost:4200' in your web browser.
This setup guide should help you get your project up and running smoothly. If you encounter any issues during the installation or setup process, feel free to reach out for assistance.



### Thank You and Happy Coding






