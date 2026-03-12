import java.util.*;

public class MultiLevelCache {

    HashMap<String,String> L1=new HashMap<>();
    HashMap<String,String> L2=new HashMap<>();
    HashMap<String,String> database=new HashMap<>();

    public String getVideo(String id){

        if(L1.containsKey(id))
            return "L1 HIT "+L1.get(id);

        if(L2.containsKey(id)){

            L1.put(id,L2.get(id));
            return "L2 HIT "+L2.get(id);
        }

        if(database.containsKey(id)){

            L2.put(id,database.get(id));
            return "DB HIT "+database.get(id);
        }

        return "Video not found";
    }

    public static void main(String[] args){

        MultiLevelCache cache=new MultiLevelCache();

        cache.database.put("video1","VideoData");

        System.out.println(cache.getVideo("video1"));
    }
}