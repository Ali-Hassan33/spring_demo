package components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Foo {

    @Autowired
    private Bar bar;

    @Transactional(propagation = Propagation.REQUIRED)
    public void a(String name) {
        try {
            bar.b(name);
        } catch (RuntimeException e) {
            System.out.println("exception being caught");
        }
    }
}
