import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Order {
    private StringBuilder receipt = new StringBuilder();
    private int total = 0;

    public void addItem(String itemName, int price) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================");
        System.out.println("Berapa pesanan anda");
        System.out.println("=========================");
        System.out.println(itemName + "\t| " + price);
        System.out.print("(input 0 untuk kembali)\nqty => ");
        int quantity = scanner.nextInt();
        if (quantity == 0)
            return;

        int subtotal = price * quantity;
        receipt.append(itemName).append("\t\t").append(quantity).append("\t").append(subtotal).append("\n");
        total += subtotal;
    }

    public void displayOrder() {
        System.out.println(receipt.toString());
        System.out.println("------------------------------------------+");
        System.out.println("Total\t\t" + total + "\n");
    }

    public void generateReceipt() {
        try {
            FileWriter writer = new FileWriter("receipt.txt");
            writer.write("==========================\n");
            writer.write("BinarFud\n");
            writer.write("==========================\n\n");
            writer.write("Terima kasih sudah memesan di BinarFud\n\n");
            writer.write("Dibawah ini adalah pesanan anda\n\n");
            writer.write(receipt.toString());
            writer.write("----------------------------------+\n");
            writer.write("Total\t\t" + total + "\n\n");
            writer.write("Pembayaran : BinarCash\n\n");
            writer.write("=========================\n");
            writer.write("Simpan struk ini sebagai\nbukti pembayaran\n");
            writer.write("=========================");
            writer.close();
            System.out.println("Struk pembayaran telah disimpan sebagai file 'receipt.txt'");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan struk pembayaran.");
            e.printStackTrace();
        }
    }
}