import java.util.*;

public class AutocompleteSystem {

    HashMap<String,Integer> queries=new HashMap<>();

    public void addQuery(String query){

        queries.put(query,queries.getOrDefault(query,0)+1);
    }

    public List<String> search(String prefix){

        List<String> result=new ArrayList<>();

        for(String q:queries.keySet()){

            if(q.startsWith(prefix))
                result.add(q);
        }

        result.sort((a,b)->queries.get(b)-queries.get(a));

        return result.subList(0,Math.min(5,result.size()));
    }

    public static void main(String[] args){

        AutocompleteSystem sys=new AutocompleteSystem();

        sys.addQuery("java tutorial");
        sys.addQuery("javascript");
        sys.addQuery("java download");

        System.out.println(sys.search("jav"));
    }
}