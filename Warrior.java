package ThuchanhnhomSs11;
public class Warrior extends GameCharacter implements ISkill{
    private int armor;
    public Warrior(String name, int hp, int attackPower,int armor, Faction faction) {
        super(name, hp, attackPower, faction);
        this.armor=armor;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("[Chiến binh] " + name + " tấn công " + target.getName() + "!");
        target.takeDamage(attackPower);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println("[Chiến binh] " + name + " dùng chiêu cuối Đấm ngàn cân!");
        int damage = attackPower * 2;
        target.takeDamage(damage);

        int selfDamage = hp / 10;
        hp -= selfDamage;
        System.out.println(name + " mất " + selfDamage + " HP do gắng sức!");
    }
    @Override
    public void takeDamage(int amount){
        int realDamage = amount - armor;
        if (realDamage < 0) realDamage = 0;
        super.takeDamage(realDamage);
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Giáp: " + armor);
    }
}
