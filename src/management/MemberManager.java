package management;

import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

public class MemberManager {
    private CustomHashMap<String, Member> members;

    public MemberManager() {
        members = new CustomHashMap<>();
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId) {
        return members.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        getMember(memberId).addTransaction(transaction);
    }

    public Transaction getLastTransaction(String memberId) {
        return members.get(memberId).getLastTransaction();
    }

    public CustomHashMap<String, Member> getMembers() {
        return members;
    }

    public void setMembers(CustomHashMap<String, Member> members) {
        this.members = members;
    }

}
