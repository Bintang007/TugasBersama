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
    static ArrayList dataIdUser = new ArrayList();
    static ArrayList dataIdAdmin = new ArrayList();
    ArrayList dataPassword = new ArrayList();
    ArrayList dataEmail = new ArrayList();
    ArrayList dataAlamat = new ArrayList();
    ArrayList dataNama = new ArrayList();
    ArrayList dataNoHP = new ArrayList();
    ArrayList dataHobi = new ArrayList();
    static ArrayList dataPaket = new ArrayList();
    static ArrayList dataHarga = new ArrayList();
    static ArrayList dataSaluranTV = new ArrayList();
    //ArrayList dataPaketSaluranTV = new ArrayList();
    static String dataPaketSaluranTV[][] = new String[100][100];
    static ArrayList dataPelanggan = new ArrayList();
    //static ArrayList namaPaket = new ArrayList();
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
    static SayaTV user = new SayaTV();
    static SayaTV admin = new SayaTV();
    //static SayaTV objek[] = new SayaTV[100];
    static boolean kondisiMain = true;
    static boolean kondisi = true;

    static void garisTepi() {
        System.out.println("==========================");
    }

    static void noPilihan() {
        System.out.println("Pilihan tidak tersedia");
    }

    static void form() throws IOException {
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

    static void menuAwal() throws IOException {
        System.out.println("======= Menu Login =======");
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
                noPilihan();
        }
    }

    static void signUp() throws IOException {
        boolean kondisiSignUp = true;
        do {
            System.out.println("========= SignUp =========");
            System.out.print("Daftar sebagai (admin/user) ");
            String pilihan = input.read.readLine();
            garisTepi();
            System.out.println();
            if (pilihan.equalsIgnoreCase("admin")) {
                System.out.println("========= SignUp =========");
                System.out.print("Masukkan kode admin(didapatkan dari developer): ");
                String kode = input.read.readLine();
                garisTepi();
                System.out.println();
                if (kode.equals("A23uu!!@j")) {
                    System.out.println("========= SignUp =========");
                    form();
                    System.out.print("Masukkan ID Admin : ");
                    data.Id = input.read.readLine();
                    System.out.print("Mauskkan password : ");
                    data.password = input.read.readLine();
                    garisTepi();
                    if (!dataIdAdmin.contains(data.Id) && !dataIdUser.contains(data.Id)) {
                        admin.dataNama.add(data.nama);
                        admin.dataAlamat.add(data.alamat);
                        admin.dataEmail.add(data.email);
                        admin.dataNoHP.add(data.noHP);
                        dataIdAdmin.add(data.Id);
                        admin.dataPassword.add(data.password);
                        admin.dataHobi.add(data.hobi);
                        kondisiSignUp = false;
                        System.out.println();
                        garisTepi();
                        System.out.println("Selamat anda berhasil mendaftar");
                    } else {
                        System.out.println();
                        garisTepi();
                        System.out.println("SignUp dibatalkan");
                        System.out.println("Username sudah digunakan");
                        kondisiSignUp = false;
                    }
                } else {
                    garisTepi();
                    System.out.println("Kode admin salah. Harap hubungi developer");
                    kondisiSignUp = false;
                }
                garisTepi();
                System.out.println();
            } else if (pilihan.equalsIgnoreCase("user")) {
                System.out.println("========= SignUp =========");
                form();
                System.out.print("Masukkan ID User  : ");
                data.Id = input.read.readLine();
                System.out.print("Mauskkan password : ");
                data.password = input.read.readLine();
                garisTepi();
                System.out.println();
                if (!dataIdUser.contains(data.Id) && !dataIdAdmin.contains(data.Id)) {
                    user.dataNama.add(data.nama);
                    user.dataAlamat.add(data.alamat);
                    user.dataEmail.add(data.email);
                    user.dataNoHP.add(data.noHP);
                    dataIdUser.add(data.Id);
                    user.dataPassword.add(data.password);
                    user.dataHobi.add(data.hobi);
                    kondisiSignUp = false;
                    garisTepi();
                    System.out.println("Selamat anda berhasil mendaftar");
                } else {
                    garisTepi();
                    System.out.println("SignUp dibatalkan");
                    System.out.println("Username sudah digunakan");
                    kondisiSignUp = false;
                }
                garisTepi();
                System.out.println();
            } else {
                garisTepi();
                noPilihan();
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
        if (dataIdAdmin.contains(signIn.Id)) {
            int i = dataIdAdmin.indexOf(signIn.Id);
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
        } else if (dataIdUser.contains(signIn.Id)) {
            int i = dataIdUser.indexOf(signIn.Id);
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
//        garisTepi();
//        System.out.println();
    }

    static void lupaPassword() throws IOException {

        System.out.print("Masukkan ID   : ");
        String id = input.read.readLine();
        System.out.print("Masukkan hobi : ");
        String hobi = input.read.readLine();
        garisTepi();
        System.out.println();
        if (((dataIdUser.contains(id) || dataIdAdmin.contains(id))) && ((!dataIdUser.isEmpty() || !dataIdAdmin.isEmpty()))) {
            int i = user.dataHobi.indexOf(hobi);
            int j = admin.dataHobi.indexOf(hobi);
            if ((String.valueOf(user.dataHobi.get(i)).equalsIgnoreCase(hobi)) || (String.valueOf(admin.dataHobi.get(j))).equalsIgnoreCase(hobi)) {
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
                        if (dataIdUser.contains(id)) {
                            user.dataPassword.set(i, password);
                        } else if (dataIdAdmin.contains(id)) {
                            admin.dataPassword.set(j, password);
                        }
                        System.out.println("Password berhasil diubah");
                        kondisi = false;
                    } else {
                        System.out.println("Ulangi lagi");
                    }
                    garisTepi();
                    System.out.println();
                } while (kondisi);
            } else {
                System.out.println("Id dan hobi tidak ditemukan");
                garisTepi();
                System.out.println();
            }
        } else {
            garisTepi();
            System.out.println("Id dan hobi tidak ditemukan");
            garisTepi();
            System.out.println();
        }
    }

    static void showMenuUser(int i) throws IOException {
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
                beliPaket(alamatKantor, noRekeningKantor, noTelpKantor);
                break;
            case 3:
                garisTepi();
                System.out.println("Maaf menu belum tersedia");
//                System.out.println("==== Info Berlangganan ===");
//                infoPaketBerlangganan();
                break;
            case 4:
                garisTepi();
                System.out.println("Maaf menu belum tersedia");
//                System.out.println("== Berhenti Berlangganan =");
//                berhentiPaket();
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
                noPilihan();
        }
    }

    static void showMenuAdmin(int i) throws IOException {
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
                daftarPelanggan();
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
                addPaket();
                break;
            case 5:
                System.out.println("== Tambahkan Saluran TV ==");
                addSaluranTV();
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
                noPilihan();
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
                        System.out.format("     %d. %s\n", (j + 1), String.valueOf(dataPaketSaluranTV[i][j]));
                    }
                }
                System.out.format("     Harga %d", Integer.valueOf(String.valueOf(dataHarga.get(i))));
                System.out.println();
            }
        }
    }

    static void beliPaket(String tempat, long noRekening, long noTelp) throws IOException {
        daftarPaket("tersedia");
        if (!dataPaket.isEmpty()) {
            System.out.print("Pilih paket: ");
            int pilihan = Integer.valueOf(input.read.readLine());
            String abc = String.valueOf(dataPaket.get(pilihan));
            garisTepi();
            System.out.println();
            if (pilihan <= dataPaket.size() && pilihan > 0) {
                garisTepi();
                System.out.println("Mode pembayaran: ");
                System.out.println("[1]. Bayar langsung ke tempat");
                System.out.println("[2]. Via ATM");
                int i = Integer.valueOf(input.read.readLine());
                garisTepi();
                System.out.println();
                garisTepi();
                switch (i) {
                    case 1:
                        System.out.println("Pembayaran di " + tempat);
                        break;
                    case 2:
                        System.out.println("Pembayaran dikirim ke nomer" + noTelp);
                        System.out.println("Setelah selesai silahkan upload foto");
                        System.out.println("bukti pembayaran dan id Anda ke nomor" + noRekening);
                        System.out.println("guna memvalidasi pembayaran");
                        break;
                    default:
                        noPilihan();
                }
            } else {
                garisTepi();
                noPilihan();
            }
        }

    }

    static void infoPaketBerlangganan() {

    }

    static void berhentiPaket() {

    }

    static void daftarPelanggan() {
        if (dataPelanggan.isEmpty()) {
            System.out.println("Belum ada pelanggan");
        } else {
            for (int i = 0; i < dataPelanggan.size(); i++) {
                int j = dataIdUser.indexOf(dataPelanggan.get(i));
                System.out.println("Pelanggan ke-" + (i + 1));
                System.out.format("Nama   : %s\n", user.dataNama.get(j));
                System.out.format("Alamat : %s\n", user.dataAlamat.get(j));
                System.out.format("Hobi   : %s\n", user.dataHobi.get(j));
                System.out.format("No. HP : %d\n", user.dataNoHP.get(j));
                System.out.format("Email  : %s\n", user.dataEmail.get(j));
            }
        }
    }

    static void daftarSaluranTV() {
        if (dataSaluranTV.isEmpty()) {
            System.out.println("Saluran TV belum ditambahkan");
        } else {
            for (int i = 0; i < dataSaluranTV.size(); i++) {
                System.out.format("[%d]. %s. ", (i + 1), String.valueOf(dataSaluranTV.get(i)));
                System.out.println();
            }
        }
    }

    static void addPaket() throws IOException {
        boolean kondisiAddPaket = true;
        boolean kondisiAddPaket1 = true;
        int j = 0;
        if (dataSaluranTV.isEmpty()) {
            System.out.println("Menambahkan paket tidak bisa");
            System.out.println("Saluran TV belum ditambahkan");
        } else {
            System.out.print("Nama paket: ");
            data.paket = input.read.readLine();
            if (dataPaket.contains(data.paket)) {
                System.out.println("Nama paket sudah digunakan");
            } else {
                do {
                    dataPaket.add(data.paket);
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
                        do {
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
                        noPilihan();
                        System.out.println("Ulangi lagi");
                    }
                } while (kondisiAddPaket);
                System.out.print("Harga paket: ");
                data.harga = input.read.readLine();
                dataHarga.add(data.harga);
                garisTepi();
                System.out.println();
                garisTepi();
                System.out.format("Paket ke-%d telah tersimpan\n", dataPaket.size());
            }
        }
    }

    static void addSaluranTV() throws IOException {
        System.out.print("Masukkan saluran TV: ");
        data.saluranTV = input.read.readLine();
        int i = dataSaluranTV.size();
        dataSaluranTV.add(data.saluranTV);
        garisTepi();
        System.out.println();
        garisTepi();
        System.out.format("Saluran ke-%d telah tersimpan\n", i + 1);
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
        garisTepi();
        System.out.println();
        garisTepi();
        if (dataIdUser.contains(validasi)) {
            dataPelanggan.add(validasi);
            System.out.println("Validasi sukses");
        } else {
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
            menuAwal();
            while (user.autentikasi) {
                showMenuUser(user.indeks);
                garisTepi();
                System.out.println();
            }
            while (admin.autentikasi) {
                if (alamatKantor == null) {
                    garisTepi();
                    System.out.println("Informasi kantor masih kosong");
                    System.out.println("Harap diisi");
                    System.out.print("Masukkan alamat kantor sayaTV       : ");
                    alamatKantor = input.read.readLine();
                    System.out.print("Masukkan no. rekening kantor sayaTV : ");
                    noRekeningKantor = Integer.valueOf(input.read.readLine());
                    System.out.print("Masukkan no. Telp kantor sayaTV     : ");
                    noTelpKantor = Integer.valueOf(input.read.readLine());
                    garisTepi();
                    System.out.println();
                }
                showMenuAdmin(admin.indeks);
                garisTepi();
                System.out.println();
            }
        } while (kondisiMain);
        garisTepi();
    }
}
