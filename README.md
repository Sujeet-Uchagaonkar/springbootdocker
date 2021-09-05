# springbootdocker
Spring boot Docker Sample With Gradle 


* Steps to run :

To install Docker on Windows, you can download the Docker Desktop Community edition from the docker.com website. You might be asked to create an account in order to download the executable. However, we found the direct download link for version 2.1.0.2 here: https://docs.docker.com/docker-for-windows/release-notes/

For this tutorial, we will keep all the default settings that we see in the installer. There are some things that you might need to take care of when installing and running Docker on Windows.


* Windows version and Hyper-V support:

Hyper-V is a native hypervisor from Microsoft. This hypervisor can be enabled as a feature on select Windows versions only. For example, if you are running Windows 10, then you will need a Windows 10 Pro, Education or Enterprise editions to be able to enable the Hyper-V windows feature.
This feature is important for Docker version 2.x to run on Windows, and if not present, then Docker will refuse to install on your machine.





Once you have Docker installed and running, you can make sure it is running properly by opening a Powershell Window and running the commands “docker version” and the “docker ps”.
The docker version command will indicate that Docker has been correctly installed, and the docker ps command will indicate that docker is running correctly running by listing the running docker containers. Do not worry if the list of running docker containers is empty.
If you have an output similar to the following, then you are ready to move on to the next section.


PS C:\Users\nullbeans> docker ps
CONTAINER ID        IMAGE               COMMAND             CREATED             STATUS              PORTS               NAMES

C:\Users\nullbeans> docker version
Client: Docker Engine - Community
 Version:           18.09.2
 API version:       1.39
 Go version:        go1.10.8
 Git commit:        6247962
 Built:             Sun Feb 10 04:12:31 2019
 OS/Arch:           windows/amd64
 Experimental:      false

Server: Docker Engine - Community
 Engine:
  Version:          18.09.2
  API version:      1.39 (minimum version 1.12)
  Go version:       go1.10.6
  Git commit:       6247962
  Built:            Sun Feb 10 04:13:06 2019
  OS/Arch:          linux/amd64
  Experimental:     false
  
  
  
  
  
* About Docker images:

Now that we have got all the Windows issues out of the way and having docker installed and running, we will need to create our Docker image. If you are just starting with Docker, then I recommend that you read about it more in order to better understand the architecture and to make more informed decisions about your applications.

With that in mind, let us discuss a few things that will make the next steps clearer.


* Most Docker images require a base image:

When creating a Docker image of your Spring boot or Java application, you will need to create it on top of an existing base image. A base image provides the “basics” that are required for your Java application to run. For example the base image openjdk:8-jdk-alpine will provide you with essential Linux/Unix OS repositories that allow a JVM to run, and a JDK 8 or JRE to actually run your Java application.



* The Docker File:

Once you have chosen the base image, you can configure the other parameters and settings that are required to run your application. Environment settings include storage volumes, environment variables, among others. Once you have defined these, you will then have to choose the Entry Point.  This is the command which will run your application inside the Docker Container.

The base image, environment settings and the entry point can be defined in a file called the Docker File. The Docker file contains the definition of your container / image. The Docker File is also used to build your docker image which you can then upload to Docker Hub or to your local Docker environment.
  
  
  
  
  
* Preparing our test Spring Boot application
 
Create bootable application jar with the help of 'gradlew build' command.
 
Now that we have our demo application ready, we will need to create a dockerfile to define our image. If your application requires Java version 8, then you can use openjdk:8-jdk-alpine which is based on Alpine linux.
Create the following file in the project’s root folder. The file is simply called “dockerfile”.
Let us discuss the docker file line by line in order to understand what is going on.

FROM: 

This command is used to define the base image that we will select for our Docker container. In this case, we will use the image tag 11.0.4 from the docker repository called amazoncorretto.

VOLUME: 

This will create a “volume” or partition in our docker container environment called /tmp. This is often required for tomcat based Spring application in order to persist data on the filesystem.

ARG: 

Defines an argument variable that will be available during the container building stage. After the image has been build, ARG variables are no longer accessible. The value of this argument will be set from our pom.xml file as we will see in the next section.

COPY: 

This command simply copies a file from source to destination.

ENTRYPOINT: 

As mentioned previously, this command will be used to run our JAR file. In our example, we run the file JAR which we “simply” renamed to nullbeansdockerdemo.jar along with some other jvm arguments.
  



* Creating docker image & running in docker container (Execute below commands in cmd at root level of project):

1.  docker build . -t dockerdemo

2.  docker run dockerdemo

3.  docker run -p 8081:8080 -t dockerdemo
