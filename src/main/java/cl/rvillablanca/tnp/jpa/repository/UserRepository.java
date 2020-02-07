package cl.rvillablanca.tnp.jpa.repository;

import cl.rvillablanca.tnp.jpa.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * Rodrigo Villablanca <villa061004@gmail.com>
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.email = ?1 and u.enabled = true")
    User findByEmail(String email);

}
