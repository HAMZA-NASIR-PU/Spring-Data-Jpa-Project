import org.slf4j.LoggerFactory;

public class App {


    public static void main(String[] args) throws Exception {
        System.setProperty("logging.level.ROOT", "debug");
        SQL sql = new SQL(null, "mydb", "mytable");
        System.out.println("Hello, World!");
    }
}
