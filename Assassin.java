package ThuchanhnhomSs11;
public class Assassin extends GameCharacter implements ISkill{
    private int critChance;
    private int dodgeChance;
    public Assassin(String name, int hp, int attackPower,int critChance,int dodgeChance) {
        super(name, hp, attackPower, Faction.TEAM_A);
        this.critChance=critChance;
        this.dodgeChance=dodgeChance;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("[Sát thủ] " + name + " tấn công " + target.getName() + "!");
        int damage = attackPower;
        int random=(int)(Math.random()*100);
        if(random>critChance){
            damage=damage*2;
            System.out.println("Đòn chí mạng!");

        }
        target.takeDamage(damage);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println("[Sát thủ] " + name + " dùng chiêu cuối Ám Sát!");
        target.takeDamage(attackPower * 3);
    }
    @Override
    public void takeDamage(int amount) {
        int random = (int)(Math.random() * 100);
        if (random < dodgeChance) {
            System.out.println(name + " né được đòn tấn công!");
            return;
        }
        super.takeDamage(amount);
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Tên: " + name +
                        " | HP: " + hp +
                        " | Crit: " + critChance + "%" +
                        " | Né: " + dodgeChance + "%"
        );
    }
}