import org.junit.After;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MyBeforeAfterTest {

    @BeforeAll
    static void hahaPreums(){
        System.out.println("Haha I am the first test executed");
    }

    @AfterAll
    static void hahaLast(){
        System.out.println("Haha I am the last test executed");
    }


    @Test
    void test1() {
        System.out.println("Test 1");
}
@BeforeEach
void blabla1()
{
    System.out.println("I happen before each test");
}

    @AfterEach
    void blabla2()
    {
        System.out.println("I happen after each test\n-------------\n");
    }
    @Test
    void test2() {
        System.out.println("Test 2");
    }
    @Test
    void test3() {
        System.out.println("Test 3");
    }
}
