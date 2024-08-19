package test.jsonconverter.jdbc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import test.jsonconverter.Address;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@ReadingConverter
public class JsonToAddressConverter implements Converter<String, Address> {

    private final ObjectMapper objectMapper;

    @Override
    public Address convert(String source) {
        try {
            return objectMapper.readValue(source, Address.class);
        } catch (IOException e) {
            log.info("JSON 타입을 Address 객체로 변경에 실패했습니다.");
            return null;
        }
    }
}