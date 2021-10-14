import java.util.ArrayList;

public class Band {
    private String bandName;
    private int ticketAmount;

    public Band(String bandName, int ticketAmount) {
        this.bandName = bandName;
        this.ticketAmount = ticketAmount;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public String getBandName() {
        return bandName;
    }

    @Override
    public String toString() {
        return bandName;
    }
}
