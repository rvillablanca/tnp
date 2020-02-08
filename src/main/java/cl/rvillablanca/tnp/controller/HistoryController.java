package cl.rvillablanca.tnp.controller;

import cl.rvillablanca.tnp.controller.beans.HistoryResponse;
import cl.rvillablanca.tnp.jpa.beans.HistoricalRegister;
import cl.rvillablanca.tnp.jpa.beans.User;
import cl.rvillablanca.tnp.jpa.repository.HistoricalRegisterRepository;
import cl.rvillablanca.tnp.jpa.repository.UserRepository;
import io.swagger.annotations.ApiParam;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
@RestController
public class HistoryController {

    @Autowired
    HistoricalRegisterRepository registerRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/history")
    public HistoryResponse findHistory(@ApiParam(hidden = true) Principal principal) {
        String username = principal.getName();
        List<String> history = new ArrayList<>();
        User user = userRepository.findByEmail(username);
        List<HistoricalRegister> registers = registerRepository.findByUser(user);
        for (HistoricalRegister hr : registers) {
            history.add(String.format("%d + %d = %d", hr.getFirstValue(), hr.getSecondValue(), hr.getFirstValue() + hr.getSecondValue()));
        }
        return new HistoryResponse(String.format("Historial de %s %s", user.getName(), user.getLastName()), history);
    }
}
