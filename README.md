# Inch-by-inch-BackEnd
This Repo is the Back-end of my Capstone project. For this project, I will be coding the Front and Back-End to an application of my choice.  [Repo for the FrontEnd](https://github.com/Cecilierenee/Inch-by-inch-FE). I'm using springboot on the backend to build a restful api that my user will be able to interact with.

## Purpose
After doing the “Big Chop”, it didn’t take me long to realize; that it was going to be a long, strategic and possibly expensive process to find the products that work with my hair. To simplify this process, I’m creating an app to keep track of the various products and hair routines I follow.

## MVP
Users will be able to create a hair routine, where they can add, delete, and edit their list.

## User Stories;
  -A user can create categories for their hair routines<br>
  -A user can edit categories for their hair routines<br>
  -A user can delete categories from their hair routines<br>
  -A user can create a new routine<br>
  -A user can add products to their routine.<br>
  -A user can edit the products in their routine<br>
  -A user can delete products from their routine.<br>

## ERD
![Inch-by-inch](https://user-images.githubusercontent.com/89564513/151240985-ef828ded-a24a-4370-9b95-593aa65f34bd.png)

## End Points

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

