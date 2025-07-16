import java.util.ArrayList;
import creature.*;
import creature.Character;
import creature.character.*;
import creature.monster.*;

public class GameMaster {
    public static void main(String[] args) {
        //party init
        ArrayList<Character> party = new ArrayList<>();
        Hero hero = new Hero("勇者", 100);
        Wizard wizard = new Wizard("魔法使い", 60, 10);
        Thief thief = new Thief("盗賊", 70);
        party.add(hero);
        party.add(wizard);
        party.add(thief);

        //monsters init
        ArrayList<Monster> monsters = new ArrayList<>();
        Matango matango = new Matango(45, 'A');
        Goblin goblin = new Goblin(50, 'A');
        Slime slime = new Slime(40, 'A');
        monsters.add(matango);
        monsters.add(goblin);
        monsters.add(slime);

        System.out.println("---味方パーティー---");
        party.forEach(Character::showStatus);
        System.out.println("---敵グループ---");
        monsters.forEach(Monster::showStatus);
        System.out.println();

        System.out.println("味方の総攻撃！");
        for (Character character : party) {
            for (Monster monster : monsters) {
                character.attack(monster);
            }
        }

        System.out.println();

        System.out.println("敵の総攻撃！");
        for (Monster monster : monsters) {
            for (Character character : party) {
                monster.attack(character);
            }
        }
        System.out.println();

        //スーパーヒーロー進化
        SuperHero superHero = new SuperHero(hero);
        party.set(party.indexOf(hero), superHero);

        //スーパーヒーローの攻撃
        for (Monster monster : monsters) {
            superHero.attack(monster);
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
