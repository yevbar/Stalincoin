package coin;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    Blockchain blockchain = new Blockchain(true);

    /*
    Block genesisBlock = new Block("Hi I'm the first block", "0");
    System.out.println("Hash for block 1: " + genesisBlock.hash);

    Block secondBlock = new Block("Yo I'm the second block", genesisBlock.hash);
    System.out.println("Hash for block 2: " + secondBlock.hash);

    Block thirdBlock = new Block("Yo I'm the third block", secondBlock.hash);
    System.out.println("Hash for block 3: " + thirdBlock.hash);
    */

    SpringApplication.run(Application.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      System.out.println("Let's inspect the beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName: beanNames) {
        System.out.println(beanName);
      }
    };
  }
}
