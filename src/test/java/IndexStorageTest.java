import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
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

        try {
            int actualInt = arrayIndexStorage.get(-1313);
        } catch (IndexOutOfBoundsException thrown) {
            Assertions.assertEquals("Ячейка не существет!", thrown.getMessage());
        }

        try {
            int actualInt = arrayIndexStorage.get(1313);
        } catch (IndexOutOfBoundsException thrown) {
            Assertions.assertEquals("Ячейка не существет!", thrown.getMessage());
        }

    }

    @Test
    public void getnull() throws IOException {
        IndexStorage indexStorage = new IndexStorage(2);
        try {
            int actual = indexStorage.get(13);
        } catch (IndexOutOfBoundsException thrown) {
            Assertions.assertEquals("Ячейка не существет!", thrown.getMessage());
        }

        try {
            int actual = indexStorage.get(-13);
        } catch (IndexOutOfBoundsException thrown) {
            Assertions.assertEquals("Ячейка не существет!", thrown.getMessage());
        }

        indexStorage = new IndexStorage(-13);
        try {
            int actual = indexStorage.size();
        } catch (IllegalArgumentException thrown) {
            Assertions.assertEquals("Размер массива должен быть больше нуля!", thrown.getMessage());
        }

    }

}
