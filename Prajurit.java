/**
 * Subclass 1: Prajurit (punya armor).
 * Syarat: 4 (extends), 5 (super), 6 (@Override), 8 (if/else), 9 (interface)
 */
public class Prajurit extends Karakter implements Penyerang {

    private int armor;

    // [Syarat 5] super(...) memanggil konstruktor superclass
    public Prajurit(String id, String nama) {
        super(id, nama);
        this.armor = 3;
    }

    public Prajurit(String id, String nama, int level, int armor) {
        super(id, nama, level);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    // [Syarat 6] Override + [Syarat 5] super.namaMethod()
    @Override
    public void tampilkanStatus() {
        super.tampilkanStatus();
        System.out.println("   Peran: Prajurit | Armor: " + armor);
    }

    // [Syarat 6 & 8] Implementasi abstract method dengan if/else
    // membaca state (armor, hp) dan mengubah state (armor, hp)
    @Override
    public void terimaSerangan(int damage) {
        if (armor > 0) {
            damage = damage - 5; // armor mengurangi damage
            armor = armor - 1;   // armor berkurang tiap kena serang
            if (damage < 0) {
                damage = 0;
            }
        }

        if (getHp() - damage <= 0) {
            setHp(0);
            System.out.println(getNama() + " gugur!");
        } else {
            setHp(getHp() - damage);
            System.out.println(getNama() + " terkena " + damage + " damage.");
        }
    }

    // implementasi interface Penyerang
    @Override
    public void serang(Karakter target) {
        System.out.println(getNama() + " menebas " + target.getNama());
        target.terimaSerangan(hitungKekuatan());
    }
}
