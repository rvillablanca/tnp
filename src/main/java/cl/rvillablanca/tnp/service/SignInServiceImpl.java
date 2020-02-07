package cl.rvillablanca.tnp.service;

import cl.rvillablanca.tnp.controller.beans.SignInRequest;
import cl.rvillablanca.tnp.jpa.beans.User;
import cl.rvillablanca.tnp.jpa.repository.UserRepository;
import cl.rvillablanca.tnp.service.exceptions.UserAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createUser(SignInRequest req) throws UserAlreadyExists {
        User user = userRepository.findByEmail(req.getUsername());
        if (user != null) {
            throw new UserAlreadyExists();
        }

        user = new User();
        user.setEmail(req.getUsername());

        String encodedPassword = passwordEncoder.encode(req.getPassword());
        user.setPassword(encodedPassword);

        user.setName(req.getName());
        user.setLastName(req.getLastName());

        userRepository.save(user);
    }

}
