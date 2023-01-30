public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean food;
    private boolean fireWood;
    private boolean water;
    

    

    public Inventory(){
        this.weapon = new Weapon("Yumruk", 0, 0, 0);
        this.armor = new Armor(0, "Pacavra", 0, 0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean hasFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean hasFireWood() {
        return fireWood;
    }

    public void setFireWood(boolean fireWood) {
        this.fireWood = fireWood;
    }

    public boolean hasWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

}
