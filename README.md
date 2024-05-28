# Spring boot MVC Demo
Welcome to SpringBoot MVC Demo Project

# Local Setup
Follow the following steps to install application

	Step 1 : Update the system packages
		$ sudo apt-get update
		
	Step 2 : Install OpenJDK 17
		$ sudo apt install openjdk-17-jdk -y
		
	Step 3 : Install Maven
		$ sudo apt install maven -y
		
	Step 4 : Install Git
		$ sudo apt-get install git -y
		
	Step 5 : Clone as following
		$ git clone https://<access_token>@github.com/TechHubRepo/springboot-mvc.git

# Setup MySQL Database
Install Docker

    $ sudo apt-get update
    $ sudo apt install docker.io -y
    $ sudo groupadd docker
    $ sudo usermod -aG docker ${USER}

Create MySQL Container

    $ docker run -d --name mysql-container -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=customer_service mysql:8.0.36-debian
    $ docker container start mysql-container
    $ docker container stop mysql-container
    $ docker container rm mysql-container

Set the environment variable as following

    MYSQL_DB_HOST=localhost
    MYSQL_DB_PORT=3306
    MYSQL_DB_USERNAME=root
    MYSQL_DB_PASSWORD=root
    MYSQL_DB_NAME_CUSTOMER_SERVICE=customer_service

# How to Run
Goto project cloning directory and use any one option from following to run the application

	$ mvn spring-boot:run

# How to Build Docker Image

    $ mvn clean package
    $ docker image build -t techeduhub/mvcdemo:latest .
    $ docker push techeduhub/mvcdemo:latest

