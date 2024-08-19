package test.jsonconverter.jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.Arrays;

@Configuration
public class JdbcConfig extends AbstractJdbcConfiguration {

    @Bean
    public JdbcCustomConversions jdbcCustomConversions(ObjectMapper objectMapper) {
        return new JdbcCustomConversions(Arrays.asList(
                new AddressToJsonConverter(objectMapper),
                new JsonToAddressConverter(objectMapper)
        ));
    }
}
