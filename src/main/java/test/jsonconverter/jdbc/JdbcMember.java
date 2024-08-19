package test.jsonconverter.jdbc;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import test.jsonconverter.Address;

@Getter
@ToString
@Table("MEMBER")
public class JdbcMember {
    @Id
    @Column("MEMBER_ID")
    private Long id;

    @Column("USERNAME")
    private String username;

    private Address address;

    public JdbcMember(String username, Address address) {
        this.username = username;
        this.address = address;
    }
}
