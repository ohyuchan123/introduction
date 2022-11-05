package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/*
* DataSource는 데이터베이스 커넥션을 획득할 떄 사용하는 객체다.
* 스프링 부트는 데이터베이스 커넥션 정보를 바탕으로 DataSource를 생성하고 스프링 빈을 만들어준다.
* 그래서 DI를 받을 수 있다.*/

@Configuration
//public class SpringConfig {
//    //스프링이 관리하는 dataSource가 database와 연결할 수 있는 db를 만들어줌
//    private DataSource dataSource;
//    private final EntityManager em;
//
//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.dataSource = dataSource;
//        this.em = em;
//    }
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//    @Bean
//    public MemberRepository memberRepository() {
//        // return new MemoryMemberRepository();
//        // return new JdbcMemberRepository(dataSource);
//        // return new JdbcTemplateMemberRepository(dataSource);
//        return (MemberRepository) new JpaMemberRepository(em);
//    }
//}
public class SpringConfig {
    private final MemberRepository memberRepository; public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}
