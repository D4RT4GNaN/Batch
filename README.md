You can found the project on : https://github.com/D4RT4GNaN/Batch.git

# Library Web Application
P7 - DA JAVA Openclassroom - A community site around climbing



## Getting Started


You can get this project either by downloading it in ZIP file or cloning it.


This project works in duo with a web service that you will find [here](https://github.com/D4RT4GNaN/library-web-service.git).


To clone it, go to the folder of your choice in command line and use the following command :

```

$ git clone https://github.com/D4RT4GNaN/Batch.git

```
See deployment for notes on how to deploy the project on a live system.



### Prerequisites


You need to install :

* An IDE like [IntelliJ IDEA Ultimate](https://www.jetbrains.com/idea/download/) or [Eclipse JEE](https://www.eclipse.org/downloads/packages/release/2019-06/r/eclipse-ide-enterprise-java-developers)

* The associated Web Service you can find [here](https://github.com/D4RT4GNaN/library-web-service.git).

First follow its deployment instructions before deploying the web application.



### Installing

To start with this project :

1. Open it in IDE.

2. Delete the *generated.libraryservice* folder.

3. In terminal, go to the project folder and enter the following command :
```

$ wsimport -Xnocompile -d ./src/main/java -p generated.libraryservice [your_address] 

```
where **[your_address]** is the address of the WSDL on your web service (ex: http://localhost:8080/libraryservice-webservice/libraryservice?wsdl)



## Deployment


To deploy the project, first run the **deploy-batch.sh** script.


When it's done, move the **.jar** file created on the server along with the **start-batch.sh** script.


Finally, run the script to start the program.



## Built With


* [Maven](https://maven.apache.org/) - Dependency Management and Multi-module Management

* [Quartz Scheduler](http://www.quartz-scheduler.org/documentation/) - Enterprise Job Scheduler



## Versioning


I use [Git](https://git-scm.com/) for versioning.



## Authors


* **Maxime Blaise** - [D4RT4GNaN](https://github.com/D4RT4GNaN)

