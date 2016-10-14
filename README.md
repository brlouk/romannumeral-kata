# romannumeral-kata

This is my solution for the given roman numeral kata part1 built with spring boot and Java 8.

https://github.com/xebia-france/romannumeral-kata/blob/master/README.md

Prerequisites
=============
* Maven 3.0+
* Java 8+
* Spring boot 1.4+

Run
=====
        mvn clean install


Sonar
=====
* Prepare jacoco agent to allow coverage report generation, build the project, and execute the unit tests:

        mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install

* Analyze the project with SonarQube using Maven:

        mvn sonar:sonar
