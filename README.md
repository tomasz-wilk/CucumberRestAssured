1. Test scenarios stored in jsonplaceholder-test/src/test/resources/features
2. How to run tests: (allure report artifacts will be also generated):
- mvn clean verify
3. How to open Allure report:
- JAVA_HOME has to be set
- ./jsonplaceholder-test/.allure/allure-2.24.0/bin/allure serve report ./jsonplaceholder-test/target/allure-results
