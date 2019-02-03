package domain.rule;

import domain.Order;

public class SecondStudentTicketRule implements OrderPricingRule {

    public Order applyRule(Order order) {
        if (order.isStudentOrder() && order.getTickets().size() > 1) {
            order.getTickets().get(1).setPrice(0.0);
        }
        return order;
    }
}
