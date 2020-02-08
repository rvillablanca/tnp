package cl.rvillablanca.tnp.controller;

import cl.rvillablanca.tnp.controller.beans.LoginRequest;
import cl.rvillablanca.tnp.controller.beans.SignInRequest;
import cl.rvillablanca.tnp.controller.exceptions.InvalidData;
import cl.rvillablanca.tnp.controller.exceptions.RequiredData;
import cl.rvillablanca.tnp.service.SignInService;
import cl.rvillablanca.tnp.service.exceptions.TPNException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
@RestController
@RequestMapping("/authentication")
public class AuthenticationController extends BaseExceptionHandler {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private SignInService signInService;

    @PostMapping("/signin")
    public void signin(@RequestBody SignInRequest req) throws TPNException {
        checkSignIn(req);
        signInService.createUser(req);
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest req) throws RequiredData {
        checkLogin(req);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
        Authentication authentication = authenticationProvider.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public void checkLogin(LoginRequest req) throws RequiredData {
        if (req == null) {
            throw require("login request is required to login");
        }

        if (StringUtils.isBlank(req.getUsername())) {
            throw require("username is required");
        }

        if (StringUtils.isBlank(req.getPassword())) {
            throw require("password is required");
        }
    }

    public void checkSignIn(SignInRequest req) throws RequiredData, InvalidData {
        if (req == null) {
            throw require("signin request is required");
        }

        if (StringUtils.isBlank(req.getUsername())) {
            throw require("username is required");
        }

        if (StringUtils.isBlank(req.getPassword())) {
            throw require("password is required");
        }

        if (StringUtils.isBlank(req.getName())) {
            throw require("name is required");
        }

        if (StringUtils.isBlank(req.getLastName())) {
            throw require("lastName is required");
        }

        boolean validEmail = EmailValidator.getInstance().isValid(req.getUsername());
        if (!validEmail) {
            throw invalid("invalid email (username)");
        }
    }
}
