package cl.rvillablanca.tnp.service.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
public class TPNAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        response.setStatus(HttpStatus.FORBIDDEN.value());
        mapper.writeValue(response.getOutputStream(), new ForbiddenResponse("forbidden access, please login first"));
        response.getOutputStream().flush();
    }

    @Data
    @AllArgsConstructor
    class ForbiddenResponse {

        private String description;
    }
}
