public class Monster {
    private int id;
    private int damage;
    private int healt;
    private int award;
    private String name;
    private int fullHealth;
    
    

    

    public Monster(String name, int id, int damage, int health, int award){
        setName(name);
        setId(id);
        setDamage(damage);
        setHealt(health);
        setAward(award);
        setFullHealth(health);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealt() {
        return healt;
    }

    public void setHealt(int healt) {
        if(healt < 0){
            healt = 0;
        }
        this.healt = healt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getFullHealth() {
        return fullHealth;
    }

    public void setFullHealth(int fullHealth) {
        this.fullHealth = fullHealth;
    }
}
