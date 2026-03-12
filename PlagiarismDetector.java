import java.util.*;

public class PlagiarismDetector {

    HashMap<String, Set<String>> index = new HashMap<>();

    public List<String> generateNgrams(String text, int n) {

        String[] words = text.split(" ");
        List<String> grams = new ArrayList<>();

        for(int i=0;i<=words.length-n;i++){

            String gram="";

            for(int j=0;j<n;j++){
                gram+=words[i+j]+" ";
            }

            grams.add(gram.trim());
        }

        return grams;
    }

    public void storeDocument(String id,String text){

        List<String> grams = generateNgrams(text,5);

        for(String g:grams){

            index.putIfAbsent(g,new HashSet<>());
            index.get(g).add(id);
        }
    }

    public void analyzeDocument(String text){

        List<String> grams = generateNgrams(text,5);

        HashMap<String,Integer> similarity=new HashMap<>();

        for(String g:grams){

            if(index.containsKey(g)){

                for(String doc:index.get(g)){

                    similarity.put(doc,
                    similarity.getOrDefault(doc,0)+1);
                }
            }
        }

        System.out.println(similarity);
    }

    public static void main(String[] args){

        PlagiarismDetector p=new PlagiarismDetector();

        p.storeDocument("essay1",
        "this is a sample essay for plagiarism detection");

        p.analyzeDocument(
        "this is a sample essay written by a student");
    }
}