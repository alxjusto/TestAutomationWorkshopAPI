# TestAutomationWorkshopAPI
This is a base test automation framework for automate some endpoints from "reqres" API.
We set a JsonDataProvider class as a test data example for DDT.

####Tools
* API: https://reqres.in
* Java 11
* Gradle
* Allure

####Dependencies
* JUnit 5
* Rest-assured version: 4.4.0
* Jackson-databind version: 2.12.4
* Gson version: 2.8.6
* Project Lombock: https://projectlombok.org/setup/gradle
* Allure version: 2.8.1

####Design Patterns
* DTO
* Builder

####Generate Allure Report
Steps:
1. ./gradlew clean test
2. ./gradlew allureReport
3. ./gradlew allureServe
