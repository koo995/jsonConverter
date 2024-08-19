package test.jsonconverter.jdbc;

import org.springframework.data.repository.CrudRepository;

public interface JdbcMemberRepository extends CrudRepository<JdbcMember, Long> {
}
