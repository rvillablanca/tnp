package cl.rvillablanca.tnp.jpa.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
@Entity
@Table(name = "historial")
public class HistoricalRegister extends BaseEntity {

    public User user;
    public Integer firstValue;
    public Integer secondValue;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "primer_valor")
    public Integer getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(Integer firstValue) {
        this.firstValue = firstValue;
    }

    @Column(name = "segundo_valor")
    public Integer getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(Integer secondValue) {
        this.secondValue = secondValue;
    }

}
