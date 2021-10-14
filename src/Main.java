import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Band> bands = new ArrayList<>();

        Arrangement arrangement = new Arrangement(bands, "Super Festival 2022");
        Billet ticket = new Billet("", 295);

        Band band1 = new Band("Slipknot", 100);
        Band band2 = new Band("Neelix", 100);
        Band band3 = new Band("Post Malone", 100);
        Band band4 = new Band("Benal", 100);
        Band band5 = new Band("Arianna Grande", 100);

        bands.add(band1);
        bands.add(band2);
        bands.add(band3);
        bands.add(band4);
        bands.add(band5);

        while (true) {
            welcomeMsg();

            int bandChoice = printBandName(bands);

            int ticketAmount = bandTicketsAvailable(bandChoice, bands, ticket.getTicketPrice(), ticket);

            printTickets(ticket, ticketAmount, arrangement, bandChoice, bands);
        }
    }

    public static void printTickets(Billet ticket, int ticketAmount, Arrangement arrangement, int bandChoice, ArrayList<Band> bands) {
        String ticketQuestion = "Would you like to see your tickets? 'y' 'n'";
        String lineBreaker = "-------------------------------------------------------------------";
        //Denne "if" bruger "ticketAmountBought" som nu hedder ticketAmount.
        //Hvis den er på 0 så springer den hele printTickets metoden over.
        if (ticketAmount > 0) {
            System.out.println(ticketQuestion);
            String answer = scanner.next() + scanner.nextLine();
            //Denne "if" printer billetter hvis der bliver svaret ja.
            if (answer.equals("y")) {
                for (int i = 0; i < ticketAmount; i++) {
                    System.out.println(lineBreaker);
                    System.out.println(ticket);
                    System.out.println(arrangement.getAddresse() + " - " + bands.get(bandChoice - 1));
                    System.out.println(lineBreaker);
                }
                System.out.println("Thanks for using 'BEST TICKET WEBSITE IN TOWN', press any key and then enter");
                String temp = scanner.next() + scanner.nextLine();
            } else {
                System.out.println("Thanks for using 'BEST TICKET WEBSITE IN TOWN', press any key and then enter");
                String temp = scanner.next() + scanner.nextLine();
            }
        }
    }

    public static int bandTicketsAvailable(int bandChoice, ArrayList<Band> bands, int ticket, Billet billet) {
        String getNameMsg = "Please type your name";
        String ticketMsg = "How many tickets would you like to buy?";
        String ticketCost = "Your tickets cost ";
        System.out.println(getNameMsg);
        billet.setTicketHolder(scanner.next());
        //Her viser hvor mange tickets der er til det valgte band.
        Band band = bands.get(bandChoice - 1);
        System.out.println("There are " + bands.get(bandChoice - 1).getTicketAmount() + " available tickets for " + bands.get(bandChoice - 1));
        //Her trækker vi trækker vi det valgte antal billetter valgt fra den totale mængde af billetter.
        System.out.println(ticketMsg);
        int ticketAmountBought = scanner.nextInt();
        band.setTicketAmount(band.getTicketAmount() - ticketAmountBought);

        //Her ser man hvor meget ens billetter ville koste samlet og om de er sikre på om de vil købe dem.
        System.out.println(ticketCost + (ticket * ticketAmountBought) + "-' Would you like to buy them? 'y' 'n'");
        String answer = scanner.next() + scanner.nextLine();
        //Hvis der bliver sagt nej lægger jeg de købte billetter tilbage i billet puljen og sætter "ticketAmountBought" til 0 for at bruge det i den nøste metode.
        if (answer.equals("n")) {
            band.setTicketAmount(band.getTicketAmount() + ticketAmountBought);
            System.out.println("Press any key and then 'enter' to continue");
            String temp = scanner.next();
            ticketAmountBought = 0;
            return ticketAmountBought;
        } else {
            //Her viser jeg hvor mange billetter der er købt til hvilket band.
            System.out.println("Your bought " + ticketAmountBought + " tickets to see " + bands.get(bandChoice - 1));
            return ticketAmountBought;
        }
    }

        //Denne metode printer bands og beder om et tal der bliver brugt senere til at finde det rigtige band frem.
    public static int printBandName(ArrayList<Band> bands) {
        int[] bandNumber = {1, 2, 3, 4, 5};
        for (int i = 0; i < bands.size(); i++) {
            System.out.println(bandNumber[i] + " " + bands.get(i));
        }
        int bandChoice = scanner.nextInt();
        return bandChoice;
    }

    public static void welcomeMsg() {
        String bandQuestion = "Welcome to 'BEST TICKET WEBSITE IN TOWN'\nPlease choose which band you would like to see\n";
        System.out.println(bandQuestion);
    }
}