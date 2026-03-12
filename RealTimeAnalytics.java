import java.util.*;

public class RealTimeAnalytics {

    HashMap<String,Integer> pageViews=new HashMap<>();
    HashMap<String,Set<String>> uniqueVisitors=new HashMap<>();
    HashMap<String,Integer> sources=new HashMap<>();

    public void processEvent(String url,String userId,String source){

        pageViews.put(url,pageViews.getOrDefault(url,0)+1);

        uniqueVisitors.putIfAbsent(url,new HashSet<>());
        uniqueVisitors.get(url).add(userId);

        sources.put(source,sources.getOrDefault(source,0)+1);
    }

    public void dashboard(){

        System.out.println("Page Views: "+pageViews);

        for(String page:uniqueVisitors.keySet()){

            System.out.println(page+" unique visitors: "
            +uniqueVisitors.get(page).size());
        }

        System.out.println("Traffic Sources: "+sources);
    }

    public static void main(String[] args){

        RealTimeAnalytics system=new RealTimeAnalytics();

        system.processEvent("/news","user1","google");
        system.processEvent("/news","user2","facebook");

        system.dashboard();
    }
}