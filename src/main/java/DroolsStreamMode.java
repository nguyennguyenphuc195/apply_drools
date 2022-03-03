import drools.StatefulSessionServices;
import model.promotion.Product;
import model.stream.Event;
import model.stream.Promotion;
import model.stream.VoiceCall;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import javax.management.timer.Timer;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class DroolsStreamMode {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        lst.add("D:\\MWGSoftware\\MWGProject\\mwgdrools\\src\\main\\resources\\rules\\streamdemo.drl");

        HashMap<String, String> properties = new HashMap<>();
        properties.put("drools.eventProcessingMode", "stream");

        StatefulSessionServices services = new StatefulSessionServices(lst, properties);
        KieSession session = services.getKieSession();

        Promotion pr = new Promotion("A", 0, 10000, 0.1);
        session.insert(pr);
        session.insert(new Event("a", 1, 100));
        session.insert(new Event("b",700, 200));
        session.insert(new Event("c", 1002, 300));
        session.insert(new Event("d", 10002, 400));
        session.fireAllRules();
        System.out.println("Only promotion A");
        printAllEvents(session);

        pr = new Promotion("B", 900, 10000, 0.2);
        session.insert(pr);
        session.fireAllRules();
        System.out.println("Only promotion A & B");
        printAllEvents(session);

        pr = new Promotion("C", 1000, 5, 0.2);
        FactHandle fh = session.insert(pr);
        session.fireAllRules();
        System.out.println("Only promotion A, B & C");
        printAllEvents(session);

        session.delete(fh);
        session.fireAllRules();
        System.out.println("Only promotion A, B");
        printAllEvents(session);

        session.dispose();
    }

    public static void printAllEvents(KieSession session) {
        QueryResults results = session.getQueryResults("get_all_events");
        for ( QueryResultsRow row : results ) {
            Event event = ( Event ) row.get( "$event" );
            System.out.println(String.format("%s : %f -> %f", event.getName(), event.getPrice(), event.getSalePrice()));
        }
        System.out.println("************");
    }
}
