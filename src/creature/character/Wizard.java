package creature.character;

import creature.Character;
import creature.Creature;

public class Wizard extends Character {
    private int mp;

    public Wizard(final String name, final int hp, final int mp) {
        super(name,hp);
        this.mp = mp;
    }

    @Override
    public void attack(final Creature target) {
        System.out.println
                (this.getName() + "は火の玉を放った！" + target.getName() + "に3のダメージを与えた！");
        target.setHp(target.getHp() - 3);
        this.setMp(this.getMp() - 1);
    }

    public int getMp() {
        return this.mp;
    }
    public void setMp(final int mp) {
        this.mp = mp;
    }
}
