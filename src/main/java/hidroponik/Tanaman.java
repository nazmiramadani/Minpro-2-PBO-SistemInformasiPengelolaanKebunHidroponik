package hidroponik;

public class Tanaman {
    private final int idTanaman;
    protected String namaTanaman;
    protected String gradeTanaman;
    protected String sistemIrigasi;
    
    public Tanaman(int idTanaman, String namaTanaman, String gradeTanaman, String sistemIrigasi) {
        this.idTanaman = idTanaman;
        setNamaTanaman(namaTanaman);
        setGradeTanaman(gradeTanaman);
        setSistemIrigasi(sistemIrigasi);
    }

    public int getIdTanaman() {
        return idTanaman;
    }

    public String getNamaTanaman() {
        return namaTanaman;
    }

    public String getGradeTanaman() {
        return gradeTanaman;
    }
    
    public String getSistemIrigasi() {
        return sistemIrigasi;
    }

    public void setNamaTanaman(String namaTanaman) {
        if (namaTanaman.isEmpty()){
            System.out.println("Nama tidak valid");
            return;
        }
        this.namaTanaman = namaTanaman;
    }

    public void setGradeTanaman(String gradeTanaman) {
        if (gradeTanaman.isEmpty()) {
            System.out.println("Grade Tanaman tidak valid");
            return;
        }
        this.gradeTanaman = gradeTanaman;
    }
    
    public void setSistemIrigasi(String sistemIrigasi) {
        if (sistemIrigasi.isEmpty()) {
            System.out.println("Sistem Irigasi tidak Valid");
            return;
        }
        this.sistemIrigasi = sistemIrigasi;
    }
    
    public void tampilkanInfo() {
        System.out.println("ID Netpot      : " + idTanaman);
        System.out.println("Nama Tanaman   : " + namaTanaman);
        System.out.println("Grade          : " + gradeTanaman);
        System.out.println("Sistem Irigasi : " + sistemIrigasi);
    }

    public final void kataKata() {
        System.out.println("Hidroponik Tanaman Masa Depann ");
    }
}