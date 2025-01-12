import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class StudentScoreCalculatorTestParams {

    private static Object[] testValues(){

        return new Object[]{
                new Object[]{50, 50,  2500},
                new Object[]{-10, 50, -1},
                new Object[]{50, -1, -1},
                new Object[]{-1, -1, -1},
                new Object[]{150, 50, -1},
                new Object[]{50, 150, -1},
                new Object[]{150, 150, -1},
                new Object[]{0, 0, 0},
                new Object[]{100, 100, 10000}
        };

    }

    @Test
    @Parameters(method = "testValues")// parameter로 사용할 객체를 가져오기 위해 property로 method에 메서드명을 입력해준다.(String으로)
    public void studentScoreCalculator(int mathsScore, int literacyScore, int expectedScore){

        StudentScoreCalculator sc = new StudentScoreCalculator();
        sc.calculateSATScore(mathsScore, literacyScore);
        assertEquals(expectedScore, sc.getSatScore());
    }
}
