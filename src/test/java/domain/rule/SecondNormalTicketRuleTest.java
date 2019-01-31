package domain.rule;

import domain.Movie;
import domain.MovieScreening;
import domain.MovieTicket;
import domain.Order;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class SecondNormalTicketRuleTest {

    private Movie movie;

    @Before
    public void setUp() {
        this.movie = new Movie("Harry Potter");
    }

    @Test
    public void testDoNothingWithStudentTicket() {
        MovieScreening movieScreening = new MovieScreening(movie, null, 10.0);
        Order order = new Order(1, true);

        order.addPricingRule(new SecondNormalTicketRule());
        order.addSeatReservation(new MovieTicket(movieScreening, false, 1, 1));

        assertEquals(10.0, order.calculatePrice(), 0.01);
    }

    @Test
    public void testDiscountOnWeekdays() {
        MovieScreening movieScreening = new MovieScreening(movie, LocalDateTime.of(2019, 1, 31, 0, 0), 10.0);
        Order order = new Order(1, false);

        order.addPricingRule(new SecondNormalTicketRule());
        order.addSeatReservation(new MovieTicket(movieScreening, false, 1, 1));

        assertEquals(0.0, order.calculatePrice(), 0.01);
    }

    @Test
    public void testDiscountInWeekend() {
        MovieScreening movieScreening = new MovieScreening(movie, LocalDateTime.of(2019, 2, 1, 0, 0), 10.0);
        Order order = new Order(1, false);

        order.addPricingRule(new SecondNormalTicketRule());
        order.addSeatReservation(new MovieTicket(movieScreening, false, 1, 1));

        assertEquals(10.0, order.calculatePrice(), 0.01);
    }
}
