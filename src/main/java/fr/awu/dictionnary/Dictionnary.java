package fr.awu.dictionnary;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionnary {
    private HashMap<String, ArrayList<String>> dictionnary;

    public Dictionnary() {
        this.dictionnary = new HashMap<>();
    }

    public void add(String w, String t){
        if(!this.dictionnary.containsKey(w)){
            this.dictionnary.put(w, new ArrayList<String>());
        }
        if(!this.dictionnary.get(w).contains(t)){
            this.dictionnary.get(w).add(t);
        }
    }
    
}
