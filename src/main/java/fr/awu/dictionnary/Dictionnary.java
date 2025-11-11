package fr.awu.dictionnary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Dictionnary {
    private HashMap<String, String> dictionnary;
    private ArrayList<String> words;
    private Random random = new Random();

    public Dictionnary() {
        this.dictionnary = new HashMap<>();
    }

    public void add(String w, String t){
        if(!this.words.contains(w)) this.words.add(w);
        this.dictionnary.put(w, t);
    }

    public String get(String w) throws Exception{
        if(!this.dictionnary.containsKey(w)) throw new IllegalArgumentException("Word doesn't exist");
        return this.dictionnary.get(w);
    }

    public String getRandom(){
        return this.words.get(random.nextInt(this.words.size()));
    }
    
}
