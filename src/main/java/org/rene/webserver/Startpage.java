package org.rene.webserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

@SpringBootApplication
public class Startpage {

    public static void main(String[] args) {
        SpringApplication.run(Startpage.class, args);
    }
    private String fromFile(String filename) throws FileNotFoundException {
        return new Scanner(new File(filename)).useDelimiter("\\Z").next();
    }

    @RestController
    public class MyController {

        @GetMapping("/test")
        public String sayHello() throws FileNotFoundException {
            return fromFile("src/main/resources/static/startpage.html");
        }
    }
}
