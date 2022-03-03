import cli.CommandLine;
import demo.DataSource;
import drools.StatefulSessionServices;
import model.promotion.Product;
import org.drools.core.factmodel.Fact;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.EntryPoint;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
    public static void main(String[] args) throws IOException {
        List<String> lst = new ArrayList<>();
        lst.add("/home/nguyennp/IdeaProjects/apply_drools/apply_drools/src/main/resources/rules/demo/voucher.drl");
        lst.add("/home/nguyennp/IdeaProjects/apply_drools/apply_drools/src/main/resources/rules/demo/promotion.drl");
        lst.add("/home/nguyennp/IdeaProjects/apply_drools/apply_drools/src/main/resources/rules/demo/query.drl");

        HashMap<String, String> properties = new HashMap<>();
        properties.put("drools.eventProcessingMode", "stream");

        StatefulSessionServices service = new StatefulSessionServices(lst, properties);

        List<Map<Object, Object>> stores = prepareStores();
        List<Map<Object, Object>> prods = prepareProducts();
        DataSource ds = new DataSource(stores, prods);

        KieSession session = service.getKieSession();
        session.insert(ds);

        /*
        int[] id = {1, 2, 3, 4};
        int[] productId = {1, 2, 3, 4};
        int[] storeId = {3, 2, 1, 2};
        float[] price = {1000, 500, 200, 100};
        float[] vat = {10, 10, 10, 5};
        int[] type = {0, 1, 0, 0};
        long[] timestamp = {20, 50, 70, 40};

        EntryPoint voucherEntry = session.getEntryPoint("Voucher");
        for (int i = 0; i < productId.length; i++) {
            HashMap<String, Object> m = new HashMap<>();
            m.put("voucherId", id[i]);
            m.put("productId", productId[i]);
            m.put("storeId", storeId[i]);
            m.put("price", price[i]);
            m.put("vat", vat[i]);
            m.put("type", type[i]);
            m.put("timestamp", timestamp[i]);

            voucherEntry.insert(m);
        }
        session.fireAllRules();

        System.out.println("Before add promotion");
        QueryResults results = session.getQueryResults("list_all_voucher_with_revenue");
        for ( QueryResultsRow row : results ) {
            Map<String, Object> m = (Map<String, Object>) row.get( "$m" );
            System.out.println(m.get("voucherId") + " - " + m.get("revenue") + " - " + m.get("storeName") + " - " + m.get("productName"));
        }

        //Add promotion
        HashMap<String, Object> prom = new HashMap<>();
        prom.put("promotionName", "promotion 1");
        prom.put("timestamp", 0L);
        prom.put("duration", 65L);
        prom.put("percent", 0.1F);
        EntryPoint promEntry = session.getEntryPoint("Promotion");
        promEntry.insert(prom);

        session.fireAllRules();

        System.out.println("After add promotion");
        results = session.getQueryResults("list_all_voucher_with_revenue");
        for ( QueryResultsRow row : results ) {
            Map<String, Object> m = (Map<String, Object>) row.get( "$m" );
            System.out.println(m.get("voucherId") + " - " + m.get("revenue") + " - " + m.get("storeName") + " - " + m.get("productName"));
        }

        promEntry.delete(promEntry.getFactHandle(prom));
        session.fireAllRules();
        System.out.println("After remove promotion again");
        results = session.getQueryResults("list_all_voucher_with_revenue");
        for ( QueryResultsRow row : results ) {
            Map<String, Object> m = (Map<String, Object>) row.get( "$m" );
            System.out.println(m.get("voucherId") + " - " + m.get("revenue") + " - " + m.get("storeName") + " - " + m.get("productName"));
        }
        */
        EntryPoint voucherEntry = session.getEntryPoint("Voucher");
        EntryPoint promEntry = session.getEntryPoint("Promotion");
        CommandLine cmd = new CommandLine();
        int opt;
        Map<String, Object> m;
        do {
            opt = cmd.run();
            switch (opt) {
                case 1: {
                    m = cmd.addVoucher();
                    voucherEntry.insert(m);
                    session.fireAllRules();
                    break;
                }
                case 2: {
                    m = cmd.addPromo();
                    promEntry.insert(m);
                    session.fireAllRules();
                    break;
                }
                case 3: {
                    QueryResults results = session.getQueryResults("list_all_voucher_with_revenue");
                    for ( QueryResultsRow row : results ) {
                        m = (Map<String, Object>) row.get( "$m" );
                        String o = String.format("id=%s\nrevenue=%s\nstore name=%s\nproduct name=%s",
                                m.get("voucherId"), m.get("revenue"), m.get("storeName"), m.get("productName"));
                        System.out.println(o);
                    }
                    break;
                }
            }
        } while (opt != 0);
        session.dispose();
    }

    static List<Map<Object, Object>> prepareStores() {
        Map<Object, Object> s1 = new HashMap<>();
        Map<Object, Object> s2 = new HashMap<>();
        Map<Object, Object> s3 = new HashMap<>();

        s1.put("id", 1);
        s1.put("name", "Sieu thi 1");
        s2.put("id", 2);
        s2.put("name", "Sieu thi 2");
        s3.put("id", 3);
        s3.put("name", "Sieu thi 3");
        return List.of(s1, s2, s3);
    }

    static List<Map<Object, Object>> prepareProducts() {
        Map<Object, Object> p1 = new HashMap<>();
        Map<Object, Object> p2 = new HashMap<>();
        Map<Object, Object> p3 = new HashMap<>();

        p1.put("id", 1);
        p1.put("name", "San pham 1");
        p2.put("id", 2);
        p2.put("name", "San pham 2");
        p3.put("id", 3);
        p3.put("name", "San pham 3");
        return List.of(p1, p2, p3);
    }
}
