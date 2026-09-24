package com.mycompany.minpro;

import hidroponik.ManajemenKebun;
import java.util.Scanner;

public class MINPRO {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ManajemenKebun manajemen = new ManajemenKebun(scanner);

        boolean berjalan = true;

        while (berjalan) {
            System.out.println("\n=== Sistem Informasi Pengelolaan Kebun Hidroponik ===");
            System.out.println("1. Menu Kelola Tanaman");
            System.out.println("2. Menu Kelola Perawatan");
            System.out.println("3. Menu Kelola Pekerja");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu utama (1-4): ");
            
            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();
                
                switch (pilihan) {
                    case 1 -> menuTanaman(scanner, manajemen);
                    case 2 -> menuPerawatan(scanner, manajemen);
                    case 3 -> menuPekerja(scanner, manajemen);
                    case 4 -> {
                        System.out.println("Terima kasih dan bye");
                        berjalan = false;
                    }
                    default -> System.out.println("Pilihan tidak valid");
                }
            } catch (Exception e) {
                System.out.println("Error: Pilihan harus pakai angka");
                scanner.nextLine(); // Membersihkan buffer input
            }
        }
        scanner.close();
    }

//MENU TANAMAN
    private static void menuTanaman(Scanner scanner, ManajemenKebun manajemen) {
        boolean subBerjalan = true;
        while (subBerjalan) {
            System.out.println("\n--- Menu Kelola Tanaman ---");
            System.out.println("1. Tambah Tanaman");
            System.out.println("2. Tampilkan Tanaman");  
            System.out.println("3. Update Tanaman");
            System.out.println("4. Hapus Tanaman");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih operasi (1-5): ");
            
            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();
                
                switch (pilihan) {
                    case 1 -> manajemen.tambahTanaman();
                    case 2 -> manajemen.tampilkanTanaman();
                    case 3 -> manajemen.updateTanaman();
                    case 4 -> manajemen.hapusTanaman();
                    case 5 -> subBerjalan = false;
                    default -> System.out.println("Pilihan tidak valid");
                }
            } catch (Exception e) {
                System.out.println("Error: Pilihan harus pakai angka");
                scanner.nextLine();
            }
        }
    }

//MENU PERAWATAN
    private static void menuPerawatan(Scanner scanner, ManajemenKebun manajemen) {
        boolean subBerjalan = true;
        while (subBerjalan) {
            System.out.println("\n--- Menu Kelola Perawatan ---");
            System.out.println("1. Tambah Perawatan");
            System.out.println("2. Tampilkan Perawatan");
            System.out.println("3. Update Perawatan");
            System.out.println("4. Hapus Perawatan");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih operasi (1-5): ");
            
            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();
                
                switch (pilihan) {
                    case 1 -> manajemen.tambahPerawatan();
                    case 2 -> manajemen.tampilkanPerawatan();
                    case 3 -> manajemen.updatePerawatan();
                    case 4 -> manajemen.hapusPerawatan();
                    case 5 -> subBerjalan = false;
                    default -> System.out.println("Pilihan tidak valid");
                }
            } catch (Exception e) {
                System.out.println("Pilihan harus pakai angka");
                scanner.nextLine();
            }
        }
    }

//MENU PEKERJA
    private static void menuPekerja(Scanner scanner, ManajemenKebun manajemen) {
        boolean subBerjalan = true;
        while (subBerjalan) {
            System.out.println("\n--- Menu Kelola Pekerja ---");
            System.out.println("1. Tambah Pekerja");
            System.out.println("2. Tampilkan Pekerja");
            System.out.println("3. Update Pekerja");
            System.out.println("4. Hapus Pekerja");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih operasi (1-5): ");
            
            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();
                
                switch (pilihan) {
                    case 1 -> manajemen.tambahPekerja();
                    case 2 -> manajemen.tampilkanPekerja();
                    case 3 -> manajemen.updatePekerja();
                    case 4 -> manajemen.hapusPekerja();
                    case 5 -> subBerjalan = false;
                    default -> System.out.println("Pilihan tidak valid");
                }
            } catch (Exception e) {
                System.out.println("Pilihan harus pakai angka");
                scanner.nextLine();
            }
        }
    }
}