/*
 * Harap diperhatikan baik baik jika ingin merubah source code
 * Jika ingin merubah harap diberikan penjelasan
 * Linsesi menggunakan MIT Lisence (LIsensi jangan dirubah)
 */
package sayatv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @penulis timBersama
 */
public class SayaTV {

    /**
     * @param args argumen baris perintah
     */
    static InputStreamReader scan = new InputStreamReader(System.in);
    final BufferedReader read = new BufferedReader(scan);
    ArrayList dataId = new ArrayList();
    ArrayList dataPassword = new ArrayList();
    ArrayList dataEmail = new ArrayList();
    ArrayList dataAlamat = new ArrayList();
    ArrayList dataNama = new ArrayList();
    ArrayList dataNoHP = new ArrayList();
    ArrayList dataHobi = new ArrayList();
    static ArrayList dataPaket = new ArrayList();
    static ArrayList dataHarga = new ArrayList();
    static ArrayList dataSaluranTV = new ArrayList();
    static String dataPaketSaluranTV[][] = new String[100][100];
    static ArrayList dataPelanggan = new ArrayList();
    static ArrayList dataMasaAktifPaket = new ArrayList();
    static String[][] dataValidasiPembelianPaket = new String[100][100];
    String paketSaluranTV;
    String saluranTV;
    String harga;
    String nama;
    String Id;
    String password;
    String alamat;
    String paket;
    String email;
    String pilihan;
    String hobi;
    long noHP;
    boolean autentikasi;
    int indeks;
    static String validasi;
    static String alamatKantor;
    static long noRekeningKantor;
    static long noTelpKantor;
    static SayaTV data = new SayaTV();
    static SayaTV input = new SayaTV();
    static SayaTV signIn = new SayaTV();
    static SayaTV signUp = new SayaTV();
    static SayaTV lupaPassword = new SayaTV();
    static SayaTV user = new SayaTV();
    static SayaTV admin = new SayaTV();
    static boolean kondisiMain = true;
    static boolean kondisi = true;

    static void garisTepi() {
        System.out.println("==========================");
    }

    static void pilihanTidakTersedia() {
        System.out.println("Pilihan tidak tersedia");
    }

    static void formulirPendaftaran() throws IOException {
        System.out.print("Masukkan nama     : ");
        data.nama = input.read.readLine();
        System.out.print("Masukkan alamat   : ");
        data.alamat = input.read.readLine();
        System.out.print("Masukkan email    : ");
        data.email = input.read.readLine();
        System.out.print("Masukkan no-HP    : ");
        data.noHP = Long.valueOf(input.read.readLine());
        System.out.print("Masukkan hobi     : ");
        data.hobi = input.read.readLine();
    }

    static void menuSelamatDatang() throws IOException {
        System.out.println("===== Selamat Datang =====");
        System.out.println("[1]. SignIn");
        System.out.println("[2]. SignUp");
        System.out.println("[3]. Lupa password");
        System.out.println("[4]. Keluar Aplikasi");
        System.out.print("Pilih: ");
        int pilihan = Integer.valueOf(input.read.readLine());
        garisTepi();
        System.out.println();
        switch (pilihan) {
            case 1:
                System.out.println("========= SignIn =========");
                signIn();
                break;
            case 2:
                signUp();
                break;
            case 3:
                System.out.println("====== Lupa password =====");
                lupaPassword();
                break;
            case 4:
                kondisiMain = false;
                break;
            default:
                garisTepi();
                pilihanTidakTersedia();
                garisTepi();
                System.out.println();
        }
    }

    static void signUp() throws IOException {
        boolean kondisiSignUp = true;
        do {
            System.out.println("========= SignUp =========");
            System.out.print("Daftar sebagai (admin/user) ");
            String jawaban = input.read.readLine();
            garisTepi();
            System.out.println();
            if (jawaban.equalsIgnoreCase("admin")) {
                System.out.println("========= SignUp =========");
                System.out.print("Masukkan kode admin(didapatkan dari developer): ");
                String kode = input.read.readLine();
                garisTepi();
                System.out.println();
                if (kode.equals("A23uu!!@j")) {
                    System.out.println("========= SignUp =========");
                    formulirPendaftaran();
                    System.out.print("Masukkan ID Admin : ");
                    signUp.Id = input.read.readLine();
                    System.out.print("Mauskkan password : ");
                    signUp.password = input.read.readLine();
                    garisTepi();
                    if (!admin.dataId.contains(signUp.Id) && !user.dataId.contains(signUp.Id)) {
                        admin.dataNama.add(data.nama);
                        admin.dataAlamat.add(data.alamat);
                        admin.dataEmail.add(data.email);
                        admin.dataNoHP.add(data.noHP);
                        admin.dataId.add(signUp.Id);
                        admin.dataPassword.add(signUp.password);
                        admin.dataHobi.add(data.hobi);
                        kondisiSignUp = false;
                        System.out.println();
                        garisTepi();
                        System.out.println("Selamat anda berhasil mendaftar");
                    } else {
                        System.out.println();
                        garisTepi();
                        System.out.println("SignUp dibatalkan");
                        System.out.println("Id sudah digunakan");
                        kondisiSignUp = false;
                    }
                } else {
                    garisTepi();
                    System.out.println("Kode admin salah. Harap hubungi developer");
                    kondisiSignUp = false;
                }
                garisTepi();
                System.out.println();
            } else if (jawaban.equalsIgnoreCase("user")) {
                System.out.println("========= SignUp =========");
                formulirPendaftaran();
                System.out.print("Masukkan ID User  : ");
                signUp.Id = input.read.readLine();
                System.out.print("Mauskkan password : ");
                signUp.password = input.read.readLine();
                garisTepi();
                System.out.println();
                if (!user.dataId.contains(signUp.Id) && !admin.dataId.contains(signUp.Id)) {
                    user.dataNama.add(data.nama);
                    user.dataAlamat.add(data.alamat);
                    user.dataEmail.add(data.email);
                    user.dataNoHP.add(data.noHP);
                    user.dataId.add(signUp.Id);
                    user.dataPassword.add(signUp.password);
                    user.dataHobi.add(data.hobi);
                    kondisiSignUp = false;
                    garisTepi();
                    System.out.println("Selamat anda berhasil mendaftar");
                } else {
                    garisTepi();
                    System.out.println("SignUp dibatalkan");
                    System.out.println("Id sudah digunakan");
                    kondisiSignUp = false;
                }
                garisTepi();
                System.out.println();
            } else {
                garisTepi();
                pilihanTidakTersedia();
                System.out.println("Ulangi lagi");
                garisTepi();
                System.out.println();
            }
        } while (kondisiSignUp);
    }

    static void signIn() throws IOException {
        System.out.print("Masukkan ID Anda  : ");
        signIn.Id = input.read.readLine();
        System.out.print("Masukkan password : ");
        signIn.password = input.read.readLine();
        garisTepi();
        System.out.println();
        if (admin.dataId.contains(signIn.Id)) {
            int i = admin.dataId.indexOf(signIn.Id);
            garisTepi();
            if (signIn.password.equals(admin.dataPassword.get(i))) {
                System.out.println("Login berhasil");
                admin.autentikasi = true;
                admin.indeks = i;
            } else {
                System.out.println("Id atau password salah");
            }
            garisTepi();
            System.out.println();
        } else if (user.dataId.contains(signIn.Id)) {
            int i = user.dataId.indexOf(signIn.Id);
            garisTepi();
            if (signIn.password.equals(user.dataPassword.get(i))) {
                System.out.println("Login berhasil");
                user.autentikasi = true;
                user.indeks = i;
            } else {
                System.out.println("Id atau password salah");
            }
            garisTepi();
            System.out.println();
        } else {
            garisTepi();
            System.out.println("Id atau password salah");
            garisTepi();
            System.out.println();
        }
    }

    static void lupaPassword() throws IOException {
        boolean kondisiLupaPassword = true;
        System.out.print("Masukkan ID   : ");
        String id = input.read.readLine();
        System.out.print("Masukkan hobi : ");
        String hobi = input.read.readLine();
        garisTepi();
        System.out.println();
        if (user.dataId.contains(id)) {
            int i = user.dataId.indexOf(id);
            if ((hobi.equalsIgnoreCase(String.valueOf(user.dataHobi.get(i))))) {
                do {
                    garisTepi();
                    System.out.print("Password baru       : ");
                    String password = input.read.readLine();
                    System.out.print("Konfirmasi password : ");
                    String confirmPassword = input.read.readLine();
                    garisTepi();
                    System.out.println();
                    garisTepi();
                    if (password.equals(confirmPassword)) {
                        user.dataPassword.set(i, password);
                        System.out.println("Password berhasil diubah");
                        kondisiLupaPassword = false;
                    } else {
                        System.out.println("Ulangi lagi");
                        System.out.println("Password baru & konfirmasi");
                        System.out.println("tidak cocok");
                    }
                    garisTepi();
                    System.out.println();
                } while (kondisiLupaPassword);
            } else {
                garisTepi();
                System.out.println("Id atau hobi salah");
                garisTepi();
                System.out.println();
            }
        } else if (admin.dataId.contains(id)) {
            int j = admin.dataId.indexOf(id);
            if (hobi.equalsIgnoreCase(String.valueOf(admin.dataHobi.get(j)))) {
                do {
                    garisTepi();
                    System.out.print("Password baru       : ");
                    String password = input.read.readLine();
                    System.out.print("Konfirmasi password : ");
                    String confirmPassword = input.read.readLine();
                    garisTepi();
                    System.out.println();
                    garisTepi();
                    if (password.equals(confirmPassword)) {
                        admin.dataPassword.set(j, password);
                        System.out.println("Password berhasil diubah");
                        kondisiLupaPassword = false;
                    } else {
                        System.out.println("Ulangi lagi");
                        System.out.println("Password baru & konfirmasi");
                        System.out.println("tidak cocok");
                    }
                    garisTepi();
                    System.out.println();
                } while (kondisiLupaPassword);
            } else {
                garisTepi();
                System.out.println("Id atau hobi salah");
                garisTepi();
                System.out.println();
            }
        } else {
            garisTepi();
            System.out.println("Id atau hobi salah");
            garisTepi();
            System.out.println();
        }
    }

    static void menuUser(int i) throws IOException {
        System.out.println("====== Menu Layanan ======");
        System.out.println("[1]. Daftar paket");
        System.out.println("[2]. Beli paket berlangganan");
        System.out.println("[3]. Info paket berlangganan");
        System.out.println("[4]. Berhenti berlangganan");
        System.out.println("[5]. Info akun");
        System.out.println("[6]. Info Kantor");
        System.out.println("[7]. Logout");
        System.out.print("Pilih: ");
        int pilihan = Integer.valueOf(input.read.readLine());
        garisTepi();
        System.out.println();
        switch (pilihan) {
            case 1:
                System.out.println("====== Daftar Paket ======");
                daftarPaket("tersedia");
                break;
            case 2:
                System.out.println("======= Beli Paket =======");
                beliPaket(alamatKantor, noRekeningKantor, noTelpKantor, i);
                break;
            case 3:
                System.out.println("==== Info Berlangganan ===");
                infoPaketBerlangganan(i);
                break;
            case 4:
                System.out.println("== Berhenti Berlangganan =");
                berhentiPaket(i);
                break;
            case 5:
                System.out.println("======== Info Akun =======");
                infoAkunUser(i);
                break;
            case 6:
                System.out.println("======= Info Kantor ======");
                infoKantor();
                break;
            case 7:
                user.autentikasi = false;
                break;
            default:
                System.out.println();
                pilihanTidakTersedia();
        }
    }

    static void menuAdmin(int i) throws IOException {
        System.out.println("====== Menu Layanan ======");
        System.out.println("[1]. Daftar & Info Pelanggan");
        System.out.println("[2]. Daftar Paket");
        System.out.println("[3]. Daftar Saluran TV");
        System.out.println("[4]. Tambahkan Paket");
        System.out.println("[5]. Tambahkan saluran TV");
        System.out.println("[6]. Validasi Pembayaran Paket");
        System.out.println("[7]. Info Akun");
        System.out.println("[8]. Info Kantor");
        System.out.println("[9]. Logout");
        System.out.print("Pilih: ");
        int pilihan = Integer.valueOf(input.read.readLine());
        garisTepi();
        System.out.println();
        switch (pilihan) {
            case 1:
                System.out.println("=== Daftar & Info Pelanggan ===");
                daftarInfoPelanggan();
                break;
            case 2:
                System.out.println("====== Daftar Paket ======");
                daftarPaket("ditambahkan");
                break;
            case 3:
                System.out.println("==== Daftar Saluran TV ===");
                daftarSaluranTV();
                break;
            case 4:
                System.out.println("===== Tambahkan Paket ====");
                tambahPaket();
                break;
            case 5:
                System.out.println("== Tambahkan Saluran TV ==");
                tambahSaluranTV();
                break;
            case 6:
                System.out.println("== Validasi Pembayaran ===");
                validasiPembayaran();
                break;
            case 7:
                System.out.println("======== Info Akun =======");
                infoAkunAdmin(i);
                break;
            case 8:
                System.out.println("======= Info Kantor ======");
                infoKantor();
                break;
            case 9:
                admin.autentikasi = false;
                break;
            default:
                garisTepi();
                pilihanTidakTersedia();
        }
    }

    static void daftarPaket(String keterangan) throws IOException {
        if (dataPaket.isEmpty()) {
            System.out.println("Paket belum " + keterangan);
        } else {
            for (int i = 0; i < dataPaket.size(); i++) {
                System.out.format("[%d]. Paket %s\n", (i + 1), String.valueOf(dataPaket.get(i)));
                System.out.println("     Saluran TV : ");
                for (int j = 0; j < dataPaketSaluranTV[i].length; j++) {
                    if (dataPaketSaluranTV[i][j] != null) {
                        System.out.format("         %d. %s\n", (j + 1), String.valueOf(dataPaketSaluranTV[i][j]));
                    }
                }
                System.out.format("     Harga %d", Integer.valueOf(String.valueOf(dataHarga.get(i))));
                System.out.println();
                System.out.format("     Masa aktif %d hari", Integer.valueOf(String.valueOf(dataMasaAktifPaket.get(i))));
                System.out.println();
            }
        }
    }

    static void beliPaket(String tempat, long noRekening, long noTelp, int a) throws IOException {
        daftarPaket("tersedia");
        if (!dataPaket.isEmpty()) {
            System.out.print("Pilih paket: ");
            int pilihan = Integer.valueOf(input.read.readLine());
            garisTepi();
            System.out.println();
            if (pilihan <= dataPaket.size() && pilihan > 0) {
                garisTepi();
                System.out.println("Mode pembayaran: ");
                System.out.println("[1]. Bayar langsung ke kantor");
                System.out.println("[2]. Via ATM");
                System.out.print("Pilih: ");
                int i = Integer.valueOf(input.read.readLine());
                garisTepi();
                System.out.println();
                garisTepi();
                switch (i) {
                    case 1:
                        System.out.println("Pembayaran langsung dibayarkan di " + tempat);
                        break;
                    case 2:
                        System.out.println("Pembayaran dikirim ke nomer rekening " + noRekening);
                        System.out.println("Setelah selesai silahkan upload foto");
                        System.out.println("bukti pembayaran, nama paket dan id Anda ke");
                        System.out.format("nomor telepon %d guna memvalidasi pembayaran\n", noTelp);
                        break;
                    default:
                        pilihanTidakTersedia();
                }
            } else {
                garisTepi();
                pilihanTidakTersedia();
            }
        }
    }

    static void infoPaketBerlangganan(int i) {
        int n = 1;
        if (dataPelanggan.contains(user.dataId.get(i))) {
            int j = dataPelanggan.indexOf(user.dataId.get(i));
            for (int k = 0; k < dataValidasiPembelianPaket[j].length; k++) {
                if (dataPaket.contains(dataValidasiPembelianPaket[j][k])) {
                    int l = dataPaket.indexOf(dataValidasiPembelianPaket[j][k]);
                    System.out.format("[%d]. Paket %s\n", n, String.valueOf(dataPaket.get(l)));
                    System.out.println("     Saluran TV : ");
                    for (int m = 0; m < dataPaketSaluranTV[l].length; m++) {
                        if (dataPaketSaluranTV[l][m] != null) {
                            System.out.format("         %d. %s\n", (m + 1), String.valueOf(dataPaketSaluranTV[l][m]));
                        }
                    }
                    System.out.format("     Harga %d", Integer.valueOf(String.valueOf(dataHarga.get(l))));
                    System.out.println();
                    System.out.format("     Masa aktif %d hari", Integer.valueOf(String.valueOf(dataMasaAktifPaket.get(l))));
                    System.out.println();
                    n++;
                }
            }
        } else {
            System.out.println("Anda belum membeli paket atau ");
            System.out.println("pembayaran belum divalidasi");
        }
    }

    static void berhentiPaket(int i) throws IOException {
        infoPaketBerlangganan(i);
        if (dataPelanggan.contains(user.dataId.get(i))) {
            System.out.print("Pilih: ");
            int pilihan = Integer.valueOf(input.read.readLine());
            garisTepi();
            System.out.println();
            garisTepi();
            int k = 0;
            for (int j = 0; j < dataValidasiPembelianPaket[i].length; j++) {
                if (dataValidasiPembelianPaket[i][j] != null) {
                    k++;
                }
            }
            if (pilihan <= k && pilihan > 0) {
                dataValidasiPembelianPaket[i][pilihan - 1] = null;
                System.out.format("Paket ke-%d sukses dihentikan\n", pilihan);
            } else {
                pilihanTidakTersedia();
            }
        }
    }

    static void daftarInfoPelanggan() {
        int n = 1;
        if (dataPelanggan.isEmpty()) {
            System.out.println("Belum ada pelanggan");
        } else {
            for (int i = 0; i < dataPelanggan.size(); i++) {
                int j = user.dataId.indexOf(dataPelanggan.get(i));
                System.out.println("Pelanggan ke-" + (i + 1));
                System.out.format("  Nama   : %s\n", user.dataNama.get(j));
                System.out.format("  Alamat : %s\n", user.dataAlamat.get(j));
                System.out.format("  No. HP : %d\n", user.dataNoHP.get(j));
                System.out.format("  Email  : %s\n", user.dataEmail.get(j));
                System.out.println("  Paket yang aktif: ");
                for (int k = 0; k < dataValidasiPembelianPaket[i].length; k++) {
                    if (dataPaket.contains(dataValidasiPembelianPaket[i][k])) {
                        int l = dataPaket.indexOf(dataValidasiPembelianPaket[i][k]);
                        System.out.format("  [%d]. Paket %s\n", n, String.valueOf(dataPaket.get(l)));
                        System.out.println("       Saluran TV : ");
                        for (int m = 0; m < dataPaketSaluranTV[l].length; m++) {
                            if (dataPaketSaluranTV[l][m] != null) {
                                System.out.format("           %d. %s\n", (m + 1), String.valueOf(dataPaketSaluranTV[l][m]));
                            }
                        }
                        System.out.format("       Harga %d", Integer.valueOf(String.valueOf(dataHarga.get(l))));
                        System.out.println();
                        System.out.format("       Masa aktif %d hari", Integer.valueOf(String.valueOf(dataMasaAktifPaket.get(l))));
                        System.out.println();
                        n++;
                    }
                }
            }
        }
    }

    static void daftarSaluranTV() {
        if (dataSaluranTV.isEmpty()) {
            System.out.println("Saluran TV belum ditambahkan");
        } else {
            for (int i = 0; i < dataSaluranTV.size(); i++) {
                System.out.format("[%d]. %s ", (i + 1), String.valueOf(dataSaluranTV.get(i)));
                System.out.println();
            }
        }
    }

    static void tambahPaket() throws IOException {
        boolean kondisiAddPaket = true;
        int j = 0;
        if (dataSaluranTV.isEmpty()) {
            System.out.println("Menambahkan paket tidak bisa");
            System.out.println("Saluran TV belum ditambahkan");
        } else {
            System.out.print("Nama paket: ");
            data.paket = input.read.readLine();
            data.paket = data.paket.toUpperCase();
            garisTepi();
            System.out.println();
            if (dataPaket.contains(data.paket)) {
                garisTepi();
                System.out.println("Nama paket sudah digunakan");
            } else {
                dataPaket.add(data.paket);
                do {
                    garisTepi();
                    daftarSaluranTV();
                    System.out.print("Pilih saluran TV: ");
                    int i = Integer.valueOf(input.read.readLine());
                    if (i <= dataSaluranTV.size() && i > 0) {
                        data.paketSaluranTV = String.valueOf(dataSaluranTV.get(i - 1));
                        dataPaketSaluranTV[dataPaket.size() - 1][j] = data.paketSaluranTV;
                        j++;
                        garisTepi();
                        System.out.println();
                        garisTepi();
                        System.out.format("Saluran TV %s berhasil dimasukkan\n", dataSaluranTV.get(i - 1));
                        garisTepi();
                        System.out.println();
                        boolean kondisiAddPaket1 = true;
                        do {
                            garisTepi();
                            System.out.print("Pilih lagi?(Y/N) ");
                            String pilihan = input.read.readLine();
                            if (pilihan.equalsIgnoreCase("n")) {
                                kondisiAddPaket1 = false;
                                kondisiAddPaket = false;
                            } else if (pilihan.equalsIgnoreCase("y")) {
                                kondisiAddPaket1 = false;
                            }
                            garisTepi();
                            System.out.println();
                        } while (kondisiAddPaket1);
                    } else {
                        garisTepi();
                        System.out.println();
                        garisTepi();
                        pilihanTidakTersedia();
                        System.out.println("Ulangi lagi");
                        garisTepi();
                        System.out.println();
                    }
                } while (kondisiAddPaket);
                garisTepi();
                System.out.print("Harga paket: ");
                data.harga = input.read.readLine();
                dataHarga.add(data.harga);
                System.out.print("Masa aktif paket(hari): ");
                int hari = Integer.valueOf(input.read.readLine());
                dataMasaAktifPaket.add(hari);
                garisTepi();
                System.out.println();
                garisTepi();
                System.out.format("Paket ke-%d telah tersimpan\n", dataPaket.size());
            }
        }
    }

    static void tambahSaluranTV() throws IOException {
        boolean kondisiAddSaluranTV = true;
        do {
            boolean kondisiAddSaluranTV1 = true;
            System.out.print("Masukkan nama saluran TV: ");
            data.saluranTV = input.read.readLine();
            garisTepi();
            System.out.println();
            garisTepi();
            data.saluranTV = data.saluranTV.toUpperCase();
            if (dataSaluranTV.contains(data.saluranTV)) {
                System.out.println("Saluran TV sudah ditambahkan");
                System.out.println("Ulangi lagi");
                garisTepi();
                System.out.println();
                garisTepi();
            } else {
                dataSaluranTV.add(data.saluranTV);
                System.out.format("Saluran TV ke-%d telah tersimpan\n", dataSaluranTV.size());
                garisTepi();
                System.out.println();
                do {
                    garisTepi();
                    System.out.print("Masukkan lagi?(Y/N) ");
                    String pilihan = input.read.readLine();
                    if (pilihan.equalsIgnoreCase("y")) {
                        kondisiAddSaluranTV1 = false;
                        garisTepi();
                        System.out.println();
                        garisTepi();
                    } else if (pilihan.equalsIgnoreCase("n")) {
                        kondisiAddSaluranTV = false;
                        kondisiAddSaluranTV1 = false;
                    } else {
                        System.out.println();
                    }
                } while (kondisiAddSaluranTV1);
            }
        } while (kondisiAddSaluranTV);
    }

    static void infoAkunUser(int i) throws IOException {
        System.out.format("Nama   : %s\n", user.dataNama.get(i));
        System.out.format("Alamat : %s\n", user.dataAlamat.get(i));
        System.out.format("Hobi   : %s\n", user.dataHobi.get(i));
        System.out.format("No. HP : %d\n", user.dataNoHP.get(i));
        System.out.format("Email  : %s\n", user.dataEmail.get(i));
    }

    static void infoAkunAdmin(int i) throws IOException {
        System.out.format("Nama\t: %s\n", admin.dataNama.get(i));
        System.out.format("Alamat\t: %s\n", admin.dataAlamat.get(i));
        System.out.format("Hobi\t: %s\n", admin.dataHobi.get(i));
        System.out.format("No. HP\t: %d\n", admin.dataNoHP.get(i));
        System.out.format("Email\t: %s\n", admin.dataEmail.get(i));
    }

    static void validasiPembayaran() throws IOException {
        System.out.print("Masukkan id user yang telah membayar: ");
        validasi = input.read.readLine();
        if (user.dataId.contains(validasi)) {
            System.out.print("Masukkan nama paket yang dibeli: ");
            String namaPaket = input.read.readLine();
            garisTepi();
            System.out.println();
            garisTepi();
            if (dataPaket.contains(namaPaket)) {
                if (dataPelanggan.contains(validasi)) {
                    int i = dataPelanggan.indexOf(validasi);
                    for (int j = 0; j < dataValidasiPembelianPaket[i].length; j++) {
                        if (dataValidasiPembelianPaket[i][j] == null) {
                            dataValidasiPembelianPaket[i][j] = namaPaket;
                            break;
                        }
                    }
                } else {
                    dataPelanggan.add(validasi);
                    int i = dataPelanggan.size() - 1;
                    for (int j = 0; j < dataValidasiPembelianPaket[i].length; j++) {
                        if (dataValidasiPembelianPaket[i][j] == null) {
                            dataValidasiPembelianPaket[i][j] = namaPaket;
                            break;
                        }
                    }
                }
                System.out.println("Validasi sukses");
            } else {
                System.out.println("Nama Paket tidak ditemukan");
            }
        } else {
            garisTepi();
            System.out.println();
            garisTepi();
            System.out.println("Id user tidak ditemukan");
        }
    }

    static void infoKantor() throws IOException {
        if (alamatKantor != null) {
            System.out.format("- Alamat kantor        : %s\n", alamatKantor);
            System.out.format("- No. rekening kantor  : %d\n", noRekeningKantor);
            System.out.format("- No. telepon kantor   : %d\n", noTelpKantor);
        } else {
            System.out.println("Informasi kantor belum tersedia");
        }

    }

    public static void main(String[] args) throws IOException {
        do {
            menuSelamatDatang();
            while (user.autentikasi) {
                menuUser(user.indeks);
                if (user.autentikasi) {
                    garisTepi();
                    System.out.println();
                }
            }
            while (admin.autentikasi) {
                if (alamatKantor == null) {
                    garisTepi();
                    System.out.println("Informasi kantor masih kosong");
                    System.out.println("Harap diisi");
                    garisTepi();
                    System.out.println();
                    garisTepi();
                    System.out.print("Masukkan alamat kantor sayaTV       : ");
                    alamatKantor = input.read.readLine();
                    System.out.print("Masukkan no. rekening kantor sayaTV : ");
                    noRekeningKantor = Integer.valueOf(input.read.readLine());
                    System.out.print("Masukkan no. Telp kantor sayaTV     : ");
                    noTelpKantor = Integer.valueOf(input.read.readLine());
                    garisTepi();
                    System.out.println();
                }
                menuAdmin(admin.indeks);
                if (admin.autentikasi) {
                    garisTepi();
                    System.out.println();
                }
            }
        } while (kondisiMain);
    }
}
