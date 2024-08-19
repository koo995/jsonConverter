package test.jsonconverter.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import test.jsonconverter.Address;

@Getter
@NoArgsConstructor
@ToString
@Table(name = "MEMBER")
@Entity
public class JpaMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @Convert(converter = AddressConverter.class)
    @Column(columnDefinition = "json")
    private Address address;

    public JpaMember(String username, Address address) {
        this.username = username;
        this.address = address;
    }
}