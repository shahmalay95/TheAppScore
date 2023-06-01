## Mobile Automation Framework

This is a simple framework for mobile automation using Appium, Maven build, and TestNG.

### Prerequisites
Before running the tests, make sure you have the following dependencies installed on your machine:

- Java Development Kit (JDK)
- Android SDK
- Appium server
- Maven
- A compatible IDE (e.g., IntelliJ, Eclipse)
### Setup
- Clone or download this repository to your local machine.
- Open the project in your preferred IDE.
### Configuration
  - Update the desired capabilities in the `src/test/resources/config.properties` file according to your mobile device and application under test.
  - Make sure your mobile device is connected to your machine and has USB debugging enabled.
### Running the Tests
- Open a terminal or command prompt.
- Navigate to the project directory.
- Run the following command to build the project and execute the tests:
`mvn clean test`

- The tests will be executed on the connected mobile device using the specified desired capabilities.

### Test Results
- After the tests are completed, the test results will be generated in the `target/surefire-reports` directory.

### Troubleshooting
- If you encounter any issues while setting up or running the tests, please refer to the troubleshooting section in the project's documentation or search for solutions online.