public class Goblin extends Monster {
    public Goblin(final String name, final int hp, final char suffix) {
        super(name, hp, suffix);
    }

    @Override
    public void attack(Creature target) {
        System.out.println
                ("ゴブリン" + this.getSuffix() + "はナイフで切り付けた！" + target.getName() + "に8のダメージを与えた！");
        target.setHp(target.getHp() - 8);
    }
}
