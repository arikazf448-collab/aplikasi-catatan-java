import java.util.ArrayList ;
import java.util.Scanner;

class Catatan {
    private String content;

    public Catatan (String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

public class Aplikasi_Catatan {
    private static ArrayList<Catatan> notes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getChoice();
            handleChoice(choice);
        }
    }

    private static void showMenu() {
        System.out.println("Selamat datang di Aplikasi Catatan");
        System.out.println("=======================================");
        System.out.println("Pilih opsi:");
        System.out.println("1. Tambah Catatan");
        System.out.println("2. Lihat Catatan");
        System.out.println("3. Hapus Catatan");
        System.out.println("4. Keluar");
        System.out.print("Masukkan pilihan Anda: ");
    }

    private static int getChoice() {
        int choice = -1;
        while (choice < 1 || choice > 4) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.next();
            }
            if (choice < 1 || choice > 4) {
                System.out.print("Pilihan tidak valid. Masukkan pilihan Anda: ");
            }
        }
        return choice;
    }

    private static void handleChoice(int choice) {
        scanner.nextLine();
        switch (choice) {
            case 1:
                Aplikasi_Catatan.addNote();
                break;
            case 2:
                Aplikasi_Catatan.viewNotes();
                break;
            case 3:
                Aplikasi_Catatan.deleteNote();
                break;
            case 4:
                System.out.println("Terima kasih telah menggunakan Aplikasi Catatan.");
                System.exit(0);
                break;
        }
    }

    private static void addNote() {
        System.out.print("Masukkan isi catatan baru: ");
        String content = scanner.nextLine();
        notes.add(new Catatan(content));
        System.out.println("Catatan berhasil ditambahkan.");
        System.out.println("=============================");
    }

    private static void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("Tidak ada catatan.");
        } else {
            System.out.println("Daftar Catatan:");
            for (int i = 0; i < notes.size(); i++) {
                System.out.println((i + 1) + ". " + notes.get(i).getContent());
            }
        }
    }

    private static void deleteNote() {
        if (notes.isEmpty()) {
            System.out.println("Tidak ada catatan untuk dihapus.");
            return;
        }

        viewNotes();
        System.out.print("Masukkan nomor catatan yang ingin dihapus: ");
        int noteIndex = -1;
        while (noteIndex < 1 || noteIndex > notes.size()) {
            if (scanner.hasNextInt()) {
                noteIndex = scanner.nextInt();
            } else {
                scanner.next(); // clear invalid input
            }
            if (noteIndex < 1 || noteIndex > notes.size()) {
                System.out.print("Nomor tidak valid. Masukkan nomor catatan yang ingin dihapus: ");
                System.out.println("============================================================");
            }
        }
        notes.remove(noteIndex - 1);
        System.out.println("Catatan berhasil dihapus.");
        System.out.println("=========================");
    }
}
