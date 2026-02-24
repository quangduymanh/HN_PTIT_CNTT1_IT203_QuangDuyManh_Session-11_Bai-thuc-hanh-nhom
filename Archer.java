package ThuchanhnhomSs11;
public class Archer extends GameCharacter implements ISkill {
    private int critChance; // % chí mạng (0-100)

    public Archer(String name, int hp, int attackPower, int critChance, Faction faction) {
        super(name, hp, attackPower, faction);
        this.critChance = critChance;
    }

    @Override
    public void attack(GameCharacter target) {
        int roll = (int) (Math.random() * 100); // 0..99
        int damage = attackPower;

        if (roll < critChance) {
            damage = attackPower * 2;
            System.out.println("[Xạ thủ] " + name + " bắn CHÍ MẠNG vào " + target.getName() + " gây " + damage + " sát thương!");
        } else {
            System.out.println("[Xạ thủ] " + name + " bắn " + target.getName() + " gây " + damage + " sát thương.");
        }

        target.takeDamage(damage);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        int damage = attackPower + 30;
        System.out.println("[Xạ thủ] " + name + " dùng chiêu cuối: MƯA TÊN!");
        System.out.println("Gây " + damage + " sát thương lên " + target.getName());
        target.takeDamage(damage);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Tỉ lệ chí mạng: " + critChance + "%");
    }
}