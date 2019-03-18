package BellmanFord;

import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BellmanFord {
	 /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int[][] dizi = new int[40][40];
        int tepe = 0;
        String[] arrayLetter = {"A", "B", "C", "D", "E", "F", "G", "�", "H", "I", "�", "J", "K", "L", "M", "N",
            "O", "�", "P", "R", "S", "�", "T", "U", "�", "V", "Y", "Z"};
        int i = 0, j = 0, dugumsay = 0;
        File file = new File("dosya.txt");
        FileReader fileReader = new FileReader(file);
        String c;
        BufferedReader br = new BufferedReader(fileReader);
        String iki = "";
        //while i�inde dosyadan okudu�um degerleriint bir dizinin i�erisine att�m
        while ((c = br.readLine()) != null) {
            for (int h = 0; h < c.length(); h++) {
                while (c.charAt(h) != ',' && c.charAt(h) != ';') {

                    iki += c.charAt(h);
                    h++;
                }

                dizi[i][j] = Integer.parseInt(iki);
                iki = "";
                j++;
                if (c.charAt(h) == ';') {
                    j = 0;
                    i++;
                    dugumsay++;
                }
            }
        }
        br.close();
        for (int k = 0; k < dugumsay; k++) {
            for (j = 0; j < dugumsay; j++) {
                System.out.print(dizi[k][j] + "  ");
            }
            System.out.println();
        }
        int sayac = 0;
        System.out.println();
        System.out.println("");
        System.out.println("EDGE");
        int[] edge = new int[30];
        for (int k = 0; k < dugumsay; k++) {
            for (j = 0; j < dugumsay; j++) {
                if (dizi[k][j] != 0) {
                    System.out.println(arrayLetter[k] + " - " + arrayLetter[j] + " " + dizi[k][j]);
                    edge[sayac] = dizi[k][j];
                    sayac++;
                }
            }
        }
        System.out.println();
        System.out.println();
        for (int k = 0; k < dugumsay; k++) {
            for (int l = 0; l < dugumsay; l++) {
                if (k == l) {
                    dizi[k][l] = 0;
                    continue;
                }
                if (dizi[k][l] == 0) {
                    dizi[k][l] = 1000;
                }
            }
        }
        Scanner scn = new Scanner(System.in);
        System.out.println("Mevcut d���mler:");
        for (int k = 0; k < dugumsay; k++) {
            System.out.print(arrayLetter[k] + " ");
        }
        System.out.println();      
        System.out.println();
        bellman blm = new bellman(dugumsay);
        blm.BellmanMtd(0, dizi);
    }

}
