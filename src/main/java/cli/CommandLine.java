package cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CommandLine {
    public int run() throws IOException {
        System.out.println("Choose :");
        System.out.println("1. add voucher");
        System.out.println("2, add promotion");
        System.out.println("3, query voucher");
        System.out.println("0, exit");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        str = br.readLine();

        return Integer.parseInt(str);
    }

    public HashMap<String, Object> addVoucher() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        HashMap<String, Object> m = new HashMap<>();
        System.out.print("Id=");
        str = br.readLine();
        m.put("voucherId", Integer.parseInt(str));

        System.out.print("Product Id=");
        str = br.readLine();

        m.put("productId", Integer.parseInt(str));
        System.out.print("store Id=");
        str = br.readLine();
        m.put("storeId", Integer.parseInt(str));

        System.out.print("price=");
        str = br.readLine();
        m.put("price", Float.parseFloat(str));

        System.out.print("vat=");
        str = br.readLine();
        m.put("vat", Float.parseFloat(str));

        System.out.print("type=");
        str = br.readLine();
        m.put("type", Integer.parseInt(str));

        System.out.print("timestamp=");
        str = br.readLine();
        m.put("timestamp", Long.parseLong(str));

        return m;
    }

    public HashMap<String, Object> addPromo() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        HashMap<String, Object> m = new HashMap<>();
        System.out.print("promotionName=");
        str = br.readLine();
        m.put("promotionName", str);


        System.out.print("timestamp=");
        str = br.readLine();
        m.put("timestamp", Long.parseLong(str));

        System.out.print("duration=");
        str = br.readLine();
        m.put("duration", Long.parseLong(str));

        System.out.print("percent=");
        str = br.readLine();
        m.put("percent", Float.parseFloat(str));
        return m;
    }
}
