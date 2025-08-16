
# HybridFramework — Complete Selenium Grid POM Framework

> A production‑style test automation framework using **Selenium 4**, **TestNG**, **Page Object Model (POM)**, **Maven**, and **Selenium Grid** (local Docker or remote). Includes parallel runs, environment‑driven configs, and clean reporting.

---

## ✨ Features

- **Selenium 4** WebDriver with W3C actions
- **TestNG** for test orchestration, groups, data providers & parallelism
- **Page Object Model (POM)** + clear separation of concerns
- **Maven** lifecycle (`test`, `verify`) + Surefire for TestNG suites
- **Selenium Grid** support (Dockerized or remote hub)
- **Configurable** via `config.properties` / system properties
- **Parallel execution** by methods / classes / tests
- **Reporting**: surefire reports out of the box (drop‑in Allure/Extent optional)
- **WebDriverManager** for local driver binaries (when not using Grid)

---

## 🧰 Tech Stack

- **Java 17+**
- **Maven 3.8+**
- **Selenium 4.x**
- **TestNG 7.x**
- **WebDriverManager 5.x**
- **(Optional) Docker** for Selenium Grid
- **(Optional) Allure** or **Extent** for rich reports

---

## 📦 Project Structure
Hybrid-Automation-Framework/
├─ pom.xml
├─ README.md
├─ src
│ ├─ main
│ │ ├─ java
│ │ │ ├─ framework
│ │ │ │ ├─ core/ # DriverManager, GridFactory, BaseTest
│ │ │ │ ├─ utils/ # Waits, Config, TestData, Logger
│ │ │ └─ pages/ # Page Objects (LoginPage, HomePage, etc.)
│ │ └─ resources
│ │ ├─ config.properties # baseUrl, browser, gridUrl, timeouts...
│ │ └─ log4j2.xml # logging
│ └─ test
│ ├─ java
│ │ └─ tests # TestNG tests (organized by feature)
│ └─ resources
│ └─ testng.xml # Suite definition (parallel/groups)
└─ docker
└─ grid-compose.yml # Selenium Grid (hub + nodes)
