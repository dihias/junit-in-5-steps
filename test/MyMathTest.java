import org.junit.jupiter.api.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    @Test
    void calculateSum() {
        int [] numbers = {1,2,3};
     MyMath myMath = new MyMath();
     int result = myMath.calculateSum(numbers);
        System.out.println(result);
        int expectedRrsult = 6;
        assertEquals(expectedRrsult, result);
    }
}
