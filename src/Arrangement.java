import java.util.ArrayList;

public class Arrangement {
    private ArrayList<Band> Bandlist;
    private String addresse;


    public Arrangement(ArrayList<Band> bandlist, String addresse) {
        Bandlist = bandlist;
        this.addresse = addresse;
    }

    public ArrayList<Band> getBandlist() {
        return Bandlist;
    }

    public void setBandlist(ArrayList<Band> bandlist) {
        Bandlist = bandlist;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    @Override
    public String toString() {
        return "Arrangement{" +
                "Bandlist=" + Bandlist +
                ", addresse='" + addresse + '\'' +
                '}';
    }
}
