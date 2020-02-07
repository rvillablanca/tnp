package cl.rvillablanca.tnp.controller.beans;

import lombok.Data;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
@Data
public class SignInRequest {

    private String username;
    private String password;
    private String name;
    private String lastName;
}
