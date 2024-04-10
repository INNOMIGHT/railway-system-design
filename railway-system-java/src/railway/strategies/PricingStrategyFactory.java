package railway.strategies;

public interface PricingStrategyFactory {
    CapacityPricingEnum createStrategy(double capacity);
}
