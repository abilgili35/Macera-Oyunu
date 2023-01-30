public class ToolStore extends NormalLocation {
    
    public ToolStore(Player player){
        super(player, "Magaza");
    }

    public void printWeapon(){
        System.out.println("\nSilahlar");
        System.out.println();
        System.out.println("0  -  Cikis Yap.");
        for(Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + " - " + w.getName() + " < Fiyat : " +  w.getPrice() + " , Hasar : " + w.getDamage() + " > ");
        }

        System.out.println("Bir silah seciniz :");        
        
    }

    private void buyWeapon(){
        int selectWeaponID = input.nextInt();
        
        while(selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length){
            if(selectWeaponID == 0){
                return;
            }
            System.out.print("Gecersiz deger.Tekrar giriniz:");
            selectWeaponID = Location.input.nextInt();
        }

        Weapon selectedArmor = Weapon.getWeaaponObjById(selectWeaponID);

        if(selectedArmor != null){
            if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Yeterli paraniz bulunmamaktadir!");
            }else{
                System.out.println(selectedArmor.getName() + " silahini satin aldiniz.");
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paraniz : " + this.getPlayer().getMoney());
                System.out.println("Onceki Silahiniz : " + this.getPlayer().getInventory().getWeapon().getName() );
                this.getPlayer().getInventory().setWeapon(selectedArmor);
                System.out.println("Yeni Silahiniz : " + this.getPlayer().getInventory().getWeapon().getName() );
            }
        }



        System.out.println();
    }

    public void printArmor(){
        System.out.println("---------Zırhlar----------");
        System.out.println("0  -  Cikis Yap.");
        for(Armor a : Armor.armors()){
            System.out.println(a.getId() + " - " + a.getName() + " < Fiyat : " +  a.getPrice() + " , Zirh : " + a.getBlock() + " > ");
        }

    }

    public void buyArmor(){
        System.out.print("Bir zirh seciniz.");
        int selectArmorID = input.nextInt();

        while(selectArmorID < 1 || selectArmorID > Armor.armors().length){
            if(selectArmorID == 0){
                return;
            }
            System.out.print("Gecersiz deger.Tekrar giriniz:");
            selectArmorID = Location.input.nextInt();
        }

        
        Armor selectedArmor = Armor.getArmorObjById(selectArmorID);

        if(selectedArmor != null){
            if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Yeterli paraniz bulunmamaktadir!");
            }else{
                System.out.println(selectedArmor.getName() + " zirhini satin aldiniz.");
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paraniz : " + this.getPlayer().getMoney());
                System.out.println("Onceki Zirhiniz : " + this.getPlayer().getInventory().getArmor().getName() );
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Yeni Zirhiniz : " + this.getPlayer().getInventory().getArmor().getName() );
            }
        }
        



    }

    public boolean onLocation(){
        boolean showMenu = true;
        clearScreen();
        System.out.println("################## MAGAZA ##################");
        while(showMenu){
            System.out.println("Tool Store dasiniz.!");
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Cıkış yap");
            System.out.print("Seciminiz.");
           
            int selectCase = Location.input.nextInt();
    
            while(selectCase < 1 || selectCase > 3){
                System.out.print("Gecersiz deger.Tekrar giriniz:");
                selectCase = Location.input.nextInt();
            }
    
            switch(selectCase){
                case 1: 
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz.");
                    showMenu = false;
                    break;
    
            }
        }
        askToContinue();
        return true;
    }
}
