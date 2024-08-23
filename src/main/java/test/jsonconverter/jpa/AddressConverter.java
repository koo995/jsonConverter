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
            log.info("Address 타입을 Json 으로 변환할 수 없습니다.");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Address convertToEntityAttribute(String source) {
        try {
            return objectMapper.readValue(source, Address.class);
        } catch (Exception e) {
            log.info("json 타입을 Address 타입으로 변환할 수 없습니다.");
            throw new RuntimeException(e);
        }
    }
}
