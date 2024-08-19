package test.jsonconverter.jpa;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import test.jsonconverter.Address;

@Slf4j
@RequiredArgsConstructor
@Converter(autoApply = true)
public class AddressConverter implements AttributeConverter<Address, String> {
    private final ObjectMapper objectMapper;

    @Override
    public String convertToDatabaseColumn(Address address) {
        try {
            return objectMapper.writeValueAsString(address);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Address convertToEntityAttribute(String source) {
        try {
            return objectMapper.readValue(source, Address.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
