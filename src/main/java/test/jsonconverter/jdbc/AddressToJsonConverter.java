package test.jsonconverter.jdbc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import test.jsonconverter.Address;

@Slf4j
@RequiredArgsConstructor
@WritingConverter
public class AddressToJsonConverter implements Converter<Address, String> {

    private final ObjectMapper objectMapper;

    @Override
    public String convert(Address address) {
        try {
            return objectMapper.writeValueAsString(address);
        } catch (JsonProcessingException e) {
            log.info("Address 객체를 JSON 타입으로 변경에 실패했습니다.");
            return null;
        }
    }
}