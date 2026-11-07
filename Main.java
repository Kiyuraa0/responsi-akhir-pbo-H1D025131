public class Main {
    public static void main(String[] args) {

        // [Syarat 3] konstruktor overloading: versi pendek & versi lengkap
        Prajurit prajurit = new Prajurit("P01", "Arga");                 // konstruktor 1
        Penyihir penyihir = new Penyihir("P02", "Lyra", 2, 30);          // konstruktor 2
        Pemanah pemanah = new Pemanah("P03", "Bayu", 1, 2);              // konstruktor 2

        // [Syarat 1 & 5 & 6] method void + override + super.tampilkanStatus()
        System.out.println("=== STATUS AWAL ===");
        prajurit.tampilkanStatus();
        penyihir.tampilkanStatus();
        pemanah.tampilkanStatus();

        // [Syarat 1] method fungsi (return value)
        System.out.println("\nKekuatan Prajurit: " + prajurit.hitungKekuatan());

        // [Syarat 2] konstanta global & atribut final
        System.out.println("HP maksimal (konstanta): " + Karakter.HP_MAKSIMAL);
        System.out.println("ID Prajurit (final): " + prajurit.getId());

        // [Syarat 9] Polimorfisme: variabel bertipe INTERFACE
        System.out.println("\n=== PERTARUNGAN ===");
        Penyerang p1 = new Prajurit("P04", "Raka", 3, 2);
        Penyerang p2 = new Pemanah("P05", "Sari");
        Penyerang p3 = new Penyihir("P06", "Mira");

        p1.serang(penyihir);   // Prajurit menyerang Penyihir
        p2.serang(prajurit);   // Pemanah menyerang Prajurit (armor mengurangi damage)
        p3.serang(pemanah);    // Penyihir menyerang Pemanah

        // [Syarat 8] logika if/else yang mengubah state
        System.out.println("\n=== ARMOR HABIS & GUGUR ===");
        pemanah.setAnakPanah(0);
        pemanah.serang(prajurit);        // anak panah habis -> gagal
        prajurit.setArmor(0);
        prajurit.terimaSerangan(200);    // damage besar -> gugur

        // [Syarat 10] Satu class implement 2 interface (Penyerang & Penyembuh)
        System.out.println("\n=== PENYEMBUHAN ===");
        Penyembuh healer = penyihir;     // interface kedua
        healer.sembuhkan(pemanah);
        healer.sembuhkan(pemanah);
        healer.sembuhkan(pemanah);
        healer.sembuhkan(pemanah);       // mana habis -> gagal

        System.out.println("\n=== STATUS AKHIR ===");
        prajurit.tampilkanStatus();
        penyihir.tampilkanStatus();
        pemanah.tampilkanStatus();
    }
}
