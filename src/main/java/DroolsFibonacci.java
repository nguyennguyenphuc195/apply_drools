import drools.StatefulSessionServices;
import model.fibonacci.Fibonacci;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.DecisionTableInputType;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class DroolsFibonacci {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        lst.add("D:\\MWGSoftware\\MWGProject\\mwgdrools\\src\\main\\resources\\rules\\fibonacci\\fibonacciRule.drl");
        StatefulSessionServices service = new StatefulSessionServices(lst, new HashMap<>());

        KieSession kieSession = service.getKieSession();
        kieSession.insert(new Fibonacci(50));
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
