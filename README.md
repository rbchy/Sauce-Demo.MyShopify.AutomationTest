<div align="center">

# 🛍️ Sauce Demo Shop Automation

### BDD UI test suite for the Sauce Demo Shopify store and the Sauce Labs login demo

[![Typing SVG](https://readme-typing-svg.demolab.com/?font=Fira+Code&size=18&pause=1500&color=FFC107&center=true&vCenter=true&width=900&repeat=true&lines=Java+17+%C2%B7+Selenium+4+%C2%B7+Cucumber+7+%C2%B7+TestNG+%C2%B7+Maven;Home+%C2%B7+navigation+%C2%B7+search+%C2%B7+cart+%C2%B7+login+%2F+logout;17+%2F+17+smoke+scenarios+passing)](https://git.io/typing-svg)

<!-- ============ STATUS BAR ============ -->
![Status](https://img.shields.io/badge/Status-Stable-0d9488?style=for-the-badge&logo=checkmarx&logoColor=white)
![Pass Rate](https://img.shields.io/badge/Pass%20Rate-100%25%20(17%2F17)-22c55e?style=for-the-badge)
![Domain](https://img.shields.io/badge/Domain-E--commerce-155e75?style=for-the-badge)
![Targets](https://img.shields.io/badge/Targets-Shopify%20store%20%C2%B7%20saucedemo.com-1e3a8a?style=for-the-badge&logo=shopify&logoColor=white)

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-4-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Cucumber](https://img.shields.io/badge/Cucumber-7.18-23D96C?style=for-the-badge&logo=cucumber&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-7.10-FF7F00?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

![Last Commit](https://img.shields.io/github/last-commit/rbchy/Sauce-Demo.MyShopify.AutomationTest?style=flat-square&color=0d9488&label=Last%20commit)
![Repo Size](https://img.shields.io/github/repo-size/rbchy/Sauce-Demo.MyShopify.AutomationTest?style=flat-square&color=155e75&label=Repo%20size)
![Top Language](https://img.shields.io/github/languages/top/rbchy/Sauce-Demo.MyShopify.AutomationTest?style=flat-square&color=f59e0b)

</div>

---

## 📌 At a Glance

<table>
<tr>
<td width="50%" valign="top">

**🙋 What this is**

A Cucumber + Selenium smoke suite for two public practice shops:

- 🛍️ **[sauce-demo.myshopify.com](https://sauce-demo.myshopify.com/)** — a Shopify storefront: home page, catalog, blog, About Us, search, product pages and cart
- 🔐 **[saucedemo.com](https://www.saucedemo.com/)** — Sauce Labs' login demo: sign-in, logout and invalid-credential handling

Scenarios are plain-English Gherkin, backed by **Page Object** classes and run by **TestNG** through Maven.

> *A shop that loads but cannot find, show or cart a product is still broken — smoke tests catch that first.*

</td>
<td width="50%" valign="top">

**📍 Quick facts**

| | |
|---|---|
| 🧪 **Scenarios** | 17 in 6 feature files |
| ✅ **Latest run** | 17 / 17 passed · 4 m 11 s |
| 💻 **Run on** | macOS · OpenJDK 21 · Chrome |
| 🏷️ **Tags** | `@smoke` (all) · `@regression` |
| 📄 **Report** | [Cucumber report (PDF)](Cucumber.pdf) |

</td>
</tr>
</table>

---

## ✅ Latest Results

| Feature file | Site | Scenarios | Result |
|---|---|---:|---|
| 🏠 `HomePage.feature` | Shopify store | 1 | ![passed](https://img.shields.io/badge/-1%20passed-22c55e?style=flat-square) |
| 🧭 `NavigationLinks.feature` | Shopify store | 6 | ![passed](https://img.shields.io/badge/-6%20passed-22c55e?style=flat-square) |
| 🔎 `SearchFunctionality.feature` | Shopify store | 4 | ![passed](https://img.shields.io/badge/-4%20passed-22c55e?style=flat-square) |
| 🛒 `AddToCart.feature` | Shopify store | 3 | ![passed](https://img.shields.io/badge/-3%20passed-22c55e?style=flat-square) |
| 🔐 `LoginSteps.feature` | saucedemo.com | 2 | ![passed](https://img.shields.io/badge/-2%20passed-22c55e?style=flat-square) |
| 🚫 `SignUp.feature` | saucedemo.com | 1 | ![passed](https://img.shields.io/badge/-1%20passed-22c55e?style=flat-square) |
| **Total** | | **17** | **100 %** |

<sub>Source: [Cucumber.pdf](Cucumber.pdf) in this repository — cucumber-jvm 7.18.0, OpenJDK 21.0.7, macOS. Both targets are shared public demos, so results depend on their availability.</sub>

---

## 🎯 Test Coverage

<details open>
<summary><strong>🏠 Home page &amp; 🧭 navigation (Shopify store)</strong></summary>

<br>

- Home page shows the left navigation, featured products, product cards and images, cart and checkout links, and the footer
- **Catalog** opens the collection page · **Blog** opens the blog
- **About Us** opens from both the left navigation and the footer
- **Checkout** link opens the cart · footer **Search** opens the search page

</details>

<details>
<summary><strong>🔎 Search (Shopify store)</strong></summary>

<br>

| Scenario | Check |
|---|---|
| Search bar is visible and accepts input | typed value stays in the field |
| Valid search — *"Noir Jacket"* | results shown, at least one product |
| Invalid search — *"Blue Shade"* | "no results" message, no products |
| Click the first result | product details page opens |

</details>

<details>
<summary><strong>🛒 Cart (Shopify store)</strong></summary>

<br>

- Cart page loads and shows the empty-cart message
- Product page shows title, price and **Add to Cart**
- Adding a product makes the cart show **1 item**

</details>

<details>
<summary><strong>🔐 Login, logout &amp; invalid credentials (saucedemo.com)</strong></summary>

<br>

- Successful login with the demo user
- Log out from the menu and return to the login page
- Invalid username and password show an error message (`@smoke @regression`)

</details>

---

## 🏗️ Framework Architecture

```mermaid
flowchart LR
  F["Feature files<br/>(Gherkin)"] --> S["Step definitions<br/>steps/"]
  S --> P["Page Objects<br/>pages/"]
  P --> W["Selenium WebDriver<br/>+ WebDriverManager"]
  W --> C["Chrome"]
  C --> A["sauce-demo.myshopify.com"]
  C --> B["saucedemo.com"]
  H["Hooks<br/>@Before / @After"] -.->|"fresh browser per scenario"| W
  R["TestRunner<br/>(@smoke)"] --> F
```

- **Page Object Model** — `LoginPage` and `InventoryPage` (saucedemo.com) and `SignUpPage` (Shopify registration) keep locators and actions out of the steps
- **Explicit waits** — `WaitUtils` wraps visibility and clickability waits
- **WebDriverManager** — downloads the matching ChromeDriver; no manual driver path
- **Hooks** — a clean Chrome session for every scenario, closed afterwards

---

## 🛠️ Tech Stack

| Layer | Technology | Version |
|---|---|---|
| Language | Java | 17 |
| Browser automation | Selenium WebDriver | 4.x |
| Driver management | WebDriverManager | 5.5.3 |
| BDD | Cucumber JVM (Gherkin) | 7.18.0 |
| Runner | TestNG (`cucumber-testng`) | 7.10.2 |
| Build | Maven (Surefire 3.2.5) | — |
| Reporting | Cucumber HTML + JSON | — |

---

## 📁 Project Structure

```
Sauce-Demo.MyShopify.AutomationTest/
├── src/test/java/
│   ├── base/BaseTest.java              ← shared driver access
│   ├── hooks/Hooks.java                ← @Before / @After browser lifecycle
│   ├── pages/
│   │   ├── LoginPage.java              ← saucedemo.com login
│   │   ├── SignUpPage.java             ← Shopify account-registration form (not yet used)
│   │   └── InventoryPage.java          ← saucedemo.com product list, menu, logout
│   ├── steps/
│   │   ├── HomePageSteps.java          NavigationLinksSteps.java
│   │   ├── SearchSteps.java            AddToCartSteps.java
│   │   ├── LoginSteps.java             LogoutSteps.java
│   │   └── SignUpStep.java
│   ├── runner/TestRunner.java          ← TestNG + CucumberOptions (@smoke)
│   └── utils/
│       ├── DriverManager.java          ← ThreadLocal driver holder
│       └── WaitUtils.java              ← explicit waits
├── src/test/resources/features/        ← 6 feature files, 17 scenarios
├── Cucumber.pdf                        ← latest run (17 / 17 passed)
├── pom.xml
└── testng.xml
```

---

## ⚙️ Getting Started

**Prerequisites:** JDK 17+ · Maven 3.8+ · Google Chrome · Git

```bash
git clone https://github.com/rbchy/Sauce-Demo.MyShopify.AutomationTest.git
cd Sauce-Demo.MyShopify.AutomationTest
mvn clean install -DskipTests
```

---

## ▶️ Running the Tests

```bash
# All @smoke scenarios (the runner's default)
mvn clean test

# Through the TestNG suite file
mvn clean test -DsuiteXmlFile=testng.xml

# A single tag expression
mvn clean test -Dcucumber.filter.tags="@regression"
```

**From the IDE:** right-click `runner/TestRunner.java` or `testng.xml` → **Run As › TestNG Test**.

Reports are written after each run to:

| File | Format |
|---|---|
| `target/cucumber-reports/SauceDemoCucumberFinalReport.html` | Cucumber HTML report |
| `target/cucumber-reports/SauceDemoCucumberFinalReport.json` | JSON, for CI plugins |

---

## 🔍 Review Notes

| # | Item | Suggestion |
|---|---|---|
| 1 | `pom.xml` lists `selenium-java` twice (4.21.0 and 4.14.0) and `cucumber-java` twice | Keep one of each; Maven silently picks one today |
| 2 | Both `cucumber-testng` and `cucumber-junit` + JUnit 4 are declared | The runner uses TestNG; JUnit can go |
| 3 | `Hooks` stores the driver in a `static` field while `DriverManager` offers a `ThreadLocal` | Use `DriverManager` in Hooks to make parallel runs safe |
| 4 | URLs are written in the step classes | Move them to a `config.properties` |
| 5 | No screenshot on failure, no headless switch | Attach a screenshot in `@After`; read `-Dheadless=true` |
| 6 | `SignUp.feature` tests an invalid login, while `SignUpPage` models the Shopify registration form | Rename the feature, or add a real Shopify sign-up scenario |

---

## 📈 Roadmap

- [ ] Clean up `pom.xml` duplicates (see review notes)
- [ ] `config.properties` for URLs and the demo credentials
- [ ] Screenshot on failure embedded in the Cucumber report
- [ ] Headless mode and a GitHub Actions workflow running the suite on every push
- [ ] saucedemo.com shopping flow: sort, cart badge, checkout, order confirmation
- [ ] Parallel scenarios through the `ThreadLocal` driver

---

## 🔗 Related Projects

| Project | Stack |
|---|---|
| ⭐ [RbcTcsWorld E-Commerce Suite](https://github.com/rbchy/RbcTcsWorld_ECommerceSuite) | Spring Boot · REST Assured · Selenium · Playwright · CI quality gates |
| 🔌 [API — Rest Assured](https://github.com/rbchy/QaBrainsAPIAutomationRestAssured) | Java · Rest Assured · Cucumber · Selenium — CI green |
| ☁️ [Sauce Labs Cloud Automation](https://github.com/rbchy/QaBrainsSauceLabAPI_Automation) | Java · Selenium · Cucumber · Sauce Labs |
| 🏥 [OpenEMR Healthcare](https://github.com/rbchy/OpenEMR_Automation) | Java · Selenium · Cucumber · TestNG |

<sub>All projects: [github.com/rbchy](https://github.com/rbchy)</sub>

---

## 👤 Author

<div align="center">

**Ranajit Baran Chowdhury (RB Chowdhury)**
QA Automation Engineer / SDET · West Norriton, Pennsylvania, USA

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/rbchy/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/rbchy)
[![Website](https://img.shields.io/badge/Website-rbchy.github.io%2Frbchy-0d9488?style=for-the-badge&logo=githubpages&logoColor=white)](https://rbchy.github.io/rbchy/)
[![Portfolio](https://img.shields.io/badge/Portfolio-Website-blueviolet?style=for-the-badge&logo=wix&logoColor=white)](https://rbc6543.wixsite.com/rbc-portfolio)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:chyranajit@gmail.com)

<sub>Provided for educational and professional QA automation purposes. Both target sites are public practice demos.</sub>

⭐ *If this project helps you, a star on the repo is appreciated.*

</div>
