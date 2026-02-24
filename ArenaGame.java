package ThuchanhnhomSs11;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ArenaGame {

    private static int countAlive(List<GameCharacter> characters) {
        int count = 0;
        for (GameCharacter character : characters) {
            if (character != null && character.getHp() > 0) {
                count++;
            }
        }
        return count;
    }

    private static Set<Faction> aliveFactions(List<GameCharacter> characters) {
        Set<Faction> factions = new HashSet<>();
        for (GameCharacter character : characters) {
            if (character != null && character.getHp() > 0) {
                factions.add(character.getFaction());
            }
        }
        return factions;
    }

    private static Faction getWinningFaction(List<GameCharacter> characters) {
        Set<Faction> factions = aliveFactions(characters);
        if (factions.size() == 1) {
            return factions.iterator().next();
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println("=== ARENA OF HEROES ===");

        List<GameCharacter> characters = new ArrayList<>();

        // Team A
        characters.add(new Warrior("Yasuo", 500, 50, 20, Faction.TEAM_A));
        characters.add(new Mage("Veigar", 300, 40, 200, Faction.TEAM_A));
        characters.add(new Archer("Ashe", 280, 35, 40, Faction.TEAM_A));
        characters.add(new Assassin("Zed", 260, 45, 50, 40));

        // Team B (Goblin team)
        characters.add(new Goblin("Goblin 1", 120, 15, Faction.TEAM_B));
        characters.add(new Goblin("Goblin 2", 100, 10, Faction.TEAM_B));
        characters.add(new Goblin("Goblin 3", 80, 12, Faction.TEAM_B));

        System.out.println("Tổng số nhân vật: " + GameCharacter.count);


        Random random = new Random();
        int round = 1;

        while (aliveFactions(characters).size() > 1 && countAlive(characters) > 1) {
            System.out.println("=== Vòng " + round + " ===");

            for (GameCharacter attacker : characters) {

                if (attacker == null || attacker.getHp() <= 0) {
                    continue;
                }

                List<GameCharacter> possibleTargets = new ArrayList<>();
                for (GameCharacter target : characters) {
                    if (target == null || target == attacker) continue;
                    if (target.getHp() > 0 && target.getFaction() != attacker.getFaction()) {
                        possibleTargets.add(target);
                    }
                }

                if (possibleTargets.isEmpty()) {
                    continue;
                }

                GameCharacter target = possibleTargets.get(random.nextInt(possibleTargets.size()));

                System.out.println("\nLượt của " + attacker.getName() + ":");

                if (attacker instanceof ISkill && random.nextBoolean()) {
                    ((ISkill) attacker).useUltimate(target);
                } else {
                    attacker.attack(target);
                }

                if (aliveFactions(characters).size() <= 1 || countAlive(characters) <= 1) {
                    break;
                }
            }

            System.out.println();
            round++;
        }

        System.out.println("\n=== TRẠNG THÁI CUỐI ===");

        for (GameCharacter character : characters) {
            if (character != null) {
                character.displayInfo();
            }
        }

        Faction winningFaction = getWinningFaction(characters);
        if (winningFaction != null) {
            System.out.println("\n>>> Chiến thắng thuộc về phe: " + winningFaction + "!");
        } else {
            System.out.println("\nKhông có phe nào sống sót, hòa cả làng.");
        }
    }
}
