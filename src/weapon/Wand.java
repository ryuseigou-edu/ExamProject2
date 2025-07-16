package weapon;

public class Wand extends Weapon{
    Wand() {
        super("魔法の杖", 15);
    }

    @Override
    public String attackMessage() {
        return "から魔法を放った！";
    }
}
