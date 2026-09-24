# Sistem Informasi Manajemen Kebun Hidroponik

## Deskripsi Singkat Program

Program ini adalah aplikasi berbasis konsol (CLI) yang dibangun menggunakan bahasa pemrograman Java. Aplikasi ini menerapkan konsep Object-Oriented Programming (OOP) tingkat lanjut seperti inheritance dan polymorphism. Aplikasi ini berfungsi untuk mengelola data kebun hidroponik secara digital yang datanya disimpan di dalam memori menggunakan struktur data ArrayList. Program ini mengelola tiga entitas utama:

* Tanaman: Entitas ini merupakan superclass yang kini diturunkan menjadi dua jenis spesifik, yaitu Tanaman Sayur dan Tanaman Buah. Tanaman Sayur memiliki atribut khusus berupa tingkat kerenyahan dan masa simpan. Tanaman Buah memiliki atribut khusus berupa skala Brix dan status berbiji

* Perawatan: Entitas ini menyimpan data pemeliharaan seperti nama perawatan dan frekuensi. Entitas ini saling berelasi dan merujuk secara spesifik ke tanaman yang dirawat menggunakan ID tanaman.

* Pekerja: Entitas ini berfungsi untuk mengelola data staf kebun. Atribut yang dicatat meliputi ID, nama, nomor telepon, dan shift kerja.

Melalui menu utama, pengguna dapat melakukan operasi CRUD (Create, Read, Update, Delete) secara lengkap pada ketiga entitas tersebut. Program saat ini juga telah disempurnakan dengan enkapsulasi untuk validasi setter dan perlindungan blok try-catch, sehingga aplikasi tidak akan crash apabila pengguna memasukkan input data yang tidak valid.

## Penjelasan Alur Program

1. Menu Awal

<img width="490" height="164" alt="image" src="https://github.com/user-attachments/assets/17510ab6-dc3a-46eb-bcab-5330ea6ba8d0" />

Pada Tampilan awal terdapat 4 pilihan menu yaitu menu kelola tanaman, kelola perawatan, kelola pekerja, dan keluar. jika memilih menu keluar maka system akan berhenti.
   
2. Menu Kelola Tanaman

<img width="490" height="164" alt="image" src="https://github.com/user-attachments/assets/eea0c9ce-5bee-4aee-80c5-0ac53c721584" />

Jika masuk ke dalam menu kelola tanaman maka kita bisa melakukan operasi CRUD pada entintas Tanaman termasuk Tanaman Buah dan Tanaman Sayur. pada pilihan kembali ke menu utama system akan keluar dari sub menu kelola tanaman dan kembali ke menu awal.
   
3. Menu Kelola Perawatan

<img width="455" height="147" alt="image" src="https://github.com/user-attachments/assets/676bfa67-e421-4d91-96e7-c92b085f9832" />

Jika masuk ke dalam menu kelola tanaman maka kita bisa melakukan operasi CRUD pada entintas Perawatan. pada pilihan kembali ke menu utama system akan keluar dari sub menu kelola perawatan dan kembali ke menu awal.

4. Menu Kelola Pekerja

<img width="477" height="137" alt="image" src="https://github.com/user-attachments/assets/63f1d26f-9096-4698-b476-f6f4442d26fe" />

Jika masuk ke dalam menu kelola tanaman maka kita bisa melakukan operasi CRUD pada entintas Pekerja. pada pilihan kembali ke menu utama system akan keluar dari sub menu kelola pekerja dan kembali ke menu awal.

## Penjelasan Penerapan Encapsulation dan Inheritance

### Encapsulation

Seluruh atribut pada class model (`Tanaman`, `TanamanSayur`, `TanamanBuah`, `Perawatan`, `Pekerja`) dideklarasikan dengan **access modifier `private`** (atau `protected` pada atribut yang diturunkan di `Tanaman`), sehingga tidak bisa diakses langsung dari luar class. Akses dilakukan melalui **getter** dan **setter** publik, contohnya:

- `Tanaman`: `getIdTanaman()`, `getNamaTanaman()`, `setNamaTanaman()`, `setGradeTanaman()`, `setSistemIrigasi()` — masing-masing setter melakukan **validasi input** (menolak string kosong) sebelum mengubah nilai atribut.
- `TanamanBuah`: `setSkalaBrix()` memvalidasi bahwa nilai brix harus berada pada rentang 1–16.
- `TanamanSayur`: `setMasaSimpan()` memvalidasi bahwa masa simpan harus lebih dari 0.
- `Pekerja` dan `Perawatan`: setter-nya menolak input `String` kosong (nama, nomor telepon, shift, nama perawatan, frekuensi).

Atribut `idTanaman` pada `Tanaman` dideklarasikan `private final`, artinya nilainya hanya bisa diisi sekali lewat constructor dan tidak dapat diubah setelahnya (tidak disediakan setter untuk ID) — ini melindungi identitas unik objek tanaman.

### Inheritance 

Program menerapkan relasi pewarisan dengan:
- **Superclass**: `Tanaman` memiliki atribut dan method umum (`namaTanaman`, `gradeTanaman`, `sistemIrigasi`, method `tampilkanInfo()`, dan method `kataKata()` yang dideklarasikan `final` sehingga tidak bisa di-override oleh subclass).
- **Subclass 1**: `TanamanSayur extends Tanaman` menambahkan atribut khusus sayur (`tingkatKerenyahan`, `masaSimpan`).
- **Subclass 2**: `TanamanBuah extends Tanaman` menambahkan atribut khusus buah (`skalaBrix`, `berbiji`).

Kedua subclass memanggil constructor superclass melalui `super(...)` untuk mengisi atribut yang diwariskan, lalu menambahkan inisialisasi atribut miliknya sendiri.

## Penerapan Nilai Tambah

### Polymorphism

- Method `tampilkanInfo()` yang dideklarasikan di superclass `Tanaman` di-**override** oleh `TanamanSayur` dan `TanamanBuah`. Masing-masing override memanggil `super.tampilkanInfo()` terlebih dahulu (untuk menampilkan info umum), lalu menambahkan output atribut spesifiknya sendiri (kerenyahan & masa simpan untuk sayur; skala brix & status berbiji untuk buah).
- Efek polymorphism terlihat jelas di `ManajemenKebun.tampilkanTanaman()`: program melakukan iterasi terhadap `ArrayList<Tanaman>` dan memanggil `t.tampilkanInfo()` pada setiap objek — meskipun tipe referensinya adalah `Tanaman`, method yang dijalankan otomatis sesuai objek aslinya (`TanamanSayur` atau `TanamanBuah`), tanpa perlu pengecekan tipe manual untuk menentukan tampilan.


