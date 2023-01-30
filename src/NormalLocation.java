public abstract class NormalLocation extends Location {
    
    public NormalLocation(Player p, String name){
        super(p, name);
    }

    public boolean onLocation(){
        return false;
    }
}
