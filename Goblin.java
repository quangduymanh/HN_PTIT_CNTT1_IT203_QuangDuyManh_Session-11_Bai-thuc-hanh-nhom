package ThuchanhnhomSs11;
public class Goblin extends GameCharacter {

    public Goblin(String name, int hp, int attackPower, Faction faction) {
        super(name, hp, attackPower, faction);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("[Goblin] " + name + " cắn trộm " + target.getName() + "!");
        target.takeDamage(attackPower);
    }
}
