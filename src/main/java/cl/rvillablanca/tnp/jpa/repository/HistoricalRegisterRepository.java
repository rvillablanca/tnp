package cl.rvillablanca.tnp.jpa.repository;

import cl.rvillablanca.tnp.jpa.beans.HistoricalRegister;
import cl.rvillablanca.tnp.jpa.beans.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
public interface HistoricalRegisterRepository extends JpaRepository<HistoricalRegister, Long> {

    @Query("select hr from HistoricalRegister hr where hr.user = ?1")
    public List<HistoricalRegister> findByUser(User user);
}
