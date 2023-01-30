import java.io.IOException;
import java.util.Random;

public abstract class BattleLoc extends Location {
    private Monster monster;
    private String award;
    private int maxObstacle;
    private boolean playerStarts;
    
    
    public BattleLoc(Player player, String name, Monster monster, String award, int maxObstacle){
        super(player, name);
        setAward(award);
        setMonster(monster);
        setMaxObstacle(maxObstacle);
        playerStarts = false;
    }

    

    

    @Override
    public boolean onLocation(){
        
        int monsterCount = this.randomObstacleCount();
        boolean returnValue = true;

        clearScreen();


        if(this.getPlayer().checkInventory(award)){
            System.out.println("Bu bolumu daha once tamamladiniz! Tekrar giris yapamazsiniz!");
            askToContinue();
            return true;
        }

        

        System.out.println("############### " + this.getName().toUpperCase() + " ###############");
        System.out.println();

        System.out.println("Su an buradasiniz : " + this.getName());
        System.out.println("Dikkatli ol! Burada " + monsterCount + " adet " + this.getMonster().getName() + " yasiyor.");
        System.out.print("<S>avaş veya <K>aç");
        String selectCase = input.next();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("S")){
            if(combat(monsterCount)){
                System.out.println(this.getName() + " daki tum dusmanlari yendiniz!");
                completeLocation();
                returnValue = true;
            }else{
                if(this.getPlayer().getHealth() <= 0){
                    returnValue = false;
                }else{
                    returnValue = true;
                }
                
            }
        }else if(selectCase.equals("K")){
            System.out.println("Kactiniz!");
            returnValue = true;
        }
        
        if(this.getPlayer().getHealth() < 0){
            returnValue = false;
        }

        
        askToContinue();
        return returnValue;
        
    }

    public void completeLocation(){
        System.out.println(this.getAward() + " envanterinize eklendi!");
        this.getPlayer().addInventory(this.getAward());
    }

    private void chooseStarter(){
        Random r = new Random();
        if((r.nextInt(100) + 1) <= 50){
            playerStarts = true;
        }else{
            playerStarts = false;
        }
    }

    public boolean combat(int monsterCount){
        for(int i=1; i<=monsterCount; i++){
            this.getMonster().setHealt(this.getMonster().getFullHealth());
            playerStats();
            monsterStats(i);
            chooseStarter();
            while(this.getPlayer().getHealth() > 0 && this.getMonster().getHealt() > 0){
                if(playerStarts == true){
                    System.out.println("<V>ur veya <K>ac");
                    String selectCombat = input.next().toUpperCase();
                    if(selectCombat.equals("V")){
                        System.out.println("\nSiz Vurdunuz!");
                        this.monster.setHealt(monster.getHealt() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if(this.getMonster().getHealt() > 0){
                            System.out.println();
                            System.out.println("Canavar Size Vurdu!");
                            int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if(monsterDamage < 0){
                                monsterDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                            afterHit();
                        }
                    }else if(selectCombat.equals("K")){
                        return false;
                    }
                }else{
                    System.out.println();
                    System.out.println("Canavar Size Vurdu!");
                    int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                    if(monsterDamage < 0){
                        monsterDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                    afterHit();
                    if(this.getPlayer().getHealth() > 0){
                        System.out.println("<V>ur veya <K>ac");
                        String selectCombat = input.next().toUpperCase();
                        if(selectCombat.equals("V")){
                            System.out.println("\nSiz Vurdunuz!");
                            this.monster.setHealt(monster.getHealt() - this.getPlayer().getTotalDamage());
                            afterHit();
                        }else if(selectCombat.equals("K")){
                            return false;
                        }
                    }
                }
                
            }
            if(this.getMonster().getHealt() < this.getPlayer().getHealth()){
                winCombat();
            }else if(this.getPlayer().getHealth() <= 0){
                System.out.println("Oldunuz!");
                return false;
            }
        }
        return true;
    }

    protected void winCombat(){
        System.out.println("Dusmani Yendiniz!");
        System.out.println(this.getMonster().getAward() + " para kazandiniz.");
        this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());                
        System.out.println("Guncel paraniz : " + this.getPlayer().getMoney());
        System.out.println();
    }

    public void afterHit(){
        System.out.println("Caniniz " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + " Cani : " + this.getMonster().getHealt() + "\n");
    }

    public void monsterStats(int i){
        System.out.println();
        System.out.println(i + ". " + this.getMonster().getName() + " Degerleri");
        System.out.println("-------------------------------------------");
        System.out.println("Saglik : " + this.getMonster().getHealt());
        System.out.println("Hasar : " + this.getMonster().getDamage());
        System.out.println("Odul : " + this.getMonster().getAward());


    }

    public void playerStats(){
        System.out.println();
        System.out.println("Oyuncu Degerleri");
        System.out.println("--------------------------");
        System.out.println("Saglik : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getWeapon().getName());
        System.out.println("Zirh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Para : " + this.getPlayer().getMoney());
        
    }

    public int randomObstacleCount(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Monster getMonster() {
        
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    
}
