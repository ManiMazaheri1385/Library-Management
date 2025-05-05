package datastructures.stacks;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

public class CustomStack<T> implements Queue<T> {
    private CustomLinkedList<T> list;
    private int capacity;

    public CustomStack(int capacity) {
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
        return list.removeLast();
    }

    @Override
    public T element() {
        return list.getLast();
    }

    @Override
    public T peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.getLast();
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