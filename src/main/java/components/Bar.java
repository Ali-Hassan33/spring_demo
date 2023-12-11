package components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Bar {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // by adding @Transactional(propagation = Propagation.REQUIRED) I faced "UnexpectedRollbackException" but why even
    // I caught this exception in method a(). Why this transaction is rolledBack and I face this exception.
    @Transactional(propagation = Propagation.REQUIRED)
    public void b(String name) {
        jdbcTemplate.update("INSERT INTO product(name) VALUES(?)", name);
        throw new RuntimeException();
    }
}
