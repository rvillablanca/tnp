package cl.rvillablanca.tnp.service.security;

import cl.rvillablanca.tnp.service.TNPUserDetailService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo Villablanca
 */
@Service
public class TNPAuthenticationProvider extends DaoAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private TNPUserDetailService userDetails;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        setUserDetailsService(userDetails);
        setPasswordEncoder(passwordEncoder);
    }

}
