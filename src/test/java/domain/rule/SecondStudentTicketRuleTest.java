package domain.rule;

import domain.Movie;
import domain.MovieScreening;
import domain.MovieTicket;
import domain.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class SecondStudentTicketRuleTest {

    private Movie movie;
    private MovieScreening movieScreening;

    @Before
    public void setUp() {
        this.movie = new Movie("Harry Potter");
        this.movieScreening = new MovieScreening(movie, LocalDateTime.now(), 10.0);
    }

    @Test
    public void testStudentSingleTicket() {
        Order order = new Order(1, true);

        order.addSeatReservation(new MovieTicket(movieScreening, false, 1, 1));

        assertEquals(10.0, order.calculatePrice(), 0.01);
    }

    @Test
    public void testStudentMultipleTickets() {
        Order order = new Order(1, true);

        order.addSeatReservation(new MovieTicket(movieScreening, false, 1, 1));
        order.addSeatReservation(new MovieTicket(new MovieScreening(movie, null, 10.0), false, 1, 1));

        assertEquals(10.0, order.calculatePrice(), 0.01);
    }
}
