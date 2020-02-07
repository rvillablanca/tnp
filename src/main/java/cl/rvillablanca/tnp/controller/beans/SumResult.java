package cl.rvillablanca.tnp.controller.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
@Data()
@AllArgsConstructor
public class SumResult {

    private int result;

    public static SumResult with(int c) {
        return new SumResult(c);
    }
}
