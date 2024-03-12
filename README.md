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
 * Download any IDE of your choice to work on, however I recommend VS code as all the examples you'll see will be done on there. 
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
4. https://maven.apache.org/download.cgi

**Postman**
Postman is a useful tool for testing API endpoints. If you don't have it installed, you can sign up on their website and use it remotely on their browser.
5.[https://www.postman.com/]

**Git**
Git provides version control. If you want to use version control for your project, install Git from here https://github.com/.

**P.S**
It's beneficial to have a basic understanding of RESTful principles as your Recipe Book API will need to support CRUD operations using standard HTTP methods.
These prerequisites will ensure a smooth setup and development process for your Recipe Book Diary API.
  

### **Learning Outcomes:**

* Java will be your middle name, working with objects and all that is JAVA!
* You will be working with a Json file with Key:Value pairs which will hold all the data for your recipes and ingredients. 
*Classes, Services, Controller, Repositories, and more.
* You will learn to work with Postman to test your endpoints I.E below...
* * GET /recipes: Retrieves a list of all recipes in the database
* * GET/recipes/{id}: Retrieves a specific recipe by its ID
  

  
### **By following these steps, you will be able to build a well structured Recipe Book API which will have the folllowing:**

**Good Use of HTTP Protocols:**
You will adhere to HTTP protocol standards, ensuring that your API methods, requests, and responses follow RESTful principles and support full CRUD operations. 
Using GET, POST, PUT and DELETE. You will use Postman to test 
all end points and you will structure these accordingly. 

**Repository Repository Repository!!:**
You will use version control to commit any progresses frequently, capturing your development process and thought process in the commit messages. 
You will also maintain a detailed Git history to maintian a streamlined diary of the development of your API, for future changes and enhancements..

**Code Quality & Structure:**
You will adhere to Java and Spring Boot best practices and conventions, ensuring that your code is clean, modular, reusable, and easily comprehensible.
By following these design considerations and requirements, you will be able to develop a top-notch API using Java and Spring Boot that meets the expectations outlined in all of the above.




### Getting started!

#### 1. Clone the Repository

```sh
git clone https://github.com/shanaallenholder/Java_Assessment_Repo
cd api_assessment_project
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
[INFO] -------------------< com.cbfacademy:api-assessment >--------------------
[INFO] Building api-assessment 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot:3.1.4:run (default-cli) > test-compile @ api-assessment >>>
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ api-assessment ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 2 resources from src/main/resources to target/classes
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ api-assessment ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ api-assessment ---
[INFO] skip non existing resourceDirectory /Users/shana/
[INFO] 
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ api-assessment ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 2 source files with javac [debug release 17] to target/test-classes
[INFO] 
[INFO] <<< spring-boot:3.1.4:run (default-cli) < test-compile @ api-assessment <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot:3.1.4:run (default-cli) @ api-assessment ---
[INFO] Attaching agents: []

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.1.4)

2024-03-12T14:14:04.235Z  INFO 66802 --- [  restartedMain] com.cbfacademy.apiassessment.App         : Starting App using Java 17.0.9 with PID 66802 
2024-03-12T14:14:04.236Z  INFO 66802 --- [  restartedMain] com.cbfacademy.apiassessment.App         : No active profile set, falling back to 1 default profile: "default"
2024-03-12T14:14:04.256Z  INFO 66802 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2024-03-12T14:14:04.256Z  INFO 66802 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2024-03-12T14:14:04.574Z  INFO 66802 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2024-03-12T14:14:04.579Z  INFO 66802 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-03-12T14:14:04.579Z  INFO 66802 --- [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.13]
2024-03-12T14:14:04.603Z  INFO 66802 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-03-12T14:14:04.603Z  INFO 66802 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 346 ms

Open your browser and navigate to `http://localhost:8080`.



