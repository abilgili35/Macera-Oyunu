import java.util.Random;

public class Mine extends BattleLoc {
    public Mine(Player player){
        super(player, "Maden", new Snake(), "", 5);
    }

    private void winMoney(){
        Random r = new Random();
        int randNum = r.nextInt(100) + 1;

        if( (randNum > 0) && (randNum <= 20)){
            System.out.println(10 + " para kazandiniz.");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);                
            System.out.println("Guncel paraniz : " + this.getPlayer().getMoney());
            System.out.println();
        }else if( (randNum > 20) && (randNum <= 50) ){
            System.out.println(5 + " para kazandiniz.");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);                
            System.out.println("Guncel paraniz : " + this.getPlayer().getMoney());
            System.out.println();
        }else if(randNum > 50){
            System.out.println(1 + " para kazandiniz.");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);                
            System.out.println("Guncel paraniz : " + this.getPlayer().getMoney());
            System.out.println();
        }
    }

    private void winWeapon(){
        Random r = new Random();
        int randNum = r.nextInt(100) + 1;
        Weapon awardWeapon = null;

        if( (randNum > 0) && (randNum <= 50)){
            System.out.println( Weapon.weapons()[0].getName() + " kazandiniz!");
            awardWeapon = Weapon.weapons()[0];
        }else if( (randNum > 50) && (randNum <= 80) ){
            System.out.println( Weapon.weapons()[1].getName() + " kazandiniz!");
            awardWeapon = Weapon.weapons()[1];
        }else if(randNum > 80){
            System.out.println( Weapon.weapons()[2].getName() + " kazandiniz!");
            awardWeapon = Weapon.weapons()[2];
        }
        System.out.println();
        System.out.println("Mevcut silahiniz : " + this.getPlayer().getInventory().getWeapon().getName());

        if(this.getPlayer().getInventory().getWeapon().getId() < awardWeapon.getId()){
            System.out.println(awardWeapon.getName() + " envanterinizdeki silahdan daha iyi.");
            System.out.println(awardWeapon.getName() + " envanterinizdeki silah ile degistirildi!");
            this.getPlayer().getInventory().setWeapon(awardWeapon);
        }else{
            System.out.println(awardWeapon.getName() + " envanterinizdeki silahdan daha iyi degil.");
            System.out.println("Envanterinizdeki silah degistirilmedi!");
        }
    }

    private void winArmor(){
        Random r = new Random();
        int randNum = r.nextInt(100) + 1;
        Armor awardArmor = null;

        if( (randNum > 0) && (randNum <= 50)){
            System.out.println( Armor.armors()[0].getName() + " kazandiniz!");
            awardArmor = Armor.armors()[0];
        }else if( (randNum > 50) && (randNum <= 80) ){
            System.out.println( Armor.armors()[1] + " kazandiniz!");
            awardArmor = Armor.armors()[1];
        }else if(randNum > 80){
            System.out.println( Weapon.weapons()[2].getName() + " kazandiniz!");
            awardArmor = Armor.armors()[2];
        }
        System.out.println();
        System.out.println("Mevcut zirhiniz : " + this.getPlayer().getInventory().getArmor().getName());

        if(this.getPlayer().getInventory().getArmor().getId() < awardArmor.getId()){
            System.out.println(awardArmor.getName() + " envanterinizdeki zirhdan daha iyi.");
            System.out.println(awardArmor.getName() + " envanterinizdeki zirh ile degistirildi!");
            this.getPlayer().getInventory().setArmor(awardArmor);
        }else{
            System.out.println(awardArmor.getName() + " envanterinizdeki zirhdan daha iyi degil.");
            System.out.println("Envanterinizdeki zirh degistirilmedi!");
        }
    }

    protected void winCombat(){
        Random r = new Random();
        int randNum = r.nextInt(100) + 1;

        System.out.println("Dusmani Yendiniz!");

        if( (randNum > 0) && (randNum <= 15)){
            System.out.println("Silah kazandiniz!\n");
            winWeapon();
        }else if( (randNum > 15) && (randNum <= 30) ){
            System.out.println("Zirh kazandiniz!");
            winArmor();
        }else if( (randNum > 30) && (randNum <= 65) ){
            System.out.println("Para kazandiniz!\n");
            winMoney();
        }else{
            System.out.println("Hic birsey kazanamadiniz!");
        }
        
        //System.out.println(this.getMonster().getAward() + " para kazandiniz.");
        //this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());                
        //System.out.println("Guncel paraniz : " + this.getPlayer().getMoney());
        //System.out.println();
    }
}
