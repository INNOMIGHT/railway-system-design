package railway.strategies;

public enum CapacityPricingEnum {

    CALCULATE_PRICE_AT_FORTY_PERCENT(2000, 0.18),
    CALCULATE_PRICE_AT_THIRTY_FIVE_PERCENT(2000, 0.15),
    CALCULATE_PRICE_AT_THIRTY_PERCENT(2000, 0.12),
    CALCULATE_PRICE_AT_TWENTY_PERCENT(2000, 0.10),

    DEFAULT_PRICE(2000, 0);

    private final double basePrice;
    private final double percentIncrease;

    CapacityPricingEnum(double basePrice, double percentIncrease) {
        this.basePrice = basePrice;
        this.percentIncrease = percentIncrease;
    }

    public double calculatePrice(){
        double priceIncrease = basePrice * percentIncrease;
        return basePrice + priceIncrease;
    }


}
