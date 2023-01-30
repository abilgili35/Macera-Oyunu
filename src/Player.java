public class Player {
    
    private int damage;
    private int health;
    private int money;
    private String name;
    private GameChar gameChar;
    private Inventory inventory;
    
    public Player(String name){
        this.setName(name);
        this.gameChar = null;
        this.inventory = new Inventory();
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
            return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameChar getGameChar() {
        return gameChar;
    }

    public void setGameChar(GameChar gameChar) {
        this.gameChar = gameChar;
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.heal();
    }

    public String getCharName(){
        if(this.gameChar != null){
            return gameChar.getName();
        }
        return "";
    }

    public Inventory getInventory() {
        return inventory;
    }


    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }

    public void heal(){
        setHealth(gameChar.getHealth());
    }

    public void addInventory(String itemName){
        if(itemName.equals("food")){
            this.getInventory().setFood(true);
        }else if(itemName.equals("water")){
            this.getInventory().setWater(true);
        }else if(itemName.equals("firewood")){
            this.getInventory().setFireWood(true);
        }
    }

    public boolean checkInventory(String itemName){
        if(itemName.equals("food")){
            return this.getInventory().hasFood();
        }else if(itemName.equals("water")){
            return this.getInventory().hasWater();
        }else if(itemName.equals("firewood")){
            return this.getInventory().hasFireWood();
        }

        return false;
    }

    public boolean canWin(){
        return this.getInventory().hasFood() && this.getInventory().hasFireWood() && this.getInventory().hasWater();
    }

    public void printInfo(){
        System.out.println();
        System.out.println();
        System.out.println(
            "Karakter Adi : " + this.getCharName() +
            " - Silah : " + this.getInventory().getWeapon().getName() +
            " - Zirh : " + this.getInventory().getArmor().getName() +
            " - Bloklama : " + this.getInventory().getArmor().getBlock() +
            " - Hasar : " + this.getTotalDamage() +
            " - Saglik : " + this.getHealth() + 
            " - Para : " + this.getMoney());
        System.out.println();

    }
}
