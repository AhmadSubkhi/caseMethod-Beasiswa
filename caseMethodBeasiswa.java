import java.util.Scanner;

public class caseMethodBeasiswa {
    static String[] namaMahasiswa = new String[100];
    static long[] NIM = new long[100];
    static float[] IPK = new float[100];
    static String[] jenisBeasiswa = new String[100];
    static int[] penghasilanOrtu = new int[100];
    static int totalData = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihMenu;

        while (true) {
            tampilMenu();
            pilihMenu = sc.nextInt();
            sc.nextLine();
            
            switch (pilihMenu) {
                case 1:
                    tambahPendaftar();
                    break;
                case 2:
                    tampilSemuaPendaftar();
                    break;
                case 3:
                    cariPendaftar();
                    break;
                case 4:
                    hitungAverage();
                    break;
                case 5:
                    System.out.println("Anda keluar dari program....");
                    return;
                default:
                    System.out.println("Menu tidak valid! Coba lagi!");
                    break;
            }
        }
    }
    
    public static void tampilMenu() {
        System.out.println();
        System.out.println("=== Sistem Pendaftaran Beasiswa ===");
        System.out.println("1. Tambah Data Pendaftar Beasiswa");
        System.out.println("2. Tampilkan Semua Pendaftar");
        System.out.println("3. Cari Pendaftar berdasarkan Jenis Beasiswa");
        System.out.println("4. Hitung rata-rata IPK per Jenis Beasiswa");
        System.out.println("5. Keluar");
        System.out.print("Pilih Menu (1-5): ");
    }

    static void tambahPendaftar() {
        System.out.print("Nama Mahasiswa: ");
        namaMahasiswa[totalData] = sc.nextLine();

        System.out.print("NIM: ");
        NIM[totalData] = sc.nextLong();
        sc.nextLine();

        System.out.print("IPK terakhir: ");
        IPK[totalData] = sc.nextFloat(); 
        sc.nextLine();

        while (true) {
            System.out.print("Jenis Beasiswa (Reguler/Unggulan/Riset): ");
            jenisBeasiswa[totalData] = sc.nextLine();
            if (jenisBeasiswa[totalData].equalsIgnoreCase("Reguler") || 
                jenisBeasiswa[totalData].equalsIgnoreCase("Unggulan") || 
                jenisBeasiswa[totalData].equalsIgnoreCase("Riset")) {
                break;
            } else {
                System.out.println("Input salah! Hanya boleh Reguler, Unggulan, atau Riset.");
            }
        }

        System.out.print("Penghasilan Orang Tua (maksimal 2000000): ");
        penghasilanOrtu[totalData] = sc.nextInt(); 

        if (penghasilanOrtu[totalData] > 2000000) {
            System.out.println("Pendaftaran dibatalkan karena penghasilan melebihi batas maksimal.");
        } else {
            totalData++;
            System.out.println("Pendaftar berhasil disimpan. Total pendaftar: " + totalData);
        }
    }

    static void tampilSemuaPendaftar() {


        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf("| %-20s | %-12s | %-5s | %-10s | %-15s |\n", "Nama", "NIM", "IPK", "Beasiswa", "Gaji Ortu");
        System.out.println("------------------------------------------------------------------------------------------");
        for (int i = 0; i < totalData; i++) {
            System.out.printf("| %-20s | %-12d | %-5.2f | %-10s | %-15d |\n", 
                namaMahasiswa[i], NIM[i], IPK[i], jenisBeasiswa[i], penghasilanOrtu[i]);
        }
        System.out.println("------------------------------------------------------------------------------------------");
    }

    static void cariPendaftar() {
        String cari;


        sc.nextLine();
        System.out.print("Masukkan Jenis Beasiswa: "); 
        cari = sc.nextLine();   

        boolean ditemukan = false;

        for (int i = 0; i < totalData; i++) {
            if (jenisBeasiswa[i].equalsIgnoreCase(cari)  ) {
                System.out.println();
                System.out.println("Nama Mahasiswa: " + namaMahasiswa[i]);
                System.out.println("NIM: " + NIM[i]);
                System.out.println("IPK terakhir: " + IPK[i]);
                System.out.println("Jenis Beasiswa: " + jenisBeasiswa[i]);
                System.out.println("Penghasilan Orang Tua: " + penghasilanOrtu[i]);                           
                    
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Pendaftar berdasarkan Jenis Beasiswa yang anda cari tidak ada!");
        }
    }

    static void hitungAverage() {

        double totalIpkReguler = 0, totalIpkUnggulan = 0, totalIpkRiset = 0;
        int countReguler = 0, countUnggulan = 0, countRiset = 0;

        for (int i = 0; i < totalData; i++) {
            
            if (jenisBeasiswa[i].equalsIgnoreCase("Reguler")) {
                totalIpkReguler += IPK[i]; // Tambahkan IPK ke wadah total
                countReguler++;            // Hitung orangnya
            } 
            else if (jenisBeasiswa[i].equalsIgnoreCase("Unggulan")) {
                totalIpkUnggulan += IPK[i];
                countUnggulan++;
            }
            else if (jenisBeasiswa[i].equalsIgnoreCase("Riset")) {
                totalIpkRiset += IPK[i];
                countRiset++;
            }
        }

        System.out.println("--- Laporan Rata-rata IPK ---");

        if (countReguler > 0) {
            double rataReguler = totalIpkReguler / countReguler;
            System.out.println("Reguler  : rata-rata IPK = " + rataReguler);
        } else {
            System.out.println("Reguler  : Tidak ada data.");
        }

        if (countUnggulan > 0) {
            double rataUnggulan = totalIpkUnggulan / countUnggulan;
            System.out.println("Unggulan : rata-rata IPK = " + rataUnggulan);
        } else {
            System.out.println("Unggulan : Tidak ada data.");
        }
        
        if (countRiset > 0) {
            double rataRiset = totalIpkRiset / countRiset;
            System.out.println("Riset    : rata-rata IPK = " + rataRiset);
        } else {
            System.out.println("Riset    : Tidak ada data.");
        }  

    }
}
