import java.util.ArrayList;

public class Billet {
    private String ticketHolder;
    private int ticketPrice;

    public Billet(String ticketHolder, int ticketPrice) {
        this.ticketHolder = ticketHolder;
        this.ticketPrice = ticketPrice;
    }

    public String getTicketHolder() {
        return ticketHolder;
    }

    public void setTicketHolder(String ticketHolder) {
        this.ticketHolder = ticketHolder;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Ticket:\n" + "Ticket Holder '" + ticketHolder + '\'' +
                " - Ticket Price: " + ticketPrice +
                "'-";
    }
}
