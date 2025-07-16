public class Hero extends Character {
    private String weapon;

    public Hero(final String name, final int hp, final String weapon) {
        super(name,hp);
        this.weapon = weapon;
    }

    @Override
    public void attack(final Creature target) {
        System.out.println
                (getName() + "は" + this.getWeapon() + "で攻撃！" + target.getName() + "に10のダメージを与えた！");
        target.setHp(target.getHp() - 10);
    }

    public String getWeapon() {
        return this.weapon;
    }
    public void setWeapon(final String weapon) {
        this.weapon = weapon;
    }
}
