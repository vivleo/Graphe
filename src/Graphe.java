import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graphe {
    private LinkedList<Noeud> noeuds;
    private HashMap<Integer, Boolean> boolMap;

    public Graphe(){
        this.noeuds=new LinkedList<>();
        this.boolMap=new HashMap<>();
    }

    public Graphe(int k){
        this.noeuds=new LinkedList<>();
        this.boolMap=new HashMap<>();
        for (int i=1;i<k;i++){
            this.noeuds.add(new Noeud(i));
        }
    }
/*
    public Graphe(String file){
        String fileExt=file+".csv";
        BufferedReader br=null;
        String line = "";
        String sep=";";
        ArrayList<String> couple=new ArrayList<>();
        try{
            br = new BufferedReader(new FileReader(fileExt));
            while ((line=br.readLine())!=null){

            }
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }*/

    public void addNoeud(int n){
        if(!this.noeuds.contains(n))
            this.noeuds.add(new Noeud(n));
    }

    public Noeud getNoeud(int n){
        for (Noeud node : noeuds){
            if (node.getId()==n)
                return node;
        }
        return null;
    }

    public void addArc(int x, int y){
        Noeud beg=getNoeud(x);
        Noeud targ=getNoeud(y);
        if (beg!=null && targ != null){
            if (!beg.hasSucc(y)){
                Arc a=new Arc(beg,targ);
                beg.addArc(a);
            }
        }
    }
    public void parcours(){
        for (Noeud n : this.noeuds){
            boolMap.put(n.getId(),false);
        }
        for (Noeud n : this.noeuds){
            if (!boolMap.get(n.getId())){
                profR(n,0);
            }
        }
    }
    public void profR(Noeud n, int cmptr){
        boolMap.replace(n.getId(),true);
        System.out.println(n.toString());
        for (Arc nbis : n.getSucc()){
            if (!boolMap.get(nbis.getTarg().getId())){
                for (int i =0;i<cmptr;i++) {
                    System.out.print("-");
                }
                profR(nbis.getTarg(),cmptr++);
            }
        }
    }

    @Override
    public String toString(){
        String resu="";
        for (Noeud n:noeuds){
            resu+=n.toString()+" : ";
            for (Arc a:n.getSucc()){
                resu+=a.getTarg().toString();
            }
            resu+="\n";
        }
        return resu;
    }

}
