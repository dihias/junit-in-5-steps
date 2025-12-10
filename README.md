
# **JUnit 5 – Professional Cheat-Sheet**

A concise reference designed for engineering teams building reliable, maintainable, and expressive automated tests using **JUnit 5 (Jupiter)**.

---

## **1. Project Setup**

**Standard test directory layout (Maven/Gradle):**

```
src
 ├── main/java
 └── test/java
```

**JUnit 5 dependency:**

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.x.x</version>
    <scope>test</scope>
</dependency>
```

---

# **2. Core Annotations**

### **@Test**

Marks a test method.

### **@BeforeEach / @AfterEach**

Executed before/after *each* test method.

### **@BeforeAll / @AfterAll**

Executed once before/after the test class.
(Static by default.)

### **@DisplayName**

Human-readable test names.

### **@Disabled**

Temporarily disables a test or test class.

### **@Nested**

Groups related test cases using inner classes.

### **@TestInstance(TestInstance.Lifecycle.PER_CLASS)**

Allows non-static lifecycle methods.

---

# **3. Assertions**

## Basic Assertions

* `assertEquals(expected, actual)`
* `assertNotEquals(a, b)`
* `assertTrue(condition)`
* `assertFalse(condition)`
* `assertNull(value)`
* `assertNotNull(value)`

## Exceptions

```java
assertThrows(Exception.class, () -> method());
assertDoesNotThrow(() -> method());
```

## Grouped Assertions

```java
assertAll(
    () -> assertEquals(10, service.sum(5,5)),
    () -> assertTrue(list.isEmpty())
);
```

## Collections & Arrays

* `assertArrayEquals(...)`
* `assertIterableEquals(...)`

## Fail Fast

```java
fail("Should not reach this branch");
```

---

# **4. Test Structure & Best Practices**

* Tests should be deterministic and isolated.
* Test only one logical behavior per method.
* Prefer descriptive method names:

  ```
  shouldRejectEmptyInput()
  ```
* Use `@BeforeEach` to initialize common objects.
* Focus on **public behavior**, not implementation details.
* Never let tests depend on each other’s execution order.
* Keep assert statements minimal and expressive.

---

# **5. Parameterized Tests**

Add parameterized test dependency:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
</dependency>
```

### Example: @ValueSource

```java
@ParameterizedTest
@ValueSource(strings = {"A", "B", "C"})
void shouldAcceptValidInputs(String value) {
    assertTrue(validator.isValid(value));
}
```

### Example: @CsvSource

```java
@ParameterizedTest
@CsvSource({
    "2, 3, 5",
    "1, 1, 2"
})
void add_shouldReturnExpectedSums(int a, int b, int expected) {
    assertEquals(expected, calculator.add(a, b));
}
```

---

# **6. Test Development Milestones (Generic Reference)**

A typical progression when building a JUnit test suite:

### **✔ Initial test setup**

Creating the first JUnit project with a basic passing test (“green bar”).

### **✔ Adding simple assertions**

Using `assertEquals`, `assertTrue`, `assertFalse`, and null checks.

### **✔ Introducing structured test methods**

Improved naming, using `@DisplayName`, and separating concerns.

### **✔ Exploring JUnit annotations**

Implementing lifecycle callbacks (`@BeforeEach`, `@AfterEach`, etc.).

### **✔ Expanding test coverage**

Introducing exception testing, grouped assertions, and parameterized tests.

This progression reflects a standard approach to maturing a project’s test suite and aligns with common engineering onboarding practices.

---

# **7. Advanced JUnit Concepts**

### **Mockito Integration (Test Doubles)**

* Mocks
* Stubs
* Verifications
* ArgumentCaptor

### **Conditional Test Execution**

* `@EnabledOnOs`
* `@EnabledIfEnvironmentVariable`
* `@EnabledOnJre`

### **Temporary Workspaces**

* `@TempDir` for filesystem-related tests.

### **Dynamic Tests**

Generate tests programmatically using `DynamicTest`.

---

# **8. Minimal Example Template**

```java
@DisplayName("UserService – Unit Tests")
class UserServiceTest {

    private UserService service;

    @BeforeEach
    void setUp() {
        service = new UserService();
    }

    @Test
    @DisplayName("should calculate correct age")
    void shouldCalculateCorrectAge() {
        assertEquals(25, service.calculateAge(2000));
    }

    @Test
    void shouldThrowExceptionForInvalidYear() {
        assertThrows(IllegalArgumentException.class,
            () -> service.calculateAge(-10)
        );
    }
}
```

---
