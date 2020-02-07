package cl.rvillablanca.tnp.controller.exceptions;

import cl.rvillablanca.tnp.service.exceptions.TPNException;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
public class InvalidData extends TPNException {

    public InvalidData(String message) {
        super(message);
    }

}
