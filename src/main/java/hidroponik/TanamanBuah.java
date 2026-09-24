package hidroponik;

public class TanamanBuah extends Tanaman {
    private double skalaBrix;
    private boolean berbiji; 
    
    public TanamanBuah(int idTanaman, String namaTanaman, String gradeTanaman, String sistemIrigasi, double skalaBrix, boolean berbiji) {
        super(idTanaman, namaTanaman, gradeTanaman, sistemIrigasi);
        setSkalaBrix(skalaBrix);
        this.berbiji = berbiji;
    }

    public double getSkalaBrix() { return skalaBrix; }
    public boolean isBerbiji() { return berbiji; }

    public void setSkalaBrix(double skalaBrix) {
        if (skalaBrix >= 1 && skalaBrix <= 16) {
            this.skalaBrix = skalaBrix;
        } else {
            System.out.println("Skala Brix harus dalam rentang 1 - 16.");
        }
    }

    public void setBerbiji(boolean berbiji) {
        this.berbiji = berbiji;
    }
    
@Override
public void tampilkanInfo() {
    super.tampilkanInfo();
    System.out.println("Skala Brix    : " + skalaBrix + "Brix");
    System.out.println("Berbiji       : " + (berbiji ? "Yes" : "No"));
}
}