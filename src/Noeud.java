import java.util.LinkedList;

public class Noeud {
    private final int id;
    private LinkedList<Arc> succ =new LinkedList<>();
    boolean mark;

    public Noeud(int id){
        this.id=id;
    }

    @Override
    public String toString(){
        return Integer.toString(this.id);
    }

    public int getId(){
        return this.id;
    }

    public LinkedList<Arc> getSucc() {
        return succ;
    }

    public void setSucc(LinkedList<Arc> succ) {
        this.succ = succ;
    }

    public void addArc(Arc a){
        this.succ.add(a);
    }

    public boolean hasSucc(int j){
        for (int i=0;i<this.succ.size();i++){
            return this.succ.get(i).getTarg().getId()==j;
        }
        return false;
    }
}
