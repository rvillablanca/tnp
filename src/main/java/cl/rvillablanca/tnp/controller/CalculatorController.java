package cl.rvillablanca.tnp.controller;

import cl.rvillablanca.tnp.controller.beans.SumResult;
import cl.rvillablanca.tnp.controller.exceptions.InvalidData;
import cl.rvillablanca.tnp.jpa.beans.HistoricalRegister;
import cl.rvillablanca.tnp.jpa.beans.User;
import cl.rvillablanca.tnp.jpa.repository.HistoricalRegisterRepository;
import cl.rvillablanca.tnp.jpa.repository.UserRepository;
import java.security.Principal;
import org.apache.commons.lang3.StringUtils;
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
public class CalculatorController extends BaseExceptionHandler {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HistoricalRegisterRepository registerRepository;

    @GetMapping("/sum/{a}/{b}")
    public SumResult sum(Principal principal, @PathVariable("a") String a, @PathVariable("b") String b) throws InvalidData {
        int first = parseValue(a);
        int second = parseValue(b);
        createRegister(principal.getName(), first, second);
        return SumResult.with(first + second);
    }

    private int parseValue(String val) throws InvalidData {
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException ex) {
            throw new InvalidData(String.format("invalid integer value %s", val));
        }
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
