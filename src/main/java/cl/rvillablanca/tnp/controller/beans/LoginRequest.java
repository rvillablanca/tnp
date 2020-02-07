package cl.rvillablanca.tnp.controller.beans;

import lombok.Data;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
@Data
public class LoginRequest {

    private String username;
    private String password;
}
