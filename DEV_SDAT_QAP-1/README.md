#  Game Store System (CLI Java Project)

This is a simple Java-based Command Line Application that simulates a basic game store. Users can view available games,
add them to a cart, and view the cart total. The project was developed for the **QAP 1 – SDAT & DevOps Combined** assignment.

---

##  Features

-  Browse available games
-  Add games to a cart
-  Calculate and display the total cart value
-  Command-line interface using `Scanner` for better interactivity
-  JUnit 5 test coverage for cart operations
-  Maven project setup
-  GitHub Actions CI integration

---

##  Unit Tests (JUnit 5)

Tested using **JUnit 5**. The following scenarios were covered:

1.  **testAddGame** – confirms that the cart is no longer empty after adding a game
2.  **testCalculateTotal** – ensures the total price is calculated correctly for multiple games
3.  **testEmptyCart** – validates that a new cart is empty and its total is 0.0

Run the tests using:
```bash
mvn test
```

---

##  Clean Code Examples

### 1.  Game Class
```java
public class Game {
    private final String name;
    private final double price;
    public Game(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
```
**Why it's clean:** The class is immutable, single-responsibility, and follows proper naming.

---

### 2.  Cart Total Logic
```java
public double calculateTotal() {
    return games.stream().mapToDouble(Game::getPrice).sum();
}
```
**Why it's clean:** Uses Java Stream API for a concise and readable total calculation.

---

### 3.  CLI Menu
```java
System.out.println("1. View Games");
System.out.println("2. Add Game");
System.out.println("3. View Total");
System.out.println("0. Exit");
```
**Why it's clean:** Simple switch-based menu for clarity and user interaction.

---

## ️ How to Run the App

1. Clone or download the repo
2. Open in IntelliJ (as a Maven project)
3. Run `Main.java` to start the CLI
4. Use the terminal menu to interact

---

##  Dependencies

Listed in `pom.xml` and retrieved via Maven Central:
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.3</version>
    <scope>test</scope>
</dependency>
```

---

##  GitHub Actions CI

CI workflow is defined in:
```
.github/workflows/maven.yml
```

Runs all tests on every Pull Request using:
```bash
mvn test
```

---

##  Problems Faced

- Integrating `Scanner` cleanly into the CLI required refactoring `Main.java`
- Configuring Maven Surefire plugin correctly to detect JUnit 5
- Learning GitHub Actions for CI automation

---

##  Summary

This project demonstrates:
- Clean, object-oriented design
- Proper test coverage
- Maven and GitHub Actions integration
- CLI interactivity via Scanner

---

##  Author

**Abdul Rahman Zahiri**
QAP 1 – SDAT & DevOps Combined
