public class ArrayDeque<Item> {
    private int size;
    private Item[] items;
    private int frontPointer;
    private int nextPointer;
    private int Refactor = 2;
    private float useage;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        frontPointer = 0;
        nextPointer = 7;
        useage = 0;
    }


    private boolean checkUseage() {
        return (useage < 0.25 && (items.length > 16));
    }

    private void resizeL() {
        Item[] a = (Item[]) new Object[2 * items.length];
        System.arraycopy(items, 0, a, 1, size);
        items = a;


    }

    private void resizeS() {
        Item[] a = (Item[]) new Object[];

    }


    public void addFirst(Item x) {
        if (size == items.length) {
            resizeL();
        }
        items[0] = x;
        size += 1;
        useage = (float) size / items.length;
    }

    public void addLast(Item x) {
        if (size == items.length) {
            resizeL();
        }
        items[size] = x;
        size += 1;
        useage = (float) size / items.length;

    }

    public Item removeFirst() {
        size -= 1;
        if (checkUseage()) {
            resizeS();
        }
        items[0] = null;
        useage = (float) size / items.length;

    }

    public Item removeLast() {
        size -= 1;
        if (checkUseage()) {
            resizeS();
        }
        items[size - 1] = null;
        useage = (float) size / items.length;
    }


    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {

    }


    public Item get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return items[index];

    }
}
