/**
 * Subclass 2: Penyihir (punya mana).
 * Mengimplementasikan DUA interface sekaligus -> Syarat 10
 */
public class Penyihir extends Karakter implements Penyerang, Penyembuh {

    private int mana;

    public Penyihir(String id, String nama) {
        super(id, nama);
        this.mana = 30;
    }

    public Penyihir(String id, String nama, int level, int mana) {
        super(id, nama, level);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void tampilkanStatus() {
        super.tampilkanStatus();
        System.out.println("   Peran: Penyihir | Mana: " + mana);
    }

    // Penyihir tidak punya armor, jadi menerima damage penuh
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

    @Override
    public void serang(Karakter target) {
        System.out.println(getNama() + " melempar bola api ke " + target.getNama());
        target.terimaSerangan(hitungKekuatan() + 5);
    }

    // implementasi interface Penyembuh (butuh mana 10)
    @Override
    public void sembuhkan(Karakter target) {
        if (mana >= 10) {
            mana = mana - 10;
            target.setHp(target.getHp() + 20);
            System.out.println(getNama() + " menyembuhkan " + target.getNama() + " (+20 HP)");
        } else {
            System.out.println(getNama() + " kehabisan mana, gagal menyembuhkan!");
        }
    }
}
