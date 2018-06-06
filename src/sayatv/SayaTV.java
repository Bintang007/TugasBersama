/*
 * The MIT License
 *
 * Copyright 2018 STAR.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package sayatv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author timBersama
 */
public class SayaTV {

    // Membuat objek untuk merekam inputan dari keyboard 
    private static final InputStreamReader SCAN = new InputStreamReader(System.in);
    private final BufferedReader READ = new BufferedReader(SCAN);

    // Membuat objek - objek yang dibutuhkan untuk menyimpan inputan DATA yang
    // nantinya sangat dibutuhkan selama menjalankan program
    private final ArrayList DATA_ID = new ArrayList();
    private final ArrayList DATA_PASSWORD = new ArrayList();
    private final ArrayList DATA_EMAIL = new ArrayList();
    private final ArrayList DATA_ALAMAT = new ArrayList();
    private final ArrayList DATA_NAMA = new ArrayList();
    private final ArrayList DATA_NO_HP = new ArrayList();
    private final ArrayList dataHobi = new ArrayList();
    private static final ArrayList DATA_PAKET = new ArrayList();
    private static final ArrayList<Integer> DATA_HARGA = new ArrayList<>();
    private static final ArrayList DATA_SALURAN_TV = new ArrayList();
    private static final String[][] DATA_PAKET_SALURAN_TV = new String[100][100];
    private static final ArrayList DATA_PELANGGAN = new ArrayList();
    private static final ArrayList<Integer> DATA_MASA_AKTIF_PAKET = new ArrayList<>();
    private static final String[][] DATA_VALIDASI_PEMBELIAN_PAKET = new String[100][100];

    // Membuat variabel - variabel yang dibutuhkan untuk menampung semantara inputan
    // DATA sebelum DATA tersebut disimpan
    private String paketSaluranTV;
    private String saluranTV;
    private String nama;
    private String Id;
    private String password;
    private String alamat;
    private String paket;
    private String email;
    private String hobi;
    private String noHP;
    private boolean autentikasi;
    private int indeks;
    private static String alamatKantor;
    private static String noRekeningKantor;
    private static String noTelpKantor;

    // Instansi dan inisialisasi objek dengan konstruktor class SayaTV
    private static final SayaTV DATA = new SayaTV();
    private static final SayaTV INPUT = new SayaTV();
    private static final SayaTV SIGN_IN = new SayaTV();
    private static final SayaTV SIGN_UP = new SayaTV();
    private static final SayaTV USER = new SayaTV();
    private static final SayaTV ADMIN = new SayaTV();

    // Static variabel yang dapat diakses di semua method/function
    private static boolean kondisiMain = true;
    private static boolean kondisiPilihanKembali;
    private static boolean kondisiPilihanUbah;
    private static int pilihanKembaliAtauUbah;

    /**
     * Memunculkan pesan yang bertuliskan Selamat Datang dengan ditampilkan
     * secara bergerak dari kanan ke kiri dalam satu baris atau dapat dikatakan
     * terlihat seperti pesan berjalan. Untuk menampilkan pesan ini seakan
     * berjalan maka diharuskan me-run program ini menggunakan terminal apapun
     * (Contoh: cmd dan windows powershell)
     *
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void pesanSelamatDatang() throws IOException, InterruptedException {
        for (int i = 0; i < 28; i++) {
            garisTepi();
            for (int j = i; j < 28; j++) {
                System.out.print(" ");
            }
            System.out.println("Selamat Datang ^-^");
            garisTepi();
            Thread.sleep(100);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }

    /**
     * Memunculkan pesan yang bertuliskan Sampai jumpa dengan ditampilkan secara
     * bergerak dari kanan ke kiri dalam satu baris atau dapat dikatakan
     * terlihat seperti pesan berjalan. Untuk menampilkan pesan ini seakan
     * berjalan maka diharuskan me-run program ini menggunakan terminal apapun
     * (Contoh: cmd dan windows powershell)
     *
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void pesanSempaiJumpa() throws IOException, InterruptedException {
        for (int i = 0; i < 30; i++) {
            garisTepi();
            for (int j = i; j < 30; j++) {
                System.out.print(" ");
            }
            System.out.println("Sampai jumpa ^-^");
            garisTepi();
            Thread.sleep(100);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }

    /**
     * Menghapus semua log yang telah ditampilkan sebelumnya. Untuk dapat
     * menjalankan fitur ini diharuskan menjalankan program dengan terminal
     *
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void clearConsole() throws IOException, InterruptedException {
        Thread.sleep(500);
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    /**
     * menampikan untaian simbol sama dengan '=' sebanyak 46 buah
     */
    public static void garisTepi() {
        System.out.println("==============================================");
    }

    /**
     * Menampilkan fitur kembali (untuk kembali ke menu sebelumnya) dan ubah
     * (untuk mengubah isi dari suatu entitas yang dimaksud)
     *
     * @param kondisiKembali jika bernilai benar maka akan menampikan fitur
     * untuk kembali ke langkah sebelumnya jika tidak maka tidak berlaku
     * @param kondisiUbah Jika bernilai benar maka akan menampilkan fitur untuk
     * merubah suatu entitas yang dimaksud
     * @param keterangan keterangan yang akan ditampilkan pada pilihan ke-0
     * @param keteranganMenu keterangan untuk menampilan keterangan menu di
     * suatu entitas yang dimaksud
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void pilihanKembaliAtauUbah(boolean kondisiKembali, boolean kondisiUbah, String keterangan, String keteranganMenu) throws IOException, InterruptedException {
        try {
            if (kondisiKembali) {
                if (kondisiUbah) {
                    System.out.println("[1]. Ubah");
                }
                System.out.println("[0]. " + keterangan);
                System.out.print("Pilih: ");
                pilihanKembaliAtauUbah = Integer.valueOf(INPUT.READ.readLine());
                garisTepi();
                clearConsole();
                if (!kondisiUbah) {
                    if (pilihanKembaliAtauUbah != 0) {
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
                } else {
                    switch (pilihanKembaliAtauUbah) {
                        case 1:
                            kondisiPilihanKembali = true;
                            kondisiPilihanUbah = true;
                            break;
                        case 0:
                            kondisiPilihanKembali = false;
                            break;
                        default:
                            garisTepi();
                            pilihanTidakTersedia();
                            System.out.println("Ulangi lagi");
                            garisTepi();
                            Thread.sleep(1000);
                            clearConsole();
                            System.out.println(keteranganMenu);
                            kondisiPilihanKembali = true;
                    }
                }
            }
        } catch (NumberFormatException nfe) {
            inputTidakValid();
            System.out.println(keteranganMenu);
            kondisiPilihanKembali = true;
        }
    }

    /**
     * Menampikan pesan "Pilihan tidak tersedia"
     */
    public static void pilihanTidakTersedia() {
        System.out.println("Pilihan tidak tersedia");
    }

    /**
     * Menampilkan pesan "INPUT tidak valid" dengan dijeda selama 0,5 detik
     * sebelum pesan tersebut menghilang
     *
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void inputTidakValid() throws IOException, InterruptedException {
        garisTepi();
        clearConsole();
        garisTepi();
        System.out.println("Input tidak valid");
        garisTepi();
        Thread.sleep(500);
        clearConsole();
    }

    /**
     * menampikan den menginputkan formulir pendaftaran (nama, alamat, email, no
     * mer HP dan hobi) secara bergantian
     *
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     */
    public static void formulirPendaftaran() throws IOException {
        System.out.print("Nama     : ");
        DATA.nama = INPUT.READ.readLine();
        System.out.print("Alamat   : ");
        DATA.alamat = INPUT.READ.readLine();
        System.out.print("email    : ");
        DATA.email = INPUT.READ.readLine();
        System.out.print("no-HP    : ");
        DATA.noHP = INPUT.READ.readLine();
        System.out.print("hobi     : ");
        DATA.hobi = INPUT.READ.readLine();
    }

    /**
     * Menampikan menu awal yang berisikan pilihan SignIn/login, SignUp/daftar
     * akun sebagai USER atau ADMIN, lupa password, dan keluar aplikasi. Serta
     * instruksi - intruksi untuk memproses pilahan yang telah dipilih
     *
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void menuSelamatDatang() throws IOException, InterruptedException {
        try {
            System.out.println("==============  Selamat Datang  ==============");
            System.out.println("[1]. SignIn");
            System.out.println("[2]. SignUp");
            System.out.println("[3]. Lupa password");
            System.out.println("[4]. Keluar Aplikasi");
            System.out.print("Pilih: ");
            int pilihan = Integer.valueOf(INPUT.READ.readLine());
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
                    clearConsole();
            }
        } catch (NumberFormatException nfe) {
            inputTidakValid();
        }
    }

    /**
     * Berisi tahap - tahapan yang harus dilewati untuk membuat akun (sebagai
     * USER/ ADMIN). Setelah selesai melewati tahap - tahapan tersebut maka DATA
     * - DATA yang telah terinputkan akan tersinmpan secara otomatis di dalam
     * berbagai object ArrayList yang telah di deklar sebelumnya
     *
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void signUp() throws IOException, InterruptedException {
        boolean kondisiSignUp = true;
        do {
            System.out.println("=================  SignUp  =================");
            System.out.print("Daftar sebagai (admin/user) ");
            String jawaban = INPUT.READ.readLine();
            garisTepi();
            clearConsole();
            if (jawaban.equalsIgnoreCase("admin")) {
                System.out.println("=================  SignUp  =================");
                System.out.print("Kode admin: ");
                String kode = INPUT.READ.readLine();
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
                        SIGN_UP.Id = INPUT.READ.readLine();
                        if (ADMIN.DATA_ID.contains(SIGN_UP.Id) || USER.DATA_ID.contains(SIGN_UP.Id)) {
                            garisTepi();
                            clearConsole();
                            garisTepi();
                            System.out.println("Id sudah digunakan");
                            System.out.println("Ulangi lagi");
                            garisTepi();
                            Thread.sleep(1000);
                            clearConsole();
                        }
                    } while (ADMIN.DATA_ID.contains(SIGN_UP.Id) || USER.DATA_ID.contains(SIGN_UP.Id));
                    System.out.print("Password baru : ");
                    SIGN_UP.password = INPUT.READ.readLine();
                    garisTepi();
                    clearConsole();
                    boolean kondisiSignUp1 = true;
                    do {
                        System.out.println("=================  SignUp  =================");
                        System.out.println("Nama     : " + DATA.nama);
                        System.out.println("Alamat   : " + DATA.alamat);
                        System.out.println("email    : " + DATA.email);
                        System.out.println("no-HP    : " + DATA.noHP);
                        System.out.println("hobi     : " + DATA.hobi);
                        System.out.print("Apakah anda yakin?(Y/N) ");
                        String pilihan = INPUT.READ.readLine();
                        garisTepi();
                        clearConsole();
                        if (pilihan.equalsIgnoreCase("y")) {
                            garisTepi();
                            System.out.println("SignUp berhasil");
                            garisTepi();
                            Thread.sleep(500);
                            clearConsole();
                            ADMIN.DATA_NAMA.add(DATA.nama);
                            ADMIN.DATA_ALAMAT.add(DATA.alamat);
                            ADMIN.DATA_EMAIL.add(DATA.email);
                            ADMIN.DATA_NO_HP.add(DATA.noHP);
                            ADMIN.dataHobi.add(DATA.hobi);
                            ADMIN.DATA_ID.add(SIGN_UP.Id);
                            ADMIN.DATA_PASSWORD.add(SIGN_UP.password);
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
                    SIGN_UP.Id = INPUT.READ.readLine();
                    if (ADMIN.DATA_ID.contains(SIGN_UP.Id) || USER.DATA_ID.contains(SIGN_UP.Id)) {
                        garisTepi();
                        clearConsole();
                        garisTepi();
                        System.out.println("Id sudah digunakan");
                        System.out.println("Ulangi lagi");
                        garisTepi();
                        Thread.sleep(1000);
                        clearConsole();
                    }
                } while (ADMIN.DATA_ID.contains(SIGN_UP.Id) || USER.DATA_ID.contains(SIGN_UP.Id));
                System.out.print("Password Baru : ");
                SIGN_UP.password = INPUT.READ.readLine();
                garisTepi();
                clearConsole();
                boolean kondisiSignUp1 = true;
                do {
                    System.out.println("=================  SignUp  =================");
                    System.out.println("Nama     : " + DATA.nama);
                    System.out.println("Alamat   : " + DATA.alamat);
                    System.out.println("email    : " + DATA.email);
                    System.out.println("no-HP    : " + DATA.noHP);
                    System.out.println("hobi     : " + DATA.hobi);
                    System.out.print("Apakah anda yakin?(Y/N) ");
                    String pilihan = INPUT.READ.readLine();
                    garisTepi();
                    clearConsole();
                    if (pilihan.equalsIgnoreCase("y")) {
                        garisTepi();
                        System.out.println("SignUp berhasil");
                        garisTepi();
                        Thread.sleep(500);
                        clearConsole();
                        USER.DATA_NAMA.add(DATA.nama);
                        USER.DATA_ALAMAT.add(DATA.alamat);
                        USER.DATA_EMAIL.add(DATA.email);
                        USER.DATA_NO_HP.add(DATA.noHP);
                        USER.dataHobi.add(DATA.hobi);
                        USER.DATA_ID.add(SIGN_UP.Id);
                        USER.DATA_PASSWORD.add(SIGN_UP.password);
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

    /**
     * Sebagai tahapan untuk dapat mengakses sistem lebih lanjut sebagai
     * USER/ADMIN yang memiliki hak akses berbeda. Tahapan tersebut yakni
     * memasukkan Id dan password. Jika kedua entitas tersebut dinilai cocok
     * dimana posisi urutan suatu indeks id sama dengan indeks password maka
     * akan berhasil jika tidak maka akan menampilkan pesan "id atau password
     * salah". Jika pada saat berhasil masuk maka akan ada suatu variabel yang
     * menampung indeks DATA id (USER/ADMIN) tertentu yang nantinya dibutuhkan
     * untuk mengakses DATA DATA yang sesuai dengan indeks tersebut pada saat
     * memasuki menu USER/ADMIN
     *
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void signIn() throws IOException, InterruptedException {
        System.out.println("=================  SignIn  ==================");
        System.out.print("Id Anda  : ");
        SIGN_IN.Id = INPUT.READ.readLine();
        System.out.print("Password : ");
        SIGN_IN.password = INPUT.READ.readLine();
        garisTepi();
        clearConsole();
        if (ADMIN.DATA_ID.contains(SIGN_IN.Id)) {
            int i = ADMIN.DATA_ID.indexOf(SIGN_IN.Id);
            garisTepi();
            if (SIGN_IN.password.equals(ADMIN.DATA_PASSWORD.get(i))) {
                System.out.println("Login berhasil");
                ADMIN.autentikasi = true;
                ADMIN.indeks = i;
            } else {
                System.out.println("Id atau password salah");
            }
        } else if (USER.DATA_ID.contains(SIGN_IN.Id)) {
            int i = USER.DATA_ID.indexOf(SIGN_IN.Id);
            garisTepi();
            if (SIGN_IN.password.equals(USER.DATA_PASSWORD.get(i))) {
                System.out.println("Login berhasil");
                USER.autentikasi = true;
                USER.indeks = i;
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

    /**
     * sebagai cara jika USER atau ADMIN lupa password. Dibutuhkan id beserta
     * hobi. Jika id dan hobi yang diinputkan sama dengan indeks id dan indeks
     * hobi yang sama dengan indeks id maka berhasil jika tidak akan menampilkan
     * pesan "id atau hobi salah"
     *
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void lupaPassword() throws IOException, InterruptedException {
        System.out.println("===============  Lupa password  ==============");
        boolean kondisiLupaPassword = true;
        System.out.print("Id Anda   : ");
        String id = INPUT.READ.readLine();
        System.out.print("Hobi Anda : ");
        String hobi = INPUT.READ.readLine();
        garisTepi();
        clearConsole();
        if (USER.DATA_ID.contains(id)) {
            int i = USER.DATA_ID.indexOf(id);
            if ((hobi.equalsIgnoreCase(String.valueOf(USER.dataHobi.get(i))))) {
                do {
                    System.out.println("===============  Lupa password  ==============");
                    System.out.print("Password baru       : ");
                    String password = INPUT.READ.readLine();
                    System.out.print("Password konfirmasi : ");
                    String confirmPassword = INPUT.READ.readLine();
                    garisTepi();
                    clearConsole();
                    garisTepi();
                    if (password.equals(confirmPassword)) {
                        USER.DATA_PASSWORD.set(i, password);
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
        } else if (ADMIN.DATA_ID.contains(id)) {
            int i = ADMIN.DATA_ID.indexOf(id);
            if (hobi.equalsIgnoreCase(String.valueOf(ADMIN.dataHobi.get(i)))) {
                do {
                    System.out.println("===============  Lupa password  ==============");
                    System.out.print("Password baru       : ");
                    String password = INPUT.READ.readLine();
                    System.out.print("Password konfirmasi : ");
                    String confirmPassword = INPUT.READ.readLine();
                    garisTepi();
                    clearConsole();
                    garisTepi();
                    if (password.equals(confirmPassword)) {
                        ADMIN.DATA_PASSWORD.set(i, password);
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

    /**
     * berisikan pilihan - pilihan yang hanya dapat diakses oleh USER dimana
     * hanya dapat mengakses DATA - DATA dengan indeks yang sama terhadap indeks
     * USER tertentu
     *
     * @param i indeks id USER yang berhasil SignIn/login
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void menuUser(int i) throws IOException, InterruptedException {
        try {
            System.out.println("===============  Menu Layanan  ===============");
            System.out.println("[1]. Daftar paket");
            System.out.println("[2]. Beli paket berlangganan");
            System.out.println("[3]. Info paket berlangganan");
            System.out.println("[4]. Berhenti berlangganan");
            System.out.println("[5]. Info akun");
            System.out.println("[6]. Info Kantor");
            System.out.println("[7]. Logout");
            System.out.print("Pilih: ");
            int pilihan = Integer.valueOf(INPUT.READ.readLine());
            garisTepi();
            clearConsole();
            switch (pilihan) {
                case 1:
                    daftarPaket("tersedia");
                    break;
                case 2:
                    beliPaket(alamatKantor, noRekeningKantor, noTelpKantor);
                    break;
                case 3:
                    infoPaketBerlangganan(i);
                    break;
                case 4:
                    berhentiPaket(i);
                    break;
                case 5:
                    infoAkunUser(i);
                    break;
                case 6:
                    infoKantor(false);
                    break;
                case 7:
                    garisTepi();
                    System.out.println("Logout berhasil");
                    garisTepi();
                    Thread.sleep(500);
                    clearConsole();
                    USER.autentikasi = false;
                    break;
                default:
                    garisTepi();
                    pilihanTidakTersedia();
                    garisTepi();
                    Thread.sleep(500);
                    clearConsole();
            }
        } catch (NumberFormatException nfe) {
            inputTidakValid();
        }
    }

    /**
     * berisikan pilihan - pilihan yang hanya dapat diakses oleh ADMIN dimana
     * hanya dapat mengakses DATA - DATA dengan indeks yang sama terhadap indeks
     * ADMIN tertentu
     *
     * @param i indeks id ADMIN yang berhasil SignIn/login
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void menuAdmin(int i) throws IOException, InterruptedException {
        try {
            System.out.println("===============  Menu Layanan  ===============");
            System.out.println("[1]. Daftar & Info Pelanggan");
            System.out.println("[2]. Daftar Paket");
            System.out.println("[3]. Daftar Saluran TV");
            System.out.println("[4]. Tambahkan Paket");
            System.out.println("[5]. Tambahkan saluran TV");
            System.out.println("[6]. Validasi Pembayaran Paket");
            System.out.println("[7]. Info Akun");
            System.out.println("[8]. Info Kantor");
            System.out.println("[9]. Cari Pelanggan dengan Paket Tertentu");
            System.out.println("[10]. Logout");
            System.out.print("Pilih: ");
            int pilihan = Integer.valueOf(INPUT.READ.readLine());
            garisTepi();
            clearConsole();
            switch (pilihan) {
                case 1:
                    daftarInfoPelanggan();
                    break;
                case 2:
                    daftarPaket("ditambahkan");
                    break;
                case 3:
                    daftarSaluranTV();
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
                    infoKantor(true);
                    break;
                case 9:
                    cariPelangganPaket();
                    break;
                case 10:
                    garisTepi();
                    System.out.println("Logout berhasil");
                    garisTepi();
                    Thread.sleep(500);
                    clearConsole();
                    ADMIN.autentikasi = false;
                    break;
                default:
                    garisTepi();
                    pilihanTidakTersedia();
                    garisTepi();
                    Thread.sleep(500);
                    clearConsole();
            }
        } catch (NumberFormatException nfe) {
            inputTidakValid();
        }
    }

    /**
     * Digunakan untuk mencari pelanggan dengan paket tertentu.
     *
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void cariPelangganPaket() throws IOException, InterruptedException {
        System.out.println("======= Pelanggan dengan Paket Tertentu ======");
        System.out.print("Cari: ");
        String cari = INPUT.READ.readLine();
        garisTepi();
        clearConsole();
        System.out.println("======= Pelanggan dengan Paket Tertentu ======");
        do {
            System.out.println("Hasil:");
            int cek = 0;
            for (int i = 0; i < DATA_PAKET.size(); i++) {
                if (cari.equalsIgnoreCase(String.valueOf(DATA_PAKET.get(i)))) {
                    for (int j = 0; j < DATA_PELANGGAN.size(); j++) {
                        int jumlahPaket = 0;
                        for (int k = 0; k < DATA_VALIDASI_PEMBELIAN_PAKET[j].length; k++) {
                            if (DATA_VALIDASI_PEMBELIAN_PAKET[j][k] != null) {
                                if (cari.equalsIgnoreCase(DATA_VALIDASI_PEMBELIAN_PAKET[j][k])) {
                                    jumlahPaket++;
                                }
                            } else {
                                break;
                            }
                        }
                        if (jumlahPaket > 0) {
                            System.out.format("Pelanggan ke-%d: %s\tJumlah paket %s: %dx\n", (j + 1), DATA_PELANGGAN.get(j), DATA_PAKET.get(i), jumlahPaket);
                            cek++;
                        }
                    }
                }
            }
            if (cek == 0) {
                System.out.println("Tidak ada Pelanggan dengan Paket " + cari);
                garisTepi();
                Thread.sleep(2000);
                clearConsole();
            } else {
                pilihanKembaliAtauUbah(true, false, "Kembali", "======= Pelanggan dengan Paket Tertentu ======");
            }
        } while (kondisiPilihanKembali);
    }

    /**
     * Menampikan daftar - daftar paket beserta saluran tv, harga dan masa akrif
     * yang sebelumnya telah diinputkan oleh USER
     *
     * @param keterangan ketarangan yang nantinya ditampikan disamping tulisan
     * "Paket belum "
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void daftarPaket(String keterangan) throws IOException, InterruptedException {
        System.out.println("===============  Daftar Paket  ===============");
        if (DATA_PAKET.isEmpty()) {
            System.out.println("Paket belum " + keterangan);
            garisTepi();
            Thread.sleep(500);
            clearConsole();
        } else {
            do {
                for (int i = 0; i < DATA_PAKET.size(); i++) {
                    System.out.format("- Paket %s\n", String.valueOf(DATA_PAKET.get(i)));
                    System.out.println("     Saluran TV : ");
                    for (int j = 0; j < DATA_PAKET_SALURAN_TV[i].length; j++) {
                        if (DATA_PAKET_SALURAN_TV[i][j] != null) {
                            System.out.format("         %d. %s\n", (j + 1), String.valueOf(DATA_PAKET_SALURAN_TV[i][j]));
                        }
                    }
                    System.out.format("     Harga %d", Integer.valueOf(String.valueOf(DATA_HARGA.get(i))));
                    System.out.println();
                    System.out.format("     Masa aktif %d hari", Integer.valueOf(String.valueOf(DATA_MASA_AKTIF_PAKET.get(i))));
                    System.out.println();
                }
                pilihanKembaliAtauUbah(true, false, "Kembali", "===============  Daftar Paket  ===============");
            } while (kondisiPilihanKembali);
        }
    }

    /**
     * digunakan oleh USER jika ingin membeli paket. Menampilkan daftar paket
     * yang berisikan nama paket, saluran TV, harga, dan masa aktif sebelum USER
     * memilih paket. Serta terdapat fitur untuk mengurutkan daftar paket. Fitur
     * tersebut antara lain mengurutkan dari pembelian terbanyak, termahal, dan
     * termurah
     *
     * @param tempat alamat kantor SayaTV
     * @param noRekening nomer rekening kantor SayaTV
     * @param noTelp nomer telepon kantor SayaTV
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void beliPaket(String tempat, String noRekening, String noTelp) throws IOException, InterruptedException {
        System.out.println("================  Beli Paket  ================");
        if (!DATA_PAKET.isEmpty()) {
            ArrayList tempDataPaket = new ArrayList(DATA_PAKET);
            String[][] tempDataPaketSaluranTV = new String[100][100];
            for (int i = 0; i < DATA_PAKET_SALURAN_TV.length; i++) {
                for (int j = 0; j < DATA_PAKET_SALURAN_TV[i].length; j++) {
                    tempDataPaketSaluranTV[i][j] = DATA_PAKET_SALURAN_TV[i][j];
                }
            }
            ArrayList tempDataHarga = new ArrayList(DATA_HARGA);
            ArrayList tempDataMasaAktifPaket = new ArrayList(DATA_MASA_AKTIF_PAKET);
            boolean kondisiBeliPaket = true;
            boolean kondisiBeliPaket1 = true;
            do {
                try {
                    do {
                        for (int i = 0; i < tempDataPaket.size(); i++) {
                            System.out.format("[%d]. Paket %s\n", (i + 1), String.valueOf(tempDataPaket.get(i)));
                            System.out.println("     Saluran TV : ");
                            for (int j = 0; j < tempDataPaketSaluranTV[i].length; j++) {
                                if (tempDataPaketSaluranTV[i][j] != null) {
                                    System.out.format("         %d. %s\n", (j + 1), String.valueOf(tempDataPaketSaluranTV[i][j]));
                                }
                            }
                            System.out.format("     Harga %d", Integer.valueOf(String.valueOf(tempDataHarga.get(i))));
                            System.out.println();
                            System.out.format("     Masa aktif %d hari", Integer.valueOf(String.valueOf(tempDataMasaAktifPaket.get(i))));
                            System.out.println();
                        }
                        if (tempDataHarga.size() > 1 && kondisiBeliPaket1 == true) {
                            System.out.print("Apakah ingin disortir?(Y/N) ");
                            String jawabSortir = INPUT.READ.readLine();
                            garisTepi();
                            clearConsole();
                            if (jawabSortir.equalsIgnoreCase("y")) {
                                boolean kondisiBeliPaket2 = true;
                                do {
                                    try {
                                        garisTepi();
                                        System.out.println("Berdasarkan:");
                                        System.out.println("1.Terpopuler\n2.Termahal\n3.Termurah");
                                        System.out.print("Pilih: ");
                                        int jawabBerdasarkan = Integer.valueOf(INPUT.READ.readLine());
                                        garisTepi();
                                        clearConsole();
                                        String tempPaket;
                                        String tempHarga;
                                        String tempMasaAktifPaket;
                                        String[][] tempPaketSaluranTV = new String[100][100];
                                        switch (jawabBerdasarkan) {
                                            case 1:
                                                garisTepi();
                                                System.out.println("Sorry, we cant run this feature");
                                                garisTepi();
                                                Thread.sleep(3000);
                                                clearConsole();
                                                System.out.println("================  Beli Paket  ================");
                                                kondisiBeliPaket2 = false;
                                                break;
                                            case 2:
                                                for (int i = 0; i < tempDataHarga.size() - 1; i++) {
                                                    for (int j = i; j < tempDataHarga.size(); j++) {
                                                        if (String.valueOf(tempDataHarga.get(i)).compareTo(String.valueOf(tempDataHarga.get(j))) < 0) {
                                                            tempPaket = String.valueOf(tempDataPaket.get(j));
                                                            tempDataPaket.set(j, tempDataPaket.get(i));
                                                            tempDataPaket.set(i, tempPaket);
                                                            for (int k = 0; k < tempPaketSaluranTV[j].length; k++) {
                                                                tempPaketSaluranTV[j][k] = tempDataPaketSaluranTV[j][k];
                                                                tempDataPaketSaluranTV[j][k] = tempDataPaketSaluranTV[i][k];
                                                                tempDataPaketSaluranTV[i][k] = tempPaketSaluranTV[j][k];
                                                            }
                                                            tempHarga = String.valueOf(tempDataHarga.get(j));
                                                            tempDataHarga.set(j, tempDataHarga.get(i));
                                                            tempDataHarga.set(i, tempHarga);
                                                            tempMasaAktifPaket = String.valueOf(tempDataMasaAktifPaket.get(j));
                                                            tempDataMasaAktifPaket.set(j, tempDataMasaAktifPaket.get(i));
                                                            tempDataMasaAktifPaket.set(i, tempMasaAktifPaket);
                                                        }
                                                    }
                                                }
                                                System.out.println("================  Beli Paket  ================");
                                                kondisiBeliPaket2 = false;
                                                break;
                                            case 3:
                                                for (int i = 0; i < tempDataHarga.size() - 1; i++) {
                                                    for (int j = i; j < tempDataHarga.size(); j++) {
                                                        if (String.valueOf(tempDataHarga.get(i)).compareTo(String.valueOf(tempDataHarga.get(j))) > 0) {
                                                            tempPaket = String.valueOf(tempDataPaket.get(j));
                                                            tempDataPaket.set(j, tempDataPaket.get(i));
                                                            tempDataPaket.set(i, tempPaket);
                                                            for (int k = 0; k < tempPaketSaluranTV[j].length; k++) {
                                                                tempPaketSaluranTV[j][k] = tempDataPaketSaluranTV[j][k];
                                                                tempDataPaketSaluranTV[j][k] = tempDataPaketSaluranTV[i][k];
                                                                tempDataPaketSaluranTV[i][k] = tempPaketSaluranTV[j][k];
                                                            }
                                                            tempHarga = String.valueOf(tempDataHarga.get(j));
                                                            tempDataHarga.set(j, tempDataHarga.get(i));
                                                            tempDataHarga.set(i, tempHarga);
                                                            tempMasaAktifPaket = String.valueOf(tempDataMasaAktifPaket.get(j));
                                                            tempDataMasaAktifPaket.set(j, tempDataMasaAktifPaket.get(i));
                                                            tempDataMasaAktifPaket.set(i, tempMasaAktifPaket);
                                                        }
                                                    }
                                                }
                                                System.out.println("================  Beli Paket  ================");
                                                kondisiBeliPaket2 = false;
                                                break;
                                            default:
                                                garisTepi();
                                                pilihanTidakTersedia();
                                                System.out.println("Ulangi lagi");
                                                garisTepi();
                                                Thread.sleep(1000);
                                                clearConsole();
                                        }
                                    } catch (NumberFormatException nfe) {
                                        inputTidakValid();
                                    }
                                } while (kondisiBeliPaket2);
                            } else if (jawabSortir.equalsIgnoreCase("n")) {
                                System.out.println("================  Beli Paket  ================");
                                for (int i = 0; i < tempDataPaket.size(); i++) {
                                    System.out.format("[%d]. Paket %s\n", (i + 1), String.valueOf(tempDataPaket.get(i)));
                                    System.out.println("     Saluran TV : ");
                                    for (int j = 0; j < tempDataPaketSaluranTV[i].length; j++) {
                                        if (tempDataPaketSaluranTV[i][j] != null) {
                                            System.out.format("         %d. %s\n", (j + 1), String.valueOf(tempDataPaketSaluranTV[i][j]));
                                        }
                                    }
                                    System.out.format("     Harga %d", Integer.valueOf(String.valueOf(tempDataHarga.get(i))));
                                    System.out.println();
                                    System.out.format("     Masa aktif %d hari", Integer.valueOf(String.valueOf(tempDataMasaAktifPaket.get(i))));
                                    System.out.println();
                                }
                                kondisiBeliPaket1 = false;
                            } else {
                                System.out.println("================  Beli Paket  ================");
                                pilihanTidakTersedia();
                                System.out.println("Ulangi lagi");
                                garisTepi();
                                Thread.sleep(1000);
                                clearConsole();
                                System.out.println("================  Beli Paket  ================");
                            }
                        } else {
                            kondisiBeliPaket1 = false;
                        }
                    } while (kondisiBeliPaket1);
                    System.out.print("Pilih paket: ");
                    int pilihan = Integer.valueOf(INPUT.READ.readLine());
                    garisTepi();
                    clearConsole();
                    if (pilihan <= DATA_PAKET.size() && pilihan > 0) {
                        boolean kondisiBeliPaket2 = true;
                        do {
                            try {
                                System.out.println("================  Beli Paket  ================");
                                System.out.println("Mode pembayaran: ");
                                System.out.println("[1]. Bayar langsung ke kantor");
                                System.out.println("[2]. Via ATM");
                                System.out.print("Pilih: ");
                                int modeBayar = Integer.valueOf(INPUT.READ.readLine());
                                garisTepi();
                                clearConsole();
                                garisTepi();
                                switch (modeBayar) {
                                    case 1:
                                        do {
                                            System.out.println("Pembayaran langsung dibayarkan");
                                            System.out.println("di " + tempat);
                                            kondisiBeliPaket = false;
                                            kondisiBeliPaket2 = false;
                                            pilihanKembaliAtauUbah(true, false, "Selesai", "=========================================");
                                        } while (kondisiPilihanKembali);
                                        break;
                                    case 2:
                                        do {
                                            System.out.println("Pembayaran dikirim ke nomer rekening " + noRekening);
                                            System.out.println("Setelah selesai silahkan upload foto");
                                            System.out.println("bukti pembayaran, nama paket dan id Anda ke");
                                            System.out.format("nomor telepon %s guna memvalidasi pembayaran\n", noTelp);
                                            kondisiBeliPaket = false;
                                            kondisiBeliPaket2 = false;
                                            pilihanKembaliAtauUbah(true, false, "Selesai", "=========================================");
                                        } while (kondisiPilihanKembali);
                                        break;
                                    default:
                                        pilihanTidakTersedia();
                                        System.out.println("Ulangi lagi");
                                        garisTepi();
                                        Thread.sleep(1000);
                                        clearConsole();
                                }
                            } catch (NumberFormatException nfe) {
                                inputTidakValid();
                            }
                        } while (kondisiBeliPaket2);
                    } else {
                        garisTepi();
                        pilihanTidakTersedia();
                        System.out.println("Ulangi lagi");
                        garisTepi();
                        Thread.sleep(1000);
                        clearConsole();
                        System.out.println("================  Beli Paket  ================");
                    }
                } catch (NumberFormatException nfe) {
                    inputTidakValid();
                    System.out.println("================  Beli Paket  ================");
                }
            } while (kondisiBeliPaket);
        } else {
            System.out.println("Paket belum tersedia");
            garisTepi();
            Thread.sleep(500);
            clearConsole();
        }
    }

    /**
     * menampilkan paket - paket yang telah divalidai oleh ADMIN
     *
     * @param i indeks USER
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void infoPaketBerlangganan(int i) throws IOException, InterruptedException {
        System.out.println("===========  Info Berlangganan  ==============");
        int n = 1;
        if (DATA_PELANGGAN.contains(USER.DATA_ID.get(i))) {
            int j = DATA_PELANGGAN.indexOf(USER.DATA_ID.get(i));
            if (DATA_VALIDASI_PEMBELIAN_PAKET[j][0] != null) {
                do {
                    for (int k = 0; k < DATA_VALIDASI_PEMBELIAN_PAKET[j].length; k++) {
                        if (DATA_PAKET.contains(DATA_VALIDASI_PEMBELIAN_PAKET[j][k])) {
                            int l = DATA_PAKET.indexOf(DATA_VALIDASI_PEMBELIAN_PAKET[j][k]);
                            System.out.format("- Paket %s\n", String.valueOf(DATA_PAKET.get(l)));
                            System.out.println("     Saluran TV : ");
                            for (int m = 0; m < DATA_PAKET_SALURAN_TV[l].length; m++) {
                                if (DATA_PAKET_SALURAN_TV[l][m] != null) {
                                    System.out.format("         %d. %s\n", (m + 1), String.valueOf(DATA_PAKET_SALURAN_TV[l][m]));
                                }
                            }
                            System.out.format("     Harga %d\n", Integer.valueOf(String.valueOf(DATA_HARGA.get(l))));
                            System.out.format("     Masa aktif %d hari\n", Integer.valueOf(String.valueOf(DATA_MASA_AKTIF_PAKET.get(l))));
                            n++;
                        }
                    }
                    pilihanKembaliAtauUbah(true, false, "Kembali", "===========  Info Berlangganan  ==============");
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

    /**
     * memberhentikan suatu paket
     *
     * @param i indeks USER
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void berhentiPaket(int i) throws IOException, InterruptedException {
        System.out.println("===========  Berhenti Berlangganan  ==========");
        int n = 1;
        if (DATA_PELANGGAN.contains(USER.DATA_ID.get(i))) {
            int l = DATA_PELANGGAN.indexOf(USER.DATA_ID.get(i));
            if (DATA_VALIDASI_PEMBELIAN_PAKET[l][0] != null) {
                boolean kondisiBerhentiPaket = true;
                do {
                    try {
                        for (int j = 0; j < DATA_VALIDASI_PEMBELIAN_PAKET[l].length; j++) {
                            if (DATA_PAKET.contains(DATA_VALIDASI_PEMBELIAN_PAKET[l][j])) {
                                int k = DATA_PAKET.indexOf(DATA_VALIDASI_PEMBELIAN_PAKET[l][j]);
                                System.out.format("[%d]. Paket %s\n", n, String.valueOf(DATA_PAKET.get(k)));
                                System.out.println("     Saluran TV : ");
                                for (int m = 0; m < DATA_PAKET_SALURAN_TV[k].length; m++) {
                                    if (DATA_PAKET_SALURAN_TV[k][m] != null) {
                                        System.out.format("         %d. %s\n", (m + 1), String.valueOf(DATA_PAKET_SALURAN_TV[k][m]));
                                    }
                                }
                                System.out.format("     Harga %d\n", Integer.valueOf(String.valueOf(DATA_HARGA.get(k))));
                                System.out.format("     Masa aktif %d hari\n", Integer.valueOf(String.valueOf(DATA_MASA_AKTIF_PAKET.get(k))));
                                n++;
                            }
                        }
                        System.out.print("Pilih: ");
                        int pilihan = Integer.valueOf(INPUT.READ.readLine());
                        garisTepi();
                        clearConsole();
                        int k = 0;
                        for (int j = 0; j < DATA_VALIDASI_PEMBELIAN_PAKET[i].length; j++) {
                            if (DATA_VALIDASI_PEMBELIAN_PAKET[i][j] != null) {
                                k++;
                            }
                        }
                        if (pilihan <= k && pilihan > 0) {
                            boolean kondisiBerhentiPaket1 = true;
                            do {
                                garisTepi();
                                System.out.print("Apakah anda yakin?(Y/N) ");
                                String jawab = INPUT.READ.readLine();
                                garisTepi();
                                clearConsole();
                                if (jawab.equalsIgnoreCase("y")) {
                                    DATA_VALIDASI_PEMBELIAN_PAKET[i][pilihan - 1] = null;
                                    for (int j = pilihan - 1; j < DATA_VALIDASI_PEMBELIAN_PAKET[i].length - 1; j++) {
                                        DATA_VALIDASI_PEMBELIAN_PAKET[i][j] = DATA_VALIDASI_PEMBELIAN_PAKET[i][j + 1];
                                    }
                                    garisTepi();
                                    System.out.format("Paket ke-%d berhasil diberhentikan\n", pilihan);
                                    garisTepi();
                                    Thread.sleep(1500);
                                    clearConsole();
                                    kondisiBerhentiPaket = false;
                                    kondisiBerhentiPaket1 = false;
                                } else if (jawab.equalsIgnoreCase("n")) {
                                    garisTepi();
                                    System.out.println("Berhenti paket dibatalkan");
                                    garisTepi();
                                    Thread.sleep(500);
                                    clearConsole();
                                    kondisiBerhentiPaket = false;
                                    kondisiBerhentiPaket1 = false;
                                } else {
                                    garisTepi();
                                    pilihanTidakTersedia();
                                    System.out.println("Ulangi lagi");
                                    garisTepi();
                                    Thread.sleep(1000);
                                    clearConsole();
                                }
                            } while (kondisiBerhentiPaket1);
                        } else {
                            garisTepi();
                            pilihanTidakTersedia();
                            System.out.println("Ulangi lagi");
                            garisTepi();
                            Thread.sleep(1000);
                            clearConsole();
                            System.out.println("===========  Berhenti Berlangganan  ==========");
                        }
                    } catch (NumberFormatException nfe) {
                        inputTidakValid();
                        System.out.println("===========  Berhenti Berlangganan  ==========");
                    }
                } while (kondisiBerhentiPaket);
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

    /**
     * Menampilkan semua pelanggan besertakan DATA diri pelanggan berupa nama,
     * alamat, nomer hp dan email dan paket paket yang telah divalidasi ADMIN
     *
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void daftarInfoPelanggan() throws IOException, InterruptedException {
        System.out.println("==========  Daftar & Info Pelanggan  =========");
        if (DATA_PELANGGAN.isEmpty()) {
            System.out.println("Belum ada pelanggan");
            garisTepi();
            Thread.sleep(500);
            clearConsole();
        } else {
            do {
                for (int i = 0; i < DATA_PELANGGAN.size(); i++) {
                    int j = USER.DATA_ID.indexOf(DATA_PELANGGAN.get(i));
                    System.out.println(" - Pelanggan ke-" + (i + 1));
                    System.out.format("    Nama   : %s\n", USER.DATA_NAMA.get(j));
                    System.out.format("    Alamat : %s\n", USER.DATA_ALAMAT.get(j));
                    System.out.format("    No. HP : %s\n", USER.DATA_NO_HP.get(j));
                    System.out.format("    Email  : %s\n", USER.DATA_EMAIL.get(j));
                    System.out.println("    Paket yang aktif: ");
                    if (DATA_VALIDASI_PEMBELIAN_PAKET[i][0] != null) {
                        int n = 1;
                        for (int k = 0; k < DATA_VALIDASI_PEMBELIAN_PAKET[i].length; k++) {
                            if (DATA_PAKET.contains(DATA_VALIDASI_PEMBELIAN_PAKET[i][k])) {
                                int l = DATA_PAKET.indexOf(DATA_VALIDASI_PEMBELIAN_PAKET[i][k]);
                                System.out.format("     %d. Paket %s\n", n, String.valueOf(DATA_PAKET.get(l)));
                                System.out.println("          Saluran TV : ");
                                for (int m = 0; m < DATA_PAKET_SALURAN_TV[l].length; m++) {
                                    if (DATA_PAKET_SALURAN_TV[l][m] != null) {
                                        System.out.format("              %d. %s\n", (m + 1), String.valueOf(DATA_PAKET_SALURAN_TV[l][m]));
                                    }
                                }
                                System.out.format("          Harga %d", Integer.valueOf(String.valueOf(DATA_HARGA.get(l))));
                                System.out.println();
                                System.out.format("          Masa aktif %d hari", Integer.valueOf(String.valueOf(DATA_MASA_AKTIF_PAKET.get(l))));
                                System.out.println();
                                n++;
                            }
                        }
                    } else {
                        System.out.println("      -Tidak ada");
                    }
                }
                pilihanKembaliAtauUbah(true, false, "Kembali", "==========  Daftar & Info Pelanggan  =========");
            } while (kondisiPilihanKembali);
        }
    }

    /**
     * Menampilkan daftas saluran tv
     *
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void daftarSaluranTV() throws IOException, InterruptedException {
        System.out.println("============  Daftar Saluran TV  =============");
        if (DATA_SALURAN_TV.isEmpty()) {
            System.out.println("Saluran TV belum ditambahkan");
            garisTepi();
            Thread.sleep(500);
            clearConsole();
        } else {
            do {
                for (int i = 0; i < DATA_SALURAN_TV.size(); i++) {
                    System.out.format("- %s ", String.valueOf(DATA_SALURAN_TV.get(i)));
                    System.out.println();
                }
                pilihanKembaliAtauUbah(true, false, "Kembali", "============  Daftar Saluran TV  =============");
            } while (kondisiPilihanKembali);
        }
    }

    /**
     * Menambahkan paket dengan cara memberikan nama paket, memilih berbagai
     * salurah tv, menentukan harga dan masa aktif paket
     *
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void tambahPaket() throws IOException, InterruptedException {
        boolean kondisiAddPaket = true;
        do {
            System.out.println("==============  Tambahkan Paket  =============");
            int j = 0;
            if (DATA_SALURAN_TV.isEmpty()) {
                System.out.println("Saluran TV belum ditambahkan");
                garisTepi();
                Thread.sleep(500);
                clearConsole();
            } else {
                System.out.print("Nama paket: ");
                DATA.paket = INPUT.READ.readLine();
                DATA.paket = DATA.paket.toUpperCase();
                garisTepi();
                clearConsole();
                if (DATA_PAKET.contains(DATA.paket)) {
                    garisTepi();
                    System.out.println("Nama paket sudah digunakan");
                    System.out.println("Ulangi Lagi");
                    garisTepi();
                    Thread.sleep(1000);
                    clearConsole();
                } else {
                    DATA_PAKET.add(DATA.paket);
                    ArrayList tempDataSaluranTV = new ArrayList(DATA_SALURAN_TV);
                    kondisiAddPaket = false;
                    boolean kondisiAddPaket1 = true;
                    do {
                        try {
                            System.out.println("==============  Tambahkan Paket  =============");
                            System.out.println("Nama Paket: " + DATA.paket);
                            System.out.println("Saluran TV:");
                            for (int i = 0; i < tempDataSaluranTV.size(); i++) {
                                System.out.format("[%d]. %s\n", (i + 1), tempDataSaluranTV.get(i));
                            }
                            System.out.print("Pilih saluran TV: ");
                            int pilihSaluranTV = Integer.valueOf(INPUT.READ.readLine());
                            garisTepi();
                            clearConsole();
                            if (pilihSaluranTV <= tempDataSaluranTV.size() && pilihSaluranTV > 0) {
                                DATA.paketSaluranTV = String.valueOf(tempDataSaluranTV.get(pilihSaluranTV - 1));
                                DATA_PAKET_SALURAN_TV[DATA_PAKET.size() - 1][j] = DATA.paketSaluranTV;
                                j++;
                                garisTepi();
                                System.out.format("Saluran TV %s berhasil dimasukkan\n", tempDataSaluranTV.get(pilihSaluranTV - 1));
                                tempDataSaluranTV.remove(pilihSaluranTV - 1);
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
                                        String pilihLagi = INPUT.READ.readLine();
                                        garisTepi();
                                        clearConsole();
                                        if (pilihLagi.equalsIgnoreCase("n")) {
                                            kondisiAddPaket1 = false;
                                            kondisiAddPaket2 = false;
                                        } else if (pilihLagi.equalsIgnoreCase("y")) {
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
                        } catch (NumberFormatException nfe) {
                            inputTidakValid();
                        }
                    } while (kondisiAddPaket1);
                    boolean kondisiAddPaket2 = true;
                    do {
                        try {
                            System.out.println("==============  Tambahkan Paket  =============");
                            int k = DATA_PAKET.size();
                            System.out.println("Nama Paket: " + DATA_PAKET.get(k - 1));
                            System.out.println("Saluran TV:");
                            for (int i = 0; i < 10; i++) {
                                if (DATA_PAKET_SALURAN_TV[k - 1][i] != null) {
                                    System.out.format("[%d]. %s\n", (i + 1), DATA_PAKET_SALURAN_TV[k - 1][i]);
                                }
                            }
                            System.out.print("Harga paket: ");
                            int harga = Integer.valueOf(INPUT.READ.readLine());
                            System.out.print("Masa aktif paket(hari): ");
                            int hari = Integer.valueOf(INPUT.READ.readLine());
                            DATA_MASA_AKTIF_PAKET.add(hari);
                            DATA_HARGA.add(harga);
                            garisTepi();
                            clearConsole();
                            garisTepi();
                            System.out.format("Paket ke-%d telah tersimpan\n", DATA_PAKET.size());
                            garisTepi();
                            Thread.sleep(1000);
                            clearConsole();
                            kondisiAddPaket2 = false;
                        } catch (NumberFormatException nfe) {
                            inputTidakValid();
                        }
                    } while (kondisiAddPaket2);
                }
            }
        } while (kondisiAddPaket);
    }

    /**
     * Menambahkan saluran TV. Setiap inputan saluran TV akan secara otomatis
     * menjadi huruf kapital semua. Saluran TV yang sudah diinputkan tidak bisa
     * lagi diinputkan
     *
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void tambahSaluranTV() throws IOException, InterruptedException {
        boolean kondisiAddSaluranTV = true;
        do {
            System.out.println("============  Tambah Saluran TV  =============");
            if (!DATA_SALURAN_TV.isEmpty()) {
                System.out.println("Daftar Saluran TV Lama:");
                for (int i = 0; i < DATA_SALURAN_TV.size(); i++) {
                    System.out.format("- %s\n", DATA_SALURAN_TV.get(i));
                }
            }
            System.out.print("Saluran TV baru: ");
            DATA.saluranTV = INPUT.READ.readLine();
            garisTepi();
            clearConsole();
            garisTepi();
            DATA.saluranTV = DATA.saluranTV.toUpperCase();
            if (DATA_SALURAN_TV.contains(DATA.saluranTV)) {
                System.out.println("Saluran TV sudah ditambahkan");
                System.out.println("Ulangi lagi");
                garisTepi();
                Thread.sleep(1000);
                clearConsole();
            } else {
                DATA_SALURAN_TV.add(DATA.saluranTV);
                System.out.format("Saluran TV ke-%d telah tersimpan\n", DATA_SALURAN_TV.size());
                garisTepi();
                Thread.sleep(1000);
                clearConsole();
                boolean kondisiAddSaluranTV1 = true;
                do {
                    garisTepi();
                    System.out.print("Tambahkan lagi?(Y/N) ");
                    String tambahLagi = INPUT.READ.readLine();
                    garisTepi();
                    clearConsole();
                    if (tambahLagi.equalsIgnoreCase("y")) {
                        kondisiAddSaluranTV1 = false;
                    } else if (tambahLagi.equalsIgnoreCase("n")) {
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

    /**
     * Menampilkan info USER berupa nama, alamaat, hobi, nomer HP dan email.
     * Terdapat juga fitur untuk merubah isi dari info tersebut
     *
     * @param i indeks USER
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void infoAkunUser(int i) throws IOException, InterruptedException {
        System.out.println("=================  Info Akun  ================");
        do {
            System.out.format("-Nama   : %s\n", USER.DATA_NAMA.get(i));
            System.out.format("-Alamat : %s\n", USER.DATA_ALAMAT.get(i));
            System.out.format("-Hobi   : %s\n", USER.dataHobi.get(i));
            System.out.format("-No. HP : %s\n", USER.DATA_NO_HP.get(i));
            System.out.format("-Email  : %s\n", USER.DATA_EMAIL.get(i));
            pilihanKembaliAtauUbah(true, true, "Kembali", "=================  Info Akun  ================");
            while (kondisiPilihanUbah) {
                System.out.println("=================  Info Akun  ================");
                System.out.print("Nama baru  : ");
                String nama = INPUT.READ.readLine();
                System.out.print("Alamat baru: ");
                String alamat = INPUT.READ.readLine();
                System.out.print("Hobi baru  : ");
                String hobi = INPUT.READ.readLine();
                System.out.print("No. HP baru: ");
                String noHP = INPUT.READ.readLine();
                System.out.print("Email baru : ");
                String email = INPUT.READ.readLine();
                garisTepi();
                clearConsole();
                boolean kondisiInfoAkunUser = true;
                do {
                    System.out.println("=================  Info Akun  ================");
                    System.out.format("Nama baru  : %s\n", nama);
                    System.out.format("Alamat baru: %s\n", alamat);
                    System.out.format("Hobi baru  : %s\n", hobi);
                    System.out.format("No. HP baru: %s\n", noHP);
                    System.out.format("Email baru : %s\n", email);
                    System.out.print("Apakah anda yakin?(Y/N) ");
                    String apaYakin = INPUT.READ.readLine();
                    garisTepi();
                    clearConsole();
                    if (apaYakin.equalsIgnoreCase("y")) {
                        USER.DATA_NAMA.set(i, nama);
                        USER.DATA_ALAMAT.set(i, alamat);
                        USER.dataHobi.set(i, hobi);
                        USER.DATA_NO_HP.set(i, noHP);
                        USER.DATA_EMAIL.set(i, email);
                        garisTepi();
                        System.out.println("Perubahan berhasil");
                        garisTepi();
                        Thread.sleep(500);
                        clearConsole();
                        System.out.println("=================  Info Akun  ================");
                        kondisiInfoAkunUser = false;
                        kondisiPilihanUbah = false;
                    } else if (apaYakin.equalsIgnoreCase("n")) {
                        garisTepi();
                        System.out.println("Perubahan dibatalkan");
                        garisTepi();
                        Thread.sleep(500);
                        clearConsole();
                        System.out.println("=================  Info Akun  ================");
                        kondisiInfoAkunUser = false;
                        kondisiPilihanUbah = false;
                    } else {
                        garisTepi();
                        pilihanTidakTersedia();
                        System.out.println("Ulangi lagi");
                        garisTepi();
                        Thread.sleep(1000);
                        clearConsole();
                    }
                } while (kondisiInfoAkunUser);
            }
        } while (kondisiPilihanKembali);
    }

    /**
     * Menampilkan info ADMIN berupa nama, alamaat, hobi, nomer HP dan email.
     * Terdapat juga fitur untuk merubah isi dari info tersebut
     *
     * @param i indeks ADMIN
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void infoAkunAdmin(int i) throws IOException, InterruptedException {
        System.out.println("=================  Info Akun  ================");
        do {
            System.out.format("-Nama\t: %s\n", ADMIN.DATA_NAMA.get(i));
            System.out.format("-Alamat\t: %s\n", ADMIN.DATA_ALAMAT.get(i));
            System.out.format("-Hobi\t: %s\n", ADMIN.dataHobi.get(i));
            System.out.format("-No. HP\t: %s\n", ADMIN.DATA_NO_HP.get(i));
            System.out.format("-Email\t: %s\n", ADMIN.DATA_EMAIL.get(i));
            pilihanKembaliAtauUbah(true, true, "Kembali", "=================  Info Akun  ================");
            while (kondisiPilihanUbah) {
                System.out.println("=================  Info Akun  ================");
                System.out.print("Nama baru  : ");
                String nama = INPUT.READ.readLine();
                System.out.print("Alamat baru: ");
                String alamat = INPUT.READ.readLine();
                System.out.print("Hobi baru  : ");
                String hobi = INPUT.READ.readLine();
                System.out.print("No. HP baru: ");
                String noHP = INPUT.READ.readLine();
                System.out.print("Email baru : ");
                String email = INPUT.READ.readLine();
                garisTepi();
                clearConsole();
                boolean kondisiInfoAkunAdmin = true;
                do {
                    System.out.println("=================  Info Akun  ================");
                    System.out.format("Nama baru  : %s\n", nama);
                    System.out.format("Alamat baru: %s\n", alamat);
                    System.out.format("Hobi baru  : %s\n", hobi);
                    System.out.format("No. HP baru: %s\n", noHP);
                    System.out.format("Email baru : %s\n", email);
                    System.out.print("Apakah anda yakin?(Y/N) ");
                    String apaYakin = INPUT.READ.readLine();
                    garisTepi();
                    clearConsole();
                    if (apaYakin.equalsIgnoreCase("y")) {
                        ADMIN.DATA_NAMA.set(i, nama);
                        ADMIN.DATA_ALAMAT.set(i, alamat);
                        ADMIN.dataHobi.set(i, hobi);
                        ADMIN.DATA_NO_HP.set(i, noHP);
                        ADMIN.DATA_EMAIL.set(i, email);
                        garisTepi();
                        System.out.println("Perubahan berhasil");
                        garisTepi();
                        Thread.sleep(500);
                        clearConsole();
                        System.out.println("=================  Info Akun  ================");
                        kondisiInfoAkunAdmin = false;
                        kondisiPilihanUbah = false;
                    } else if (apaYakin.equalsIgnoreCase("n")) {
                        garisTepi();
                        System.out.println("Perubahan dibatalkan");
                        garisTepi();
                        Thread.sleep(500);
                        clearConsole();
                        System.out.println("=================  Info Akun  ================");
                        kondisiInfoAkunAdmin = false;
                        kondisiPilihanUbah = false;
                    } else {
                        garisTepi();
                        pilihanTidakTersedia();
                        System.out.println("Ulangi lagi");
                        garisTepi();
                        Thread.sleep(1000);
                        clearConsole();
                    }
                } while (kondisiInfoAkunAdmin);
            }
        } while (kondisiPilihanKembali);
    }

    /**
     * Validasi pembelian paket USER oleh ADMIN yang telah melakukan pembayaran.
     * Posisi USER tersebut yang telah divalidasi akan dimasukkan ke DATA
     * pelanggan. Cara validasi yakni ADMIN akan memilih salah satu USER dari
     * daftar semua id USER . Setelah itu ADMIN akan memilih paket dari daftas
     * semua nama paket. Selesai dari itu paket yang dibeli oleh USER
     * tervalidasi dan posisi USER langsung menjadi pelanggan.
     *
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void validasiPembayaran() throws IOException, InterruptedException {
        System.out.println("===========  Validasi Pembayaran  ============");
        if (USER.DATA_ID.isEmpty()) {
            System.out.println("Belum ada Id User");
            System.out.println("Validasi dibatalkan");
            garisTepi();
            Thread.sleep(1000);
            clearConsole();
        } else {
            boolean kondisiValidasiPembayaran = true;
            do {
                try {
                    System.out.println("Daftar Id User:");
                    for (int i = 0; i < USER.DATA_ID.size(); i++) {
                        System.out.format("[%d]. %s\n", (i + 1), USER.DATA_ID.get(i));
                    }
                    System.out.print("Pilih: ");
                    int pilihUser = Integer.valueOf(INPUT.READ.readLine());
                    garisTepi();
                    clearConsole();
                    if (pilihUser <= USER.DATA_ID.size() && pilihUser > 0) {
                        kondisiValidasiPembayaran = false;
                        System.out.println("===========  Validasi Pembayaran  ============");
                        if (DATA_PAKET.isEmpty()) {
                            System.out.println("Belum ada paket");
                            System.out.println("Validasi dibatalkan");
                            garisTepi();
                            Thread.sleep(1000);
                            clearConsole();
                        } else {
                            boolean kondisiValidasiPembayaran1 = true;
                            do {
                                try {
                                    System.out.println("Daftar Paket:");
                                    for (int i = 0; i < DATA_PAKET.size(); i++) {
                                        System.out.format("[%d]. %s\n", (i + 1), DATA_PAKET.get(i));
                                    }
                                    System.out.print("Pilih: ");
                                    int pilihPaket = Integer.valueOf(INPUT.READ.readLine());
                                    garisTepi();
                                    clearConsole();
                                    if (pilihPaket <= DATA_PAKET.size() && pilihPaket > 0) {
                                        kondisiValidasiPembayaran1 = false;
                                        boolean kondisiValidasiPembayaran2 = true;
                                        do {
                                            System.out.println("===========  Validasi Pembayaran  ============");
                                            System.out.println("Id User          : " + USER.DATA_ID.get(pilihUser - 1));
                                            System.out.println("Paket yang dibeli: " + DATA_PAKET.get(pilihPaket - 1));
                                            System.out.print("Apakah anda yakin?(Y/N) ");
                                            String pilihan2 = INPUT.READ.readLine();
                                            garisTepi();
                                            clearConsole();
                                            if (pilihan2.equalsIgnoreCase("y")) {
                                                if (DATA_PELANGGAN.contains(USER.DATA_ID.get(pilihUser - 1))) {
                                                    int i = DATA_PELANGGAN.indexOf(USER.DATA_ID.get(pilihUser - 1));
                                                    for (int j = 0; j < DATA_VALIDASI_PEMBELIAN_PAKET[i].length; j++) {
                                                        if (DATA_VALIDASI_PEMBELIAN_PAKET[i][j] == null) {
                                                            DATA_VALIDASI_PEMBELIAN_PAKET[i][j] = String.valueOf(DATA_PAKET.get(pilihPaket - 1));
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    DATA_PELANGGAN.add(USER.DATA_ID.get(pilihUser - 1));
                                                    int i = DATA_PELANGGAN.size() - 1;
                                                    for (int j = 0; j < DATA_VALIDASI_PEMBELIAN_PAKET[i].length; j++) {
                                                        if (DATA_VALIDASI_PEMBELIAN_PAKET[i][j] == null) {
                                                            DATA_VALIDASI_PEMBELIAN_PAKET[i][j] = String.valueOf(DATA_PAKET.get(pilihPaket - 1));
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
                                } catch (NumberFormatException nfe) {
                                    inputTidakValid();
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
                } catch (NumberFormatException nfe) {
                    inputTidakValid();
                    System.out.println("===========  Validasi Pembayaran  ============");
                }
            } while (kondisiValidasiPembayaran);
        }
    }

    /**
     * Menampilkan info kantor berupa alamat, no rekening, dan no telepon kantor
     *
     * @param edit jika benar maka fitur mengubah info kantor akan aktif jika
     * tidak maka kebalikannya
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void infoKantor(boolean edit) throws IOException, InterruptedException {
        System.out.println("===============  Info Kantor  ================");
        if (alamatKantor != null) {
            do {
                System.out.format("- Alamat kantor        : %s\n", alamatKantor);
                System.out.format("- No. rekening kantor  : %s\n", noRekeningKantor);
                System.out.format("- No. telepon kantor   : %s\n", noTelpKantor);
                pilihanKembaliAtauUbah(true, edit, "Kembali", "===============  Info Kantor  ================");
                while (kondisiPilihanUbah) {
                    System.out.println("===============  Info Kantor  ================");
                    System.out.print("- Alamat kantor baru       : ");
                    String alamat = INPUT.READ.readLine();
                    System.out.print("- No. rekening kantor baru : ");
                    String noRekening = INPUT.READ.readLine();
                    System.out.print("- No. telepon kantor baru  : ");
                    String noTelp = INPUT.READ.readLine();
                    garisTepi();
                    clearConsole();
                    boolean kondisiInfoKantor = true;
                    do {
                        System.out.println("===============  Info Kantor  ================");
                        System.out.format("- Alamat kantor baru       : %s\n", alamat);
                        System.out.format("- No. rekening kantor baru : %s\n", noRekening);
                        System.out.format("- No. telepon kantor baru  : %s\n", noTelp);
                        System.out.print("Apakah anda yakin?(Y/N) ");
                        String apaYakin = INPUT.READ.readLine();
                        garisTepi();
                        clearConsole();
                        if (apaYakin.equalsIgnoreCase("y")) {
                            alamatKantor = alamat;
                            noRekeningKantor = noRekening;
                            noTelpKantor = noTelp;
                            garisTepi();
                            System.out.println("Perubahan berhasil");
                            garisTepi();
                            Thread.sleep(500);
                            clearConsole();
                            System.out.println("===============  Info Kantor  ================");
                            kondisiInfoKantor = false;
                            kondisiPilihanUbah = false;
                        } else if (apaYakin.equalsIgnoreCase("n")) {
                            garisTepi();
                            System.out.println("Perubahan dibatalkan");
                            garisTepi();
                            Thread.sleep(500);
                            clearConsole();
                            System.out.println("===============  Info Kantor  ================");
                            kondisiInfoKantor = false;
                            kondisiPilihanUbah = false;
                        } else {
                            garisTepi();
                            pilihanTidakTersedia();
                            System.out.println("Ulangi lagi");
                            garisTepi();
                            Thread.sleep(1000);
                            clearConsole();
                        }
                    } while (kondisiInfoKantor);
                }
            } while (kondisiPilihanKembali);
        } else {
            System.out.println("Informasi kantor belum tersedia");
            garisTepi();
            Thread.sleep(1000);
            clearConsole();
        }
    }

    /**
     * Berisi instruksi utama yang akan dieksekusi
     *
     * @param args tidak ada
     * @throws IOException memberikan pertanda jika terjadi pengecualian I/O
     * yang terjadi
     * @throws InterruptedException dilempar ketika thread berhenti sejenak,
     * tidur atau apapun yang dapat menyebabkan kesalahan pada saat
     * multithreading
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        clearConsole();
        pesanSelamatDatang();
        do {
            menuSelamatDatang();
            while (USER.autentikasi) {
                menuUser(USER.indeks);
            }
            while (ADMIN.autentikasi) {
                if (alamatKantor == null) {
                    garisTepi();
                    System.out.println("Informasi kantor masih kosong");
                    System.out.println("Harap diisi");
                    garisTepi();
                    Thread.sleep(1000);
                    clearConsole();
                    garisTepi();
                    System.out.print("Alamat kantor sayaTV       : ");
                    alamatKantor = INPUT.READ.readLine();
                    System.out.print("No. rekening kantor sayaTV : ");
                    noRekeningKantor = INPUT.READ.readLine();
                    System.out.print("No. Telp kantor sayaTV     : ");
                    noTelpKantor = INPUT.READ.readLine();
                    garisTepi();
                    clearConsole();
                }
                menuAdmin(ADMIN.indeks);
            }
        } while (kondisiMain);
        pesanSempaiJumpa();
    }
}
