package cl.rvillablanca.tnp.controller;

import cl.rvillablanca.tnp.controller.beans.SumResult;
import cl.rvillablanca.tnp.jpa.beans.HistoricalRegister;
import cl.rvillablanca.tnp.jpa.beans.User;
import cl.rvillablanca.tnp.jpa.repository.HistoricalRegisterRepository;
import cl.rvillablanca.tnp.jpa.repository.UserRepository;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HistoricalRegisterRepository registerRepository;

    @GetMapping("/sum/{a}/{b}")
    public SumResult sum(Principal principal, @PathVariable("a") int a, @PathVariable("b") int b) {
        createRegister(principal.getName(), a, b);
        return SumResult.with(a + b);
    }

    private void createRegister(String username, int a, int b) {
        User user = userRepository.findByEmail(username);
        HistoricalRegister hr = new HistoricalRegister();
        hr.setUser(user);
        hr.setFirstValue(a);
        hr.setSecondValue(b);
        registerRepository.save(hr);
    }
}
