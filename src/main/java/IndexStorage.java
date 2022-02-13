public class IndexStorage {

    private int size;

    //размер заполняется конструктором
    public IndexStorage(int size) {
        this.size = size;
    }

    public int size() {
        if (size < 1) {
            throw new IllegalArgumentException("Размер массива должен быть больше нуля!");
        }
        return this.size;
    }

    //индекс или -индекс в зависимости от чётности
    public int get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Ячейка не существет!");
        }
        return index % 2 == 0 ? index : -index;
    }

    //возвращает массив, заполненный элементами в обратном порядке
    public int[] reverse() {
        int[] rev = new int[size];
        for (int i = 0; i < size; i++) {
            rev[size - i - 1] = get(i);
        }
        return rev;
    }
}
