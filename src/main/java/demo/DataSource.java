package demo;

import java.util.List;
import java.util.Map;

public class DataSource {
    private List<Map<Object, Object>> stores;
    private List<Map<Object, Object>> products;

    public DataSource(List<Map<Object, Object>> stores, List<Map<Object, Object>> products) {
        this.stores = stores;
        this.products = products;
    }

    public List<Map<Object, Object>> getStores() {
        return stores;
    }

    public List<Map<Object, Object>> getProducts() {
        return products;
    }

    public void setStores(List<Map<Object, Object>> stores) {
        this.stores = stores;
    }

    public void setProducts(List<Map<Object, Object>> products) {
        this.products = products;
    }
}
