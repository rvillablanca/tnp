package cl.rvillablanca.tnp.service;

import cl.rvillablanca.tnp.jpa.beans.User;
import cl.rvillablanca.tnp.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
@Service("tnpUserDetails")
public class TNPUserDetailServiceImpl implements TNPUserDetailService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("user %s not found", email));
        }

        return user;
    }

}
