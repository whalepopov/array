import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class IndexStorageTest {

    @Test
    public void mustBeLessZero() {
        IndexStorage indexStorage = new IndexStorage(2);
        int actual = indexStorage.get(1);
        int expected = -1;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void compareInverted() {
        //создадим
        IndexStorage indexStorage = new IndexStorage(100);
        //заполним
        int actual[] = new int[indexStorage.size()];
        for (int i = 0; i < actual.length; i++) {
            actual[i] = indexStorage.get(i);
        }
        //наследник перевернутый
        int expected[] = indexStorage.reverse();
        ArrayIndexStorage arrayIndexStorage = new ArrayIndexStorage(expected);
        expected = arrayIndexStorage.reverse();

        Assertions.assertEquals(Arrays.toString(actual), Arrays.toString(expected));
    }
}
