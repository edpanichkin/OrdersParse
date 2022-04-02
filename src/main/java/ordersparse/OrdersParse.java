package ordersparse;

import com.google.gson.Gson;
import ordersparse.config.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component("ordersParse")
public class OrdersParse {
  //public String[] args;
  public static ArrayList<Order> orders = new ArrayList<>();
  private final static String COMMA_DELIMITER = ",";

  public OrdersParse() {
  }

  public void printOrders() {
    orders.forEach(o -> System.out.println(o.toString()));
  }

  public void analyzeArgs(String[] args) throws IOException {
    for (String s : args) {
      if (".csv".equals(s.substring(s.lastIndexOf(".")))) {
        csvParse(s);
      }
      if (".json".equals(s.substring(s.lastIndexOf(".")))) {
        jsonParse(s);
      }
      if (".xlsx".equals(s.substring(s.lastIndexOf(".")))) {
        xlsxParse(s);
      }
    }
  }

  private static void jsonParse(String fileName) throws IOException {
    int lineNum = 1;
    Gson gson = new Gson();
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    String line = reader.readLine();
    byte ptext[] = line.getBytes(StandardCharsets.ISO_8859_1);
    System.out.println(ptext);
    String value = new String(ptext, StandardCharsets.UTF_8);

    System.out.println(value);
    while (line != null) {
      Order order = gson.fromJson(line, Order.class);
      order.setFilename(fileName);
      order.setLine(lineNum++);
      orders.add(order);
      line = reader.readLine();
    }
    reader.close();
  }

  private static void csvParse(String fileName) throws IOException {
    int lineNum = 1;
    List<String> result = Files.readAllLines(Paths.get(fileName));
    System.out.println(result);
    for (String line : result) {
      String[] str = line.split(COMMA_DELIMITER);
      Order order = new Order(Integer.parseInt(str[0]),
              Float.parseFloat(str[1]),
              str[2],
              str[3]);
      order.setFilename(fileName);
      order.setLine(lineNum++);
      orders.add(order);
    }
  }

  private static void xlsxParse(String fileName) throws IOException {
  }
}
