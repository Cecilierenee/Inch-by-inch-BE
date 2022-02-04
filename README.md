# Inch-by-inch-BE

## Inch-by-inch-api

This Repo is the Back-end of my Capstone project. For this project, I will be coding the Front and Back-End to an application of my choice.  [Repo for the FrontEnd](https://github.com/Cecilierenee/Inch-by-inch-FE). I'm using springboot on the backend to build a restful api that my user will be able to interact with.

## Purpose
After doing the “Big Chop”, it didn’t take me long to realize; that it was going to be a long, strategic and possibly expensive process to find the products that work with my hair. To simplify this process, I’m creating an app to keep track of the various products and hair routines I follow.

## MVP
Users will be able to create a hair routine, where they can add, delete, and edit their list.

<h3 align="left">Languages and Tools:</h3>
<p align="left"> <a href="https://www.w3schools.com/css/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original-wordmark.svg" alt="css3" width="40" height="40"/> </a> <a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a> <a href="https://www.w3.org/html/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg" alt="html5" width="40" height="40"/> </a> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-original.svg" alt="javascript" width="40" height="40"/> </a> <a href="https://www.linux.org/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/linux/linux-original.svg" alt="linux" width="40" height="40"/> </a> <a href="https://www.postgresql.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="40" height="40"/> </a> <a href="https://postman.com" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="postman" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>

## User Stories;
  -A user can create a hair routine<br>
  -A user can edit their hair routines<br>
  -A user can delete their old hair routines<br>
  -A user can create a new routine<br>
  -A user can add products to their routine.<br>
  -A user can edit the products in their routine<br>
  -A user can delete products from their routine.<br>

## ERD
![Inch-by-inch](https://lucid.app/lucidchart/c6f823b3-187b-47ec-a060-35ffda717158/edit?invitationId=inv_a0c68bb6-6eb4-474b-86c3-02d45abb3cc0)

## End Points

| Request Type  | Url  |
|---------------|------|
|Get   | http://localhost:9193/routine/{id}|
|Get   | http://localhost:9193/routine/all|
|Post  | http://localhost:9193/routine/add|
|Put   | http://localhost:9193/routine/update/{id}|
|Delete| http://localhost:9193/routine/delete/{id}|

## My Process

[Project Tracker](https://github.com/users/Cecilierenee/projects/1/views/1)

### Day 1 :pencil2: :notebook_with_decorative_cover:
-Determined what MVP is for this project<br>
-Developed my user stories<br>
-Created an ERD<br>
-Determined Endpoints<br>
**Project Approval**<br>
-Gathered appropriate resources<br>
-Started on backend structure


### Day 2 :computer:
-Began building backend(API)<br>
  -Started with creating my models<br>
  -created crontroller with endpoints<br>
  -created my service class for business logic<br>
-Gathered resources for auth services 

### Day 3 :computer:
-Build user controller and services classes<br>
-Attempted to run the application<br>
  -I ran into issues with 'Circle Dependency' due to my web security and authorization manager that were injected into different aspects of my app. I found that using the    '@Lazy' notation on my dependencies helped to recognize which bean to create first. [Stack Over Flow](https://stackoverflow.com/questions/39823865/spring-boot-application-fails-to-start-due-to-a-circular-dependency-between-1-be)
-Test Endpoints<br>

**Backend Running without bugs**(over the weekend) :dancer: :tada: <br>

:point_right: [Click Here](https://github.com/Cecilierenee/Inch-by-inch-FE) to continue reading my process on building my Front-End.
