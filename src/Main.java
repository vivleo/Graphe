public class Main {
    public static void main(String[] args) {
        Graphe g=new Graphe(5);
        g.addArc(1,3);
        g.addArc(2,4);
        System.out.println(g.toString());
        g.parcours();
    }
}
