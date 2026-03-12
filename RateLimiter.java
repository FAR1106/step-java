import java.util.*;

class TokenBucket {

    int tokens;
    int maxTokens;
    long lastRefill;

    TokenBucket(int max){

        maxTokens=max;
        tokens=max;
        lastRefill=System.currentTimeMillis();
    }

    boolean allowRequest(){

        long now=System.currentTimeMillis();

        if(now-lastRefill>3600000){

            tokens=maxTokens;
            lastRefill=now;
        }

        if(tokens>0){
            tokens--;
            return true;
        }

        return false;
    }
}

public class RateLimiter {

    HashMap<String,TokenBucket> clients=new HashMap<>();

    public boolean checkRateLimit(String client){

        clients.putIfAbsent(client,new TokenBucket(1000));

        return clients.get(client).allowRequest();
    }

    public static void main(String[] args){

        RateLimiter limiter=new RateLimiter();

        System.out.println(limiter.checkRateLimit("abc123"));
    }
}