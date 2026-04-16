# Remote Controller Java Socket

## Deskripsi
Proyek ini berisi dua program Java:
- `roihan.java` sebagai client yang mengirim perintah.
- `server.java` sebagai server yang menerima perintah dan mengeksekusinya.

## Cara Kerja
1. Jalankan `server.java` di komputer penerima.
2. Jalankan `roihan.java` di komputer client.
3. Client memilih perintah dari daftar.
4. Server menerima perintah dari client dan menjalankan aksi di komputer server.

## Perintah yang Tersedia
- `1` : Buka VS Code
- `2` : Sleep laptop selama 20 detik
- `3` : Shutdown laptop
- `4` : Buka Calculator
- `5` : Buka Notepad

## Detail Koneksi
- Port server: `12345`
- IP tujuan client: `xx.x.x.xx` (nilai ini saat ini masih ditulis langsung di dalam kode client)

> Catatan: `roihan.java` meminta IP target, tetapi kode client saat ini masih menggunakan alamat `10.8.0.44`.

## Jalankan Program
### 1. Jalankan server
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.mycompany.java2asocket.server"
```

### 2. Jalankan client
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.mycompany.java2asocket.roihan"
```

## Keterangan
- `server.java` menggunakan `Runtime.exec()` untuk menjalankan program Windows seperti `code`, `calc.exe`, dan `notepad.exe`.
- Program ini dibuat untuk lingkungan Windows.
- Pastikan firewall dan jaringan mengizinkan koneksi ke port `12345`.
