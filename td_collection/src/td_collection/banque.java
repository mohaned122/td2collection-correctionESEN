/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package td_collection;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author zayoud_mohanned
 */
public class banque {
    private TreeMap<Integer,compte> map;
    private String nom;

    public banque(String nom) {
        this.map = new TreeMap<Integer,compte>();
        this.nom = nom;
    }
    
    public void creerCompte(double init){
        compte c = new compte(init);
        map.put(c.getNemuro(), c);
    }
    
    public boolean isNumCompte(int n){
        return map.containsKey(n);
    }
    
    public boolean depot(int num, double m){
        if(isNumCompte(num)){
            compte c = new compte(map.get(num).getSold()+m);
            map.put(num, c);
            return true;
        }
        return false;
    }
    
    public boolean virerVers(double m, int numS, int numD, banque b){
        if(this.isNumCompte(numS) && b.isNumCompte(numD)){
            map.get(numS).retraitSold(m);
            b.map.get(numD).ajoutSold(m);
        }
        return false;
    }
    
    public boolean virerVers(double m, int numS, int numD){
         return virerVers(m,numS,numD, this);
    }
    
    private compte getCompteDeNum(int n){
        return this.map.get(n);
    }
    
    public double getSoldeTous(){
        double tous =0;
        for(Map.Entry mapentry :map.entrySet()){
            compte c = (compte) mapentry.getValue();
            tous += c.getSold();
        }
        return tous;
    }
    
    public void supprimerNull(){
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
           Map.Entry mapentry = (Map.Entry) it.next();
           compte c = (compte) mapentry.getValue();
           if(c.getSold() == 0){
               it.remove();
           }
        }
    }
}
