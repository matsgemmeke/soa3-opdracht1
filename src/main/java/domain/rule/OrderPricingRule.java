package domain.rule;

import domain.Order;

public interface OrderPricingRule {

    /**
     * Applies a pricing rule to an order.
     *
     * @param order The order to apply the rule to.
     * @return The order with the rule applied.
     */
    Order applyRule(Order order);
}
