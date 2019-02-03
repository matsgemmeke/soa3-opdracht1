package domain.rule;

import domain.MovieScreening;
import domain.MovieTicket;
import domain.Order;

public class WeekendTicketRule implements OrderPricingRule {

    public Order applyRule(Order order) {
        if (!order.isStudentOrder()) {
            for (MovieTicket ticket : order.getTickets()) {
                MovieScreening movieScreening = ticket.getMovieScreening();
                if (movieScreening.getDateAndTime().getDayOfWeek().getValue() >= 5 && order.getTickets().size() >= 6) {
                    ticket.setPrice(ticket.getPrice() * 0.9);
                }
            }
        }
        return order;
    }
}
