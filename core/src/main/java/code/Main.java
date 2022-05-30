package code;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION= "beans.xml";

    public static void main(String[] args) {
        logger.info("Lets start the game");

        // Code to create a new context (container )

        ConfigurableApplicationContext newContext = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        NumberGenerator numberGenerator = newContext.getBean("numberGeneratorId",NumberGenerator.class);

        int generatedNumber = numberGenerator.next();
        System.out.println("generated number = "+generatedNumber);

        newContext.close();

    }

}
