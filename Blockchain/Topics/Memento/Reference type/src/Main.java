import java.util.*;

class Originator {
    private int[][] array;

    public Originator(int[][] array) {
        this.array = array.clone();
    }

    public void setNumber(int position, int number) {
        array[position / array[0].length][position % array[0].length] = number;
    }

    public int[][] getArray() {
        return array.clone();
    }

    public Memento getMemento() {
        return new Memento(array);
    }

    public void setMemento(Memento memento) {
        array = memento.array;
    }

    static class Memento {
        private final int[][] array;

        public Memento(int[][] array) {
            this.array = new int[array.length][];
            for (int i = 0; i < array.length; i++) {
                this.array[i] = Arrays.copyOf(array[i], array[i].length);
            }
        }
    }
}

class Caretaker {
    private final Originator originator;
    private Originator.Memento snapshot = null;

    public Caretaker(Originator originator) {
        this.originator = originator;
    }

    public void save() {
        snapshot = originator.getMemento();
    }

    public void restore() {
        if (snapshot != null) {
            originator.setMemento(snapshot);
        }
    }
}