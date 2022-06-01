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

        // Code to create a new context for (container )

        ConfigurableApplicationContext newContext = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // getting number-generator bean

        NumberGenerator numberGenerator = newContext.getBean("numberGeneratorId",NumberGenerator.class);

        // getting game bean

        Game game = newContext.getBean("gameId",Game.class);

        game.reset();

        newContext.close();

    }

}
