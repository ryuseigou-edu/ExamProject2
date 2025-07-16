public class SuperHero extends Hero {
    public SuperHero(final Hero hero) {
        super(hero.getName(), hero.getHp(), hero.getWeapon());
        System.out.println("ダメージを受けた勇者が突然光だした！");
        System.out.println("勇者はスーパーヒーローに進化した！");
    }

    @Override
    public void attack(final Creature target) {
        System.out.println(getName() + "は" + this.getWeapon() + "で攻撃！" + target.getName() + "に25のダメージを与えた！");
        target.setHp(target.getHp() - 25);
    }
}
