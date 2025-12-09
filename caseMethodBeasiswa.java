import java.util.Scanner;

public class caseMethodBeasiswa {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String[] namaMahasiswa = new String[100];
        long[] NIM = new long[100];
        float[] IPK = new float[100];
        String[] jenisBeasiswa = new String[100];
        int[] penghasilanOrtu = new int[100];
        int totalData = 0;
        int pilihMenu;

        while (true) {
            tampilMenu();
            System.out.print("Pilih Menu (1-5): ");
            pilihMenu = sc.nextInt();
            sc.nextLine();

            switch (pilihMenu) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
}
