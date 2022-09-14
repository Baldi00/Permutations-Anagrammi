/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagrammi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Andrea
 */
public class Anagrammi {

    /**
     * @param args the command line arguments
     */
    
    
    static String parola = "domani";
    static ArrayList<Character> lettere = new ArrayList<>();
    static BufferedWriter bw;
    
    public static void main(String[] args) throws Exception{
        bw = new BufferedWriter(new FileWriter("out.txt"));
        System.out.println(Math.pow(6, 6));
        
        for(int i = 0; i<parola.length(); i++){
            lettere.add(parola.charAt(i));
        }
        
        recursive("");
        bw.close();
    }
    
    public static void recursive(String start) throws Exception{
        ArrayList<Character> lettereDiQuesta = new ArrayList<>();
        ArrayList<Character> lettereNonInQuesta = new ArrayList<>();
        
        for(int i = 0; i<start.length(); i++){
            lettereDiQuesta.add(start.charAt(i));
        }
        
        if(lettereDiQuesta.size() == lettere.size()){
            bw.write(start);
            bw.newLine();
            //System.out.println(start);
            return;
        }
        
        for(Character c : lettere){
            lettereNonInQuesta.add(c);
        }
        
        for(Character c : lettereDiQuesta){
            lettereNonInQuesta.remove(c);
        }
        
        for(Character c : lettereNonInQuesta){
            recursive(start+c);
        }
    }
    
}
