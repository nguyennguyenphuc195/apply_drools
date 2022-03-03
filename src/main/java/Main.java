import drools.StatefulSessionServices;
import model.promotion.Product;
import model.promotion.Promotion;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final String RULES_PATH1 = "D:\\MWGSoftware\\MWGProject\\mwgdrools\\src\\main\\resources\\rules\\a.drl";
    private static final String RULES_PATH2 = "D:\\MWGSoftware\\MWGProject\\mwgdrools\\src\\main\\resources\\rules\\b.drl";
    private static final String RULES_PATH3 = "D:\\MWGSoftware\\MWGProject\\mwgdrools\\src\\main\\resources\\rules\\busPass.drl";
    private static final String RULES_PATH4 = "D:\\MWGSoftware\\MWGProject\\mwgdrools\\src\\main\\resources\\rules\\promotion.drl";
    private static final String RULES_PATH5 = "D:\\MWGSoftware\\MWGProject\\mwgdrools\\src\\main\\resources\\rules\\promotionQuery.drl";

    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        lst.add(RULES_PATH4);
        lst.add(RULES_PATH5);
//        DroolsService<DataModel> service = new DroolsService<>(lst);
//
//        DataModel model = new DataModel(10);
//        System.out.println(model);
//        service.execute(model);
//        System.out.println(model);
//
//        List<DataModel> inputs = List.of(new DataModel(1), new DataModel(2), new DataModel(3));
//        service.batchExecute(inputs);
//        for (DataModel i : inputs) {
//            System.out.println(i);
//        }

//        Applicant applicant = new Applicant("Mr John Smith", 21);
//        Application application = new Application();
//
//        StatelessSessionServices<Object> service = new StatelessSessionServices<>(lst);
//
//        service.setGlobalVariable("threshold", 22);
//        application.setValid(true);
//        System.out.println(application.isValid());
//        service.batchExecute(Arrays.asList(applicant, application));
//        System.out.println(application.isValid());
//
//        application.setValid(true);
//        applicant = new Applicant("Mr John Smith", 23);
//        System.out.println(application.isValid());
//        service.batchExecute(Arrays.asList(applicant, application));
//        System.out.println(application.isValid());
        /*
        StatefulSessionServices services = new StatefulSessionServices(lst);
        KieSession session = services.getKieSession();

        Policy policy = new Policy(20);
        Person p1 = new Person("John", 21);
        Person p2 = new Person("Mike", 19);
        FactHandle fhp = session.insert(policy);
        FactHandle fh1 = session.insert(p1);
        FactHandle fh2 = session.insert(p2);

        session.fireAllRules();

        policy.setAge(18);
        session.update(fhp, policy);

        session.dispose();
        */
        StatefulSessionServices services = new StatefulSessionServices(lst, new HashMap<>());
        KieSession session = services.getKieSession();
        session.fireAllRules();

        Product p1 = new Product(1, "a", 100000);
        Product p2 = new Product(2, "b", 200000);
        Product p3 = new Product(3, "c", 150000);

        Promotion pr = new Promotion(1, new int[]{1, 3}, "Tet", 0.1);
        Promotion pr1 = new Promotion(2, new int[]{1}, "Tet", 0.1);

        session.insert(p1);
        session.insert(p2);
        session.insert(p3);

        printAllProduct(session);

        FactHandle prFh = session.insert(pr);
        session.fireAllRules();


        session.delete(prFh);
        session.fireAllRules();
        session.dispose();
    }

    public static void printAllProduct(KieSession session) {
        QueryResults results = session.getQueryResults("list_all_voucher_with_revenue");
        for ( QueryResultsRow row : results ) {
            Product product = ( Product ) row.get( "$m" );
            System.out.println(product);
        }
    }
}
