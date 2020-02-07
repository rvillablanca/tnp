package cl.rvillablanca.tnp;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "cl.rvillablanca.tnp.jpa.repository")
@EntityScan(basePackages = {"cl.rvillablanca.tnp.jpa.beans"})
public class JPAConfig {

}
