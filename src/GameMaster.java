import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import creature.*;
import creature.Character;
import creature.character.*;
import creature.monster.*;

public class GameMaster {
    public static int matangoCnt = 0;
    public static int goblinCnt = 0;
    public static int slimeCnt = 0;

    public static void main(String[] args) {
        ArrayList<Character> party = new ArrayList<>();
        ArrayList<Monster> monsters = new ArrayList<>();
        do {
            //party init
            Hero hero = new Hero("勇者", 100);
            Wizard wizard = new Wizard("魔法使い", 60, 10);
            Thief thief = new Thief("盗賊", 70);
            party.add(hero);
            party.add(wizard);
            party.add(thief);

            //monsters init
            for (int i = 0; i < 5; i++) {
                monsters.add(choiceEnemy());
            }

            System.out.println("---味方パーティー---");
            party.forEach(Character::showStatus);
            System.out.println("---敵グループ---");
            monsters.forEach(Monster::showStatus);
            System.out.println();

            Iterator<Character> it = party.iterator();
            System.out.println("味方の総攻撃！");
            while(it.hasNext()) {
                Character cur = it.next();


                if() {}
                if(monsters.isEmpty()) {
                    break;
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
                if (character.isAlive()) {
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
                if (monster.isAlive()) {
                    isAlive = "生存";
                } else {
                    isAlive = "討伐済み";
                }
                System.out.println("生存状況：" + isAlive);
            }
        } while (party.isEmpty() || monsters.isEmpty());
    }
    private static Monster choiceEnemy() {
        switch ((int)(Math.random() * 3)) {
            case 0:
                return new Matango(45, (char) ('A' + matangoCnt++));
            case 1:
                return new Goblin(50, (char) ('A' + goblinCnt++));
            case 2:
                return new Slime(40, (char) ('A' + slimeCnt++));
        }
        return null;
    }
    private static Monster choiceTarget() {
        do {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int choice = Integer.parseInt(br.readLine());
                switch (choice) {
                    case 1:
                        return choiceTarget();
                        break;

                }
            } catch (IOException e) {
                System.err.println("あー入出力エラー。おわりやね。");
            } catch (NumberFormatException e) {
                System.err.println("マジ半角数字で頼む。");
            } catch (NullPointerException e) {
                System.err.println("なんか入れろや。");
            }
        } while ();
        switch
    }
}
