package model.promotion;

public class PromotionApplication {
    Promotion promotion;
    Product product;

    public PromotionApplication(Promotion promotion, Product product) {
        this.promotion = promotion;
        this.product = product;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public Product getProduct() {
        return product;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
