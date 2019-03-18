public class RandomGraphe extends Graphe {

    public RandomGraphe(int n,double p) {
        super(n);
        int src=1;
        int targ=-1;
        double r;
        while (src<n){
            r=Math.random();
            targ += 1 + (Math.log(1-r)/Math.log(1-p));
            while (targ >= src && src < n){
                targ-=src;
                src++;
            }
            if ( src < n){
                this.addArc(src,targ);
            }
        }
    }

    public RandomGraphe(int n, int m){
        for (int i = 0 ; i < m ; i++){
            double rand=Math.random();
            int r = (int) (rand * combi(2, n) - 1);
            int [] tab=bijection(r);
            Noeud n1=new Noeud(tab[0]);
            Noeud n2=new Noeud(tab[1]);
            this.addNoeud(n1.getId());
            this.addNoeud(n2.getId());
            this.addArc(n1.getId(),n2.getId());
        }
    }

    private int combi(int k, int n){
        return factorielle(n)/(factorielle(k)*factorielle(n-k));
    }

    private int factorielle(int i){
        if (i == 0)
            return 1;
        if (i == 1)
            return 1;
        else return factorielle(i-1)*i;
    }

    private int [] bijection(int i){
        int v=1+(int)Math.floor(-(1/2)+Math.sqrt((1/4)+2*i));
        int w=i-((v*(v-1))/2);
        return new int[]{v,w};
    }
}
