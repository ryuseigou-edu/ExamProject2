package creature.character;

import creature.Character;
import creature.Creature;
import weapon.Wand;

public class Wizard extends Character {
    private int mp;

    public Wizard(final String name, final int hp, final int mp) {
        super(name,hp,new Wand());
        setHp(mp);
    }

    @Override
    public void attack(final Creature target) {
        System.out.println
                (this.getName() + "は石を投げた！" + target.getName() + "に3のダメージを与えた！");
        target.setHp(target.getHp() - 3);
    }
    public void magic(final Creature target) {

    }

    public int getMp() {
        return this.mp;
    }
    public void setMp(final int mp) {
        this.mp = mp;
    }
}
