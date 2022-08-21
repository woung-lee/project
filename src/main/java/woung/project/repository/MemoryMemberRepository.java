package woung.project.repository;

import org.springframework.stereotype.Repository;
import woung.project.domain.Member;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements  MemberRepository{

    List<Member> memberList = new ArrayList<>();

    @Override
    public Member save(Member member) {
        memberList.add(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByPassword(String pwd) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {

        return memberList;
    }
}
