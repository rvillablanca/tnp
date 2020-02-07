package cl.rvillablanca.tnp.controller.exceptions;

import cl.rvillablanca.tnp.service.exceptions.TPNException;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
public class RequiredData extends TPNException {

    public RequiredData(String message) {
        super(message);
    }

}
