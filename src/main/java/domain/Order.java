package domain;

import domain.rule.OrderPricingRule;
import domain.rule.SecondNormalTicketRule;
import domain.rule.SecondStudentTicketRule;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderNr;
    private boolean isStudentOrder;

    private List<MovieTicket> tickets;
    private List<OrderPricingRule> rules;

    public Order(int orderNr, boolean isStudentOrder) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;

        this.tickets = new ArrayList<>();
        this.rules = new ArrayList<>();

        rules.add(new SecondNormalTicketRule());
        rules.add(new SecondStudentTicketRule());
    }

    public int getOrderNr() {
        return orderNr;
    }

    public List<MovieTicket> getTickets() {
        return tickets;
    }

    public boolean isStudentOrder() {
        return isStudentOrder;
    }

    public void addSeatReservation(MovieTicket ticket) {
        tickets.add(ticket);
    }

    private void applyRules(Order order) {
        for (OrderPricingRule rule : rules) {
            rule.applyRule(order);
        }
    }

    public double calculatePrice() {
        applyRules(this);

        double price = 0.0;

        for (MovieTicket ticket : tickets) {
            price += ticket.getMovieScreening().getPricePerSeat();
        }

        return price;
    }

    public void export(TicketExportFormat exportFormat) {
        // Bases on the string respresentations of the tickets (toString), write
        // the ticket to a file with naming convention Order_<orderNr>.txt of
        // Order_<orderNr>.json
    }
}
