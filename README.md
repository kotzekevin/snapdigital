This project requires __Maven 3__ and __Java 8__ to compile, package and run.

A number of automated test cases have been provided that will execute during the Maven build.

### Install Java ###

* Download and Install JDK: https://www.oracle.com/za/java/technologies/javase/javase8u211-later-archive-downloads.html

* Set JAVA_HOME and Path Environment Variables as below example:

    JAVA_HOME='/opt/jdk1.8.0_333' 

    PATH="$JAVA_HOME/bin:$PATH" 
    
    export PATH 

* Test from a terminal using "java -version"

### Install Maven ###

* Download and Install Maven: https://maven.apache.org/download.cgi

* Set M2_HOME and Path Environment Variables as below example:

    M2_HOME='/opt/apache-maven-3.8.6'
    
    PATH="$M2_HOME/bin:$PATH"
  
    export PATH 

* Test from a terminal using "mvn -version"


### Build and Execute Test Cases ###

* Navigate to project __pom.xml__ file and execute maven package command:

		mvn package

* Example output:

````

E:\Work\dev\spandigital>mvn package
[INFO] Scanning for projects...
[INFO]
[INFO] ----------------------< com.spandigital:kev-test >----------------------
[INFO] Building kev-test 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ kev-test ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 5 resources
[INFO]
[INFO] --- maven-compiler-plugin:3.7.0:compile (default-compile) @ kev-test ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to E:\Work\dev\spandigital\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ kev-test ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory E:\Work\dev\spandigital\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.7.0:testCompile (default-testCompile) @ kev-test ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to E:\Work\dev\spandigital\target\test-classes
[INFO]
[INFO] --- maven-surefire-plugin:2.10:test (default-test) @ kev-test ---
[INFO] Surefire report directory: E:\Work\dev\spandigital\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.spandigital.test.RankingEngineTest
1. Tarantulas, 6 pts
2. Lions, 5 pts
3. FC Awesome, 1 pt
3. Snakes, 1 pt
5. Grouches, 0 pts

1. Tarantulas, 6 pts
2. Lions, 5 pts
3. FC Awesome, 1 pt
3. Grouches, 1 pt
3. Snakes, 1 pt
3. Tigers, 1 pt

1. Tarantulas, 6 pts
2. Lions, 5 pts
3. Tigers, 4 pts
4. FC Awesome, 1 pt
4. Grouches, 1 pt
4. Snakes, 1 pt
7. Rabbits, 0 pts

1. Lions, 5 pts
2. Tarantulas, 3 pts
3. FC Awesome, 1 pt
3. Grouches, 1 pt
3. Snakes, 1 pt
3. Tigers, 1 pt

1. Tarantulas, 7 pts
2. Grouches, 5 pts
2. Lions, 5 pts
4. Rabbits, 3 pts
5. FC Awesome, 2 pts
5. Snakes, 2 pts
7. Tigers, 1 pt

Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.385 sec

Results :

Tests run: 5, Failures: 0, Errors: 0, Skipped: 0

[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ kev-test ---
[INFO] Building jar: E:\Work\dev\spandigital\target\kev-test-0.0.1-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  5.360 s
[INFO] Finished at: 2022-10-06T19:43:36+02:00
[INFO] ------------------------------------------------------------------------
````

### Execute Program ###

* Compile a test input file with league results and execute program as below passing in the input file as parameter:

		java -cp target/test-0.0.1-SNAPSHOT.jar com.spandigital.test.RankingEngine <input file>

* Example output:

````
E:\Work\dev\spandigital>java -cp target/test-0.0.1-SNAPSHOT.jar com.spandigital.test.RankingEngine input/scores_5.txt
1. Tarantulas, 7 pts
2. Grouches, 5 pts
2. Lions, 5 pts
4. Rabbits, 3 pts
5. FC Awesome, 2 pts
5. Snakes, 2 pts
7. Tigers, 1 pt
````
