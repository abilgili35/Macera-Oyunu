import java.util.Random;

public class Snake extends Monster{
    Random r = new Random();

    public Snake(){
        super("Yilan", 4, 3, 12, 0);
        setDamage( getDamage() + r.nextInt(4));
    }

}
