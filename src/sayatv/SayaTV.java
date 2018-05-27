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
    String noHP;
    boolean autentikasi;
    int indeks;
    static String validasi;
    static String alamatKantor;
    static String noRekeningKantor;
    static String noTelpKantor;
    static SayaTV data = new SayaTV();
    static SayaTV input = new SayaTV();
    static SayaTV signIn = new SayaTV();
    static SayaTV signUp = new SayaTV();
    static SayaTV lupaPassword = new SayaTV();
    static SayaTV user = new SayaTV();
    static SayaTV admin = new SayaTV();
    static boolean kondisiMain = true;
    static boolean kondisi = true;
    static boolean kondisiPilihanKembali = false;
    static int pilihanKembali;

    public static void clearConsole() throws IOException, InterruptedException {
        Thread.sleep(500);
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    static void garisTepi() {
        System.out.println("=========================================");
    }

    static void pilihanKembali(int i, String keterangan, String keteranganMenu) throws IOException, InterruptedException {
        if (i == 1) {
            System.out.println("[0]. " + keterangan);
            System.out.print("Pilih: ");
            pilihanKembali = Integer.valueOf(input.read.readLine());
            garisTepi();
            clearConsole();
            if (pilihanKembali != 0) {
                garisTepi();
                pilihanTidakTersedia();
                System.out.println("Ulangi lagi");
                garisTepi();
                Thread.sleep(1000);
                clearConsole();
                System.out.println(keteranganMenu);
                kondisiPilihanKembali = true;
            } else {
                kondisiPilihanKembali = false;
            }
        }
    }

    static void pilihanTidakTersedia() {
        System.out.println("Pilihan tidak tersedia");
    }

    static void formulirPendaftaran() throws IOException {
        System.out.print("Nama     : ");
        data.nama = input.read.readLine();
        System.out.print("Alamat   : ");
        data.alamat = input.read.readLine();
        System.out.print("email    : ");
        data.email = input.read.readLine();
        System.out.print("no-HP    : ");
        data.noHP = input.read.readLine();
        System.out.print("hobi     : ");
        data.hobi = input.read.readLine();
    }

    static void menuSelamatDatang() throws IOException, InterruptedException {
        System.out.println("==============  Selamat Datang  ==============");
        System.out.println("[1]. SignIn");
        System.out.println("[2]. SignUp");
        System.out.println("[3]. Lupa password");
        System.out.println("[4]. Keluar Aplikasi");
        System.out.print("Pilih: ");
        int pilihan = Integer.valueOf(input.read.readLine());
        garisTepi();
        clearConsole();
        switch (pilihan) {
            case 1:
                signIn();
                break;
            case 2:
                signUp();
                break;
            case 3:
                lupaPassword();
                break;
            case 4:
                kondisiMain = false;
                break;
            default:
                garisTepi();
                pilihanTidakTersedia();
                garisTepi();
                Thread.sleep(1000);
        }
    }

    static void signUp() throws IOException, InterruptedException {
        boolean kondisiSignUp = true;
        do {
            System.out.println("=================  SignUp  =================");
            System.out.print("Daftar sebagai (admin/user) ");
            String jawaban = input.read.readLine();
            garisTepi();
            clearConsole();
            if (jawaban.equalsIgnoreCase("admin")) {
                System.out.println("=================  SignUp  =================");
                System.out.print("Kode admin: ");
                String kode = input.read.readLine();
                garisTepi();
                clearConsole();
                if (kode.equals("A23uu!!@j")) {
                    System.out.println("=================  SignUp  =================");
                    formulirPendaftaran();
                    garisTepi();
                    clearConsole();
                    do {
                        System.out.println("=================  SignUp  =================");
                        System.out.print("Id baru  : ");
                        signUp.Id = input.read.readLine();
                        if (admin.dataId.contains(signUp.Id) || user.dataId.contains(signUp.Id)) {
                            garisTepi();
                            clearConsole();
                            garisTepi();
                            System.out.println("Id sudah digunakan");
                            System.out.println("Ulangi lagi");
                            garisTepi();
                            Thread.sleep(1000);
                            clearConsole();
                        }
                    } while (admin.dataId.contains(signUp.Id) || user.dataId.contains(signUp.Id));
                    System.out.print("Password baru : ");
                    signUp.password = input.read.readLine();
                    garisTepi();
                    clearConsole();
                    boolean kondisiSignUp1 = true;
                    do {
                        System.out.println("=================  SignUp  =================");
                        System.out.println("Nama     : " + data.nama);
                        System.out.println("Alamat   : " + data.alamat);
                        System.out.println("email    : " + data.email);
                        System.out.println("no-HP    : " + data.noHP);
                        System.out.println("hobi     : " + data.hobi);
                        System.out.print("Apakah anda yakin?(Y/N) ");
                        String pilihan = input.read.readLine();
                        garisTepi();
                        clearConsole();
                        if (pilihan.equalsIgnoreCase("y")) {
                            garisTepi();
                            System.out.println("SignUp berhasil");
                            garisTepi();
                            Thread.sleep(500);
                            clearConsole();
                            admin.dataNama.add(data.nama);
                            admin.dataAlamat.add(data.alamat);
                            admin.dataEmail.add(data.email);
                            admin.dataNoHP.add(data.noHP);
                            admin.dataHobi.add(data.hobi);
                            admin.dataId.add(signUp.Id);
                            admin.dataPassword.add(signUp.password);
                            kondisiSignUp = false;
                            kondisiSignUp1 = false;
                        } else if (pilihan.equalsIgnoreCase("n")) {
                            garisTepi();
                            System.out.println("SignUp dibatalkan");
                            garisTepi();
                            Thread.sleep(500);
                            clearConsole();
                            kondisiSignUp = false;
                            kondisiSignUp1 = false;
                        } else {
                            garisTepi();
                            pilihanTidakTersedia();
                            System.out.println("Ulangi lagi");
                            garisTepi();
                            Thread.sleep(1000);
                            clearConsole();
                        }
                    } while (kondisiSignUp1);
                } else {
                    garisTepi();
                    System.out.println("Kode admin salah");
                    System.out.println("Harap hubungi developer");
                    garisTepi();
                    Thread.sleep(1000);
                    clearConsole();
                    kondisiSignUp = false;
                }
            } else if (jawaban.equalsIgnoreCase("user")) {
                System.out.println("=================  SignUp  =================");
                formulirPendaftaran();
                garisTepi();
                clearConsole();
                do {
                    System.out.println("=================  SignUp  =================");
                    System.out.print("Id Baru  : ");
                    signUp.Id = input.read.readLine();
                    if (admin.dataId.contains(signUp.Id) || user.dataId.contains(signUp.Id)) {
                        garisTepi();
                        clearConsole();
                        garisTepi();
                        System.out.println("Id sudah digunakan");
                        System.out.println("Ulangi lagi");
                        garisTepi();
                        Thread.sleep(1000);
                        clearConsole();
                    }
                } while (admin.dataId.contains(signUp.Id) || user.dataId.contains(signUp.Id));
                System.out.print("Password Baru : ");
                signUp.password = input.read.readLine();
                garisTepi();
                clearConsole();
                boolean kondisiSignUp1 = true;
                do {
                    System.out.println("=================  SignUp  =================");
                    System.out.println("Nama     : " + data.nama);
                    System.out.println("Alamat   : " + data.alamat);
                    System.out.println("email    : " + data.email);
                    System.out.println("no-HP    : " + data.noHP);
                    System.out.println("hobi     : " + data.hobi);
                    System.out.print("Apakah anda yakin?(Y/N) ");
                    String pilihan = input.read.readLine();
                    garisTepi();
                    clearConsole();
                    if (pilihan.equalsIgnoreCase("y")) {
                        garisTepi();
                        System.out.println("SignUp berhasil");
                        garisTepi();
                        Thread.sleep(500);
                        clearConsole();
                        user.dataNama.add(data.nama);
                        user.dataAlamat.add(data.alamat);
                        user.dataEmail.add(data.email);
                        user.dataNoHP.add(data.noHP);
                        user.dataHobi.add(data.hobi);
                        user.dataId.add(signUp.Id);
                        user.dataPassword.add(signUp.password);
                        kondisiSignUp = false;
                        kondisiSignUp1 = false;
                    } else if (pilihan.equalsIgnoreCase("n")) {
                        garisTepi();
                        System.out.println("SignUp dibatalkan");
                        garisTepi();
                        Thread.sleep(500);
                        clearConsole();
                        kondisiSignUp = false;
                        kondisiSignUp1 = false;
                    } else {
                        garisTepi();
                        pilihanTidakTersedia();
                        System.out.println("Ulangi lagi");
                        garisTepi();
                        Thread.sleep(1000);
                        clearConsole();
                    }
                } while (kondisiSignUp1);
            } else {
                garisTepi();
                pilihanTidakTersedia();
                System.out.println("Ulangi lagi");
                garisTepi();
                Thread.sleep(1000);
                clearConsole();
            }
        } while (kondisiSignUp);
    }

    static void signIn() throws IOException, InterruptedException {
        System.out.println("=================  SignIn  ==================");
        System.out.print("Id Anda  : ");
        signIn.Id = input.read.readLine();
        System.out.print("Password : ");
        signIn.password = input.read.readLine();
        garisTepi();
        clearConsole();
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
        } else {
            garisTepi();
            System.out.println("Id atau password salah");
        }
        garisTepi();
        Thread.sleep(500);
        clearConsole();
    }

    static void lupaPassword() throws IOException, InterruptedException {
        System.out.println("===============  Lupa password  ==============");
        boolean kondisiLupaPassword = true;
        System.out.print("Id Anda   : ");
        String id = input.read.readLine();
        System.out.print("Hobi Anda : ");
        String hobi = input.read.readLine();
        garisTepi();
        clearConsole();
        if (user.dataId.contains(id)) {
            int i = user.dataId.indexOf(id);
            if ((hobi.equalsIgnoreCase(String.valueOf(user.dataHobi.get(i))))) {
                do {
                    System.out.println("===============  Lupa password  ==============");
                    System.out.print("Password baru       : ");
                    String password = input.read.readLine();
                    System.out.print("Password konfirmasi : ");
                    String confirmPassword = input.read.readLine();
                    garisTepi();
                    clearConsole();
                    garisTepi();
                    if (password.equals(confirmPassword)) {
                        user.dataPassword.set(i, password);
                        System.out.println("Password berhasil diubah");
                        garisTepi();
                        Thread.sleep(500);
                        clearConsole();
                        kondisiLupaPassword = false;
                    } else {
                        System.out.println("Ulangi lagi");
                        System.out.println("Password baru & konfirmasi");
                        System.out.println("tidak cocok");
                        garisTepi();
                        Thread.sleep(1500);
                        clearConsole();
                    }
                } while (kondisiLupaPassword);
            } else {
                garisTepi();
                System.out.println("Id atau hobi salah");
                garisTepi();
                Thread.sleep(500);
                clearConsole();
            }
        } else if (admin.dataId.contains(id)) {
            int i = admin.dataId.indexOf(id);
            if (hobi.equalsIgnoreCase(String.valueOf(admin.dataHobi.get(i)))) {
                do {
                    System.out.println("===============  Lupa password  ==============");
                    System.out.print("Password baru       : ");
                    String password = input.read.readLine();
                    System.out.print("Password konfirmasi : ");
                    String confirmPassword = input.read.readLine();
                    garisTepi();
                    clearConsole();
                    garisTepi();
                    if (password.equals(confirmPassword)) {
                        admin.dataPassword.set(i, password);
                        System.out.println("Password berhasil diubah");
                        garisTepi();
                        Thread.sleep(500);
                        clearConsole();
                        kondisiLupaPassword = false;
                    } else {
                        System.out.println("Ulangi lagi");
                        System.out.println("Password baru & konfirmasi");
                        System.out.println("tidak cocok");
                        garisTepi();
                        Thread.sleep(1500);
                        clearConsole();
                    }
                } while (kondisiLupaPassword);
            } else {
                garisTepi();
                System.out.println("Id atau hobi salah");
                garisTepi();
                Thread.sleep(500);
                clearConsole();
            }
        } else {
            garisTepi();
            System.out.println("Id atau hobi salah");
            garisTepi();
            Thread.sleep(500);
            clearConsole();
        }
    }

    static void menuUser(int i) throws IOException, InterruptedException {
        System.out.println("===============  Menu Layanan  ===============");
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
        clearConsole();
        switch (pilihan) {
            case 1:
                System.out.println("===============  Daftar Paket  ===============");
                daftarPaket("tersedia", 1);
                break;
            case 2:
                beliPaket(alamatKantor, noRekeningKantor, noTelpKantor, i);
                break;
            case 3:
                System.out.println("===========  Info Berlangganan  ==============");
                infoPaketBerlangganan(i, 1);
                break;
            case 4:
                berhentiPaket(i);
                break;
            case 5:
                infoAkunUser(i);
                break;
            case 6:
                infoKantor();
                break;
            case 7:
                garisTepi();
                System.out.println("Logout berhasil");
                garisTepi();
                Thread.sleep(500);
                clearConsole();
                user.autentikasi = false;
                break;
            default:
                garisTepi();
                pilihanTidakTersedia();
                garisTepi();
                Thread.sleep(500);
                clearConsole();
        }
    }

    static void menuAdmin(int i) throws IOException, InterruptedException {
        System.out.println("===============  Menu Layanan  ===============");
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
        clearConsole();
        switch (pilihan) {
            case 1:
                daftarInfoPelanggan();
                break;
            case 2:
                System.out.println("===============  Daftar Paket  ===============");
                daftarPaket("ditambahkan", 1);
                break;
            case 3:
                System.out.println("============  Daftar Saluran TV  =============");
                daftarSaluranTV(1);
                break;
            case 4:
                tambahPaket();
                break;
            case 5:
                tambahSaluranTV();
                break;
            case 6:
                validasiPembayaran();
                break;
            case 7:
                infoAkunAdmin(i);
                break;
            case 8:
                infoKantor();
                break;
            case 9:
                garisTepi();
                System.out.println("Logout berhasil");
                garisTepi();
                Thread.sleep(500);
                clearConsole();
                admin.autentikasi = false;
                break;
            default:
                garisTepi();
                pilihanTidakTersedia();
                garisTepi();
                Thread.sleep(500);
                clearConsole();
        }
    }

    static void daftarPaket(String keterangan, int z) throws IOException, InterruptedException {
        if (dataPaket.isEmpty()) {
            System.out.println("Paket belum " + keterangan);
            garisTepi();
            Thread.sleep(500);
            clearConsole();
        } else {
            do {
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
                pilihanKembali(z, "Kembali", "===============  Daftar Paket  ===============");
            } while (kondisiPilihanKembali);
        }
    }

    static void beliPaket(String tempat, String noRekening, String noTelp, int a) throws IOException, InterruptedException {
        System.out.println("================  Beli Paket  ================");
        daftarPaket("tersedia", 0);
        if (!dataPaket.isEmpty()) {
            boolean kondisiBeliPaket = true;
            do {
                System.out.print("Pilih paket: ");
                int pilihan = Integer.valueOf(input.read.readLine());
                garisTepi();
                clearConsole();
                if (pilihan <= dataPaket.size() && pilihan > 0) {
                    boolean kondisiBeliPaket1 = true;
                    do {
                        System.out.println("================  Beli Paket  ================");
                        System.out.println("Mode pembayaran: ");
                        System.out.println("[1]. Bayar langsung ke kantor");
                        System.out.println("[2]. Via ATM");
                        System.out.print("Pilih: ");
                        int i = Integer.valueOf(input.read.readLine());
                        garisTepi();
                        clearConsole();
                        garisTepi();
                        switch (i) {
                            case 1:
//                                boolean kondisiBeliPaket2 = true;
                                do {
                                    System.out.println("Pembayaran langsung dibayarkan");
                                    System.out.println("di " + tempat);
                                    kondisiBeliPaket = false;
                                    kondisiBeliPaket1 = false;
//                                    System.out.println("[0]. Selesai");
//                                    System.out.print("Pilih: ");
//                                    int pilihan1 = Integer.valueOf(input.read.readLine());
//                                    garisTepi();
//                                    clearConsole();
                                    pilihanKembali(1, "Selesai", "=========================================");
//                                    if (pilihan1 != 0) {
//                                        garisTepi();
//                                        pilihanTidakTersedia();
//                                        garisTepi();
//                                        Thread.sleep(500);
//                                        clearConsole();
//                                        garisTepi();
//                                    } else {
//                                        kondisiBeliPaket2 = false;
//                                    }
                                } while (kondisiPilihanKembali);
                                break;
                            case 2:
//                                boolean kondisiBeliPaket3 = true;
                                do {
                                    System.out.println("Pembayaran dikirim ke nomer rekening " + noRekening);
                                    System.out.println("Setelah selesai silahkan upload foto");
                                    System.out.println("bukti pembayaran, nama paket dan id Anda ke");
                                    System.out.format("nomor telepon %s guna memvalidasi pembayaran\n", noTelp);
                                    kondisiBeliPaket = false;
                                    kondisiBeliPaket1 = false;
//                                    System.out.println("[0]. Selesai");
//                                    System.out.print("Pilih: ");
//                                    int pilihan1 = Integer.valueOf(input.read.readLine());
//                                    garisTepi();
//                                    clearConsole();
                                    pilihanKembali(1, "Selesai", "=========================================");
//                                    if (pilihan1 != 0) {
//                                        garisTepi();
//                                        pilihanTidakTersedia();
//                                        garisTepi();
//                                        Thread.sleep(500);
//                                        clearConsole();
//                                        garisTepi();
//                                    } else {
//                                        kondisiBeliPaket3 = false;
//                                    }
                                } while (kondisiPilihanKembali);
                                break;
                            default:
                                pilihanTidakTersedia();
                                System.out.println("Ulangi lagi");
                                garisTepi();
                                Thread.sleep(1000);
                                clearConsole();
                        }
                    } while (kondisiBeliPaket1);
                } else {
                    garisTepi();
                    pilihanTidakTersedia();
                    System.out.println("Ulangi lagi");
                    garisTepi();
                    Thread.sleep(1000);
                    clearConsole();
                    System.out.println("================  Beli Paket  ================");
                    daftarPaket("", 0);
                }
            } while (kondisiBeliPaket);
        }
    }

    static void infoPaketBerlangganan(int i, int z) throws IOException, InterruptedException {
        int n = 1;
        if (dataPelanggan.contains(user.dataId.get(i))) {
            int j = dataPelanggan.indexOf(user.dataId.get(i));
            int o = 0;
            for (int p = 0; p < dataValidasiPembelianPaket[j].length; p++) {
                if (dataValidasiPembelianPaket[j][p] != null) {
                    o++;
                }
            }
            if (o != 0) {
                do {
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
                            System.out.format("     Harga %d\n", Integer.valueOf(String.valueOf(dataHarga.get(l))));
                            System.out.format("     Masa aktif %d hari\n", Integer.valueOf(String.valueOf(dataMasaAktifPaket.get(l))));
                            n++;
                        }
                    }
                    pilihanKembali(z, "Kembali", "===========  Info Berlangganan  ==============");
                } while (kondisiPilihanKembali);
            } else {
                System.out.println("Anda belum membeli paket atau ");
                System.out.println("pembayaran belum divalidasi");
                garisTepi();
                Thread.sleep(2000);
                clearConsole();
            }

        } else {
            System.out.println("Anda belum membeli paket atau ");
            System.out.println("pembayaran belum divalidasi");
            garisTepi();
            Thread.sleep(2000);
            clearConsole();
        }
    }

    static void berhentiPaket(int i) throws IOException, InterruptedException {
        boolean kondisiBerhentiPaket = false;
        do {
            System.out.println("===========  Berhenti Berlangganan  ==========");
            infoPaketBerlangganan(i, 0);
            if (dataPelanggan.contains(user.dataId.get(i))) {
                if (dataValidasiPembelianPaket[dataPelanggan.indexOf(user.dataId.get(i))][0] != null) {
                    System.out.print("Pilih: ");
                    int pilihan = Integer.valueOf(input.read.readLine());
                    garisTepi();
                    clearConsole();
                    garisTepi();
                    int k = 0;
                    for (int j = 0; j < dataValidasiPembelianPaket[i].length; j++) {
                        if (dataValidasiPembelianPaket[i][j] != null) {
                            k++;
                        }
                    }
                    if (pilihan <= k && pilihan > 0) {
                        dataValidasiPembelianPaket[i][pilihan - 1] = null;
                        System.out.format("Paket ke-%d berhasil diberhentikan\n", pilihan);
                        garisTepi();
                        Thread.sleep(1000);
                        clearConsole();
                        for (int j = pilihan - 1; j < dataValidasiPembelianPaket[i].length - 1; j++) {
                            dataValidasiPembelianPaket[i][j] = dataValidasiPembelianPaket[i][j + 1];
                        }
                    } else {
                        pilihanTidakTersedia();
                        System.out.println("Ulangi lagi");
                        garisTepi();
                        Thread.sleep(1000);
                        clearConsole();
                        kondisiBerhentiPaket = true;
                    }
                }
            }
        } while (kondisiBerhentiPaket);
    }

    static void daftarInfoPelanggan() throws IOException, InterruptedException {
        System.out.println("==========  Daftar & Info Pelanggan  =========");
        if (dataPelanggan.isEmpty()) {
            System.out.println("Belum ada pelanggan");
            garisTepi();
            Thread.sleep(500);
            clearConsole();
        } else {
            do {
                for (int i = 0; i < dataPelanggan.size(); i++) {
                    int j = user.dataId.indexOf(dataPelanggan.get(i));
                    System.out.println("Pelanggan ke-" + (i + 1));
                    System.out.format("  Nama   : %s\n", user.dataNama.get(j));
                    System.out.format("  Alamat : %s\n", user.dataAlamat.get(j));
                    System.out.format("  No. HP : %s\n", user.dataNoHP.get(j));
                    System.out.format("  Email  : %s\n", user.dataEmail.get(j));
                    System.out.println("  Paket yang aktif: ");
                    if (dataValidasiPembelianPaket[i][0] != null) {
                        int n = 1;
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
                    } else {
                        System.out.println("  -Tidak ada");
                    }
                }
                pilihanKembali(1, "Kembali", "==========  Daftar & Info Pelanggan  =========");
            } while (kondisiPilihanKembali);
        }
    }

    static void daftarSaluranTV(int z) throws IOException, InterruptedException {
        if (dataSaluranTV.isEmpty()) {
            System.out.println("Saluran TV belum ditambahkan");
            garisTepi();
            Thread.sleep(500);
            clearConsole();
        } else {
            do {
                for (int i = 0; i < dataSaluranTV.size(); i++) {
                    System.out.format("[%d]. %s ", (i + 1), String.valueOf(dataSaluranTV.get(i)));
                    System.out.println();
                }
                pilihanKembali(z, "Kembali", "============  Daftar Saluran TV  =============");
            } while (kondisiPilihanKembali);
        }
    }

    static void tambahPaket() throws IOException, InterruptedException {
        boolean kondisiAddPaket = false;
        do {
            System.out.println("==============  Tambahkan Paket  =============");
            int j = 0;
            if (dataSaluranTV.isEmpty()) {
                System.out.println("Saluran TV belum ditambahkan");
                garisTepi();
                Thread.sleep(500);
                clearConsole();
            } else {
                System.out.print("Nama paket: ");
                data.paket = input.read.readLine();
                data.paket = data.paket.toUpperCase();
                garisTepi();
                clearConsole();
                if (dataPaket.contains(data.paket)) {
                    garisTepi();
                    System.out.println("Nama paket sudah digunakan");
                    System.out.println("Ulangi Lagi");
                    garisTepi();
                    Thread.sleep(1000);
                    clearConsole();
                    kondisiAddPaket = true;
                } else {
                    dataPaket.add(data.paket);
                    ArrayList tempDataSaluranTV = new ArrayList(dataSaluranTV);
                    kondisiAddPaket = false;
                    boolean kondisiAddPaket1 = true;
                    do {
                        System.out.println("==============  Tambahkan Paket  =============");
                        System.out.println("Nama Paket: " + data.paket);
                        System.out.println("Saluran TV:");
                        for (int i = 0; i < tempDataSaluranTV.size(); i++) {
                            System.out.format("[%d]. %s\n", (i + 1), tempDataSaluranTV.get(i));
                        }
                        System.out.print("Pilih saluran TV: ");
                        int i = Integer.valueOf(input.read.readLine());
                        garisTepi();
                        clearConsole();
                        if (i <= tempDataSaluranTV.size() && i > 0) {
                            data.paketSaluranTV = String.valueOf(tempDataSaluranTV.get(i - 1));
                            dataPaketSaluranTV[dataPaket.size() - 1][j] = data.paketSaluranTV;
                            j++;
                            garisTepi();
                            System.out.format("Saluran TV %s berhasil dimasukkan\n", tempDataSaluranTV.get(i - 1));
                            tempDataSaluranTV.remove(i - 1);
                            garisTepi();
                            Thread.sleep(1000);
                            clearConsole();
                            if (tempDataSaluranTV.isEmpty()) {
                                kondisiAddPaket1 = false;
                            } else {
                                boolean kondisiAddPaket2 = true;
                                do {
                                    garisTepi();
                                    System.out.print("Pilih lagi?(Y/N) ");
                                    String pilihan = input.read.readLine();
                                    garisTepi();
                                    clearConsole();
                                    if (pilihan.equalsIgnoreCase("n")) {
                                        kondisiAddPaket1 = false;
                                        kondisiAddPaket2 = false;
                                    } else if (pilihan.equalsIgnoreCase("y")) {
                                        kondisiAddPaket2 = false;
                                    } else {
                                        garisTepi();
                                        pilihanTidakTersedia();
                                        System.out.println("Ulangi lagi");
                                        garisTepi();
                                        Thread.sleep(1000);
                                        clearConsole();
                                    }
                                } while (kondisiAddPaket2);
                            }
                        } else {
                            garisTepi();
                            pilihanTidakTersedia();
                            System.out.println("Ulangi lagi");
                            garisTepi();
                            Thread.sleep(1000);
                            clearConsole();
                        }
                    } while (kondisiAddPaket1);
                    System.out.println("==============  Tambahkan Paket  =============");
                    int k = dataPaket.size();
                    System.out.println("Nama Paket: " + dataPaket.get(k - 1));
                    System.out.println("Saluran TV:");
                    for (int i = 0; i < 10; i++) {
                        if (dataPaketSaluranTV[k - 1][i] != null) {
                            System.out.format("[%d]. %s\n", (i + 1), dataPaketSaluranTV[k - 1][i]);
                        }
                    }
                    System.out.print("Harga paket: ");
                    data.harga = input.read.readLine();
                    dataHarga.add(data.harga);
                    System.out.print("Masa aktif paket(hari): ");
                    int hari = Integer.valueOf(input.read.readLine());
                    dataMasaAktifPaket.add(hari);
                    garisTepi();
                    clearConsole();
                    garisTepi();
                    System.out.format("Paket ke-%d telah tersimpan\n", dataPaket.size());
                    garisTepi();
                    Thread.sleep(1000);
                    clearConsole();
                }
            }
        } while (kondisiAddPaket);
    }

    static void tambahSaluranTV() throws IOException, InterruptedException {
        boolean kondisiAddSaluranTV = true;
        do {
            System.out.println("============  Tambah Saluran TV  =============");
            if (!dataSaluranTV.isEmpty()) {
                System.out.println("Daftar Saluran TV:");
                for (int i = 0; i < dataSaluranTV.size(); i++) {
                    System.out.format("[%d]. %s\n", (i + 1), dataSaluranTV.get(i));
                }
            }
            System.out.print("Tambah saluran TV: ");
            data.saluranTV = input.read.readLine();
            garisTepi();
            clearConsole();
            garisTepi();
            data.saluranTV = data.saluranTV.toUpperCase();
            if (dataSaluranTV.contains(data.saluranTV)) {
                System.out.println("Saluran TV sudah ditambahkan");
                System.out.println("Ulangi lagi");
                garisTepi();
                Thread.sleep(1000);
                clearConsole();
            } else {
                dataSaluranTV.add(data.saluranTV);
                System.out.format("Saluran TV ke-%d telah tersimpan\n", dataSaluranTV.size());
                garisTepi();
                Thread.sleep(1000);
                clearConsole();
                boolean kondisiAddSaluranTV1 = true;
                do {
                    garisTepi();
                    System.out.print("Masukkan lagi?(Y/N) ");
                    String pilihan = input.read.readLine();
                    garisTepi();
                    clearConsole();
                    if (pilihan.equalsIgnoreCase("y")) {
                        kondisiAddSaluranTV1 = false;
                    } else if (pilihan.equalsIgnoreCase("n")) {
                        kondisiAddSaluranTV = false;
                        kondisiAddSaluranTV1 = false;
                    } else {
                        garisTepi();
                        pilihanTidakTersedia();
                        System.out.println("Ulangi lagi");
                        garisTepi();
                        Thread.sleep(1000);
                        clearConsole();
                    }
                } while (kondisiAddSaluranTV1);
            }
        } while (kondisiAddSaluranTV);
    }

    static void infoAkunUser(int i) throws IOException, InterruptedException {
        System.out.println("=================  Info Akun  ================");
        do {
            System.out.format("-Nama   : %s\n", user.dataNama.get(i));
            System.out.format("-Alamat : %s\n", user.dataAlamat.get(i));
            System.out.format("-Hobi   : %s\n", user.dataHobi.get(i));
            System.out.format("-No. HP : %s\n", user.dataNoHP.get(i));
            System.out.format("-Email  : %s\n", user.dataEmail.get(i));
            pilihanKembali(1, "Kembali", "=================  Info Akun  ================");
        } while (kondisiPilihanKembali);
    }

    static void infoAkunAdmin(int i) throws IOException, InterruptedException {
        System.out.println("=================  Info Akun  ================");
        do {
            System.out.format("-Nama\t: %s\n", admin.dataNama.get(i));
            System.out.format("-Alamat\t: %s\n", admin.dataAlamat.get(i));
            System.out.format("-Hobi\t: %s\n", admin.dataHobi.get(i));
            System.out.format("-No. HP\t: %s\n", admin.dataNoHP.get(i));
            System.out.format("-Email\t: %s\n", admin.dataEmail.get(i));
            pilihanKembali(1, "Kembali", "=================  Info Akun  ================");
        } while (kondisiPilihanKembali);
    }

    static void validasiPembayaran() throws IOException, InterruptedException {
        System.out.println("===========  Validasi Pembayaran  ============");
        if (user.dataId.isEmpty()) {
            System.out.println("Belum ada Id User");
            System.out.println("Validasi dibatalkan");
            garisTepi();
            Thread.sleep(1000);
            clearConsole();
        } else {
            boolean kondisiValidasiPembayaran = true;
            do {
                System.out.println("Daftar Id User:");
                for (int i = 0; i < user.dataId.size(); i++) {
                    System.out.format("[%d]. %s\n", (i + 1), user.dataId.get(i));
                }
                System.out.print("Pilih: ");
                int pilihan = Integer.valueOf(input.read.readLine());
                garisTepi();
                clearConsole();
                if (pilihan <= user.dataId.size() && pilihan > 0) {
                    kondisiValidasiPembayaran = false;
                    System.out.println("===========  Validasi Pembayaran  ============");
                    if (dataPaket.isEmpty()) {
                        System.out.println("Belum ada paket");
                        System.out.println("Validasi dibatalkan");
                        garisTepi();
                        Thread.sleep(1000);
                        clearConsole();
                    } else {
                        boolean kondisiValidasiPembayaran1 = true;
                        do {
                            System.out.println("Daftar Paket:");
                            for (int i = 0; i < dataPaket.size(); i++) {
                                System.out.format("[%d]. %s\n", (i + 1), dataPaket.get(i));
                            }
                            System.out.print("Pilih: ");
                            int pilihan1 = Integer.valueOf(input.read.readLine());
                            garisTepi();
                            clearConsole();
                            if (pilihan1 <= dataPaket.size() && pilihan1 > 0) {
                                kondisiValidasiPembayaran1 = false;
                                boolean kondisiValidasiPembayaran2 = true;
                                do {
                                    System.out.println("===========  Validasi Pembayaran  ============");
                                    System.out.println("Id User          : " + user.dataId.get(pilihan - 1));
                                    System.out.println("Paket yang dibeli: " + dataPaket.get(pilihan1 - 1));
                                    System.out.print("Apakah anda yakin?(Y/N) ");
                                    String pilihan2 = input.read.readLine();
                                    garisTepi();
                                    clearConsole();
                                    if (pilihan2.equalsIgnoreCase("y")) {
                                        if (dataPelanggan.contains(user.dataId.get(pilihan - 1))) {
                                            int i = dataPelanggan.indexOf(user.dataId.get(pilihan - 1));
                                            for (int j = 0; j < dataValidasiPembelianPaket[i].length; j++) {
                                                if (dataValidasiPembelianPaket[i][j] == null) {
                                                    dataValidasiPembelianPaket[i][j] = String.valueOf(dataPaket.get(pilihan1 - 1));
                                                    break;
                                                }
                                            }
                                        } else {
                                            dataPelanggan.add(user.dataId.get(pilihan - 1));
                                            int i = dataPelanggan.size() - 1;
                                            for (int j = 0; j < dataValidasiPembelianPaket[i].length; j++) {
                                                if (dataValidasiPembelianPaket[i][j] == null) {
                                                    dataValidasiPembelianPaket[i][i] = String.valueOf(dataPaket.get(pilihan1 - 1));
                                                    break;
                                                }
                                            }
                                        }
                                        garisTepi();
                                        System.out.println("Validasi sukses");
                                        garisTepi();
                                        Thread.sleep(500);
                                        clearConsole();
                                        kondisiValidasiPembayaran2 = false;
                                    } else if (pilihan2.equalsIgnoreCase("n")) {
                                        garisTepi();
                                        System.out.println("Validasi dibatalkan");
                                        garisTepi();
                                        Thread.sleep(500);
                                        clearConsole();
                                        kondisiValidasiPembayaran2 = false;
                                    } else {
                                        garisTepi();
                                        pilihanTidakTersedia();
                                        System.out.println("Ulangi lagi");
                                        garisTepi();
                                        Thread.sleep(1000);
                                        clearConsole();
                                    }
                                } while (kondisiValidasiPembayaran2);
                            } else {
                                garisTepi();
                                pilihanTidakTersedia();
                                System.out.println("Ulangi lagi");
                                garisTepi();
                                Thread.sleep(1000);
                                clearConsole();
                                System.out.println("===========  Validasi Pembayaran  ============");
                            }
                        } while (kondisiValidasiPembayaran1);
                    }
                } else {
                    garisTepi();
                    pilihanTidakTersedia();
                    System.out.println("Ulangi lagi");
                    garisTepi();
                    Thread.sleep(1000);
                    clearConsole();
                    System.out.println("===========  Validasi Pembayaran  ============");
                }
            } while (kondisiValidasiPembayaran);
        }
    }

    static void infoKantor() throws IOException, InterruptedException {
        System.out.println("===============  Info Kantor  ================");
        do {
            if (alamatKantor != null) {
                System.out.format("- Alamat kantor        : %s\n", alamatKantor);
                System.out.format("- No. rekening kantor  : %s\n", noRekeningKantor);
                System.out.format("- No. telepon kantor   : %s\n", noTelpKantor);
            } else {
                System.out.println("Informasi kantor belum tersedia");
            }
            pilihanKembali(1, "Kembali", "===============  Info Kantor  ================");
        } while (kondisiPilihanKembali);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        clearConsole();
        do {
            menuSelamatDatang();
            while (user.autentikasi) {
                menuUser(user.indeks);
            }
            while (admin.autentikasi) {
                if (alamatKantor == null) {
                    garisTepi();
                    System.out.println("Informasi kantor masih kosong");
                    System.out.println("Harap diisi");
                    garisTepi();
                    Thread.sleep(1000);
                    clearConsole();
                    garisTepi();
                    System.out.print("Alamat kantor sayaTV       : ");
                    alamatKantor = input.read.readLine();
                    System.out.print("No. rekening kantor sayaTV : ");
                    noRekeningKantor = input.read.readLine();
                    System.out.print("No. Telp kantor sayaTV     : ");
                    noTelpKantor = input.read.readLine();
                    garisTepi();
                    clearConsole();
                }
                menuAdmin(admin.indeks);
            }
        } while (kondisiMain);
    }
}
