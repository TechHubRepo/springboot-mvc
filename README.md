# Spring Security with Springboot 3
Welcome to Springboot MVC Demo Project

# Setup
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
	  
# How to Run
Goto project cloning directory and use any one option from following to run the application

	Option 1
		$ mvn spring-boot:run

# How to Build Docker Image
Follow the following steps to make docker image

    $ mvn clean package
    $ docker image build -t techeduhub/mvcdemo:latest .
    $ docker push techeduhub/mvcdemo:latest

