package management;

import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

public class BookManager {

    private MemberManager memberManager;
    private CustomHashMap<String, Book> books;

    public BookManager(MemberManager memberManager) {
        this.memberManager = memberManager;
        books = new CustomHashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        return books.get(isbn).isAvailable();
    }

    public void setBookAvailability(String isbn, boolean available) {
        getBookByIsbn(isbn).setAvailable(available);
    }

    public void addToWaitlist(String isbn, String memberId) {
        getBookByIsbn(isbn).addToWaitlist(memberManager.getMember(memberId));
    }

    public Member getNextFromWaitlist(String isbn) {
        return getBookByIsbn(isbn).getNextInWaitlist();
    }

    public boolean hasWaitlist(String isbn) {
        return getBookByIsbn(isbn).hasWaitlist();
    }

    public MemberManager getMemberManager() {
        return memberManager;
    }

    public void setMemberManager(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    public CustomHashMap<String, Book> getBooks() {
        return books;
    }

    public void setBooks(CustomHashMap<String, Book> books) {
        this.books = books;
    }

}