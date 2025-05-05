package datastructures.queues;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

public class CustomQueue<T> implements Queue<T> {
    private CustomLinkedList<T> list;
    private int capacity;

    public CustomQueue(int capacity) {
        this.capacity = capacity;
        list = new CustomLinkedList<>();
    }

    @Override
    public boolean add(Object t) {
        if (list.size() >= capacity) {
            throw new IllegalStateException();
        }
        list.addLast((T) t);
        return true;
    }

    @Override
    public boolean offer(Object t) {
        if (list.size() >= capacity) {
            return false;
        }
        list.addLast((T) t);
        return true;
    }

    @Override
    public T remove() {
        list.removeFirst();
        return null;
    }

    @Override
    public T poll() {
        return list.removeFirst();
    }

    @Override
    public T element() {
        return list.getFirst();
    }

    @Override
    public T peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

}