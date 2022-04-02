package ordersparse;

import ordersparse.OrdersParse;
import ordersparse.config.Config;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class OrdersParseApplication {

  public static void main(String[] args) throws IOException {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
    String[] files = new String[2];
    files[0] = "src/main/resources/orders1.csv";
    files[1] = "src/main/resources/orders2.json";
    OrdersParse ordersParse = ctx.getBean("ordersParse", OrdersParse.class);
    ordersParse.analyzeArgs(files);
    ordersParse.printOrders();
  }

}
