import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;


public class LangID {
    public static Hashtable<String, Float> PT_Uni = new Hashtable<String, Float>();
    public static Hashtable<String, Float> EU_Uni = new Hashtable<String, Float>();
    public static Hashtable<String, Float> CA_Uni = new Hashtable<String, Float>();
    public static Hashtable<String, Float> ES_Uni = new Hashtable<String, Float>();
    public static Hashtable<String, Float> EN_Uni = new Hashtable<String, Float>();
    public static Hashtable<String, Float> GL_Uni = new Hashtable<String, Float>(); 
    public static Hashtable<String, Hashtable<String, Float>> EU_Bi = new Hashtable<String, Hashtable<String, Float>>();
    public static Hashtable<String, Hashtable<String, Float>> CA_Bi = new Hashtable<String, Hashtable<String, Float>>();
    public static Hashtable<String, Hashtable<String, Float>> EN_Bi = new Hashtable<String, Hashtable<String, Float>>();
    public static Hashtable<String, Hashtable<String, Float>> PT_Bi = new Hashtable<String, Hashtable<String, Float>>();
    public static Hashtable<String, Hashtable<String, Float>> GL_Bi = new Hashtable<String, Hashtable<String, Float>>();
    public static Hashtable<String, Hashtable<String, Float>> ES_Bi = new Hashtable<String, Hashtable<String, Float>>();

    
    static BufferedReader readAfile = null;
    
    /**
     * constructs unigrams.
     * @param line a string representing the line
     * @param disc a string representing the discourse/ language
     */

    public static void devUnigrams(String line, String disc) {
        String myLine = (line.replaceAll("[^A-Za-z]+", "")).toLowerCase();
        line = myLine;
        String[] myLinestr = line.split("");

        if (disc.equals("es")) {            
            for (String ches : myLinestr) {                
                float count = ES_Uni.containsKey(ches) ? ES_Uni.get(ches) : 0;
                ES_Uni.put(ches, count + 1);
                ES_Uni.put("total", ES_Uni.get("total") + 1);
            }           
        }

        if (disc.equals("en")) {            
            for (String chen : myLinestr) {               
                float count = EN_Uni.containsKey(chen) ? EN_Uni.get(chen) : 0;
                EN_Uni.put(chen, count + 1);
                EN_Uni.put("total", EN_Uni.get("total") + 1);
            }            
        }

        if (disc.equals("pt")) {            
            for (String chpt : myLinestr) {                
                float count = PT_Uni.containsKey(chpt) ? PT_Uni.get(chpt) : 0;
                PT_Uni.put(chpt, count + 1);
                PT_Uni.put("total", PT_Uni.get("total") + 1);
            }            
        }

        if (disc.equals("ca")) {           
            for (String chca : myLinestr) {                
                float count = CA_Uni.containsKey(chca) ? CA_Uni.get(chca) : 0;
                CA_Uni.put(chca, count + 1);
                CA_Uni.put("total", CA_Uni.get("total") + 1);
            }           
        }

        if (disc.equals("eu")) {
            for (String cheu : myLinestr) {                
                float count = EU_Uni.containsKey(cheu) ? EU_Uni.get(cheu) : 0;
                EU_Uni.put(cheu, count + 1);
                EU_Uni.put("total", EU_Uni.get("total") + 1);
            }            
        }

        if (disc.equals("gl")) {           
            for (String chgl : myLinestr) {                
                float count = GL_Uni.containsKey(chgl) ? GL_Uni.get(chgl) : 0;
                GL_Uni.put(chgl, count + 1);
                GL_Uni.put("total", GL_Uni.get("total") + 1);
            }           
        }
    }

/**
 * Constructs bigrams.
 * @param line a string representing the line
 * @param disc a string representing the discourse/language
 */
    public static void devBigrams(String line, String disc) {
        String myLine = line.replaceAll("[^A-Za-z]+", "");
        line = myLine;
        String[] myLinestr = line.split("");  
        
        
        if (disc.equals("es")) {
            int size = myLinestr.length;

            for (int i = 0; i < size - 1; i++) {
                if (!((myLinestr[i].equals(" ")) || (myLinestr[i + 1].equals(" ")))) {
                    if (ES_Bi.containsKey(myLinestr[i])) {
                        float count = ES_Bi.get(myLinestr[i]).containsKey(myLinestr[i + 1]) ? ES_Bi.get(myLinestr[i]).get(myLinestr[i + 1]) : 0;
                        ES_Bi.get(myLinestr[i]).put(myLinestr[i + 1], count + 1);
                        ES_Bi.get(myLinestr[i]).put("total", ES_Bi.get(myLinestr[i]).get("total") + 1);
                    } else {
                        ES_Bi.put(myLinestr[i], new Hashtable<String, Float>());
                        ES_Bi.get(myLinestr[i]).put(myLinestr[i + 1], (float) 1);
                        ES_Bi.get(myLinestr[i]).put("total", (float) 1);
                    }
                }
            }
        }
        
        if (disc.equals("en")) {
            int size = myLinestr.length;

            for (int i = 0; i < size - 1; i++) {
                if (!((myLinestr[i].equals(" ")) || (myLinestr[i + 1].equals(" ")))) {
                    if (EN_Bi.containsKey(myLinestr[i])) {
                        float count =
                                        EN_Bi.get(myLinestr[i]).containsKey(myLinestr[i + 1]) ? EN_Bi.get(myLinestr[i]).get(
                                                        myLinestr[i + 1]) : 0;
                        EN_Bi.get(myLinestr[i]).put(myLinestr[i + 1], count + 1);
                        EN_Bi.get(myLinestr[i]).put("total", EN_Bi.get(myLinestr[i]).get("total") + 1);
                    } else {
                        EN_Bi.put(myLinestr[i], new Hashtable<String, Float>());
                        EN_Bi.get(myLinestr[i]).put(myLinestr[i + 1], (float) 1);
                        EN_Bi.get(myLinestr[i]).put("total", (float) 1);
                    }
                }
            }            
        }

        if (disc.equals("eu")) {
            int size = myLinestr.length;

            for (int i = 0; i < size - 1; i++) {
                if (!((myLinestr[i].equals(" ")) || (myLinestr[i + 1].equals(" ")))) {
                    if (EU_Bi.containsKey(myLinestr[i])) {
                        float count =
                                        EU_Bi.get(myLinestr[i]).containsKey(myLinestr[i + 1]) ? EU_Bi.get(myLinestr[i]).get(
                                                        myLinestr[i + 1]) : 0;
                        EU_Bi.get(myLinestr[i]).put(myLinestr[i + 1], count + 1);
                        EU_Bi.get(myLinestr[i]).put("total", EU_Bi.get(myLinestr[i]).get("total") + 1);
                    } else {
                        EU_Bi.put(myLinestr[i], new Hashtable<String, Float>());
                        EU_Bi.get(myLinestr[i]).put(myLinestr[i + 1], (float) 1);
                        EU_Bi.get(myLinestr[i]).put("total", (float) 1);
                    }
                }
            }          
        }

        if (disc.equals("pt")) {
            int size = myLinestr.length;
            for (int i = 0; i < size - 1; i++) {
                if (!((myLinestr[i].equals(" ")) || (myLinestr[i + 1].equals(" ")))) {
                    if (PT_Bi.containsKey(myLinestr[i])) {
                        float count =
                                        PT_Bi.get(myLinestr[i]).containsKey(myLinestr[i + 1]) ? PT_Bi.get(myLinestr[i]).get(
                                                        myLinestr[i + 1]) : 0;
                        PT_Bi.get(myLinestr[i]).put(myLinestr[i + 1], count + 1);
                        PT_Bi.get(myLinestr[i]).put("total", PT_Bi.get(myLinestr[i]).get("total") + 1);
                    } else {
                        PT_Bi.put(myLinestr[i], new Hashtable<String, Float>());
                        PT_Bi.get(myLinestr[i]).put(myLinestr[i + 1], (float) 1);
                        PT_Bi.get(myLinestr[i]).put("total", (float) 1);
                    }
                }
            }           

        }

        if (disc.equals("ca")) {
            int size = myLinestr.length;
            for (int i = 0; i < size - 1; i++) {
                if (!((myLinestr[i].equals(" ")) || (myLinestr[i + 1].equals(" ")))) {
                    if (CA_Bi.containsKey(myLinestr[i])) {
                        float count =
                                        CA_Bi.get(myLinestr[i]).containsKey(myLinestr[i + 1]) ? CA_Bi.get(myLinestr[i]).get(
                                                        myLinestr[i + 1]) : 0;
                        CA_Bi.get(myLinestr[i]).put(myLinestr[i + 1], count + 1);
                        CA_Bi.get(myLinestr[i]).put("total", CA_Bi.get(myLinestr[i]).get("total") + 1);
                    } else {
                        CA_Bi.put(myLinestr[i], new Hashtable<String, Float>());
                        CA_Bi.get(myLinestr[i]).put(myLinestr[i + 1], (float) 1);
                        CA_Bi.get(myLinestr[i]).put("total", (float) 1);
                    }
                }
            }
        }

        if (disc.equals("gl")) {
            int size = myLinestr.length;

            for (int i = 0; i < size - 1; i++) {
                if (!((myLinestr[i].equals(" ")) || (myLinestr[i + 1].equals(" ")))) {
                    if (GL_Bi.containsKey(myLinestr[i])) {
                        float count =
                                        GL_Bi.get(myLinestr[i]).containsKey(myLinestr[i + 1]) ? GL_Bi.get(myLinestr[i]).get(
                                                        myLinestr[i + 1]) : 0;
                        GL_Bi.get(myLinestr[i]).put(myLinestr[i + 1], count + 1);
                        GL_Bi.get(myLinestr[i]).put("total", GL_Bi.get(myLinestr[i]).get("total") + 1);
                    } else {
                        GL_Bi.put(myLinestr[i], new Hashtable<String, Float>());
                        GL_Bi.get(myLinestr[i]).put(myLinestr[i + 1], (float) 1);
                        GL_Bi.get(myLinestr[i]).put("total", (float) 1);
                    }
                }
            }
        }
    }
    /**
     * 
     * @param line
     * @param disc
     * @param myDictionary
     * @return
     */

    public static float findUniUnSmooth(String line, String disc, Hashtable<String, Float>myDictionary) {
        float result = 0;
        String myLine = (line.replaceAll("[^A-Za-z]+", "")).toLowerCase();
        line = myLine;
        String[] myLinestr = line.split("");
        for (String ch : myLinestr) {
            float count = myDictionary.containsKey(ch) ? myDictionary.get(ch) : 0;             
            if(count!=0)
            {
                result = (float) (result + (Math.log10(count/myDictionary.get("total")) ) );
            }             
            else
            {
                return -500;
            }
        }
        return result;      
    }
    /**
     * 
     * @param line a string representing the line
     * @param disc a string representing the discourse/language
     * @param myDictionary a hashtable representing the unigram
     * @return a float representing the probabilities 
     */
    
    public static float findUniSmooth(String line, String disc, Hashtable<String, Float>myDictionary) {
        float result = 0;
        String myLine = (line.replaceAll("[^A-Za-z]+", "")).toLowerCase();
        line = myLine;
        String[] myLinestr = line.split("");
        for (String ch : myLinestr) {
            float count = myDictionary.containsKey(ch) ? myDictionary.get(ch) : 0;      
            if(count!=0)
            {
            result = (float) (result + (Math.log10( (count+0.1) / (myDictionary.get("total")+ (myDictionary.size()*0.1) ) ) ) );
            }            
        }
        return result;      
    }
    
    public static float findBiUnSmooth(String line, String disc, Hashtable<String, Hashtable<String, Float>>myDictionary) {
        
        
        float result = 0;
        String myLine = (line.replaceAll("[^A-Za-z]+", "")).toLowerCase();
        line = myLine;
        
        String[] myLinestr = line.split("");
        int size =  myLinestr.length;
        
        for (int i=0; i<size-1; i++) {
            
            if( !( (myLinestr[i].equals(" ")) || (myLinestr[i+1].equals(" ")) ) )
            {
                if(myDictionary.containsKey(myLinestr[i]))
                {
                    float count = myDictionary.get(myLinestr[i]).containsKey(myLinestr[i+1]) ? myDictionary.get(myLinestr[i]).get(myLinestr[i+1]) : 0;
                    
                    if(count!=0)
                    {
                        result = (float) (result + (Math.log10(count/myDictionary.get(myLinestr[i]).get("total")) ) );
                    }       
                    else
                    {
                        return -500;
                    }
                }
                else
                {
                    return -500;
                }
                
                            
            }
        }   
        return result;  
    }
    
    
    public static float findBiSmooth(String line, String disc, Hashtable<String, Hashtable<String, Float>>myDictionary) {
       
        float result = 0;
        String myLine = (line.replaceAll("[^A-Za-z]+", "")).toLowerCase();
        
        line = myLine;
        String[] myLinestr = line.split("");
        int size =  myLinestr.length;
        
        for (int i=0; i<size-1; i++) {
            
            if( !( (myLinestr[i].equals(" ")) || (myLinestr[i+1].equals(" ")) ) )
            {
                if(myDictionary.containsKey(myLinestr[i]))
                {
                    float count = myDictionary.get(myLinestr[i]).containsKey(myLinestr[i+1]) ? myDictionary.get(myLinestr[i]).get(myLinestr[i+1]) : 0;
                    
                    result = (float) (result + (Math.log10( (count+0.1) / (myDictionary.get(myLinestr[i]).get("total") + (myDictionary.get(myLinestr[i]).size()*0.1) )) ) );
                            
                }

            }
        }   
        return result;  
    }
    /**
     * 
     * @param line
     * @param disc
     * @param id
     */
    
   
    public static void findLangUniUnSmooth(String line, String disc, String id) {
        
        String[]language = {"eu", "es", "pt", "ca", "en", "gl"};
        
        float finalVal = -500;
        String finalLang = "";
        float result = 0;
        
        for(String lan : language)
        {
            if(lan.equals("en"))
            {
                result = findUniUnSmooth(line, disc, EN_Uni);
            }
            else if(lan.equals("eu"))
            {
                result = findUniUnSmooth(line, disc, EU_Uni);
            }
            else if(lan.equals("es"))
            {
                result = findUniUnSmooth(line, disc, ES_Uni);
            }
            else if(lan.equals("pt"))
            {
                result = findUniUnSmooth(line, disc, PT_Uni);
            }
            else if(lan.equals("ca"))
            {
                result = findUniUnSmooth(line, disc, CA_Uni);
            }
            else if(lan.equals("gl"))
            {
                result = findUniUnSmooth(line, disc, GL_Uni);
            }
            
            
            
            if(finalVal < result)
            {
                
                finalVal = result;
                finalLang = lan;
            }
        }
        
        try
        {
            String filename= "results-unigram.txt";
            FileWriter fw = new FileWriter(filename,true); 
            fw.write(id+ "\t" + finalLang + "\t" + line +"\n");
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
    /**
     * 
     * @param line
     * @param disc
     * @param id
     */
   
    public static void findLangUniSmooth(String line, String disc, String id) {
        
        String[]language = {"es", "eu", "ca", "pt", "gl", "en"};
        
        float finalVal = -500;
        String finalLang = "";
        float result = 0;
        
        for(String lan : language)
        {
            if(lan.equals("ca"))
            {
                result = findUniSmooth(line, disc, CA_Uni);
            }
            else if(lan.equals("en"))
            {
                result = findUniSmooth(line, disc, EN_Uni);
            }
            else if(lan.equals("es"))
            {
                result = findUniSmooth(line, disc, ES_Uni);
            }
            else if(lan.equals("eu"))
            {
                result = findUniSmooth(line, disc, EU_Uni);
            }
            else if(lan.equals("pt"))
            {
                result = findUniSmooth(line, disc, PT_Uni);
            }
            else if(lan.equals("gl"))
            {
                result = findUniSmooth(line, disc, GL_Uni);
            }
            
            if(finalVal < result)
            {
                finalVal = result;
                finalLang = lan;
            }
        }
        
        try
        {
            String filename= "results-smooth-unigram.txt";
            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            fw.write(id+ "\t" + finalLang + "\t" + line+"\n");
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }   
    

    public static void findLangBi(String line, String disc, String id) {
        
        String[]language = {"eu", "es", "ca", "pt", "gl", "en"};
        
        float finalVal = -500;
        String finalLang = "";
        float result = 0;
        
        for(String lan : language)
        {
            if(lan.equals("eu"))
            {
                result = findBiUnSmooth(line, disc, EU_Bi);
            }
            else if(lan.equals("en"))
            {
                result = findBiUnSmooth(line, disc, EN_Bi);
            }
            else if(lan.equals("es"))
            {
                result = findBiUnSmooth(line, disc, ES_Bi);
            }
            else if(lan.equals("ca"))
            {
                result = findBiUnSmooth(line, disc, CA_Bi);
            }
            else if(lan.equals("pt"))
            {
                result = findBiUnSmooth(line, disc, PT_Bi);
            }
            else if(lan.equals("gl"))
            {
                result = findBiUnSmooth(line, disc, GL_Bi);
            }
            
            
            
            if(finalVal < result)
            {
                
                finalVal = result;
                finalLang = lan;
            }
        }
        
        try
        {
            String filename= "results-bigram.txt";
            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            fw.write(id+ "\t" + finalLang + "\t" + line +"\n");
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
    
    public static void findLangBiSmooth(String line, String disc, String id) {
        
        String[]language = {"eu", "es", "pt", "ca", "en", "gl"};
        
        float finalVal = -500;
        String finalLang = "";
        float result = 0;
        
        for(String lan : language)
        {
            if(lan.equals("eu"))
            {
                result = findBiSmooth(line, disc, EU_Bi);
            }
            else if(lan.equals("en"))
            {
                result = findBiSmooth(line, disc, EN_Bi);
            }
            else if(lan.equals("es"))
            {
                result = findBiSmooth(line, disc, ES_Bi);
            }
            else if(lan.equals("ca"))
            {
                result = findBiSmooth(line, disc, CA_Bi);
            }
            else if(lan.equals("pt"))
            {
                result = findBiSmooth(line, disc, PT_Bi);
            }
            else if(lan.equals("gl"))
            {
                result = findBiSmooth(line, disc, GL_Bi);
            }
            
            if(finalVal < result)
            {
                finalVal = result;
                finalLang = lan;
            }
        }
        
        try
        {
            String filename= "results-smooth-bigram.txt";
            FileWriter fw = new FileWriter(filename,true); 
            fw.write(id+ "\t" + finalLang + "\t" + line+"\n");
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }  
    
    
    
    public static void printUni(Hashtable<String, Float>myDictionary, String disc){
        
        if(myDictionary.get("total") != 0)
        {
            try
            {
                String filename= "unigramLM.txt";
                FileWriter fw = new FileWriter(filename,true); 
                fw.write("\n"+"\n\n          Unigram of "+ disc + " ");
                
                String[] keys = (String[]) myDictionary.keySet().toArray(new String[0]);
                Arrays.sort(keys);
                for(String key : keys) {
                    if (!key.equals("total"))
                    {
                        String val = String.format("%.5f", myDictionary.get(key)/myDictionary.get("total"));
                        String val1 = String.format("%.5f", (myDictionary.get(key)+0.1)/(myDictionary.get("total")+(myDictionary.size()*0.1)) );
                        fw.write("\n" + key + "  " + val + "  " +  val1);
                    }
                }
                fw.close();
            }
            catch(IOException ioe)
            {
                System.err.println("IOException: " + ioe.getMessage());
            }
        }       
    }
    
    public static void printBi(Hashtable<String, Hashtable<String, Float>>myDictionary, String disc){
        
            int counter = 0;
            try
            {
                String filename= "bigramLM.txt";
                FileWriter fw = new FileWriter(filename,true); 
                fw.write("\n"+"\n\n          Bigram of "+ disc + " ");
                
                String[] MyArray = (String[]) myDictionary.keySet().toArray(new String[0]);
                Arrays.sort(MyArray);             
                for(String myKeys : MyArray) {
                    
                    String[] keys = (String[]) myDictionary.get(myKeys).keySet().toArray(new String[0]);
                    Arrays.sort(keys);
                    
                    for(String key : keys) {
                        if (!key.equals("total"))
                        {
                            String val = String.format("%.5f", myDictionary.get(myKeys).get(key)/myDictionary.get(myKeys).get("total"));
                            String val1 = String.format("%.5f", (myDictionary.get(myKeys).get(key)+0.1)/(myDictionary.get(myKeys).get("total")+(myDictionary.size()*0.1)) );
                            fw.write("\n" + myKeys + key + "  " + val + "  " +  val1);
                            counter++;
                            if(counter == 50)
                            {
                                break;
                            }
                        }
                    }
                    if(counter == 50)
                    {
                        break;
                    }
                }
                fw.close();
            }
            catch(IOException ioe)
            {
                System.err.println("IOException: " + ioe.getMessage());
            }
                
    }
    

    
    
    
    
    public static void testing(String file1, String file2, String file3){      
        
        Hashtable<String, Hashtable<String, Float>> myDictionary = new Hashtable<String, Hashtable<String, Float>>();
        
        BufferedReader fileReader1 = null;
        try {
            fileReader1 = new BufferedReader(new FileReader(file1));
        } catch (FileNotFoundException e1) {
           
            e1.printStackTrace();
        }
        BufferedReader fileReader2 = null;
        try {
            fileReader2 = new BufferedReader(new FileReader(file2));
        } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
        }


        String myTestingTweet;
        String systemDetectLine;
        
        try {
            while ( ((myTestingTweet = fileReader1.readLine()) != null) && ((systemDetectLine = fileReader2.readLine()) != null) ) {
                
                String[] testparts = myTestingTweet.split("\t");
                String[] predictparts = systemDetectLine.split("\t");
                
                
                
                if (myDictionary.containsKey(testparts[2])) {
                    float count = myDictionary.get(testparts[2]).containsKey(predictparts[1]) ? myDictionary.get(testparts[2]).get(predictparts[1]) : 0;
                    myDictionary.get(testparts[2]).put(predictparts[1], count + 1);
                    myDictionary.get(testparts[2]).put("total", myDictionary.get(testparts[2]).get("total") + 1);
                } else {
                    myDictionary.put(testparts[2], new Hashtable<String, Float>());
                    myDictionary.get(testparts[2]).put(predictparts[1], (float) 1);
                    myDictionary.get(testparts[2]).put("total", (float) 1);
                }
                
                
            }
        } catch (IOException e) {
           
            e.printStackTrace();
        }
        
        
        
        
        float corVal = 0;

        float totalSum = 0;

     for(String key1 : myDictionary.keySet()) {

     for(String key2 : myDictionary.get(key1).keySet()) {

     if(key1.equals(key2)){

     corVal = corVal + myDictionary.get(key1).get(key2);

    }

     if(key2.equals("total")){

     totalSum = totalSum + myDictionary.get(key1).get("total");

    }

    }

    }



     String accuracy = String.format("%.2f", (corVal/totalSum*100));

        
        
        
        try
        {
            FileWriter fw = new FileWriter(file3,true); 
           fw.write("\n" + "  " + "\t\t\t\t" + "CATALAN" + "\t\t\t" +  "ENGLISH" + "\t\t\t" +  "SPANISH" + "\t\t\t" +  "BASQUE" + "\t\t\t" +  "GALICIAN" + "\t\t\t" +  "PORTUGUESE");
          fw.write("Accuracy is:"+ accuracy ) ;
           String[] MyArray = (String[]) myDictionary.keySet().toArray(new String[0]);
            Arrays.sort(MyArray);             
            for(String myKeys : MyArray) {
                String ca = String.format("%.2f", 0.0);
                String en = String.format("%.2f", 0.0);
                String es = String.format("%.2f", 0.0);
                String eu = String.format("%.2f", 0.0);
                String gl = String.format("%.2f", 0.0);
                String pt = String.format("%.2f", 0.0);
                String tot = String.format("%.2f", 0.0);
                fw.write("\n" + myKeys + "\t\t\t\t");
                String[] keys = (String[]) myDictionary.get(myKeys).keySet().toArray(new String[0]);
                Arrays.sort(keys);
                
                for(String key : keys) {
                    if(key.equals("ca"))
                    {
                        ca = String.format("%.2f", (myDictionary.get(myKeys).get(key)/myDictionary.get(myKeys).get("total"))*100);
                    }
                    else if(key.equals("en"))
                    {
                        en = String.format("%.2f", (myDictionary.get(myKeys).get(key)/myDictionary.get(myKeys).get("total"))*100);
                    }
                   
                    else if(key.equals("gl"))
                    {
                        gl = String.format("%.2f", (myDictionary.get(myKeys).get(key)/myDictionary.get(myKeys).get("total"))*100);
                    }
                    else if(key.equals("pt"))
                    {
                        pt = String.format("%.2f", (myDictionary.get(myKeys).get(key)/myDictionary.get(myKeys).get("total"))*100);
                    }
                    else if(key.equals("es"))
                    {
                        es = String.format("%.2f", (myDictionary.get(myKeys).get(key)/myDictionary.get(myKeys).get("total"))*100);
                    }
                    else if(key.equals("eu"))
                    {
                        eu = String.format("%.2f", (myDictionary.get(myKeys).get(key)/myDictionary.get(myKeys).get("total"))*100);
                    }
                    else if(key.equals("total"))
                    {
                        tot = String.format("%.2f", (myDictionary.get(myKeys).get(key)/myDictionary.get(myKeys).get("total"))*100);
                    }
                }
               fw.write(ca+"\t\t"+en+"\t\t"+es+"\t\t"+eu+"\t\t"+gl+"\t\t"+pt+"\t\t"+tot);
            }
            
            
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
            
    }

    public static void main(String[] args) throws IOException {         
        String lineOfFile;
        try {
            readAfile = new BufferedReader(new FileReader("simple-training-tweets_clean.txt"));
        } catch (FileNotFoundException e) {
           
            e.printStackTrace();
        }

        PT_Uni.put("total", (float) 0);
        GL_Uni.put("total", (float) 0);
        CA_Uni.put("total", (float) 0);
        ES_Uni.put("total", (float) 0);
        EN_Uni.put("total", (float) 0);
        EU_Uni.put("total", (float) 0);

        try {
            while ((lineOfFile = readAfile.readLine()) != null) {
                
                String[] myLinestr = lineOfFile.split("\t");

                // removing
                String myTweets =( myLinestr[3].replaceAll("\\p{Punct}+", " ")).toLowerCase();
                
                if (myLinestr[2].equals("es")) {                 
                    devUnigrams(myTweets, "es");                        
                    devBigrams(myTweets, "es");                  
                }
                if (myLinestr[2].equals("en")) {
                    devUnigrams(myTweets, "en");
                    devBigrams(myTweets, "en");                    
                }
                 if (myLinestr[2].equals("eu")) {                 
                     devUnigrams(myTweets, "eu");
                    devBigrams(myTweets, "eu");
                 }
                 if (myLinestr[2].equals("ca")) {                 
                     devUnigrams(myTweets, "ca");
                    devBigrams(myTweets, "ca");
                 }
                 if (myLinestr[2].equals("pt")) {                 
                     devUnigrams(myTweets, "pt");
                    devBigrams(myTweets, "pt");
                 }
                 if (myLinestr[2].equals("gl")) {                
                     devUnigrams(myTweets, "gl");
                     devBigrams(myTweets, "gl");
                 }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        //printing
        
        try
        {
            String filename= "unigramLM.txt";
            FileWriter fw = new FileWriter(filename,false); 
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
        
        printUni(EU_Uni, "eu");
        printUni(PT_Uni, "pt");
        printUni(ES_Uni, "es");
        printUni(EN_Uni, "en");
        printUni(CA_Uni, "ca");
        printUni(GL_Uni, "gl");
        
        try
        {
            String filename= "bigramLM.txt";
            FileWriter fw = new FileWriter(filename,false); 
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
        
        printBi(EU_Bi, "eu");
        printBi(ES_Bi, "es");
        printBi(PT_Bi, "pt");
        printBi(EN_Bi, "en");
        printBi(CA_Bi, "ca");
        printBi(GL_Bi, "gl");
        
        try
      {
          String filename= "results-unigram.txt";
          FileWriter fw = new FileWriter(filename,false); //the true will append the new data
          fw.close();
      }
      catch(IOException ioe)
      {
          System.err.println("IOException: " + ioe.getMessage());
      }
        
        try
      {
          String filename= "results-smooth-unigram.txt";
          FileWriter fw = new FileWriter(filename,false); //the true will append the new data
          fw.close();
      }
      catch(IOException ioe)
      {
          System.err.println("IOException: " + ioe.getMessage());
      }
        
        try
      {
          String filename= "results-bigram.txt";
          FileWriter fw = new FileWriter(filename,false); //the true will append the new data
          fw.close();
      }
      catch(IOException ioe)
      {
          System.err.println("IOException: " + ioe.getMessage());
      }
        
        try
      {
          String filename= "results-smooth-bigram.txt";
          FileWriter fw = new FileWriter(filename,false); //the true will append the new data
          fw.close();
      }
      catch(IOException ioe)
      {
          System.err.println("IOException: " + ioe.getMessage());
      }
        
        
        
        float result;
        try {
            readAfile = new BufferedReader(new FileReader("simple-testing-tweets_clean.txt"));            
            
        } catch (FileNotFoundException e) {
           
            e.printStackTrace();
        }
        
        try {
            while ((lineOfFile = readAfile.readLine() ) != null) {
                
                String[] myLinestr = lineOfFile.split("\t");       
                
                //removing
                String words = myLinestr[3].replaceAll("\\p{Punct}+", "");                            
                
                findLangUniUnSmooth(words, myLinestr[3], myLinestr[0]);
                
                findLangUniSmooth(words, myLinestr[3], myLinestr[0]);
                
                findLangBi(words, myLinestr[3], myLinestr[0]);
                
                findLangBiSmooth(words, myLinestr[3], myLinestr[0]);              
            }
        } catch (IOException e) {
           
            e.printStackTrace();
        }

        
        
        try
        {
            String filename= "analysis-unigram.txt";
            FileWriter fw = new FileWriter(filename,false); //the true will append the new data
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
        
        testing("simple-testing-tweets_clean.txt", "results-unigram.txt", "analysis-unigram.txt");
        
        try
        {
            String filename= "analysis-smooth-unigram.txt";
            FileWriter fw = new FileWriter(filename,false); //the true will append the new data
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
        testing("simple-testing-tweets_clean.txt", "results-smooth-unigram.txt", "analysis-smooth-unigram.txt");
        
        try
        {
            String filename= "analysis-bigram.txt";
            FileWriter fw = new FileWriter(filename,false); //the true will append the new data
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
        testing("simple-testing-tweets_clean.txt", "results-bigram.txt", "analysis-bigram.txt");
        
        try
        {
            String filename= "analysis-smooth-bigram.txt";
            FileWriter fw = new FileWriter(filename,false); //the true will append the new data
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
        
        testing("simple-testing-tweets_clean.txt", "results-smooth-bigram.txt", "analysis-smooth-bigram.txt");
       
        System.out.println("successfuly Finished");
        
      
        
        

    }  

}








