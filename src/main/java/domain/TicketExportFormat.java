package domain;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public enum TicketExportFormat {

    PLAINTEXT {
        public void export(Order order, String path) throws IOException {
            BufferedWriter out = new BufferedWriter(new FileWriter("order_" + order.getOrderNr() + ".txt"));
            out.write(order.toString());
            out.close();
        }
    },
    JSON {
        public void export(Order order, String path) throws IOException {
            JSONObject object = new JSONObject();
            object.put("OrderNr", order.getOrderNr());
            object.put("StudentOrder", order.isStudentOrder());
            object.put("TotalPrice", order.calculatePrice());

            JSONArray tickets = new JSONArray();

            for (MovieTicket ticket : order.getTickets()) {
                JSONObject ticketObject = new JSONObject();

                ticketObject.put("Date", ticket.getMovieScreening().getDateAndTime().toLocalDate().toString());
                ticketObject.put("Premium", ticket.isPremiumTicket());
                ticketObject.put("SeatNr", ticket.getSeatNr());
                ticketObject.put("SeatRow", ticket.getSeatRow());

                tickets.add(ticketObject);
            }

            object.put("Tickets", tickets);

            FileWriter file = new FileWriter(path);
            file.write(object.toJSONString());
        }
    };

    public abstract void export(Order order, String path) throws IOException;
}
