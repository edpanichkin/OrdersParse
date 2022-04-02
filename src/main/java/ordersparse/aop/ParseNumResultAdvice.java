package ordersparse.aop;

import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Component
@org.aspectj.lang.annotation.Aspect
public class ParseNumResultAdvice {

  @After("execution(public void ordersparse.OrdersParse.printOrders())")
  public void resultSetter() {
    System.out.println("After PRINTING");
  }
}
