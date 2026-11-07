public abstract class Karakter {

    // [Syarat 2] konstanta global
    public static final int HP_MAKSIMAL = 100;

    // [Syarat 2] atribut instans kekal (tidak bisa diubah setelah dibuat)
    private final String id;

    // [Syarat 1 & 3] atribut (state) dan semuanya private
    private String nama;
    private int hp;
    private int level;

    // [Syarat 3] Konstruktor 1: level otomatis 1
    public Karakter(String id, String nama) {
        this(id, nama, 1); // memanggil konstruktor 2
    }

    // [Syarat 3] Konstruktor 2: level ditentukan sendiri (overloading)
    public Karakter(String id, String nama, int level) {
        this.id = id;
        this.nama = nama;
        this.level = level;
        this.hp = HP_MAKSIMAL;
    }

    // ===== Getter & Setter =====
    public String getId() {          // id final -> hanya getter
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp > HP_MAKSIMAL) {
            this.hp = HP_MAKSIMAL;
        } else if (hp < 0) {
            this.hp = 0;
        } else {
            this.hp = hp;
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // [Syarat 1] method prosedur (void) - tidak mengembalikan nilai
    public void tampilkanStatus() {
        System.out.println("[" + id + "] " + nama + " | Level: " + level + " | HP: " + hp);
    }

    // [Syarat 1] method fungsi - mengembalikan nilai
    public int hitungKekuatan() {
        return level * 10;
    }

    // [Syarat 7] abstract method - wajib diisi oleh subclass
    public abstract void terimaSerangan(int damage);
}
