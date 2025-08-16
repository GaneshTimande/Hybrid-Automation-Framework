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


2️⃣ Install dependencies
mvn clean install

3️⃣ Configure properties

Update src/main/resources/config.properties with your browser, grid URL, and application details.

▶️ Execution

🔹 Run with Maven

mvn test


🔹 Run with TestNG Suite

mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml


🔹 Run on Selenium Grid (Docker)

docker-compose -f docker/grid-compose.yml up -d
mvn test -DseleniumGrid=true

📊 Reports

Test Execution Reports → test-output/

Extent Reports → reports/extent-report.html

📸 Demo Screenshot (Optional)

Add a screenshot here if needed

🧑‍💻 Author

👤 Ganesh Timande
🔗 GitHub | LinkedIn


---

4. Save the file.  
5. Commit and push to GitHub:  

```bash
git add README.md
git commit -m "Added setup, execution, and report details to README"
git push origin master
