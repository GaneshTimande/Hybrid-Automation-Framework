# 🚀 Hybrid-Automation-Framework

A **Hybrid Selenium Automation Framework** built using **Java, TestNG, POM (Page Object Model), Selenium Grid, Docker, and Maven**.  
This framework is designed for **scalability, reusability, and parallel execution**.

---

## 📌 Tech Stack
- **Java 11+**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Log4j2**
- **Extent Reports**
- **Selenium Grid with Docker**

---

## 📂 Project Structure

```text
Hybrid-Automation-Framework
│
├── .gitignore
├── pom.xml
├── README.md
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── framework
│   │   │       ├── core
│   │   │       │   ├── DriverFactory.java
│   │   │       │   └── BaseTest.java
│   │   │       │
│   │   │       ├── pages
│   │   │       │   └── LoginPage.java
│   │   │       │
│   │   │       └── utils
│   │   │           └── ConfigReader.java
│   │   │
│   │   └── resources
│   │       ├── config.properties
│   │       └── log4j2.xml
│   │
│   └── test
│       ├── java
│       │   └── tests
│       │       └── LoginTest.java
│       │
│       └── resources
│           └── testng.xml
│
└── docker
    └── grid-compose.yml
