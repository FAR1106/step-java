import java.util.*;

public class Problem1_UsernameChecker {

    HashMap<String,Integer> usernameMap = new HashMap<>();
    HashMap<String,Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username){

        attempts.put(username, attempts.getOrDefault(username,0)+1);

        return !usernameMap.containsKey(username);
    }

    public void registerUser(String username,int userId){
        usernameMap.put(username,userId);
    }

    public List<String> suggestAlternatives(String username){

        List<String> suggestions = new ArrayList<>();

        for(int i=1;i<=3;i++){

            String suggestion = username+i;

            if(!usernameMap.containsKey(suggestion))
                suggestions.add(suggestion);
        }

        suggestions.add(username.replace("_","."));

        return suggestions;
    }

    public String getMostAttempted(){

        int max=0;
        String user="";

        for(String key:attempts.keySet()){

            if(attempts.get(key)>max){

                max=attempts.get(key);
                user=key;
            }
        }

        return user+" ("+max+" attempts)";
    }

    public static void main(String[] args){

        Problem1_UsernameChecker system=new Problem1_UsernameChecker();

        system.registerUser("john_doe",1);

        System.out.println(system.checkAvailability("john_doe"));
        System.out.println(system.checkAvailability("jane_smith"));
        System.out.println(system.suggestAlternatives("john_doe"));
        System.out.println(system.getMostAttempted());
    }
}