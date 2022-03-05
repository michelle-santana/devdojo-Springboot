package academy.devdojo.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class ApplicationStarter {

    public static void main(String [] args){
        SpringApplication.run(ApplicationStarter.class, args);
    }

}
