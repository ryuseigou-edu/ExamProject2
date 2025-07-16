import creature.*;
import creature.Character;
import creature.character.Hero;
import creature.character.SuperHero;
import creature.character.Thief;
import creature.character.Wizard;
import creature.monster.Goblin;
import creature.monster.Matango;
import creature.monster.Slime;

import java.util.ArrayList;

public class GameMaster {
    public static void main(String[] args) {
        //party init
        ArrayList<creature.Character> party = new ArrayList<creature.Character>();
        party.add(new Hero("勇者", 100));
        party.add(new Wizard("魔法使い", 60, 10));
        party.add(new Thief("盗賊", 70));

        //monsters init
        ArrayList<Monster> monsters = new ArrayList<Monster>();
        monsters.add(new Matango("お化けキノコ", 45, 'A'));
        monsters.add(new Goblin("ゴブリン", 50, 'A'));
        monsters.add(new Slime("スライム", 40, 'A'));

        System.out.println("---味方パーティー---");
        party.forEach(creature.Character::showStatus);
        System.out.println("---敵グループ---");
        monsters.forEach(Monster::showStatus);
        System.out.println();

        System.out.println("味方の総攻撃！");
        for (creature.Character character : party) {
            for (Monster monster : monsters) {
                character.attack(monster);
            }
        }

        System.out.println();

        System.out.println("敵の総攻撃！");
        for (Monster monster : monsters) {
            for (creature.Character character : party) {
                monster.attack(character);
            }
        }
        System.out.println();

        //スーパーヒーロー進化
        int heroIndex = -1;
        for (int i = 0; i < party.size(); i++) {
            if(party.get(i) instanceof Hero){
                heroIndex = i;
                break;
            }
        }

        party.set(heroIndex, new SuperHero((Hero) party.get(heroIndex)));
        for (Monster monster : monsters) {
            party.get(heroIndex).attack(monster);
        }
        System.out.println();

        System.out.println("---味方パーティ最終ステータス---");
        for (Character character : party) {
            character.showStatus();

            String isAlive;
            if(character.isAlive()){
                isAlive = "生存";
            } else {
                isAlive = "戦闘不能";
            }
            System.out.println("生存状況：" + isAlive);
        }

        System.out.println();
        System.out.println("---敵グループ最終ステータス---");
        for (Monster monster : monsters) {
            monster.showStatus();

            String isAlive;
            if(monster.isAlive()){
                isAlive = "生存";
            } else {
                isAlive = "討伐済み";
            }
            System.out.println("生存状況：" + isAlive);
        }
    }
}
