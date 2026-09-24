package hidroponik;

public class TanamanSayur extends Tanaman {
    private String tingkatKerenyahan; 
    private int masaSimpan;
    
    public TanamanSayur(int idTanaman, String namaTanaman, String gradeTanaman, String sistemIrigasi, String tingkatKerenyahan, int masaSimpan) {
        super(idTanaman, namaTanaman, gradeTanaman, sistemIrigasi);
        this.tingkatKerenyahan = tingkatKerenyahan;
        setMasaSimpan(masaSimpan);
    }

    public String getTingkatKerenyahan() { return tingkatKerenyahan; }
    public int getMasaSimpan() { return masaSimpan; }

    public void setTingkatKerenyahan(String tingkatKerenyahan) {
        this.tingkatKerenyahan = tingkatKerenyahan;
    }

    public void setMasaSimpan(int masaSimpan) {
        if (masaSimpan > 0) {
            this.masaSimpan = masaSimpan;
        } else {
            System.out.println("Masa simpan harus lebih dari 0");
        }
    }
    
@Override
public void tampilkanInfo() {
    super.tampilkanInfo();
    System.out.println("Kerenyahan    : " + tingkatKerenyahan);
    System.out.println("Masa Simpan   : " + masaSimpan + " Hari");
}
}