import org.junit.jupiter.api.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {
    MyMath myMath = new MyMath();
    @Test
    void calculateSum_EmptyArray() {
        assertEquals(0, myMath.calculateSum(new int[]{}));
    }

    @Test
    void calculateSum_ThreeMumberArray() {
        assertEquals(6, myMath.calculateSum(new int[]{1,2,3}));
    }
}
