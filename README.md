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
