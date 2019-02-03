package domain.rule;

import domain.Movie;
import domain.MovieScreening;
import domain.MovieTicket;
import domain.Order;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PremiumTicketRuleTest {

    private Movie movie;
    private MovieScreening movieScreening;

    @Before
    public void setUp() {
        this.movie = new Movie("Harry Potter");
        this.movieScreening = new MovieScreening(movie, null, 10.0);
    }

    @Test
    public void testEmptyTicketList() {
        Order order = new Order(1, false);

        order.addPricingRule(new PremiumTicketRule());

        assertEquals(0.0, order.calculatePrice(), 0.01);
    }

    @Test
    public void testNoPremiumTickets() {
        Order order = new Order(1, false);

        order.addPricingRule(new PremiumTicketRule());
        order.addSeatReservation(new MovieTicket(movieScreening, false, 1, 1));

        assertEquals(10.0, order.calculatePrice(), 0.01);
    }

    @Test
    public void testPremiumTicketStudent() {
        Order order = new Order(1, true);

        order.addPricingRule(new PremiumTicketRule());
        order.addSeatReservation(new MovieTicket(movieScreening, true, 1, 1));

        assertEquals(12.0, order.calculatePrice(), 0.01);
    }

    @Test
    public void testPremiumTicketNoStudent() {
        Order order = new Order(1, false);

        order.addPricingRule(new PremiumTicketRule());
        order.addSeatReservation(new MovieTicket(movieScreening, true, 1, 1));

        assertEquals(13.0, order.calculatePrice(), 0.01);
    }
}
