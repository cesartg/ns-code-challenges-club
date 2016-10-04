import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IslandsProblemTest {
    @Test
    public void testCase0() {
        int[][] input = new int[][]{
                {1, 0, 0},
                {1, 1, 1},
                {1, 0, 1}
        };
        assertThat(IslandsProblem.islands(input), is(1));
    }

    @Test
    public void testCase1() {
        int[][] input = new int[][]{
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1}
        };
        assertThat(IslandsProblem.islands(input), is(5));
    }

    @Test
    public void testCase2() {
        int[][] input = new int[][]{
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };
        assertThat(IslandsProblem.islands(input), is(5));
    }

    @Test
    public void testCase3() {
        int[][] input = new int[][]{
                {0, 1, 1},
                {0, 1, 0},
                {1, 1, 0}
        };
        assertThat(IslandsProblem.islands(input), is(1));
    }

    @Test
    public void testCase4() {
        int[][] input = new int[][]{
                {0,0,1,1,0},
                {1,1,0,1,0},
                {1,1,0,1,0},
                {0,0,1,1,1},
                {0,1,1,0,0}
        };
        assertThat(IslandsProblem.islands(input), is(2));
    }

    @Test
    public void testCase5() {
        int[][] input = new int[][]{
                {0, 0, 1},
                {0, 1, 1},
                {0, 0, 1}
        };
        assertThat(IslandsProblem.islands(input), is(1));
    }
}