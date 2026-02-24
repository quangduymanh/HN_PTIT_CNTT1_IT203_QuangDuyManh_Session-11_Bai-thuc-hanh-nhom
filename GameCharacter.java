package ThuchanhnhomSs11;
public abstract class GameCharacter {
    protected String name;
    protected int hp;
    protected int attackPower;
    protected Faction faction;
    static int count=0;
    public GameCharacter(String name, int hp, int attackPower, Faction faction) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.faction = faction;
        count++;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }
    public Faction getFaction() {
        return faction;
    }
    public abstract void attack(GameCharacter target);
    public void takeDamage(int amount) {
        hp -= amount;
        if (hp <= 0) {
            hp = 0;
            System.out.println(name + " đã bị hạ gục!");
        } else {
            System.out.println(name + " mất " + amount + " máu. HP còn: " + hp);
        }
    }
    public void displayInfo() {
        String status = (hp > 0) ? "Còn sống" : "Đã bị hạ gục";
        System.out.println("Tên: " + name + " | HP: " + hp + " | Trạng thái: " + status);
    }
}


