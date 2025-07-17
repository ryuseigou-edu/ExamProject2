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
    private static int matangoCnt = 0;
    private static int goblinCnt = 0;
    private static int slimeCnt = 0;
    private static ArrayList<Character> party = new ArrayList<>();
    private static ArrayList<Monster> monsters = new ArrayList<>();

    public static void main(String[] args) {
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



        do {
            System.out.println("味方の総攻撃！");
            Iterator<Character> itChar = party.iterator();
            while (itChar.hasNext()) {
                printEnemyStatus();
                Character curChar = itChar.next();
                System.out.print("[" + curChar.getName() + "]が攻撃するモンスターを選ぶんだドン(半角数字で頼む) >> ");
                Monster curTar = choiceTarget();
                curChar.attack(curTar);
                if (curTar.getHp() <= 5) {
                    curTar.run();
                    itChar.remove();
                } else if (!curTar.isAlive()) {
                    curTar.die();
                    itChar.remove();
                }
                if (monsters.isEmpty()) {
                    break;
                }
            }

            System.out.println();
            Iterator<Monster> itMon = monsters.iterator();
            System.out.println("敵の総攻撃！");
            while (itMon.hasNext()) {
                Monster curMon = itMon.next();
                Character curTar = party.get((int) (Math.random() * party.size()));
                curMon.attack(curTar);
                if (!curTar.isAlive()) {
                    curTar.die();
                    itMon.remove();
                }
                printPartyStatus();
                if (monsters.isEmpty()) {
                    break;
                }
            }
        } while (!party.isEmpty() && !monsters.isEmpty());

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
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int choice = Integer.parseInt(br.readLine());
                return monsters.get(choice - 1);
            } catch (IOException e) {
                System.err.println("あー入出力エラー。おわりやね。");
            } catch (NumberFormatException e) {
                System.err.println("マジ半角数字で頼む。");
            } catch (IndexOutOfBoundsException e) {
                System.err.println("存在するやつで頼む。");
            }
        } while (true);
    }

    private static void printPartyStatus() {
        System.out.println("---現在生存しているパーティーメンバー---");
        int index = 1;
        for (Character character : party) {
            if (character.isAlive()) {
                System.out.println(character.getName() + " HP: " + character.getHp());
                index++;
            }
        }
        if (index == 1) {
            System.out.println("全てのモンスターは討伐されました！");
        }
        System.out.println("--------------------------------");
    }
    private static void printEnemyStatus() {
        System.out.println("---現在生存しているモンスター---");
        int index = 1;
        for (Monster monster : monsters) {
            if (monster.isAlive()) {
                System.out.println(index + ": " + monster.getName() + monster.getSuffix() + " HP: " + monster.getHp());
                index++;
            }
        }
        if (index == 1) {
            System.out.println("全てのモンスターは討伐されました！");
        }
        System.out.println("----------------------------");
    }
}
