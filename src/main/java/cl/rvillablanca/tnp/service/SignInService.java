package cl.rvillablanca.tnp.service;

import cl.rvillablanca.tnp.controller.beans.SignInRequest;
import cl.rvillablanca.tnp.service.exceptions.UserAlreadyExists;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
public interface SignInService {

    void createUser(SignInRequest req) throws UserAlreadyExists;
}
