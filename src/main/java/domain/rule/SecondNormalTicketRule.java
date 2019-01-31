package domain.rule;

import domain.MovieScreening;
import domain.MovieTicket;
import domain.Order;

public class SecondNormalTicketRule implements OrderPricingRule {

    public Order applyRule(Order order) {
        if (!order.isStudentOrder()) {
            for (MovieTicket ticket : order.getTickets()) {
                MovieScreening movieScreening = ticket.getMovieScreening();

                if (movieScreening.getDateAndTime().getDayOfWeek().getValue() <= 3) {
                    movieScreening.setPricePerSeat(0.0);
                }
            }
        }
        return order;
    }
}
