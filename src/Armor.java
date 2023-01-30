public class Armor {
    private int id;
    private int block;
    private int price;
    private String name;

    

    public Armor(int id, String name, int block, int price){
        setName(name);
        setId(id);
        setBlock(block);
        setPrice(price);
    }

    public static Armor getArmorObjById(int id){
        Armor armor = null;

        for(Armor a : Armor.armors()){
            if(a.getId() == id){
                armor = a;
            }
        }

        return armor;
    }

    public static Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1, "Hafif", 1, 15);
        armorList[1] = new Armor(2, "Orta", 3, 25);
        armorList[2] = new Armor(3, "Agir", 5, 40);

        return armorList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
