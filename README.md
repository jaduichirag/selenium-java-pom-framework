# Selenium Java POM Framework

A production-ready UI Automation Framework built using **Java**, **Selenium WebDriver**, **TestNG**, **Maven**, and the **Page Object Model (POM)** design pattern.

This project demonstrates an industry-standard automation framework with reusable components, utility classes, reporting, logging, and sample test cases.

---

## 🚀 Features

- Selenium WebDriver 4
- Java 17
- TestNG
- Maven
- Page Object Model (POM)
- WebDriverManager
- Config Reader
- Explicit Waits
- Screenshot Utility
- Excel Utility (Apache POI)
- Log4j2 Logging
- Extent Reports
- Retry Mechanism
- Cross Browser Ready

---

## 📁 Project Structure

```text
src
├── main
│   ├── java
│   │   ├── base
│   │   ├── constants
│   │   ├── pages
│   │   └── utils
│   └── resources
│       ├── config.properties
│       ├── log4j2.xml
│       └── testdata.xlsx
│
├── test
│   ├── java
│   │   ├── listeners
│   │   └── tests
│   └── resources
│       └── testng.xml
│
├── reports
├── screenshots
├── logs
├── pom.xml
└── README.md
```

---

## 📦 Utility Classes

| Class | Purpose |
|------|---------|
| DriverFactory | WebDriver initialization |
| ConfigReader | Read configuration values |
| WaitUtility | Explicit waits |
| ScreenshotUtility | Capture screenshots |
| ExcelUtility | Read Excel data |
| ActionUtility | Common WebElement actions |
| DropdownUtility | Dropdown handling |
| AlertUtility | JavaScript alerts |
| FrameUtility | Frame switching |
| WindowUtility | Window/tab handling |
| JavaScriptUtility | JavaScript operations |
| LoggerUtility | Log4j2 logging |
| RetryAnalyzer | Retry failed tests |
| ExtentReportManager | HTML report generation |

---

## ▶️ Running Tests

Clone the repository

```bash
git clone https://github.com/jaduichirag/selenium-java-pom-framework.git

```

Install dependencies

```bash
mvn clean install
```

Run tests

```bash
mvn test
```

Or execute `testng.xml` from your IDE.

---

## 📊 Framework Components

- BaseTest
- BasePage
- Page Objects
- Utility Classes
- Listeners
- TestNG Suite
- Config Management
- Logging
- Reporting

---

## 🛠 Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Apache POI
- WebDriverManager
- Log4j2
- Extent Reports

---

## 📈 Roadmap

- Jenkins Integration
- GitHub Actions
- Docker Support
- Selenium Grid
- Parallel Execution
- Allure Reports

---

## 🤝 Contributing

Contributions are welcome. Feel free to fork the repository, create a feature branch, and submit a pull request.

---

## 📄 License

This project is licensed under the MIT License.

---

## 👨‍💻 Author
**Chirag Panchal**  
Senior QA Automation Engineer
📍 Ahmedabad, India

🔗 **LinkedIn:**  
https://www.linkedin.com/in/chirag243/

⭐ If you find this project useful, please consider giving it a **Star** on GitHub.