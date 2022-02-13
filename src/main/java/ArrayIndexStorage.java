public class ArrayIndexStorage extends IndexStorage {

    private int[] inside;

    public ArrayIndexStorage(int[] arr) {
        super(arr.length);
        this.inside = arr;
    }

    @Override
    public int get(int index) {
        if (index > inside.length - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Ячейка не существет!");
        }
        return inside[index];
    }
}