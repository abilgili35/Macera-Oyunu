public class SafeHouse extends NormalLocation{
    
    public SafeHouse(Player player){
        super(player, "Guvenli Ev");
    }

    @Override
    public boolean onLocation(){
        clearScreen();
        System.out.println("################## GUVENLI EV ####################");
        System.out.println();
        System.out.println("Güvenli evdesiniz!");
        System.out.println("Caniniz yenilendi!");
        this.getPlayer().heal();
        this.getPlayer().printInfo();
        if(this.getPlayer().canWin()){
            System.out.println("Oyunu kazandiniz! Tebrikler!");
            return false;
        }else{
            System.out.println("Oyunu kazanmak için : ");
            
            if(!this.getPlayer().getInventory().hasFood()){
                System.out.println(" - Yemek");
            }
            
            if(!this.getPlayer().getInventory().hasWater()){
                System.out.println(" - Su");
            }

            if(!this.getPlayer().getInventory().hasFireWood()){
                System.out.println(" - Odun");
            }
            System.out.println("elde etmeniz gerekiyor.");
            
        }
        askToContinue();
        return true;
    }

    
}
