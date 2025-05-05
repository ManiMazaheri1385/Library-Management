package datastructures.lists;
import datastructures.interfaces.LinkedList;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements LinkedList<T> {
    private Node<T> head, tail;
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    public CustomLinkedList() {
        head = new Node<T>(null);
    }

    @Override
    public void addFirst(T t) {
        Node<T> newNode = new Node<>(t);
        newNode.next = head;
        head.prev = newNode;
        size++;
    }

    @Override
    public void addLast(T t) {
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        Node<T> newNode = new Node<>(t);
        current.next = newNode;
        newNode.prev = current;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        T data = current.data;
        current = current.prev;
        current.next = null;
        size--;
        return data;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public void clear() {
        head.data = null;
        head.next = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = (T) element;
        return current.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(Object object) {
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        T data = (T) object;
        Node<T> newNode = new Node<>(data);
        current.next = newNode;
        newNode.prev = current;
        size++;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = head;
        while (current.next != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> current = head;
        while (current.next != null) {
            if (current.data.equals(o)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

}