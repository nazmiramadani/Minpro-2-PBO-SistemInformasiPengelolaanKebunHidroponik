package hidroponik;

import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenKebun {
    private ArrayList<Tanaman> daftarTanaman;
    private ArrayList<Perawatan> daftarPerawatan;
    private ArrayList<Pekerja> daftarPekerja;
    private Scanner scanner;
    
    public ManajemenKebun(Scanner scanner){
        this.daftarTanaman = new ArrayList<>();
        this.daftarPerawatan = new ArrayList<>();
        this.daftarPekerja = new ArrayList<>();
        this.scanner = scanner;
        
        daftarTanaman.add(new TanamanSayur(1, "Selada Hijau", "Grade A", "NFT", "Sangat Renyah", 7));
        daftarTanaman.add(new TanamanBuah(2, "Tomat Cherry", "Grade B", "Dutch Bucket", 10, true));
        daftarPerawatan.add(new Perawatan(1, 1, "Pengecekan Nutrisi", "Tiga Hari Sekali"));
        daftarPekerja.add(new Pekerja(1, "Andi", "08123456789", "Pagi"));
    }
    
//TANAMAN
    public void tambahTanaman(){
        try {
            System.out.print("ID Tanaman (Angka): "); 
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nama Tanaman: "); 
            String nama = scanner.nextLine();

            System.out.print("Grade Tanaman: "); 
            String grade = scanner.nextLine();
            
            System.out.print("Sistem Irigasi: "); 
            String sistem = scanner.nextLine();

            System.out.print("Kategori (1. Sayur / 2. Buah): ");
            int kategori = scanner.nextInt();
            scanner.nextLine();

            if (kategori == 1) {
                System.out.print("Tingkat Kerenyahan: ");
                String kerenyahan = scanner.nextLine();
                System.out.print("Masa Simpan: ");
                int masaSimpan = scanner.nextInt();
                scanner.nextLine();
                
                TanamanSayur sayur = new TanamanSayur(id, nama, grade, sistem, kerenyahan, masaSimpan);
                daftarTanaman.add(sayur);
            } else if (kategori == 2) {
                System.out.print("Skala Brix: ");
                double brix = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Apakah Tanaman Berbiji? yes or no: ");
                boolean berbiji = scanner.nextBoolean();
                scanner.nextLine();
                
                TanamanBuah buah = new TanamanBuah(id, nama, grade, sistem, brix, berbiji);
                daftarTanaman.add(buah);
            } else {
                System.out.println("Kategori tidak valid!");
                return;
            }

            System.out.println("Tanaman berhasil ditambahkan");
        } catch (Exception e) {
            System.out.println("Input tidak valid");
            scanner.nextLine();
        }
    }

    public void tampilkanTanaman(){
        if (daftarTanaman.isEmpty()) {
            System.out.println("Data tanaman kosong.");
            return;
        }

        for (int i = 0; i < daftarTanaman.size(); i++) {
            Tanaman t = daftarTanaman.get(i);
            t.tampilkanInfo(); 
            t.kataKata();
            System.out.println("-------------------------");
        }
    }

    public void hapusTanaman(){
        try {
            System.out.print("Masukkan ID Tanaman yang ingin dihapus: ");
            int idTarget = scanner.nextInt();
            scanner.nextLine();

            boolean ditemukan = false;
            for(int i = 0; i < daftarTanaman.size(); i++){
                if(daftarTanaman.get(i).getIdTanaman() == idTarget){    
                    daftarTanaman.remove(i);
                    System.out.println("Tanaman berhasil dihapus");
                    ditemukan = true;
                    break;
                }
            }
            if (!ditemukan) {
                System.out.println("Data tidak ada");
            }
        } catch (Exception e) {
            System.out.println("Pilihan harus pakai angka");
            scanner.nextLine(); 
        }
    }

    public void updateTanaman(){
        try {
            System.out.print("Masukkan ID Tanaman yang ingin diupdate: ");
            int idTarget = scanner.nextInt();
            scanner.nextLine(); 

            for (Tanaman t : daftarTanaman){
                if(t.getIdTanaman() == idTarget){
                    System.out.print("Nama Tanaman Baru: ");
                    String namaBaru = scanner.nextLine(); 
                    
                    System.out.print("Grade Tanaman Baru: ");
                    String gradeBaru = scanner.nextLine(); 
                    
                    System.out.print("Sistem Irigasi Baru: ");
                    String sistemBaru = scanner.nextLine(); 
                    
                    t.setNamaTanaman(namaBaru);
                    t.setGradeTanaman(gradeBaru);
                    t.setSistemIrigasi(sistemBaru);

                    if (t instanceof TanamanSayur) {
                        TanamanSayur ts = (TanamanSayur) t;
                        System.out.print("Tingkat Kerenyahan Baru: ");
                        ts.setTingkatKerenyahan(scanner.nextLine());
                        System.out.print("Masa Simpan Baru: ");
                        ts.setMasaSimpan(scanner.nextInt());
                        scanner.nextLine();
                    } else if (t instanceof TanamanBuah) {
                        TanamanBuah tb = (TanamanBuah) t;
                        System.out.print("Skala Brix Baru (1-16): ");
                        tb.setSkalaBrix(scanner.nextDouble());
                        scanner.nextLine();
                        System.out.print("Apakah Tanaman Berbiji? (yes or no): ");
                        tb.setBerbiji(scanner.nextBoolean());
                        scanner.nextLine();
                    }

                    System.out.println("Data berhasil diupdate");
                    return;
                }
            }
            System.out.println("Data tidak ada");
        } catch (Exception e) {
            System.out.println("Input tidak valid");
            scanner.nextLine(); 
        }
    }

//PERAWATAN
    public void tambahPerawatan(){
        try {
            System.out.print("ID Perawatan: "); 
            int id = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("ID Tanaman yang dirawat: "); 
            int idTanaman = scanner.nextInt();
            scanner.nextLine();

            boolean tanamanAda = false;
            for (Tanaman t : daftarTanaman) {
                if (t.getIdTanaman() == idTanaman) {
                    tanamanAda = true;
                    break; 
                }
            }

            if (!tanamanAda) {
                System.out.println("ID Tanaman tidak ada");
                return; 
            }

            System.out.print("Nama Perawatan: "); 
            String nama = scanner.nextLine();

            System.out.print("Frekuensi: "); 
            String frekuensi = scanner.nextLine();

            Perawatan perawatanBaru = new Perawatan(id, idTanaman, nama, frekuensi);
            daftarPerawatan.add(perawatanBaru);

            System.out.println("Data Perawatan berhasil ditambahkan");
        } catch (Exception e) {
            System.out.println("Pilihan harus pakai angka");
            scanner.nextLine(); 
        }
    }

    public void tampilkanPerawatan(){
        if (daftarPerawatan.isEmpty()) {
            System.out.println("Data perawatan masih kosong.");
            return;
        }

        for (int i = 0; i < daftarPerawatan.size(); i++) {
            Perawatan p = daftarPerawatan.get(i);
            System.out.println("ID Perawatan   : " + p.getIdPerawatan());
            System.out.println("ID Tanaman     : " + p.getIdTanaman());
            System.out.println("Nama Perawatan : " + p.getNamaPerawatan());
            System.out.println("Frekuensi      : " + p.getFrekuensi());
            System.out.println("-------------------------");
        }
    }

    public void updatePerawatan(){
        try {
            System.out.print("Masukkan ID Perawatan yang ingin diupdate: ");
            int idTarget = scanner.nextInt();
            scanner.nextLine(); 

            for (Perawatan p : daftarPerawatan){
                if(p.getIdPerawatan() == idTarget){
                    System.out.print("ID Tanaman Baru: "); 
                    int idTanamanBaru = scanner.nextInt();
                    scanner.nextLine();

                    boolean tanamanAda = false;
                    for (Tanaman t : daftarTanaman) {
                        if (t.getIdTanaman() == idTanamanBaru) {
                            tanamanAda = true;
                            break;
                        }
                    }

                    if (!tanamanAda) {
                        System.out.println("ID Tanaman tidak ada");
                        return;
                    }

                    System.out.print("Nama Perawatan Baru: ");
                    String namaBaru = scanner.nextLine(); 
                    
                    System.out.print("Frekuensi Baru: ");
                    String frekuensiBaru = scanner.nextLine(); 
                    
                    p.setIdTanaman(idTanamanBaru);
                    p.setNamaPerawatan(namaBaru);
                    p.setFrekuensi(frekuensiBaru); 
                    
                    System.out.println("Data perawatan berhasil diperbarui");
                    return;
                }
            }
            System.out.println("Data perawatan tidak ada");
        } catch (Exception e) {
            System.out.println("Pilihan harus pakai angka");
            scanner.nextLine(); 
        }
    }

    public void hapusPerawatan(){
        try {
            System.out.print("Masukkan ID Perawatan yang dihapus: ");
            int idTarget = scanner.nextInt();
            scanner.nextLine();

            boolean ditemukan = false;
            for(int i = 0; i < daftarPerawatan.size(); i++){
                if(daftarPerawatan.get(i).getIdPerawatan() == idTarget){    
                    daftarPerawatan.remove(i);
                    System.out.println("Data Perawatan berhasil dihapus");
                    ditemukan = true;
                    break;
                }
            }
            if (!ditemukan) {
                System.out.println("Data perawatan tidak ada");
            }
        } catch (Exception e) {
            System.out.println("Pilihan harus pakai angka");
            scanner.nextLine(); 
        }
    }

//PEKERJA
    public void tambahPekerja(){
        try {
            System.out.print("ID Pekerja: "); 
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nama Pekerja: "); 
            String nama = scanner.nextLine();

            System.out.print("Nomor Telepon: "); 
            String telepon = scanner.nextLine();
            
            System.out.print("Shift Kerja: "); 
            String shift = scanner.nextLine();

            Pekerja pekerjaBaru = new Pekerja(id, nama, telepon, shift);
            daftarPekerja.add(pekerjaBaru);

            System.out.println("Pekerja berhasil ditambahkan");
        } catch (Exception e) {
            System.out.println("Pilihan harus pakai angka");
            scanner.nextLine();
        }
    }

    public void tampilkanPekerja(){
        if (daftarPekerja.isEmpty()) {
            System.out.println("Data pekerja masih kosong.");
            return;
        }

        for (int i = 0; i < daftarPekerja.size(); i++) {
            Pekerja p = daftarPekerja.get(i);
            System.out.println("ID Pekerja    : " + p.getIdPekerja());
            System.out.println("Nama Pekerja  : " + p.getNamaPekerja());
            System.out.println("Nomor Telepon : " + p.getNomorTelepon());
            System.out.println("Shift Kerja   : " + p.getShiftKerja());
            System.out.println("-------------------------");
        }
    }

    public void updatePekerja(){
        try {
            System.out.print("Masukkan ID Pekerja yang diupdate: ");
            int idTarget = scanner.nextInt();
            scanner.nextLine(); 

            for (Pekerja p : daftarPekerja){
                if(p.getIdPekerja() == idTarget){
                    System.out.print("Nama Pekerja Baru: ");
                    String namaBaru = scanner.nextLine(); 
                    
                    System.out.print("Nomor Telepon Baru: ");
                    String teleponBaru = scanner.nextLine(); 
                    
                    System.out.print("Shift Kerja Baru: ");
                    String shiftBaru = scanner.nextLine(); 
                    
                    p.setNamaPekerja(namaBaru);
                    p.setNomorTelepon(teleponBaru); 
                    p.setShiftKerja(shiftBaru);
                    
                    System.out.println("Data pekerja berhasil diperbarui");
                    return;
                }
            }
            System.out.println("Data pekerja tidak ada");
        } catch (Exception e) {
            System.out.println("Pilihan harus pakai angka");
            scanner.nextLine(); 
        }
    }

    public void hapusPekerja(){
        try {
            System.out.print("Masukkan ID Pekerja yang dihapus: ");
            int idTarget = scanner.nextInt();
            scanner.nextLine();

            boolean ditemukan = false;
            for(int i = 0; i < daftarPekerja.size(); i++){
                if(daftarPekerja.get(i).getIdPekerja() == idTarget){    
                    daftarPekerja.remove(i);
                    System.out.println("Data Pekerja berhasil dihapus");
                    ditemukan = true;
                    break;
                }
            }
            if (!ditemukan) {
                System.out.println("Data pekerja tidak ada");
            }
        } catch (Exception e) {
            System.out.println("Pilihan harus pakai angka");
            scanner.nextLine(); 
        }
    }
}