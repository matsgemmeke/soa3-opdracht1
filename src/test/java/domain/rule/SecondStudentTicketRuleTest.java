package domain.rule;

import domain.Movie;
import domain.MovieScreening;
import domain.MovieTicket;
import domain.Order;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecondStudentTicketRuleTest {

    private Movie movie;

    @Before
    public void setUp() {
        this.movie = new Movie("Harry Potter");
    }

    @Test
    public void testDoNothingWithNormalTicket() {
        Order order = new Order(1, false);

        assertEquals(0.0, order.calculatePrice(), 0.01);
    }

    @Test
    public void testStudentSingleTicket() {
        MovieScreening movieScreening = new MovieScreening(movie, null, 10.0);
        Order order = new Order(1, true);

        order.addPricingRule(new SecondStudentTicketRule());
        order.addSeatReservation(new MovieTicket(movieScreening, false, 1, 1));

        assertEquals(10.0, order.calculatePrice(), 0.01);
    }

    @Test
    public void testStudentMultipleTickets() {
        MovieScreening movieScreeningOne = new MovieScreening(movie, null, 10.0);
        MovieScreening movieScreeningTwo = new MovieScreening(movie, null, 10.0);
        Order order = new Order(1, true);

        order.addPricingRule(new SecondStudentTicketRule());
        order.addSeatReservation(new MovieTicket(movieScreeningOne, false, 1, 1));
        order.addSeatReservation(new MovieTicket(movieScreeningTwo, false, 1, 2));

        assertEquals(10.0, order.calculatePrice(), 0.01);
    }
}
