# Sistem Informasi Manajemen Kebun Hidroponik

## Deskripsi Singkat Program

Program ini adalah aplikasi berbasis konsol (CLI) yang dibangun menggunakan bahasa pemrograman Java. Aplikasi ini menerapkan konsep Object-Oriented Programming (OOP) tingkat lanjut seperti inheritance dan polymorphism. Aplikasi ini berfungsi untuk mengelola data kebun hidroponik secara digital yang datanya disimpan di dalam memori menggunakan struktur data ArrayList. Program ini mengelola tiga entitas utama:

* Tanaman: Entitas ini merupakan superclass yang kini diturunkan menjadi dua jenis spesifik, yaitu Tanaman Sayur dan Tanaman Buah. Tanaman Sayur memiliki atribut khusus berupa tingkat kerenyahan dan masa simpan. Tanaman Buah memiliki atribut khusus berupa skala Brix dan status berbiji

* Perawatan: Entitas ini menyimpan data pemeliharaan seperti nama perawatan dan frekuensi. Entitas ini saling berelasi dan merujuk secara spesifik ke tanaman yang dirawat menggunakan ID tanaman.

* Pekerja: Entitas ini berfungsi untuk mengelola data staf kebun. Atribut yang dicatat meliputi ID, nama, nomor telepon, dan shift kerja.

Melalui menu utama, pengguna dapat melakukan operasi CRUD (Create, Read, Update, Delete) secara lengkap pada ketiga entitas tersebut. Program saat ini juga telah disempurnakan dengan enkapsulasi untuk validasi setter dan perlindungan blok try-catch, sehingga aplikasi tidak akan crash apabila pengguna memasukkan input data yang tidak valid.

## Penjelasan Alur Program

1. Menu Awal

<img width="484" height="146" alt="image" src="https://github.com/user-attachments/assets/17510ab6-dc3a-46eb-bcab-5330ea6ba8d0" />

Pada Tampilan awal terdapat 4 pilihan menu yaitu menu kelola tanaman, kelola perawatan, kelola pekerja, dan keluar.

   
2. Menu Kelola Tanaman

   
3. Menu Kelola Perawatan


4. Menu Kelola Pekerja
