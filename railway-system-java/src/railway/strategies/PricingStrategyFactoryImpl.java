package railway.strategies;

public class PricingStrategyFactoryImpl implements PricingStrategyFactory {

    @Override
    public CapacityPricingEnum createStrategy(double capacity) {
        if (capacity >= 0.40) {
            return CapacityPricingEnum.CALCULATE_PRICE_AT_FORTY_PERCENT;
        } else if (capacity >= 0.35) {
            return CapacityPricingEnum.CALCULATE_PRICE_AT_THIRTY_FIVE_PERCENT;
        } else if (capacity >= 0.30) {
            return CapacityPricingEnum.CALCULATE_PRICE_AT_THIRTY_PERCENT;
        } else if (capacity >= 0.20) {
            return CapacityPricingEnum.CALCULATE_PRICE_AT_TWENTY_PERCENT;
        }
        return CapacityPricingEnum.DEFAULT_PRICE;
    }
}