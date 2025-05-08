package library;

import datastructures.stacks.CustomStack;

public class Member {
    private String memberId;
    private String name;
    private CustomStack<Transaction> transactions;

    public Member(String memberId, String name) {
        setMemberId(memberId);
        setName(name);
        transactions = new CustomStack<>(200);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Transaction getLastTransaction() {
        return transactions.peek();
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        if (memberId == null || memberId.isEmpty()) {
            throw new IllegalArgumentException("Member ID cannot be null or empty");
        }
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public CustomStack<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(CustomStack<Transaction> transactions) {
        this.transactions = transactions;
    }

}
