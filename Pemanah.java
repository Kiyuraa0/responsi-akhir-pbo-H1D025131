/**
 * Subclass 3: Pemanah (punya jumlah anak panah).
 */
public class Pemanah extends Karakter implements Penyerang {

    private int anakPanah;

    public Pemanah(String id, String nama) {
        super(id, nama);
        this.anakPanah = 5;
    }

    public Pemanah(String id, String nama, int level, int anakPanah) {
        super(id, nama, level);
        this.anakPanah = anakPanah;
    }

    public int getAnakPanah() {
        return anakPanah;
    }

    public void setAnakPanah(int anakPanah) {
        this.anakPanah = anakPanah;
    }

    @Override
    public void tampilkanStatus() {
        super.tampilkanStatus();
        System.out.println("   Peran: Pemanah | Anak panah: " + anakPanah);
    }

    @Override
    public void terimaSerangan(int damage) {
        if (getHp() - damage <= 0) {
            setHp(0);
            System.out.println(getNama() + " gugur!");
        } else {
            setHp(getHp() - damage);
            System.out.println(getNama() + " terkena " + damage + " damage.");
        }
    }

    // anak panah berkurang tiap menyerang (state berubah)
    @Override
    public void serang(Karakter target) {
        if (anakPanah > 0) {
            anakPanah = anakPanah - 1;
            System.out.println(getNama() + " memanah " + target.getNama());
            target.terimaSerangan(hitungKekuatan());
        } else {
            System.out.println(getNama() + " kehabisan anak panah!");
        }
    }
}
