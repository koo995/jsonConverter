package test.jsonconverter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import test.jsonconverter.jdbc.JdbcMember;
import test.jsonconverter.jpa.JpaMember;
import test.jsonconverter.jpa.JpaMemberRepository;

@SpringBootTest
class JpaMemberServiceTest {
    @Autowired
    private MemberService memberService;
    @Autowired
    private JpaMemberRepository jpaMemberRepository;


    @DisplayName("jpa 유저 조회")
    @Test
    void findByJPA() throws Exception {
        JpaMember jpaMember1 = memberService.JpaFindById(1l);
        System.out.println("member1 = " + jpaMember1);
    }

    @DisplayName("jpa 유저 저장")
    @Test
    void JpaSave() throws Exception {
        // given
        JpaMember jpaMember = new JpaMember("John", new Address("1234", "Main", "St", "12345"));

        // when
        Long id = memberService.JpaSave(jpaMember).getId();

        // then
        JpaMember jpaMember1 = jpaMemberRepository.findById(id).get();
        System.out.println("member1 = " + jpaMember1);
    }

    @DisplayName("jdbc 유저 조회")
    @Test
    void findByJdbc() throws Exception {
        JdbcMember jdbcMember = memberService.JdbcFindById(1l);
        System.out.println("users = " + jdbcMember);
    }

    @DisplayName("Jdbc 유저 저장")
    @Test
    void jdbcSave() throws Exception {
        // given
        JdbcMember jdbcMember = new JdbcMember("John2", new Address("1234", "Main", "St", "12345"));

        // when
        Long id = memberService.JdbcSave(jdbcMember).getId();

        // then
        JdbcMember jdbcMember1 = memberService.JdbcFindById(id);
        System.out.println("users = " + jdbcMember1);
    }



}