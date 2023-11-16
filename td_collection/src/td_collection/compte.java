/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package td_collection;

/**
 *
 * @author zayoud_mohanned
 */
public class compte implements Comparable{
    
    public static int i = 0;
    private int nemuro;
    private double sold;

    public compte(double sold) {
        this.nemuro = i++;
        this.sold = sold;
    }

    public int getNemuro() {
        return nemuro;
    }

    public void setNemuro(int nemuro) {
        this.nemuro = nemuro;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }
    
    public void ajoutSold(double monttant){
        this.sold +=monttant;
    }
    
    public void retraitSold(double manttant){
        this.sold -=manttant;
    }

    @Override
    public int compareTo(Object o) {
        compte c = (compte)o;
        return (int)(this.sold - c.sold);
    }
}
