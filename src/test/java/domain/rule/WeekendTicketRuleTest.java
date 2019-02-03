package domain.rule;

import domain.Movie;
import domain.MovieScreening;
import domain.MovieTicket;
import domain.Order;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class WeekendTicketRuleTest {

    private Movie movie;

    @Before
    public void setUp() {
        this.movie = new Movie("Harry Potter");
    }

    @Test
    public void testGroupDiscountWeekend() {
        MovieScreening movieScreeningOne = new MovieScreening(movie, LocalDateTime.of(2019, 2, 2, 0, 0), 10.0);
        MovieScreening movieScreeningTwo = new MovieScreening(movie, LocalDateTime.of(2019, 2, 2, 0, 0), 10.0);
        MovieScreening movieScreeningThree = new MovieScreening(movie, LocalDateTime.of(2019, 2, 2, 0, 0), 10.0);
        MovieScreening movieScreeningFour = new MovieScreening(movie, LocalDateTime.of(2019, 2, 2, 0, 0), 10.0);
        MovieScreening movieScreeningFive = new MovieScreening(movie, LocalDateTime.of(2019, 2, 2, 0, 0), 10.0);
        MovieScreening movieScreeningSix = new MovieScreening(movie, LocalDateTime.of(2019, 2, 2, 0, 0), 10.0);
        Order order = new Order(1, false);

        order.addPricingRule(new WeekendTicketRule());
        order.addSeatReservation(new MovieTicket(movieScreeningOne, false, 1, 1));
        order.addSeatReservation(new MovieTicket(movieScreeningTwo, false, 1, 2));
        order.addSeatReservation(new MovieTicket(movieScreeningThree, false, 1, 3));
        order.addSeatReservation(new MovieTicket(movieScreeningFour, false, 1, 4));
        order.addSeatReservation(new MovieTicket(movieScreeningFive, false, 1, 5));
        order.addSeatReservation(new MovieTicket(movieScreeningSix, false, 1, 6));

        assertEquals(54.0, order.calculatePrice(), 0.01);
    }

    @Test
    public void testGroupDiscountNoWeekend() {
        MovieScreening movieScreeningOne = new MovieScreening(movie, LocalDateTime.of(2019, 2, 6, 0, 0), 10.0);
        MovieScreening movieScreeningTwo = new MovieScreening(movie, LocalDateTime.of(2019, 2, 6, 0, 0), 10.0);
        MovieScreening movieScreeningThree = new MovieScreening(movie, LocalDateTime.of(2019, 2, 6, 0, 0), 10.0);
        MovieScreening movieScreeningFour = new MovieScreening(movie, LocalDateTime.of(2019, 2, 6, 0, 0), 10.0);
        MovieScreening movieScreeningFive = new MovieScreening(movie, LocalDateTime.of(2019, 2, 6, 0, 0), 10.0);
        MovieScreening movieScreeningSix = new MovieScreening(movie, LocalDateTime.of(2019, 2, 6, 0, 0), 10.0);
        Order order = new Order(1, false);

        order.addPricingRule(new WeekendTicketRule());
        order.addSeatReservation(new MovieTicket(movieScreeningOne, false, 1, 1));
        order.addSeatReservation(new MovieTicket(movieScreeningTwo, false, 1, 2));
        order.addSeatReservation(new MovieTicket(movieScreeningThree, false, 1, 3));
        order.addSeatReservation(new MovieTicket(movieScreeningFour, false, 1, 4));
        order.addSeatReservation(new MovieTicket(movieScreeningFive, false, 1, 5));
        order.addSeatReservation(new MovieTicket(movieScreeningSix, false, 1, 6));

        assertEquals(60.0, order.calculatePrice(), 0.01);
    }

    @Test
    public void testGroupDiscountWeekendLessTickets() {
        MovieScreening movieScreeningOne = new MovieScreening(movie, LocalDateTime.of(2019, 2, 2, 0, 0), 10.0);
        MovieScreening movieScreeningTwo = new MovieScreening(movie, LocalDateTime.of(2019, 2, 2, 0, 0), 10.0);
        MovieScreening movieScreeningThree = new MovieScreening(movie, LocalDateTime.of(2019, 2, 2, 0, 0), 10.0);
        MovieScreening movieScreeningFour = new MovieScreening(movie, LocalDateTime.of(2019, 2, 2, 0, 0), 10.0);
        MovieScreening movieScreeningFive = new MovieScreening(movie, LocalDateTime.of(2019, 2, 2, 0, 0), 10.0);
        Order order = new Order(1, false);

        order.addPricingRule(new WeekendTicketRule());
        order.addSeatReservation(new MovieTicket(movieScreeningOne, false, 1, 1));
        order.addSeatReservation(new MovieTicket(movieScreeningTwo, false, 1, 2));
        order.addSeatReservation(new MovieTicket(movieScreeningThree, false, 1, 3));
        order.addSeatReservation(new MovieTicket(movieScreeningFour, false, 1, 4));
        order.addSeatReservation(new MovieTicket(movieScreeningFive, false, 1, 5));

        assertEquals(50.0, order.calculatePrice(), 0.01);
    }

    @Test
    public void testGroupDiscountNoWeekendLessTickets() {
        MovieScreening movieScreeningOne = new MovieScreening(movie, LocalDateTime.of(2019, 2, 20, 0, 0), 10.0);
        MovieScreening movieScreeningTwo = new MovieScreening(movie, LocalDateTime.of(2019, 2, 20, 0, 0), 10.0);
        MovieScreening movieScreeningThree = new MovieScreening(movie, LocalDateTime.of(2019, 2, 20, 0, 0), 10.0);
        MovieScreening movieScreeningFour = new MovieScreening(movie, LocalDateTime.of(2019, 2, 20, 0, 0), 10.0);
        MovieScreening movieScreeningFive = new MovieScreening(movie, LocalDateTime.of(2019, 2, 20, 0, 0), 10.0);
        Order order = new Order(1, false);

        order.addPricingRule(new WeekendTicketRule());
        order.addSeatReservation(new MovieTicket(movieScreeningOne, false, 1, 1));
        order.addSeatReservation(new MovieTicket(movieScreeningTwo, false, 1, 2));
        order.addSeatReservation(new MovieTicket(movieScreeningThree, false, 1, 3));
        order.addSeatReservation(new MovieTicket(movieScreeningFour, false, 1, 4));
        order.addSeatReservation(new MovieTicket(movieScreeningFive, false, 1, 5));

        assertEquals(50.0, order.calculatePrice(), 0.01);
    }
}
