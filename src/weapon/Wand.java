package weapon;

public class Wand extends Weapon{
    public Wand() {
        super("魔法の杖", 15,10);
    }

    @Override
    public String attackMessage() {
        return "から魔法を放った！";
    }
}
