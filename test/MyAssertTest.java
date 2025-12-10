import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class MyAssertTest {

    List <String> todos = Arrays.asList("AWS", "JAVA", "DIDI");
    @Test
    void Test(){
        assertEquals (true,todos.contains("AWS"));
        assertTrue(todos.contains("AWS"),"this String is not contained in the list todos");
        assertFalse(todos.contains("chekchouka"),"the string is contained in the list todos");
        assertEquals(3,todos.size());
        //assertNull, AssertNotNull ....
        assertArrayEquals(new int[]{1,3,6},new int[]{1,3,6});
    }
}
