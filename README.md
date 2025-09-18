# Student Records Manager

A simple **Java 17** console application to manage student records.

## Features
* Load and save student data in **JSON** using Jackson.
* Add, edit, and delete student records in memory.
* Persist changes back to JSON on exit.
* Create a daily text log of operations.

---

## Project Structure (Maven Standard Layout)

StudentRecordsManager/
│
├─ pom.xml
├─ README.md
└─ src/
   └─ main/
      └─ java/
         └─ com/
            └─ example/
               ├─ Main.java
               ├─ Student.java
               ├─ FileUtils.java
               └─ … (other classes)
   └─ main/
      └─ resources/      (if you later add config or template files)
   └─ test/
      └─ java/           (JUnit tests)

---

## Requirements
* Java 17+
* Apache Maven 3.9+

Check versions:

java -version
mvn -version



---

## Build the Project
From the project root:
mvn clean compile

This downloads all dependencies (like **Jackson**) automatically—no manual `.jar` handling needed.

---

## Run the Application
mvn exec:java -Dexec.mainClass=com.example.Main
*(Replace `com.example.Main` if your main class name is different.)*

---

## Run Tests
mvn test
JUnit 5 is already configured in `pom.xml`.

---

## Package as a JAR
To produce a runnable JAR:
mvn package

The JAR will be created in:
The JAR will be created in

target/StudentRecordsManager-1.0-SNAPSHOT.jar
Run it:

java -jar target/StudentRecordsManager-1.0-SNAPSHOT.jar

*(If you want a single “fat” jar with all dependencies, you can add the Maven Shade Plugin later.)*

---

## Next Steps
* Add more fields to `Student` (email, GPA, etc.).
* Create unit tests for file read/write utilities.
* Explore file locking or memory-mapped files for advanced I/O.

---

**License:** MIT (or add your preferred license)
