package cl.rvillablanca.tnp.controller.beans;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
@Data
@AllArgsConstructor
public class HistoryResponse {

    private String user;
    private List<String> history;
}
