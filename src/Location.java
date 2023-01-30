import java.io.IOException;
import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;
    public static Scanner input = new Scanner(System.in);

    

    public Location(Player player, String name){
        setPlayer(player);
        setName(name);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void askToContinue(){
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

    protected void clearScreen(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    abstract boolean onLocation();

}
