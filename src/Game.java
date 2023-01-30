import java.io.IOException;
import java.util.Scanner;

public class Game{

    private Scanner input = new Scanner(System.in); 
    private Player player;
    private Location location;

    public void start(){
        boolean condition;
        System.out.println("Macera oyununa Hosgeldiniz");
        System.out.println("Lutfen bir isim giriniz : ");
        String playerName = input.next();
        player = new Player(playerName);
        System.out.println(player.getName() + " Hosgeldiniz.\n\n");
    
        selectChar();
        do{
            condition = selectLocation();
        }while(condition == true);

        System.out.println("GAME OVER!");
        
    }

    private void clearScreen(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e){
            
            e.printStackTrace();
        }catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    public boolean selectLocation(){
        clearScreen();
        player.printInfo();
        System.out.println("################ Bolgeler #####################");
        System.out.println("0 - Cikis Yap");
        System.out.println("1 - Guvenli Ev");
        System.out.println("2 - Magaza");
        System.out.println("3 - Magara - Odul <Yemek>");
        System.out.println("4 - Orman - Odul <Odun>");
        System.out.println("5 - Nehir - Odul <Su>");
        System.out.println("6 - Maden - Odul <Para, Silah, Zirh>");
        System.out.println("Lutfen gitmek istediginiz bolgeyi seciniz :");
        int selectLocation = input.nextInt();

        switch(selectLocation){
            case 0:
                location = null;
                break;
            case 1:
                location = new SafeHouse(player);
                break;
            case 2:
                location = new ToolStore(player);
                break;
            case 3:
                location = new Cave(player);
                break;
            case 4:
                location = new Forest(player);
                break;
            case 5:
                location = new River(player);
                break;
            case 6:
                location = new Mine(player);
                break;
            default:
                System.out.println("Lutfen gecerli bir bolge giriniz.");
                return true;

        }
        
        if(location == null){
            System.out.println("Oyunu sonlandirdiniz.");
            return false;
        }

        if(!location.onLocation())
        {
            return false;
        }

        return true;
        
    }

    public void selectChar(){
        GameChar[] charList = {new Samurai(), new Knight(), new Archer()};
        System.out.println("################## Karakterler #######################");
        System.out.println("------------------------------------------------------------");
        int c = 1;
        for(GameChar g : charList){
            System.out.println(c + "\tKarakter:\t" + g.getName() + "\t Hasar:\t" + g.getDamage() +  "\t Saglik:\t"  + g.getHealth() + "\t Para:\t"  + g.getMoney() );
            c++;
        }

        System.out.println("------------------------------------------------------------");
        System.out.print("Lutfen bir karakter giriniz.");
        int selectChar = input.nextInt();
        GameChar selectedChar = charList[selectChar - 1];
        player.setGameChar(selectedChar); 
        player.printInfo();
        askToContinue();
    }

    private void askToContinue(){
        System.out.println("<D>evam...");
        while(true){
            
            String s = input.next();
            s = s.toUpperCase();
            if(s.equals("D")){
                break;
            }else{
                System.out.println("Gecersiz komut!");
            }
        }
    }

}