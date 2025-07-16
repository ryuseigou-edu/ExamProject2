package creature.character;

import creature.Character;
import creature.Creature;

public class Thief extends Character {
    public Thief(final String name, final int hp) {
        super(name,hp);
    }

    @Override
    public void attack(final Creature target) {
        System.out.println
                (this.getName() + "は素早く攻撃した！" + target.getName() + "に5のダメージを与えた！");
        target.setHp(target.getHp() - 5);
    }
}
