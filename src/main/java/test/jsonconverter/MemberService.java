package test.jsonconverter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.jsonconverter.jdbc.JdbcMemberRepository;
import test.jsonconverter.jdbc.JdbcMember;
import test.jsonconverter.jpa.JpaMember;
import test.jsonconverter.jpa.JpaMemberRepository;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final JpaMemberRepository jpaMemberRepository;
    private final JdbcMemberRepository jdbcMemberRepository;

    public JpaMember JpaFindById(Long id) {
        return jpaMemberRepository.findById(id).orElseThrow();
    }

    public JpaMember JpaSave(JpaMember jpaMember) {
        return jpaMemberRepository.save(jpaMember);
    }

    public JdbcMember JdbcSave(JdbcMember jdbcMember) {
        return jdbcMemberRepository.save(jdbcMember);
    }

    public JdbcMember JdbcFindById(Long id) {
        return jdbcMemberRepository.findById(id).orElseThrow();
    }
}
