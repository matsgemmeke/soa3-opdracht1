package domain;

import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;

public class TicketExportFormatTest {

    @Test
    public void testJsonExport() throws IOException {
        TicketExportFormat exportFormat = TicketExportFormat.JSON;

        Movie movie = new Movie("Harry Potter");
        MovieScreening movieScreening = new MovieScreening(movie, LocalDateTime.now(), 10.0);

        MovieTicket movieTicketOne = new MovieTicket(movieScreening, false, 1, 1);
        MovieTicket movieTicketTwo = new MovieTicket(movieScreening, true, 3, 5);

        Order order = new Order(1, false);

        order.addSeatReservation(movieTicketOne);
        order.addSeatReservation(movieTicketTwo);

        exportFormat.export(order, "C:\\Users\\Mats\\Documents\\test.json");
    }
}
