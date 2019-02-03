package domain.rule;

import domain.MovieTicket;
import domain.Order;

public class PremiumTicketRule implements OrderPricingRule {

    public Order applyRule(Order order) {
        for (MovieTicket ticket : order.getTickets()) {
            if (ticket.isPremiumTicket()) {
                ticket.setPrice(ticket.getPrice() + (order.isStudentOrder() ? 2 : 3)); // Voeg 2 toe aan studententickets en 3 aan normale tickets
            }
        }
        return order;
    }
}
