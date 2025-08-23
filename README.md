# **OpenCart UI Automation Framework**
## About Project
This project is an automation framework built using Java, Selenium, TestNG, and integrated with Jenkins & Docker.
<img width="843" height="518" alt="Hybrid Automation framework" src="https://github.com/user-attachments/assets/f999acb1-d588-4664-aaf0-59453753f51e" />

## Overview
This project is a Hybrid Automation Framework built for automating the OpenCart application using Selenium, TestNG, Maven, Docker, and Jenkins.

The framework supports:

- Page Object Model (POM) design pattern
- Data-driven testing (Excel-based)
- Cross-browser execution
- Parallel execution with Selenium Grid & Docker
- Jenkins CI/CD integration
- Extent Reporting & TestNG Listeners
## Project Structure
```
├── src/test/java/                 → Test scripts & page objects
│   ├── pageObjects/               → POM classes
│   ├── testBase/                  → Base setup class
│   ├── testCases/                 → TestNG test cases
│   └── utilities/                 → Helper classes (Excel, Reports)
├── src/test/resources/            → Config & log4j files
│   ├── config.properties/         → URL/PWD/Environment
│   └── log4j2.xml/                → Log4j execution logs
├── TestData/                      → Test data files (Excel)
├── reports/                       → HTML Extent Reports
├── screenshots/                   → Captured screenshots on failures
├── logs/                          → Log4j execution logs
├── test-output/                   → TestNG default reports
├── docker-compose.yaml            → Docker Grid setup
├── docker-grid.xml                → Grid execution config
├── pom.xml                        → Maven dependencies & plugins
├── master.xml                     → Master TestNG suite
├── run.bat                        → Batch file for execution
└── README.md                      → Project documentation
```
##  Setup & Execution
### 1️⃣ Clone the repository
```
https://github.com/aminulislamtutul/opencartV01_Web_Automation_Testing_Project.git
```
### 2️⃣ Install dependencies

```bash
mvn clean install
```
* **Using run.bat**

```bash
run.bat
```
##  Docker + Selenium Grid Execution
### Run Grid

```bash
docker-compose up -d
```
### Execute Tests on Grid

```bash
mvn clean test -DsuiteXmlFile=docker-grid.xml
```
## Reports & Logs
- Extent Reports → `reports/`
- Screenshots on Failure → `screenshots/`
- Log file → `logs/automation.log`
- TestNG Reports → `test-output/`
<img width="958" height="419" alt="Screenshot 2025-08-23 012811" src="https://github.com/user-attachments/assets/5496447f-73ae-46fd-96b9-9280db17f33e" />

## CI/CD with Jenkins

1. Install Jenkins & configure Maven + Git in **Global Tool Configuration**
2. Create a new Jenkins Job → Pull this repo
3. Add **Build Step**:
```bash
mvn clean test -DsuiteXmlFile=master.xml
```
4. View execution & reports in Jenkins
<img width="1353" height="595" alt="JenkinsConfiguration" src="https://github.com/user-attachments/assets/d062c266-8762-4af7-afee-d1599a2efb4b" />

## Test Cases Implemented
* ** TestAccountRegistrationPage_TC001** → Validate account registration
* ** TestAccountLoginPage_TC002** → Validate login with valid credentials
* ** DDTestAccountLoginPage_TC003** → Validate login with multiple data sets (Excel-driven)
## Future Enhancements
* Integrate with **Allure Reports**
* Add support for **API Testing**
* Enable **Cloud Execution** (BrowserStack/SauceLabs)


