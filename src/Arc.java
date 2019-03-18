public class Arc {
    private Noeud src;
    private Noeud targ;

    public Arc(Noeud x, Noeud y){
        this.src=x;
        this.targ=y;
    }
    @Override
    public String toString(){
        return "Noeud Source : "+src.toString()+" | Noeud cible : "+targ.toString();
    }

    public Noeud getTarg(){
        return this.targ;
    }

    public Noeud getSrc(){ return this.src;}
}
