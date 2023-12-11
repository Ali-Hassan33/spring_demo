package main;

import components.Foo;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (var applicationContext = new AnnotationConfigApplicationContext(new Class<?>[]{AppConfig.class})) {
            Foo foo = applicationContext.getBean(Foo.class);
            foo.a("Smith");
        }
    }
}
