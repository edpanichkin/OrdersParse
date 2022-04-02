package ordersparse.config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")

public class Order {
  public int orderId;
  public float amount;
  public String currency;
  public String comment;

  public String filename;
  public int line;
  public String result;


  public Order(int orderId, float amount, String currency, String comment) {
    this.orderId = orderId;
    this.amount = amount;
    this.currency = currency;
    this.comment = comment;
  }

  public Order() {

  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public void setLine(int line) {
    this.line = line;
  }

  public void setResult(String result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return "{" +
            "orderId:" + orderId +
            ", amount=" + amount +
            ", currency='" + currency + '\'' +
            ", comment='" + comment + '\'' +
            ", filename='" + filename + '\'' +
            ", line=" + line +
            ", result='" + result + '\'' +
            '}';
  }
}
