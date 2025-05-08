package library;

import datastructures.queues.CustomQueue;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    private CustomQueue<Member> waitList;

    public Book(String title, String author, String isbn) {
        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
        this.isAvailable = true;
        waitList = new CustomQueue<>(200);
    }

    public void addToWaitlist(Member member) {
        waitList.add(member);
    }

    public Member getNextInWaitlist() {
        return waitList.poll();
    }

    public boolean hasWaitlist() {
        return !waitList.isEmpty();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", available=" + isAvailable +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty");
        }
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public CustomQueue<Member> getWaitList() {
        return waitList;
    }

    public void setWaitList(CustomQueue<Member> waitList) {
        this.waitList = waitList;
    }

}