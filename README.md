# JiscRegistrationTask
Jisc Registration Task

Tests can be triggered using CukesRunner class or if you want to re-run only failed tests we can use FailedTestRunner.
Page object model is implemented and the 3 page objects can be found under the pages package.
Feature file can be found under resources/features and is written in Gherkin lanaguage.
Hooks class allows us to take a screenshot of our failed step_definitions and attach it to our cucumber report. Hooks class also allows us to close our driver instance once our tests are done running.
The utilities folder contains the Driver class which allows us to implement Singleton Design Pattern (we use once driver instance for all our tests). This class also allows us to implement parallel testing. Meaning we can run all our feature files at the same time. We have had to also implment our build in pom.xml to allow this.
ConfigurationReader is also in our utilities and allows us to read data from our configuration.properties file. This helps us to avoid hardcoding any data in our tests.
Cucumber reports can be found under the target folder.
