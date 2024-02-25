# **Recipe Book Diary API**

## **Introduction**
The Recipe Book API project has been designed to help clients manage and maintain a bespoke customisable recipe book/diary. 
It allows users to tailor their preferences and dietary requirements to the types of recipes they love. 
It will include cooking instructions, portion sizes and all listed ingredients with specific allergen information to satisfy every individuals needs. 

**Initial User Stories**
The Recipe Book Diary API will empower users to:
- View a list of recipes.
- Search recipes by keyword or category.
- Access detailed information about specific recipes.
- Save favorite recipes for easy access.
- Add new recipes to the database.
- Edit, delete, or archive existing recipes.
- Rate and review recipes.
- Retrieve all created recipes.


**Prequisites**
 Before you begin, ensure you have the following prerequisites:

 **Vs Code**
 * Download any IDE of your choice to work on, however I recommend VS code as all the examples you'll see with be from there. 
1. [Visual Studio Code](https://code.visualstudio.com/Download)
   
**Java Development Kit (JDK):**
Ensure you have Java installed on your system. You can download it from Oracle's website or use an open-source distribution like OpenJDK.
Integrated Development Environment (IDE):
Have an IDE of your choice installed, I used Vscode.

1. [JDK 17](https://learn.microsoft.com/en-gb/java/openjdk/download#openjdk-17) (or higher)
2. [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
3. [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)

**Apache Maven** 
This is project management and build automation. Make sure Maven is installed on your machine. You can download it from here.

**Postman**
Postman a useful tool for testing API endpoints. If you don't have it installed, you can sign up on their website and use it remotely.
4.[https://www.postman.com/]

**Git**
Git provides version control. If you want to use version control for your project, install Git from here https://github.com/.

**P.S**
It's beneficial to have a basic understanding of RESTful principles as your API supports CRUD operations using standard HTTP methods.
These prerequisites will ensure a smooth setup and development process for your Recipe Book Diary API.
  

### **Learning Outcomes:**

* Java will be your middle name, working with objects and all that is JAVA!
* You will be working with a Json file with Key:Value pairs which will hold all the data for your recipes and ingredients. 
*Classes, Services, Controller, Repositories, and more.
* You will learn to work with Postman to test your endpoints.
* * GET /recipes: Retrieves a list of all recipes in the database
* GET/recipes/{id}: Retrieves a specific recipe by its ID
  

  
### **By following these steps, you will be able to build a well structured Recipe Book API which will have the folllowing:**

**Good Use of HTTP Protocols:**
You will adhere to HTTP protocol standards, ensuring that your API methods, requests, and responses follow RESTful principles and support full CRUD operations. 
Using GET, POST, PUT and DELETE. You will use Postman to test 
all end points and you will structure these accordingly. 

**Repository Repository Repository!!:**
You will use version control to commit any progress frequently capturing your development process and thought process in the commit messages. 
You will also maintain a detailed Git history to maintian a streamlined diary of the development of your API, for future changes and enhancements..

**Code Quality & Structure:**
You will adhere to Java and Spring Boot best practices and conventions, ensuring that your code is clean, modular, reusable, and easily comprehensible.
By following these design considerations and requirements, I’ll be able to develop a top-notch API using Java and Spring Boot that meets the expectations outlined in the assessment.




### Getting started!

#### 1. Clone the Repository

```sh
git clone https://github.com/Recipe_Book_Api
cd recipe-diary
```

Replace [REPO_URL] with the link to your GitHub repository and [REPO_NAME] with the repository's name.

#### 2. Installation

Open a terminal at the root of the repo directory and run the following command to install the dependencies:

```sh
./mvnw clean dependency:resolve
```

If you are on a Windows machine, that will be:
```cmd
mvnw clean dependency:resolve
```

You should see console output similar to the following:

```sh
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------< com.cbfacademy:api-assessment >--------------------
[INFO] Building api-assessment 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ api-assessment ---
[INFO] Deleting /Users/user/Dev/cbfacademy/java-api-assessment/target
...
[truncated output]
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.060 s
[INFO] Finished at: 2023-10-03T16:18:25+01:00
[INFO] ------------------------------------------------------------------------
```

#### 3. Running the Application

To start the API in VS Code, press `F5` or tap the 'Play' icon for the `api-assessment` app in the Spring Boot Dashboard.

Alternatively, to start the API from the terminal, run the following command:

```sh
./mvnw spring-boot:run
```

Or on Windows:

```cmd
mvnw spring-boot:run
```

You should see console output similar to the following (press `Ctrl + C` to exit):

```sh
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------< com.cbfacademy:api-assessment >--------------------
[INFO] Building api-assessment 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ api-assessment ---
[INFO] Deleting /Users/gary/Dev/cbfacademy/java-api-assessment/target
[INFO] 
[INFO] >>> spring-boot:3.1.4:run (default-cli) > test-compile @ api-assessment >>>
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ api-assessment ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 0 resource from src/main/resources to target/classes
...
[truncated output]
...
2023-10-03T17:17:34.413+01:00  INFO 35536 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2023-10-03T17:17:34.751+01:00  INFO 35536 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-10-03T17:17:34.756+01:00  INFO 35536 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-10-03T17:17:34.756+01:00  INFO 35536 --- [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.13]
2023-10-03T17:17:34.777+01:00  INFO 35536 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-10-03T17:17:34.778+01:00  INFO 35536 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 364 ms
2023-10-03T17:17:34.898+01:00  INFO 35536 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2023-10-03T17:17:34.907+01:00  INFO 35536 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-10-03T17:17:34.911+01:00  INFO 35536 --- [  restartedMain] com.cbfacademy.apiassessment.App         : Started App in 0.643 seconds (process running for 0.786)
```

Open your browser and navigate to `http://localhost:8080`.


## Top Tips

- :camera_flash: Commit frequently and use meaningful commit messages. A granular, well-labelled history becomes an increasingly valuable asset over time.
- :cactus: Use feature branches. Build the habit of isolating your changes for specific tasks and merging them into your default branch when complete.
- :vertical_traffic_light: Use consistent naming conventions. Choose easily understandable names and naming patterns for your classes, functions and variables.
- :triangular_ruler: Keep your code tidy. Using the built-in formatting of VS Code or other IDEs makes your code easier to read and mistakes easier to spot.
- :books: Read the docs. Whether via Intellisense in your IDE, or browsing online documentation, build a clear understanding of the libraries your code leverages.
- :calendar: Don't wait until the last minute. Plan your work early and make the most of the time available to complete the assessment and avoid pre-deadline palpitations.
- :sos: Ask. :clap: For. :clap: Help! :clap: Your mentors, instructors and assistants are literally here to support you, so *make use of them* - don't sit and struggle in silence.


