public class LinkedListDeque<Anytype> {
    private static class StuffNode<Anytype> {
        Anytype item;
        StuffNode next;
        StuffNode prev;

        StuffNode(Anytype x, StuffNode n, StuffNode m) {
            this.item = x;
            this.prev = n;
            this.next = m;
        }
    }

    private StuffNode sentinel;
    private int size;

    /*This should be public cause you wanna users to call it*/
    public LinkedListDeque() {
        /*Very Importment, since we can olny use sentinel
        after the decalration & initination*/
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(Anytype x) {
        sentinel = new StuffNode(x, null, null);
        sentinel.next = new StuffNode(x, sentinel, sentinel);
        size = 1;
    }

    /**
     * Those Methods
     */
    public void addFirst(Anytype x) {
        StuffNode addone = new StuffNode(x, sentinel, sentinel.next);
        sentinel.next = addone;
        sentinel.next.prev = addone;
        size += 1;
    }

    public void addLast(Anytype x) {
        StuffNode addone = new StuffNode(x, sentinel.prev.prev, sentinel);
        sentinel.prev = addone;
        sentinel.prev.prev.next = addone;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
       /* if (size == 0) {
            return true;
        } else {
            return false;
        }
        */
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode p = sentinel.next;

        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public Anytype removeFirst() {
        if (size == 0) {
            return null;
        }
        Anytype valueFirst = (Anytype) sentinel.next.item;
        StuffNode newFirst = sentinel.next.next;
        sentinel.next = newFirst;
        newFirst.prev = sentinel;
        size -= 1;
        return valueFirst;
        /*return must be at the last*/

    }

    public Anytype removeLast() {
        if (size == 0) {
            return null;
        }

        Anytype valueLast = (Anytype) sentinel.prev.item;
        sentinel.prev.next = sentinel;
        sentinel.next = sentinel.prev.prev;
        size--;
        return valueLast;
    }

    public Anytype get(int index) {
        if (size == 0 || index >= size || index < 0) {
            return null;
        }
        StuffNode p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return (Anytype) p.item;
    }

    /* Gets the item at the given index using recursion.
     If no such item exists, returns null. */
    /* Gets the item at the given index using recursion. If no such item exists, returns null. */
    public Anytype getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }

        return getRecursiveHelper(sentinel.next, index);
    }

    /* Helper method for getRecursive */
    private Anytype getRecursiveHelper(StuffNode current, int index) {

        if (index == 0) {
            return (Anytype) current.item;
        }

        return getRecursiveHelper(current.next, index - 1);
    }

}
