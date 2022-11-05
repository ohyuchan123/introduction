package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member) throws SQLException;
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll(); //지금까지 저장된 모든 리스트를 반환해주는 부분

    void clearStore();
}
