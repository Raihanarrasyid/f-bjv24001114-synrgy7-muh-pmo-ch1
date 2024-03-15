import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueOrdering = true;
        Order order = new Order();

        System.out.println("Selamat datang di program pemesanan makanan online!");

        while (continueOrdering) {
            System.out.println("Silakan pilih menu makanan yang diinginkan:");
            System.out.println("1. Nasi Goreng\t\t| 15.000");
            System.out.println("2. Mie Goreng\t\t| 13.000");
            System.out.println("3. Nasi + Ayam\t\t| 18.000");
            System.out.println("4. Es Teh Manis\t\t| 3.000");
            System.out.println("5. Es Jeruk\t\t| 5.000");
            System.out.println("99. Pembayaran");
            System.out.println("0. Keluar aplikasi");
            System.out.print("=> ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    order.addItem("Nasi Goreng", 15000);
                    break;
                case 2:
                    order.addItem("Mie Goreng", 13000);
                    break;
                case 3:
                    order.addItem("Nasi + Ayam", 18000);
                    break;
                case 4:
                    order.addItem("Es Teh Manis", 3000);
                    break;
                case 5:
                    order.addItem("Es Jeruk", 5000);
                    break;
                case 99:
                    continueOrdering = false;
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        System.out.println("=========================");
        System.out.println("Konfirmasi & Pembayaran");
        System.out.println("=========================");
        order.displayOrder();

        System.out.println("1. Konfirmasi dan Bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar aplikasi");
        System.out.print("=> ");
        int paymentChoice = scanner.nextInt();

        switch (paymentChoice) {
            case 1:
                order.generateReceipt();
                System.out.println("Terima kasih telah memesan di BinarFud!");
                break;
            case 2:
                // Kembali ke menu utama
                break;
            case 0:
                System.out.println("Terima kasih telah menggunakan layanan kami.");
                return;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }
}


