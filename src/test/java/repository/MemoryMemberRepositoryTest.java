package repository;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.util.List;

public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();


    //c의 cls()의 기능과 비슷한 기능
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        //optional에서는 get으로 꺼낼 수 있다
        Member result = repository.findById(member.getID()).get();
//        System.out.println("result = "+(result==member));

        //Assertions.assertEquals(member,result);//위 sout과 같은 기능

        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //when
        Member result = repository.findByName("spring1").get();

        //then
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        //List<T> : 인덱스로 엑세스 할 수 있는 강력한 형식의 개체 목록을 나타내며 목록의 검색,정렬 및 조작에 사용할 수 있는 메서드를 제공한다.

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
