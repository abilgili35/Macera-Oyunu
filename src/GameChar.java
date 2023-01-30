public abstract class GameChar {
    private int damage;
    private int health;
    private int money;
    private String name; 

    

    public GameChar(String name, int damage, int health, int money){
        setName(name);
        setDamage(damage);
        setHealth(health);
        setMoney(money);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
