package cl.rvillablanca.tnp.service.exceptions;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
public class UserAlreadyExists extends TPNException {

    public UserAlreadyExists() {
        super("user already exists");
    }

}
