# Customer & Car Management System

## Deskripsi

Program ini adalah aplikasi berbasis Java yang digunakan untuk mengelola data pelanggan dan mobil. Aplikasi ini memiliki dua bagian utama: **Manajemen Pelanggan (Customer Management)** dan **Manajemen Mobil (Car Management)**. Aplikasi ini memungkinkan pengguna untuk menambahkan data pelanggan dan mobil ke dalam tabel, serta melakukan proses pembayaran untuk pelanggan yang telah memilih mobil. 

### Fitur Utama

1. **Manajemen Pelanggan**:
   - Menambahkan nama pelanggan dan memilih mobil yang ingin dibeli.
   - Menampilkan daftar pelanggan dengan detail nama pelanggan, nama mobil, tipe mobil, harga mobil, status pembayaran, dan aksi pembayaran.
   - Status pembayaran pelanggan dapat diperbarui dengan memilih tombol "Pay".

2. **Manajemen Mobil**:
   - Menambahkan data mobil yang terdiri dari nama mobil, tipe mobil, merek mobil, dan harga mobil.
   - Menampilkan daftar mobil yang telah ditambahkan ke sistem.

3. **Proses Pembayaran**:
   - Pelanggan dapat melakukan pembayaran dengan memasukkan jumlah uang yang dibayarkan.
   - Sistem akan memeriksa apakah jumlah pembayaran mencukupi dan menghitung kembalian jika diperlukan.
   - Status pembayaran akan diperbarui menjadi "Paid" jika pembayaran berhasil.

## Struktur Program

### 1. **AddCarController**
   Kelas ini digunakan untuk mengelola input dan penambahan data mobil ke dalam tabel.
   - Menyimpan data mobil dalam objek `Car` yang berisi nama, tipe, merek, dan harga mobil.
   - Data mobil akan ditampilkan dalam tabel setelah ditambahkan.

### 2. **AddCustomerController**
   Kelas ini digunakan untuk mengelola input dan penambahan data pelanggan ke dalam tabel.
   - Menyimpan data pelanggan bersama dengan mobil yang dipilih oleh pelanggan.
   - Data pelanggan dan mobil yang dipilih akan ditampilkan dalam tabel setelah ditambahkan.

### 3. **PaymentButtonEditor**
   Kelas ini digunakan untuk membuat tombol "Pay" pada setiap baris di tabel pelanggan.
   - Ketika tombol "Pay" ditekan, pengguna diminta untuk memasukkan jumlah pembayaran.
   - Sistem akan memproses pembayaran dan mengupdate status pembayaran sesuai dengan hasil transaksi.

### 4. **PaymentButtonRenderer**
   Kelas ini digunakan untuk menampilkan tombol "Pay" di setiap baris tabel pelanggan.
   - Mengontrol tampilan tombol di dalam tabel agar tombol tersebut selalu ditampilkan.

### 5. **Main**
   Kelas utama yang menjalankan aplikasi.
   - Menyusun tampilan GUI dengan dua tab utama: satu untuk manajemen pelanggan dan satu lagi untuk manajemen mobil.
   - Menambahkan elemen input seperti `JTextField`, `JComboBox`, dan `JButton` serta tabel untuk menampilkan data.

## Instalasi

1. Pastikan Anda sudah menginstal **Java** di komputer Anda.
2. Unduh atau salin kode program ke dalam IDE Java seperti **Eclipse** atau **IntelliJ IDEA**.
3. Kompilasi dan jalankan program menggunakan IDE Anda.

## Penggunaan

- **Manajemen Mobil**:
  1. Masukkan nama mobil, tipe mobil, merek mobil, dan harga mobil.
  2. Klik tombol "Add Car" untuk menambahkan mobil ke dalam daftar.
  
- **Manajemen Pelanggan**:
  1. Masukkan nama pelanggan dan pilih mobil yang akan dibeli.
  2. Klik tombol "Add Customer" untuk menambahkan pelanggan ke dalam daftar.
  
- **Proses Pembayaran**:
  1. Klik tombol "Pay" di baris pelanggan yang ingin dibayar.
  2. Masukkan jumlah uang yang dibayarkan.
  3. Sistem akan memproses pembayaran dan mengupdate status pembayaran pelanggan.

## Teknologi yang Digunakan

- **Java**: Bahasa pemrograman yang digunakan untuk membangun aplikasi ini.
- **Swing**: Digunakan untuk membangun GUI (Graphical User Interface).
- **JTable**: Digunakan untuk menampilkan data dalam bentuk tabel.
- **JComboBox**: Digunakan untuk memilih mobil dalam manajemen pelanggan.
- **JButton**: Digunakan untuk membuat tombol interaktif, termasuk tombol "Pay".

## Pembaruan dan Perbaikan

Jika ada pembaruan atau perbaikan yang perlu dilakukan pada program ini, Anda dapat melakukan kontribusi melalui pull request atau melaporkan masalah pada repositori.

