import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class NQueensProblemTest {
    @Test
    public void testProblem() {
        assertThat(NQueensProblem.calculateSolutions(1), is(1));
        assertThat(NQueensProblem.calculateSolutions(2), is(0));
        assertThat(NQueensProblem.calculateSolutions(3), is(0));
        assertThat(NQueensProblem.calculateSolutions(4), is(2));
        assertThat(NQueensProblem.calculateSolutions(5), is(10));
        assertThat(NQueensProblem.calculateSolutions(6), is(4));
        assertThat(NQueensProblem.calculateSolutions(7), is(40));
        assertThat(NQueensProblem.calculateSolutions(8), is(92));
        assertThat(NQueensProblem.calculateSolutions(9), is(352));
        assertThat(NQueensProblem.calculateSolutions(10), is(724));
    }
}