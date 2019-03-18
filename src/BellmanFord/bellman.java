/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BellmanFord;


/**
 *
 * @author 
 */
public class bellman {
    int kacdugum;
    String[] arrayLetter = {"A", "B", "C", "D", "E", "F", "G", "Ä�", "H", "I", "Ä°", "J", "K", "L", "M", "N",
            "O", "Ã–", "P", "R", "S", "Å�", "T", "U", "Ãœ", "V", "Y", "Z"};
    private int uzaklik[];
    public bellman(){
        
    }
    
    public bellman(int kacdugum) {
        this.kacdugum = kacdugum;
        uzaklik =new int[kacdugum];
    }

    void BellmanMtd(int tepe, int[][] dizi) {
        for (int i = 0; i < kacdugum; i++)        
            uzaklik[i] = 1000;
        uzaklik[tepe]=0;
       // for(int i = 0; i < kacdugum; i++){
            for(int j = 0; j < kacdugum-1; j++){
                for(int k = 0; k < kacdugum; k++){
                    //if(dizi[j][k]!=1000){
                        if(uzaklik[k] > uzaklik[j]+dizi[j][k]){
                            uzaklik[k]=uzaklik[j]+dizi[j][k];
                        }
                   // }
                }
            }
       // }
        for(int i = 0; i < kacdugum; i++){
            System.out.println("kaynak "+arrayLetter[tepe]+" varÄ±ÅŸ "+arrayLetter[i]+" uzaklÄ±klar "+uzaklik[i]);
        }
    }
    
}
